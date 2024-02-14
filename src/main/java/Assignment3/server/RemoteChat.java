package Assignment3.server;

import Assignment3.model.Message;
import Assignment3.model.MessageList;
import Assignment3.model.User;
import Assignment3.shared.Chat;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class RemoteChat implements Chat
{
  private ArrayList<User> users;
  private User user;
  private final MessageList messageList;
  private final RemotePropertyChangeSupport<MessageList> support;
  //private RemoteClient remoteClient;
  private String status;
  public RemoteChat(ArrayList<User> users) throws RemoteException {
    this.messageList = MessageList.getInstance();
    this.users = users;
    this.support = new RemotePropertyChangeSupport<>();
  }

  @Override public String login(String username) throws RemoteException
  {
    User user = new User(username);
    for (User user1 : users)
    {
      //if this username already exists
      if (user1.getUsername().equals(username)) {
        return "This username already exists.";
      }
    }
    this.user = user;
    users.add(user);
    this.status = users.size() + "users";
    Message message = new Message("The user " + username + " has connected!", user);
    message.setType("general");
    support.firePropertyChange("login", null, this.messageList);
    messageList.addMessage(message);
    return username;
  }

  @Override public void logout(String username) throws RemoteException
  {
    User user = new User(username);
    users.remove(user);
    this.status = users.size() + "users";
    Message message = new Message("The user " + username + " has disconnected :(", user);
    message.setType("general");
    support.firePropertyChange("logout", null, this.messageList);
    messageList.addMessage(message);
    //remoteClient.updateMessages(messageList.getMessages());
  }

  @Override public void writeMessages(Message message) throws RemoteException
  {
    support.firePropertyChange("write", null, this.messageList);
    messageList.addMessage(message);
  }

  @Override public ArrayList<Message> getMessages() throws RemoteException
  {
    return this.messageList.getMessages();
  }

  @Override public String getStatus() throws RemoteException
  {
    return this.status;
  }

  @Override public void addPropertyChangeListener(RemotePropertyChangeListener<MessageList> listener) throws RemoteException
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(RemotePropertyChangeListener<MessageList> listener) throws RemoteException
  {
    support.removePropertyChangeListener(listener);
  }


}
