package ViewModel;

import Model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ChatMessageViewModel implements PropertyChangeListener
{
  private Model model;
  private  StringProperty chatMessage;
  private ArrayList<String> chatSupport;
  private StringProperty input;

  public ChatMessageViewModel(Model model) {
    this.model = model;
    model.addListener(this);
    input = new SimpleStringProperty();
    chatMessage = new SimpleStringProperty();
    chatSupport = new ArrayList<>();
  }

  public void sendMessage() {
    model.sendMessage(input.get());
    input.set("");
  }

  public StringProperty chatMessageProperty(){
    return chatMessage;
  }

  public void getNumberOfUsers() {
    model.getNumberOfUsers();
  }

  public ArrayList<String> getChatSupport()
  {
    return chatSupport;
  }

  public StringProperty getInput() {
    return input;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(()->{
      String chatMessageTemp = evt.getOldValue().toString() + ": " + evt.getNewValue().toString();
      chatSupport.add(chatMessageTemp);

      String allMessage = "";
      for (int i = 0; i < chatSupport.size(); i++) {
        allMessage = allMessage + chatSupport.get(i) + "\n";
      }

      chatMessage.set(allMessage);
    });
  }
}
