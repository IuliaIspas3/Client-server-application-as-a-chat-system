package Assignment3.viewmodel;

import Assignment3.model.Message;
import Assignment3.model.MessageList;
import Assignment3.model.Model;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.rmi.RemoteException;

public class ChatViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty message;
  private ListProperty<Message> allMessages;
  private StringProperty status;
  private StringProperty error;

  public ChatViewModel(Model model) {
    this.model = model;
    this.message = new SimpleStringProperty();
    this.allMessages = new SimpleListProperty<>(FXCollections.observableArrayList());
    this.error = new SimpleStringProperty();
    this.status = new SimpleStringProperty();

    model.addPropertyChangeListener(this);
  }

  public void update()
  {
    try
    {
      allMessages.setAll(model.getAllMessages());
    }
    catch (IOException e) {
      error.set(e.getMessage());
    }
  }

  public void update(MessageList messageList) {
    allMessages.setAll(messageList.getMessages());
  }

  public void writeMessage()
  {
    String text = message.get();
    try
    {
      model.writeMessage(text);
      update();
    }
    catch (IOException e) {
      error.set(e.getMessage());
    }

  }

  public void logout()
  {
    try {
      model.logOut(model.getLoggedInUser().getUsername());
    } catch (Exception e) {
      this.error.set(e.getMessage());
    }
  }

  public void bindMessage(StringProperty property)
  {
    update();
    //is it ok bind simple here?
    property.bindBidirectional(message);
  }

  public void bindMessages(ObjectProperty<ObservableList<Message>> property)
  {
    update();
    property.bindBidirectional(allMessages);
  }
  public void bindStatus(StringProperty property) throws RemoteException
  {
    status.set(model.getStatus());
    property.bindBidirectional(status);
  }

  public void bindError(StringProperty property)
  {
    property.bind(error);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      update();
      //status.set(model.getStatus());
    });
  }
}
