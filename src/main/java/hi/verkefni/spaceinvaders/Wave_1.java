package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Wave_1 {
    private int countaliens = 0;
    public Wave_1(Leikbord leikbord) {
        // Aliens initialization
        Alien_one[] aliens = new Alien_one[8];

        for (int i = 0; i < aliens.length; i++) {
            aliens[i] = new Alien_one();
            leikbord.getEnemies().add(aliens[i]);
            aliens[i].setTranslateX(100 * (i % 4 + 1));
            aliens[i].setTranslateY(-100 * (i / 4));
            leikbord.getChildren().add(aliens[i]);
        }

        // Alien timeline
        Timeline alienTimeline = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            for (Alien_one alien : aliens) {
                alien.setTranslateY(alien.getTranslateY() + 5);
            }
        }));
        alienTimeline.setCycleCount(40);
        alienTimeline.play();

        // Translate transitions for aliens
        for (int i = 0; i < aliens.length; i++) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(4), aliens[i]);
            tt.setAutoReverse(true);
            tt.setCycleCount(TranslateTransition.INDEFINITE);
            tt.setByX(80);
            tt.play();
        }
    }
}
