package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Wave_Boss {
    public Wave_Boss(Leikbord leikbord) {

        Alien_three boss = new Alien_three();
        leikbord.setBoss(boss);

        boss.setTranslateX(300);
        boss.setTranslateY(-50);

        Timeline entering = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            boss.setTranslateY(boss.getTranslateY() + 5);
        }));

        entering.setCycleCount(70);
        entering.play();

        TranslateTransition tt = new TranslateTransition(Duration.seconds(5), boss);
        tt.setAutoReverse(true);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setByX(80);
        tt.play();

        Timeline Tripleshot = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            boss.TripleFire(leikbord);
        }));
        Tripleshot.setCycleCount(20);

        Random random = new Random();
        Timeline phase1 = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
            tt.play();
            int rndmnumber = random.nextInt(3);
            if (rndmnumber == 1) {
                tt.pause();
                Tripleshot.play();

            } else {
                tt.pause();
                boss.BigShoot(leikbord);
            }
        }));

    }
}
