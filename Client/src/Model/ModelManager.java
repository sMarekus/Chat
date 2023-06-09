package Model;

import Validators.UserNameValidator;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.ChatMediatorClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelManager implements Model, PropertyChangeListener
{

private final ChatMediatorClient chatMediatorClient;

private final PropertyChangeSupport support;

public static ModelManager instance;

private ObservableList<User>userObservableList;



public ModelManager() throws IOException
  {

    this.chatMediatorClient = new ChatMediatorClient(this,"localhost",2020);
    chatMediatorClient.connect();
    chatMediatorClient.addListener(this);
    this.support = new PropertyChangeSupport(this);
    userObservableList= FXCollections.observableArrayList();
  }

  public static  ModelManager getInstance() throws IOException
  {
    if (instance == null) {
      synchronized (ModelManager.class){
        if (instance==null){
          instance=new ModelManager();
        }
      }
    }
    return instance;
  }

  @Override public void sendMessage(String text)
  {
    chatMediatorClient.sendMessage(text);
  }

  @Override public void getNumberOfUsers()
  {
    chatMediatorClient.getNumberOfUsers();
  }

  @Override public void setUserName(String userName)

  {
    chatMediatorClient.setUserName(userName);
  }

  @Override public String getUserName()
  {
    return chatMediatorClient.getUserName();
  }

  @Override public void addUser(String user)
  {
    userObservableList.add(new User(user));
  }

  @Override public ObservableList<User> getAllUsers()
  {
    return userObservableList;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }
}
