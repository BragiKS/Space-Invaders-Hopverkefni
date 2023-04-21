package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Wave_3 {
    private int shootingtimer = 0;
    private Timeline shootingTimeline;

    public Wave_3(Leikbord leikbord) {
        // Aliens and shooters initialization
        Alien_one[] aliens = new Alien_one[8];
        Alien_two[] shooters = new Alien_two[5];
        Alien_three boss = new Alien_three();

        for (int i = 0; i < aliens.length; i++) {
            aliens[i] = new Alien_one();
            leikbord.getEnemies().add(aliens[i]);

            if (i < 4) {
                aliens[i].setTranslateY(-100);
                aliens[i].setTranslateX(100 * (i + 1));
            } else {
                aliens[i].setTranslateY(0);
                aliens[i].setTranslateX(100 * (i - 3));
            }
            leikbord.getChildren().add(aliens[i]);
        }

        for (int i = 0; i < shooters.length; i++) {
            shooters[i] = new Alien_two();
            leikbord.getEnemies().add(shooters[i]);
            shooters[i].setTranslateX(50 * (i + 1) + 50);
            shooters[i].setTranslateY(-200 - 100 * (i % 2));
            leikbord.getChildren().add(shooters[i]);
        }

        boss.setTranslateX(300);
        boss.setTranslateY(-300);
        leikbord.getChildren().add(boss);

        // Alien and shooter timeline
        Timeline alienTimeline = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            for (Alien_one alien : aliens) {
                alien.setTranslateY(alien.getTranslateY() + 5);
            }

            for (Alien_two shooter : shooters) {
                shooter.setTranslateY(shooter.getTranslateY() + 5);
            }
        }));
        alienTimeline.setCycleCount(70);
        alienTimeline.play();

        shootingTimeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            shootingtimer++;
            if (shootingtimer > 1) {
                for (Alien_two shooter : shooters) {
                    shooter.Shoot(leikbord);
                }
            }
        }));
        shootingTimeline.setCycleCount(Timeline.INDEFINITE);
        shootingTimeline.play();
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

    public void stop() {
        shootingTimeline.stop();
    }
}
