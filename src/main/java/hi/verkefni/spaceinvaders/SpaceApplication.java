package hi.verkefni.spaceinvaders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceApplication extends Application {
    //Fastar

    //Myndir


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceApplication.class.getResource("playArea-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600, 700);
        SpaceController sc = fxmlLoader.getController();
        //sc.controls();
        //sc.start();
        stage.setTitle("Space invader");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
