package Model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;
public interface Model extends UnnamedPropertyChangeSubject
{

  void sendMessage(String text);

  void getNumberOfUsers();

  void setUserName(String userName);

  void setPassword(String password);
}
