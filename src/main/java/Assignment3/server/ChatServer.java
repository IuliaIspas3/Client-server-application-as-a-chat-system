package Assignment3.server;

import Assignment3.model.User;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer
{
  public static void main(String[] args) throws IOException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    ArrayList<User> users = new ArrayList<>();
    RemoteChat chat = new RemoteChat(users);
    Remote remote = UnicastRemoteObject.exportObject(chat, 0);
    registry.bind("chat", remote);
    System.out.println("Server is running");
  }
}
