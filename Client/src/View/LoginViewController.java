package View;

import ViewModel.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

public class LoginViewController extends ViewController
{
  private LoginViewModel loginViewModel;

  @FXML
  private Label errorLabel;

  @FXML
  private TextField usernameField;

  @FXML
  void onLogIn(ActionEvent event) {
    onEnter();
  }

  @Override protected void init()
  {
    this.loginViewModel=getViewModelFactory().getLoginViewModel();
    //errorLabel.setText("Incorrect input");
    errorLabel.textProperty().bindBidirectional(loginViewModel.getErrorProperty());
    usernameField.textProperty().bindBidirectional(loginViewModel.getUserNameProperty());
  }

  @FXML private void onEnter(){
    loginViewModel.setUserName();
    getViewHandler().openView("ChatView.fxml");
  }
}

