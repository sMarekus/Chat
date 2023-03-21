import Mediator.Server;

import java.io.IOException;

public class ServerTest
{
  public static void main(String[] args)
  {
    try
    {
      Server server=new Server(2020);
      Thread t1=new Thread(server);
      t1.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
