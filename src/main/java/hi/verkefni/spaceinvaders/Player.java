package hi.verkefni.spaceinvaders;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
    @FXML
    private Player fxSpaceShip;

    public Player() {
        FXML_Lestur.lesa(this, "player-view.fxml");
        setLayoutX(getImage().getWidth() / 2);
    }

    public static void main(String[] args) {

    }

    private static final double SPEED = 5.0; // Change this value to control the speed of the spaceship

    public Player(String imagePath, double x, double y, double width, double height) {
        super(new Image(imagePath, width, height, true, true));
        setX(x);
        setY(y);
    }

    public void Left() {
        setX(getX() - SPEED);
    }

    public void moveRight() {
        setX(getX() + SPEED);
    }
}
