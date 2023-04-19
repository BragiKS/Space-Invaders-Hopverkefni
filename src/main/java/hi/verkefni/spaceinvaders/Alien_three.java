package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Alien_three extends ImageView {
    private int bossLife = 60;
    public Alien_three() {
        FXML_Lestur.lesa(this, "alien3-view.fxml");
    }

    public int getBossLife() {
        return bossLife;
    }

    public void decreaseLife() {
        bossLife--;
    }

    public void BigShoot(Leikbord leikbord) {
        if (bossLife > 0) {
            Bigshot shot = new Bigshot();
            leikbord.getEnemyLasers().add(shot);
            shot.setTranslateX(getTranslateX() + getFitWidth()/4);
            shot.setTranslateY(getTranslateY() + 30);
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

    public void TripleFire(Leikbord leikbord) {
        if (bossLife > 0) {
            Alienshot[] shots = new Alienshot[3];
            for (int i = 0; i < shots.length; i++) {
                shots[i] = new Alienshot();
                shots[i].setRotate(30*(i - 1));
                leikbord.getEnemyLasers().add(shots[i]);
                shots[i].setTranslateX(getTranslateX() + 10 + (i*20));
            }

            Timeline shotTimeline = new Timeline(new KeyFrame(Duration.millis(250), e -> {
                for (int i = 0; i < shots.length; i++) {
                    shots[i].setTranslateX(shots[i].getTranslateX() + (i-1));
                    shots[i].setTranslateY(shots[i].getTranslateY() + 5);

                    if (shots[i].getTranslateY() > 600) {
                        leikbord.getChildren().remove(shots[i]);
                        leikbord.getEnemyLasers().remove(shots[i]);
                    }
                }
            }));

            shotTimeline.setCycleCount(Timeline.INDEFINITE);
            shotTimeline.play();
            
        }
    }
}
