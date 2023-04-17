package hi.verkefni.spaceinvaders;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Shot extends ImageView {

        public Shot(){
            FXML_Lestur.lesa(this,"shot-view.fxml");
        }
    }

