package Model;

import java.io.Serializable;

public class ChatMessage implements Serializable
{
  private String messageText;
  private String userName;
  private boolean isPrivate;

  public ChatMessage(String messageText, String userName) {
      this.messageText = messageText;
      this.userName = userName;
      this.isPrivate = false;
  }

  public ChatMessage(String messageText, String userName, boolean isPrivate) {
      this.messageText = messageText;
      this.userName = userName;
      this.isPrivate = isPrivate;
  }

  public boolean isPrivate() {
      return isPrivate;
  }

  public String getMessageText() {
      return messageText;
  }

  public String getUserName() {
      return userName;
  }

  public void setMessageText(String messageText) {
      this.messageText = messageText;
  }

  public void setUserName(String userName) {
      this.userName = userName;
  }

  @Override
  public String toString() {
      return getUserName() + ": " + getMessageText();
  }
}
