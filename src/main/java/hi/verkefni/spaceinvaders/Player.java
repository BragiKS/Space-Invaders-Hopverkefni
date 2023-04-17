package hi.verkefni.spaceinvaders;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
    @FXML
    private Player fxSpaceShip;
    @FXML
    private Leikbord fxLeikbord;
    @FXML
    private Shot fxShot;

    public Player() {
        FXML_Lestur.lesa(this, "player-view.fxml");
        setLayoutX(getImage().getWidth() / 2);
    }

    public static void main(String[] args) {

    }

    private static final double SPEED = 10.0; // Change this value to control the speed of the spaceship

    public Player(String imagePath, double x, double y, double width, double height) {
        super(new Image(imagePath, width, height, true, true));
        setX(x);
        setY(y);
    }

    public void Left() {
        Leikbord parent = (Leikbord) this.getParent();
        Bounds l = parent.getBoundsInParent();
        if (getX() > 0) {
            setX(getX() - SPEED);
        }
    }

    public void Right() {
        Leikbord parent = (Leikbord) this.getParent();
        Bounds l = parent.getBoundsInParent();
        if (400 > getX()) {
            setX(getX() + SPEED);
        }
    }
    public void Shoot() {
        new Shot(getX(), getY());
    }
}
