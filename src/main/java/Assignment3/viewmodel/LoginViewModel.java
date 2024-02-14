package Assignment3.viewmodel;

import Assignment3.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;

public class LoginViewModel
{
  private Model model;
  private StringProperty loggedInUsername;
  private StringProperty error;
  public LoginViewModel(Model model) {
    this.model = model;
    this.loggedInUsername = new SimpleStringProperty();
    this.error = new SimpleStringProperty();
  }

  public void login() {
    String username = loggedInUsername.get();
    try {
      loggedInUsername.set(model.logIn(username));
    } catch (IOException e) {
      error.set(e.getMessage());
    }
  }

  public void bindLoggedInUsername(StringProperty property) {
    property.bindBidirectional(loggedInUsername);//INTREBARE: care ii diferenta dintre bind si bindbidirectional?
  }

  public void bindError(StringProperty property)
  {
    property.bind(error);
  }

}
