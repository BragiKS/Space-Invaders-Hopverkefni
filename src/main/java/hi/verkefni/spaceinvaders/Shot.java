package hi.verkefni.spaceinvaders;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shot extends ImageView {
    public Shot(double x,double y) {
        super(new Image("../src/main/resources/hi/verkefni/spaceinvaders/img/playerShoot.png"));
        setTranslateX(x);
        setTranslateY(y);
    }
}
