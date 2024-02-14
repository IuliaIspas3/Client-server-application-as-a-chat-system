package Assignment3.view;

import Assignment3.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.Region;
import java.io.IOException;

public class ViewFactory
{
  private ChatController chatController;
  private LoginController loginController;
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    chatController = null;
    loginController = null;
  }

  public Region loadView(String id) {
    return switch (id) {
      case "chat" -> loadChat();
      case "login" -> loadLogin();
      default -> throw new RuntimeException("The id was not found");
    };
  }

  private Region loadChat() {
    if (chatController == null) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "/Assignment3/Chat.fxml"));
      try {
        Region root = loader.load();
        chatController = loader.getController();
        chatController.init(root, viewHandler, viewModelFactory.getChatViewModel());
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    return chatController.getRoot();
  }

  private Region loadLogin() {
    if (loginController == null) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "/Assignment3/Login.fxml"));
      try {
        Region root = loader.load();
        loginController = loader.getController();
        loginController.init(root, viewHandler, viewModelFactory.getLoginViewModel());
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    return loginController.getRoot();
  }

}
