package hi.verkefni.spaceinvaders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceApplication extends Application {
    //Fastar

    //Myndir


    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(SpaceApplication.class.getResource("playArea-view.fxml"));
        Scene s = new Scene(new Pane());
        ViewSwitcher.setScene(s);
        ViewSwitcher.switchTo(View.SHOOTING);
        SpaceController sc = (SpaceController) ViewSwitcher.lookup(View.SHOOTING);
        //sc.controls();
        //sc.start();
        stage.setTitle("Space invaders");
        stage.setScene(s);
        stage.show();


        sc.orvatakkar();
        sc.startGame();
    }

    public static void main(String[] args) {
        launch();
    }
}
