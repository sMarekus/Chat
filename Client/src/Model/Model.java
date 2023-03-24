package Model;

import Validators.UserNameValidator;
import javafx.collections.ObservableList;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;
public interface Model extends UnnamedPropertyChangeSubject
{

  void sendMessage(String text);

  void getNumberOfUsers();

  void setUserName(String userName);

  String getUserName();

  void addUser(String user);

  ObservableList<User>getAllUsers();

}
