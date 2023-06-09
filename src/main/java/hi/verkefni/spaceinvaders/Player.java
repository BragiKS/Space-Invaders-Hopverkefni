package hi.verkefni.spaceinvaders;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player extends ImageView {
    @FXML
    private Player fxSpaceShip;
    @FXML
    private Leikbord fxLeikbord;
    @FXML
    private Shot fxShot;

    private Audio audio = new Audio();
    private int dissappearCounter = 0;

    public Player() {
        FXML_Lestur.lesa(this, "player-view.fxml");
        setLayoutX(getImage().getWidth() / 2);
    }

    public static void main(String[] args) {

    }

    private static final double SPEED = 10.0; // Change this value to control the speed of the spaceship

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
        if (525 > getX()) {
            setX(getX() + SPEED);
        }
    }
    public void Shoot(Leikbord leikbordi) {

        Shot bullet = new Shot();
        leikbordi.getLasers().add(bullet);
        bullet.setTranslateX(getX() + 30.5);
        bullet.setTranslateY(getY() - 15);


        leikbordi.getChildren().add(bullet);
        audio.shootSound();

        Timeline bulletTimeline = new Timeline(new KeyFrame(Duration.seconds(0.0250), e -> {
            bullet.setTranslateY(bullet.getTranslateY() - 5);

            if (bullet.getTranslateY() < 0) {
                leikbordi.getChildren().remove(bullet);
                leikbordi.getLasers().remove(bullet);
            }
        }));

        bulletTimeline.setCycleCount(Timeline.INDEFINITE);
        bulletTimeline.play();

    }

    public void HitAnimation() {

        Timeline disappearTimeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            if (dissappearCounter % 2 == 0) {
                setVisible(false);
            } else {
                setVisible(true);
            }
            dissappearCounter++;
        }));
        disappearTimeline.setCycleCount(12);
        disappearTimeline.play();
    }
}
