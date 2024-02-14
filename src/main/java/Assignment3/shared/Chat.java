package Assignment3.shared;

import Assignment3.model.Message;
import Assignment3.model.MessageList;
import Assignment3.model.User;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Chat extends Remote
{
  String login(String username) throws RemoteException;
  void logout(String username) throws RemoteException;
  void writeMessages(Message message) throws RemoteException;
  ArrayList<Message> getMessages() throws RemoteException;
  String getStatus() throws RemoteException;
  void addPropertyChangeListener(RemotePropertyChangeListener<MessageList> listener) throws RemoteException;
  void removePropertyChangeListener(RemotePropertyChangeListener<MessageList> listener) throws RemoteException;
}
