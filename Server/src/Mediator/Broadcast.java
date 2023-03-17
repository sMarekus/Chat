package Mediator;

import Model.ChatMessage;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Broadcast implements UnnamedPropertyChangeSubject
{
  private PropertyChangeSupport prop;

  public Broadcast()
  {
    prop = new PropertyChangeSupport(this);
  }

  public void sendBroadcast(ChatMessage mess)
  {
    prop.firePropertyChange("Message", null, mess);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    prop.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    prop.removePropertyChangeListener(listener);
  }
}
