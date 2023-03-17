package Model;

public class ChatMessage
{
  private String messageText;
  private String senderName;
  private boolean isPrivate;

  public ChatMessage(String messageText, String senderName) {
      this.messageText = messageText;
      this.senderName = senderName;
      this.isPrivate = false;
  }

  public ChatMessage(String messageText, String senderName, boolean isPrivate) {
      this.messageText = messageText;
      this.senderName = senderName;
      this.isPrivate = isPrivate;
  }

  public boolean isPrivate() {
      return isPrivate;
  }

  public String getMessageText() {
      return messageText;
  }

  public String getSenderName() {
      return senderName;
  }

  public void setMessageText(String messageText) {
      this.messageText = messageText;
  }

  public void setSenderName(String senderName) {
      this.senderName = senderName;
  }

  @Override
  public String toString() {
      return getSenderName() + ": " + getMessageText();
  }
}
