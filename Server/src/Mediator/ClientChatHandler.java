package Mediator;

import Model.ChatMessage;
import Model.Logging;
import com.google.gson.Gson;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientChatHandler implements Runnable, PropertyChangeListener
{
  private Socket socket;
  private Server chatServer;
  private Broadcast messageBroadcaster;
  private BufferedReader inputStreamReader;
  private PrintWriter outputStreamWriter;
  private Gson jsonConverter;

  public ClientChatHandler(Socket socket, Server chatServer, Broadcast messageBroadcaster)
      throws IOException
  {
    this.socket = socket;
    this.chatServer = chatServer;
    jsonConverter = new Gson();
    inputStreamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    outputStreamWriter = new PrintWriter(socket.getOutputStream(), true);
    this.messageBroadcaster = messageBroadcaster;
    messageBroadcaster.addListener(this::propertyChange);
  }

  public void run()
  {
    while(true) {
      try {
        String reply = inputStreamReader.readLine();
        if (reply != null) {
          ChatMessage receivedMessage = jsonConverter.fromJson(reply, ChatMessage.class);
          System.out.println("ChatClientHandler: " + receivedMessage.getUsername() + ": " + receivedMessage.getText());

          if (receivedMessage.isPrivateRequest()) {
            ChatMessage privateRequest = new ChatMessage("Number of users: " + chatServer.getUserCount(), "SERVER", true);
            String toJson = jsonConverter.toJson(privateRequest);
            outputStreamWriter.println(toJson);
          }
          else {
            if (Logging.getInstance() == null) {
              System.out.println("Log is null");
            }
            Logging.getInstance().addLogEntry(receivedMessage);
            messageBroadcaster.sendBroadcast(receivedMessage);
          }
        }
      }
      catch (IOException e)
      {
        try {
          Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  public void close() throws IOException
  {
    socket.close();
  }


  @Override public void propertyChange(PropertyChangeEvent event)
  {
    ChatMessage mess = ((ChatMessage) event.getNewValue());
    String json = jsonConverter.toJson(mess);
    outputStreamWriter.println(json);
  }
}
