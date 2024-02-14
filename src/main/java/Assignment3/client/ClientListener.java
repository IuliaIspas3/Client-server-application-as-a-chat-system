package Assignment3.client;

import Assignment3.model.Message;
import Assignment3.model.MessageList;
import Assignment3.model.User;
import Assignment3.shared.Chat;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ClientListener extends UnicastRemoteObject implements RemotePropertyChangeListener<MessageList>, RemoteClient
{
  private final Chat server;
  private User user;
  private MessageList messages;

  public ClientListener(Chat server) throws RemoteException
  {
    this.server = server;
    this.messages = MessageList.getInstance();
    this.server.addPropertyChangeListener(this);
  }

  public String logIn(String username) throws RemoteException
  {
    if (username.isEmpty() || username.equals("")) {
      throw new IllegalArgumentException("Username cannot be empty");
    }
    this.user = new User(username);
    //client.setStatus(status);
    return server.login(username);
  }

  public void logOut(String username) throws RemoteException
  {
    server.logout(username);
    //client.setStatus(status);
  }

  public void writeMessage(String text) throws RemoteException
  {
    if (text.isEmpty() || text.equals("")) {
      throw new IllegalArgumentException("Message cannot be empty");
    }
    Message message = new Message(text, user);
    server.writeMessages(message);
    //client.setStatus(status);
  }

  public ArrayList<Message> getAllMessages() throws RemoteException
  {
    return this.server.getMessages();
  }

  public String getStatus() throws RemoteException
  {
    return server.getStatus();
  }
  public User getLoggedInUser() throws RemoteException {
    return this.user;
  }

  @Override public void propertyChange(RemotePropertyChangeEvent remotePropertyChangeEvent) throws RemoteException
  {
    messages.setMessages((ArrayList<Message>) remotePropertyChangeEvent.getNewValue());
  }
}
