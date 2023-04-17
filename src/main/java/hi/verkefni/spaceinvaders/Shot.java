package hi.verkefni.spaceinvaders;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Shot extends ImageView {

    public Shot(){
        FXML_Lestur.lesa(this,"shot-view.fxml");
    }
}


