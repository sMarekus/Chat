package ViewModel;

import Model.Model;

public class ViewModelFactory
{
  private ChatMessageViewModel chatMessageViewModel;
  private LoginViewModel loginViewModel;

  public ViewModelFactory(Model model) {
    this.chatMessageViewModel = new ChatMessageViewModel(model);
    this.loginViewModel = new LoginViewModel(model);
  }

  public ChatMessageViewModel getChatMessageViewModel()
  {
    return chatMessageViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }
}
