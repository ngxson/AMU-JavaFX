package ngxson.nasa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ngxson.utils.NearEarthObject;

import java.io.*;
import java.net.URISyntaxException;

public class Main extends Application {

    public static final boolean OFFLINE = true;
    public static DataFetcher dataFetcher = new DataFetcher();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("neo.fxml"));
        primaryStage.setTitle("Near Earth Object");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException, URISyntaxException {
        launch(args);
        //fetchAndSaveData();
    }

    public static void fetchAndSaveData() throws IOException, URISyntaxException {
        for (var i = 0 ; i < 1000/20 ; i++) {
            var file = new File("./data/" + i + ".json");
            if (!file.exists()) file.createNewFile();
            FileOutputStream fop = new FileOutputStream(file);
            dataFetcher.fetchToOutputStream(fop, i);
        }
    }
}

