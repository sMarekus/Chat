package View;


import ViewModel.ChatMessageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

  public class ChatViewController extends ViewController
  {

    private ChatMessageViewModel chatMessageViewModel;

    @FXML
    private TextArea chatField;

    @FXML
    private TextArea messageField;

    @FXML
    private TextArea userField;

    @FXML
    void onSend(ActionEvent event) {
      chatMessageViewModel.sendMessage();
    }

    @FXML
    void onShow(ActionEvent event) {
      chatMessageViewModel.getNumberOfUsers();
    }

    @Override protected void init()
    {
      this.chatMessageViewModel=getViewModelFactory().getChatMessageViewModel();
      chatField.textProperty().bind(chatMessageViewModel.chatMessageProperty());
      messageField.textProperty().bindBidirectional(chatMessageViewModel.chatMessageProperty());

    }
  }


