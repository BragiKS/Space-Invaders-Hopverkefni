package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Alien_three extends ImageView {
    private int bossLife = 700; //Set to 2250
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
            shot.setTranslateX(getTranslateX() + getFitWidth()/2);
            shot.setTranslateY(getTranslateY() + 50);
            leikbord.getChildren().add(shot);
            Timeline shotTimeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
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
                shots[i].setRotate(25*(1 - i));
                leikbord.getEnemyLasers().add(shots[i]);
                shots[i].setTranslateX(getTranslateX() + getFitWidth()/2 + 10 * (i-1));
                shots[i].setTranslateY(getTranslateY()+ 70);
                leikbord.getChildren().add(shots[i]);
            }

            Timeline shotTimeline = new Timeline(new KeyFrame(Duration.millis(25), e -> {
                for (int i = 0; i < shots.length; i++) {
                    shots[i].setTranslateX(shots[i].getTranslateX() + 2 * (i-1));
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

    public void ChargeAttack(Leikbord leikbord, TranslateTransition tt) {
        Timeline chargeTimeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {

            setTranslateY(getTranslateY() + 5);
            if (getTranslateY() == 600) {
                setTranslateY(-100);
            }
        }));

        chargeTimeline.setCycleCount(140);
        chargeTimeline.play();
        chargeTimeline.setOnFinished(e -> tt.play());
    }

    public void ConeSpray(Leikbord leikbord, double deg) {
        if (bossLife > 0) {
            Alienshot shot = new Alienshot();
            leikbord.getEnemyLasers().add(shot);
            shot.setTranslateX(getTranslateX() + getFitWidth()/2);
            shot.setTranslateY(getTranslateY() + 70);
            shot.setRotate(-deg);
            leikbord.getChildren().add(shot);

            Timeline shotTimeline = new Timeline(new KeyFrame(Duration.millis(25), e -> {

                shot.setTranslateX(shot.getTranslateX() + deg/2);
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
}
