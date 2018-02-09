package prettyMuchEverything;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//http://gjf2a.blogspot.com/2015/01/creating-minimal-javafx-user-interface.html

public class FitnessMain extends Application {
 @Override
 public void start(Stage primaryStage) {
  try {
   FXMLLoader loader = new FXMLLoader();
   loader.setLocation(FitnessMain.class.getResource("FitnessGUI.fxml"));
   BorderPane root = (BorderPane) loader.load();
   Scene scene = new Scene(root);
   primaryStage.setScene(scene);
   primaryStage.show();
  } catch(Exception e) {
   e.printStackTrace();
  }
 }

 public static void main(String[] args) {
  launch(args);
 }
}
