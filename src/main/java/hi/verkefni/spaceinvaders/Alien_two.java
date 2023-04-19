package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Alien_two extends ImageView {
    public Alien_two() {
        FXML_Lestur.lesa(this, "alien2-view.fxml");
    }

    public void Shoot(Leikbord leikbord) {
        Alienshot shot = new Alienshot();
        leikbord.getEnemyLasers().add(shot);
        shot.setTranslateX(getX());
        shot.setTranslateY(getY());
        leikbord.getChildren().add(shot);
        Timeline shotTimeline = new Timeline(new KeyFrame(Duration.seconds(0.0250), e -> {
            shot.setTranslateY(shot.getTranslateY() + 5);

            if (shot.getTranslateY() > 600) {
                leikbord.getChildren().remove(shot);
                leikbord.getEnemyLasers().remove(shot);
            }
        }));

        shotTimeline.setCycleCount(Timeline.INDEFINITE);
        shotTimeline.play();
    }
}
