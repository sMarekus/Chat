package Mediator;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable
{
  private int port;
  private int userCount;
  private ServerSocket socket;
  private Broadcast support;

  public Server(int port) throws IOException
  {
    this.port = port;
    socket = new ServerSocket(port);
    support = new Broadcast();
    userCount = 0;
  }

  public void close() throws IOException
  {
    socket.close();
  }

  @Override public void run()
  {
    System.out.println("Server starts...");
    System.out.println("Waiting...");
    while (true)
    {
      try {
        ClientChatHandler handler = new ClientChatHandler(socket.accept(), this, support);
        Thread thread = new Thread((Runnable) handler);
        thread.start();
        userCount++;
        System.out.println("Client successfully connected.");
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public int getUserCount()
  {
    return userCount;
  }
}
