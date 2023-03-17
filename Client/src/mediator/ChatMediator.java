package mediator;

import Model.ChatMessage;
import Model.Model;
import com.google.gson.Gson;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatMediator implements UnnamedPropertyChangeSubject
{

 private final String host;
 private final int port;
 private  Socket socket;
 private  BufferedReader input;
 private  PrintWriter output;
 private  PropertyChangeSupport property;
 private  String userName;
 private  Gson gson;

  public ChatMediator(Model model,String host, int port)
  {
    this.host = host;
    this.port = port;
    gson=new Gson();
    property=new PropertyChangeSupport(this);

  }

  public void connect() throws IOException
  {
  socket=new Socket(host,port);
  input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
  output=new PrintWriter(socket.getOutputStream(),true);
  }

  public void disconnect() throws IOException
  {
    input.close();
    output.close();
    socket.close();
  }

  public void received(ChatMessage fromJonson){

    if (fromJonson.isPrivate())
  {
    System.out.println(fromJonson);
    property.firePropertyChange("Number ",fromJonson.getUserName(),fromJonson.getMessageText());
  }
    else
    {
      System.out.println(fromJonson);
      property.firePropertyChange("Message ",fromJonson.getUserName(),fromJonson.getMessageText());
    }
  }

  public void getNumberOfUsers(){
    String numberOfUsers=gson.toJson(new ChatMessage("1",userName,true));
    System.out.println(numberOfUsers);
  }

  public void sendMessage(String text){
  ChatMessage chatMessage=new ChatMessage(text,userName);
  System.out.println(chatMessage.getMessageText());
  String gsonMessage= gson.toJson(chatMessage,ChatMessage.class);
    System.out.println(gsonMessage);
  }

  public void setUserName(){
    this.userName=userName;
  }

  public String getUserName(){
    return userName;
}




  @Override public void addListener(PropertyChangeListener listener)
  {
  property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
  property.removePropertyChangeListener(listener);
  }
}
