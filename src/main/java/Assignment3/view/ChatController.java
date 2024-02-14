package Assignment3.view;

import Assignment3.viewmodel.ChatViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.layout.Region;

import java.io.IOException;
import java.rmi.RemoteException;

public class ChatController
{
  @FXML Button logoutButton;
  @FXML TextField status;
  @FXML ListView chat;
  @FXML TextArea type;
  @FXML Button sendButton;

  private Region root;
  private ViewHandler viewHandler;
  private ChatViewModel chatViewModel;

  public void init(Region root, ViewHandler viewHandler, ChatViewModel chatViewModel)
      throws RemoteException
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.chatViewModel = chatViewModel;

    this.chatViewModel.bindMessage(type.textProperty());
    this.chatViewModel.bindMessages(chat.itemsProperty());
    this.chatViewModel.bindStatus(status.textProperty());
  }

  public void logout() throws IOException{
    chatViewModel.logout();
    viewHandler.openView("login");
  }

  //poate cauza ceva probleme schimbarea pe care o fac, dar schimb daca e
  public void writeMessage() throws IOException
  {
    chatViewModel.writeMessage();
    type.clear();
  }
  public Region getRoot()
  {
    return root;
  }

}
