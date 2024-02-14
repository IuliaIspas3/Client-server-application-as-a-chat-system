package Assignment3.client;

import Assignment3.model.Message;
import Assignment3.model.MessageList;
import Assignment3.model.User;
import Assignment3.server.RemoteChat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public interface RemoteClient extends Remote
{
  String logIn(String username) throws RemoteException;
  void logOut(String username) throws RemoteException;
  ArrayList<Message> getAllMessages() throws RemoteException;
  String getStatus() throws RemoteException;
  User getLoggedInUser() throws RemoteException;
  void writeMessage(String text) throws RemoteException;
  //oid updateMessages(ArrayList<Message> messageList) throws RemoteException;
}
