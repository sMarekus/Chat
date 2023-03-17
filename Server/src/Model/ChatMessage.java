package Model;

public class ChatMessage
{
  private String text;
  private String username;
  private boolean isPrivateRequest;

  public ChatMessage(String text, String username){
    this.text = text;
    this.username = username;
    this.isPrivateRequest = false;
  }

  public ChatMessage(String text, String username, boolean isPrivateRequest){
    this.text = text;
    this.username = username;
    this.isPrivateRequest = isPrivateRequest;
  }

  public boolean isPrivateRequest()
  {
    return isPrivateRequest;
  }

  public String getText()
  {
    return text;
  }

  public String getUsername()
  {
    return username;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  @Override public String toString()
  {
    return getUsername() + ": " + getText();
  }
}
