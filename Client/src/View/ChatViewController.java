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

    }

    @FXML
    void onShow(ActionEvent event) {

    }

    @Override protected void init()
    {
      this.chatMessageViewModel=getViewModelFactory().getChatMessageViewModel();
      messageField.textProperty().bind(chatMessageViewModel.chatMessageProperty());
    }
  }


