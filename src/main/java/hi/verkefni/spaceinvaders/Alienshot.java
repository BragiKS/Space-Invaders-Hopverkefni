package hi.verkefni.spaceinvaders;

import javafx.scene.image.ImageView;

public class Alienshot extends ImageView {
    public Alienshot() {
        FXML_Lestur.lesa(this, "alienshot-view.fxml");
    }
}
