package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Wave_3 {
    private int shootingtimer = 0;

    public Wave_3(Leikbord leikbord) {
        // Aliens and shooters initialization
        Alien_one[] aliens = new Alien_one[6];
        Alien_two[] shooters = new Alien_two[4];
        Alien_three boss = new Alien_three();

        for (int i = 0; i < aliens.length; i++) {
            aliens[i] = new Alien_one();
            leikbord.getEnemies().add(aliens[i]);
            aliens[i].setTranslateX(100 * (i + 1));
            aliens[i].setTranslateY(-100 * (i % 2));
            leikbord.getChildren().add(aliens[i]);
        }

        for (int i = 0; i < shooters.length; i++) {
            shooters[i] = new Alien_two();
            leikbord.getEnemies().add(shooters[i]);
            shooters[i].setTranslateX(100 * (i + 1) + 50);
            shooters[i].setTranslateY(-200 - 100 * (i % 2));
            leikbord.getChildren().add(shooters[i]);
        }

        boss.setTranslateX(300);
        boss.setTranslateY(-300);
        leikbord.getChildren().add(boss);

        // Alien and shooter timeline
        Timeline alienTimeline = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            for (Alien_one alien : aliens) {
                if (alien.getTranslateY() < 250) {
                    alien.setTranslateY(alien.getTranslateY() + 5);
                }
            }

            for (Alien_two shooter : shooters) {
                if (shooter.getTranslateY() < 200) {
                    shooter.setTranslateY(shooter.getTranslateY() + 5);
                }
            }

            shootingtimer++;

            if (shootingtimer % 20 == 0 && shootingtimer > 39) {
                for (Alien_two shooter : shooters) {
                    shooter.Shoot(leikbord);
                }
            }
        }));
        alienTimeline.setCycleCount(Timeline.INDEFINITE);
        alienTimeline.play();

        // Translate transitions for aliens and shooters
        for (int i = 0; i < aliens.length; i++) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(5 - i * 0.2), aliens[i]);
            tt.setAutoReverse(true);
            tt.setCycleCount(TranslateTransition.INDEFINITE);
            tt.setByX(80);
            tt.play();
        }

        for (int i = 0; i < shooters.length; i++) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(5 - i * 0.2), shooters[i]);
            tt.setAutoReverse(true);
            tt.setCycleCount(TranslateTransition.INDEFINITE);
            tt.setByX(80);
            tt.play();
        }

        // Translate transition for the boss (Alien_three)
        TranslateTransition ttBoss = new TranslateTransition(Duration.seconds(5), boss);
        ttBoss.setAutoReverse(true);
        ttBoss.setCycleCount(TranslateTransition.INDEFINITE);
        ttBoss.setByX(200);
        ttBoss.play();
    }
}
