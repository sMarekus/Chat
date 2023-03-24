package ViewModel;

import Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private StringProperty error;
  private StringProperty userName;
  private Model model;

  public LoginViewModel(Model model) {
    this.model = model;
    error = new SimpleStringProperty();
    userName = new SimpleStringProperty();
  }

  public void clear() {
    userName.set("");
    error.set("");
  }

  public void addUser(String user){
    model.addUser(user);
  }



  public StringProperty getErrorProperty() {
    return error;
  }

  public StringProperty getUserNameProperty() {
    return userName;
  }

  public void setUserName()
  {
    model.setUserName(userName.get());
  }
}
