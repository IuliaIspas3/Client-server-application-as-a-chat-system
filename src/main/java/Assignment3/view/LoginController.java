package Assignment3.view;

import Assignment3.viewmodel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class LoginController
{
  @FXML TextField username;
  @FXML Button continueButton;
  private Region root;
  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;
  public void init(Region root, ViewHandler viewHandler, LoginViewModel loginViewModel) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.loginViewModel = loginViewModel;

    this.loginViewModel.bindLoggedInUsername(username.textProperty());
  }

  public void login() {
    if (username.getText() != null)
    {
      loginViewModel.login();
      viewHandler.openView("chat");
    } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setContentText("The field is empty.");
      alert.show();
    }
  }
  public Region getRoot()
  {
    return root;
  }
}
