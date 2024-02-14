package Assignment3.model;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Model extends Remote
{
  String logIn(String username) throws RemoteException;
  void logOut(String username) throws RemoteException;
  void writeMessage(String text) throws RemoteException;
  ArrayList<Message> getAllMessages() throws RemoteException;
  User getLoggedInUser() throws RemoteException;
  String getStatus() throws RemoteException;

  void addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
}
