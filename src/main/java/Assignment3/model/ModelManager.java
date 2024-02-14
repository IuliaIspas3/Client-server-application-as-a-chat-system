package Assignment3.model;

import Assignment3.client.ClientListener;
import Assignment3.shared.Chat;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private final ClientListener clientListener;
  private User user;
  private final PropertyChangeSupport support;
  //private MessageList messages;

  public ModelManager(Chat server) throws RemoteException
  {
    this.clientListener = new ClientListener(server);
    this.support = new PropertyChangeSupport(this);
    //this.messages = MessageList.getInstance();
  }

  @Override public String logIn(String username) throws RemoteException
  {
//    if (username.isEmpty() || username.equals("")) {
//      throw new IllegalArgumentException("Username cannot be empty");
//    }
//    this.user = new User(username);
//    support.firePropertyChange("login", null, server.login(username));
//    //client.setStatus(status);
//    return server.login(username);
    return clientListener.logIn(username);
  }

  @Override public void logOut(String username) throws RemoteException
  {
    clientListener.logOut(username);
    //server.logout(username);
    //client.setStatus(status);
  }

  @Override public void writeMessage(String text) throws RemoteException
  {
    clientListener.writeMessage(text);
//    if (text.isEmpty() || text.equals("")) {
//      throw new IllegalArgumentException("Message cannot be empty");
//    }
//    Message message = new Message(text, user);
//    server.writeMessages(message);
//    //client.setStatus(status);
  }

  @Override public User getLoggedInUser() throws RemoteException {
    return clientListener.getLoggedInUser();
  }

  @Override public String getStatus() throws RemoteException
  {
    return clientListener.getStatus();
//    return server.getStatus();
  }

  @Override public ArrayList<Message> getAllMessages() throws RemoteException
  {
    return clientListener.getAllMessages();
//    messages.setMessages(server.getMessages());
//    return messages.getMessages();
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    this.support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    this.support.addPropertyChangeListener(listener);
  }

//  @Override public void updateMessages(ArrayList<Message> messageList) throws RemoteException
//  {
//    this.messages.setMessages(messageList);
//  }
}
