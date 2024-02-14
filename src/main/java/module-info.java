module Assignment3 {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires com.google.gson;
  requires java.rmi;
  requires remoteobserver;

  opens Assignment3 to javafx.fxml;
  opens Assignment3.view to javafx.fxml;

  opens Assignment3.model to com.google.gson, remoteobserver;
  opens Assignment3.server to remoteobserver;

  exports Assignment3.client;
  exports Assignment3.shared to java.rmi;
  exports Assignment3.model to java.rmi;
}