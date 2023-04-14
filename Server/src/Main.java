import Mediator.Server;

import java.io.IOException;

public class Main
{
  public static void main(String[] args)
  {
    try
    {
      Server server = new Server(2020);
      Thread thread = new Thread(server);
      thread.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}

//wddf