package Assignment3.view;

import Assignment3.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private Scene scene;

  private Stage stage;

  private ViewFactory viewFactory;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewFactory = new ViewFactory(this, viewModelFactory);
    this.scene = new Scene(new Region());
  }

  public void start(Stage stage) {
    this.stage = stage;
    openView("login");
  }

  public void openView(String id) {
    Region root = viewFactory.loadView(id);
    scene.setRoot(root);
    stage.setScene(scene);
    stage.sizeToScene();
    stage.show();
  }

  public void close()
  {
    stage.close();
  }
}
