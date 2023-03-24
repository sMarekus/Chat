package Model;

import Validators.UserNameValidator;
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

private final List<User>userList;


public ModelManager() throws IOException
  {

    this.chatMediatorClient = new ChatMediatorClient(this,"localhost",2020);
    chatMediatorClient.connect();
    chatMediatorClient.addListener(this);
    this.userList =  new ArrayList<>();
    this.support = new PropertyChangeSupport(this);
  }




  public void addUser(String username, String password)
      throws IllegalAccessException
  {
    UserNameValidator.validateUserName(username);

    if (getUser(username) != null) {
      throw new IllegalStateException("User already exists.");
    }
    User user = new User(username);
    userList.add(user);
    support.firePropertyChange("userCount", userList.size() - 1, userList.size());
  }

  public User getUser(String userName)
  {
    for (User user : userList)
    {
      if (userName.equals(user.getUserName()))
      {
        return user;
      }
    }
    return null;
  }

  public User getLastUser(){
    if (userList.isEmpty())
      return null;
    else
      return userList.get(userList.size() -1);
    }

    public int getUserCount()
    {
    return userList.size();
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
    UserNameValidator.validateUserName(userName);


    if (getUser(userName) != null) {
      throw new IllegalStateException("User already exists.");
    }
    User user = new User(userName);
    userList.add(user);
    support.firePropertyChange("userCount", userList.size() - 1, userList.size());
  }

  @Override public void setUserName(String userName, UserNameValidator validator)
  {
    UserNameValidator.validateUserName(userName);


    if (getUser(userName) != null) {
      throw new IllegalStateException("User already exists.");
    }
    User user = new User(userName);
    userList.add(user);
    support.firePropertyChange("userCount", userList.size() - 1, userList.size());
  }


  @Override public void setPassword(String password)
  {
    chatMediatorClient.setPassword(password);
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
