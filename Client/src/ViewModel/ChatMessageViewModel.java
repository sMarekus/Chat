package ViewModel;

import Model.Model;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import Model.ChatMessage;
import Model.User;

public class ChatMessageViewModel implements PropertyChangeListener
{
  private Model model;
  private  StringProperty chatMessage;
  private ObservableList<ChatMessage> chatSupport= FXCollections.observableArrayList();
  private StringProperty input;

  public ChatMessageViewModel(Model model) {
    this.model = model;
    model.addListener(this);
    input = new SimpleStringProperty();
    chatMessage = new SimpleStringProperty();
  }

  public void sendMessage(String message) {
    chatSupport.add(new ChatMessage(message,model.getUserName()));
    model.sendMessage(input.get());
    input.set("");
  }


  public StringProperty chatMessageProperty(){
    return chatMessage;
  }

 public ObservableList<User>getAllUsers(){
    return model.getAllUsers();
 }

  public ObservableList<ChatMessage> getChatSupport()
  {
    return chatSupport;
  }

  public StringProperty getInput() {
    return input;
  }


  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    /*
    Platform.runLater(()->{
      String chatMessageTemp = evt.getOldValue().toString() + ": " + evt.getNewValue().toString();
      chatSupport.add(chatMessageTemp);

      String allMessage = "";
      for (int i = 0; i < chatSupport.size(); i++) {
        allMessage = allMessage + chatSupport.get(i) + "\n";
      }

      chatMessage.set(allMessage);
    });*/
  }
}

