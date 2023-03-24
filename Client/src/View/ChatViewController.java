package View;


import Model.ChatMessage;
import Model.User;
import ViewModel.ChatMessageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

  public class ChatViewController extends ViewController
  {

    private ChatMessageViewModel chatMessageViewModel;

    @FXML
    private ListView<ChatMessage>chatListView;

    @FXML
    ListView<User>userListView;


    @FXML
    private TextArea messageField;

    @FXML
    void onSend(ActionEvent event) {
      chatMessageViewModel.sendMessage(messageField.getText());
      chatListView.setItems(chatMessageViewModel.getChatSupport());
      messageField.clear();
    }

    @Override protected void init()
    {
      this.chatMessageViewModel=getViewModelFactory().getChatMessageViewModel();
      //chatField.textProperty().bind(chatMessageViewModel.chatMessageProperty());
      chatListView.setItems(chatMessageViewModel.getChatSupport());
      userListView.setItems(chatMessageViewModel.getAllUsers());
      //messageField.textProperty().bindBidirectional(chatMessageViewModel.chatMessageProperty());

    }
  }


