package Assignment3.viewmodel;

import Assignment3.model.Model;

public class ViewModelFactory
{
  private ChatViewModel chatViewModel;
  private LoginViewModel loginViewModel;

  public ViewModelFactory(Model model) {
    this.chatViewModel = new ChatViewModel(model);
    this.loginViewModel = new LoginViewModel(model);
  }
  public ChatViewModel getChatViewModel()
  {
    return chatViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }
}
