package Model;

import Validators.UserNameValidator;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;
public interface Model extends UnnamedPropertyChangeSubject
{

  void sendMessage(String text);

  void getNumberOfUsers();

  void setUserName(String userName);

  void setUserName(String userName, UserNameValidator validator);
  void setPassword(String password);
}
