package ngxson.nasa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ngxson.utils.NearEarthObject;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("neo.fxml"));
        primaryStage.setTitle("Near Earth Object");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        /*var count = 0;
        for (var i = 0 ; i < 1000/20 ; i++) {
            for (NearEarthObject neo : dataFetcher.fetch(i).getNearEarthObjects()) {
                count++;
                System.out.println(count + ": " + neo.getName());
            }
        }*/
        launch(args);
    }
}

