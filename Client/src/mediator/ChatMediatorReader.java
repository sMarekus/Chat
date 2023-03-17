package mediator;

import Model.ChatMessage;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatMediatorReader implements Runnable
{
  private BufferedReader input;
  ChatMediator chatMediatorClient;
  private Gson gson;

  public ChatMediatorReader(ChatMediator chatMediatorClient,BufferedReader input)
  {
  this.chatMediatorClient=chatMediatorClient;
  this.input=input;
  gson=new Gson();
  }

  public void closeConnection() throws IOException
  {

  chatMediatorClient.disconnect();
  }

  @Override public void run()
  {
    try
    {
      while (true){
        ChatMessage fromJson=gson.fromJson(input.readLine(),ChatMessage.class);
        chatMediatorClient.received(fromJson);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
