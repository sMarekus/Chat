package Model;

import Validators.PasswordValidator;
import Validators.UserNameValidator;
import mediator.ChatMediatorClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ModelManager implements Model, PropertyChangeListener
{

private final ChatMediatorClient chatMediatorClient;

private final PropertyChangeSupport support;

public static ModelManager instance;

private final List<User>userList;

  public ModelManager( ChatMediatorClient chatMediatorClient, PropertyChangeSupport support, List userList)
  {
    this.chatMediatorClient = chatMediatorClient;
    this.userList =  userList;
    this.support = new PropertyChangeSupport(this);
  }



  public static synchronized ModelManager getInstance() {
    if (instance == null) {
      instance = new ModelManager(
          new ChatMediatorClient(null,"localhost",2020),
          new PropertyChangeSupport(new Object()),
          new ArrayList<>()
      );
    }
    return instance;
  }

  public void addUser(String username, String password)
      throws IllegalAccessException
  {
    UserNameValidator.validateUserName(username);
    PasswordValidator.validatePassword(password);

    if (getUser(username) != null) {
      throw new IllegalStateException("User already exists.");
    }
    User user = new User(username, password);
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
    chatMediatorClient.setUserName(userName);
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
