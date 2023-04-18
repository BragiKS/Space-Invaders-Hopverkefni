package hi.verkefni.spaceinvaders;

import javafx.scene.image.ImageView;

public class Boom extends ImageView {
    public Boom() {
        FXML_Lestur.lesa(this, "boom-view.fxml");
    }
}
