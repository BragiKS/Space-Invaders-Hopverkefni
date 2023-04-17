package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class Wave_1 {
    public Wave_1(Leikbord leikbord) {

        Alien_one alien1 = new Alien_one();
        alien1.setTranslateX(100);
        Alien_one alien2 = new Alien_one();
        alien2.setTranslateX(200);
        Alien_one alien3 = new Alien_one();
        alien3.setTranslateX(300);
        leikbord.getChildren().add(alien1);
        leikbord.getChildren().add(alien2);
        leikbord.getChildren().add(alien3);

        Timeline alienTimeline = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            if (alien1.getTranslateY() < 200) {
                alien1.setTranslateY(alien1.getTranslateY() + 5);
                alien2.setTranslateY(alien2.getTranslateY() + 5);
                alien3.setTranslateX(alien3.getTranslateY() + 5);
            } else {
                alien1.setTranslateX(alien1.getTranslateX() + 5);
            }

        }));
        alienTimeline.setCycleCount(Timeline.INDEFINITE);
        alienTimeline.play();

    }
}
