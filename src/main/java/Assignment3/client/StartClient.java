package Assignment3.client;

import Assignment3.model.Model;
import Assignment3.model.ModelManager;
import Assignment3.shared.Chat;
import Assignment3.view.ViewHandler;
import Assignment3.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StartClient extends Application
{

  @Override public void start(Stage primaryStage) throws Exception
  {
    Registry registry = LocateRegistry.getRegistry(1099);
    Chat chat = (Chat) registry.lookup("chat");
    ClientListener clientListener = new ClientListener(chat);
    chat.addPropertyChangeListener(clientListener);
    //chat.addPropertyChangeListener(new Listener());
    Model model = new ModelManager(chat);
    //RemoteClient client = new ModelManager(chat);
    //chat.setRemoteClient(client);
    // registry.bind("client", remote);
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    viewHandler.start(primaryStage);
  }

  public static void main(String[] args)
  {
    launch();
  }
}
