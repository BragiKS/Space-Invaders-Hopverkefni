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

        boss.setTranslateX(250);
        boss.setTranslateY(-100);

        leikbord.getChildren().add(boss);

        Timeline entering = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            boss.setTranslateY(boss.getTranslateY() + 5);
        }));
        entering.setCycleCount(40);
        entering.play();

        TranslateTransition tt = new TranslateTransition(Duration.seconds(3), boss);
        tt.setAutoReverse(true);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setByX(200);

        Timeline Tripleshot = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            boss.TripleFire(leikbord);
        }));
        Tripleshot.setCycleCount(20);

        Random random = new Random();

        Timeline phase1 = new Timeline(new KeyFrame(Duration.seconds(4), e -> {

            int rndmnumber = random.nextInt(3);
            System.out.println(rndmnumber);

            if (rndmnumber == 1) {
                tt.pause();
                Tripleshot.play();
                Tripleshot.setOnFinished(e2 -> tt.play());

            } else if (rndmnumber == 2){
                boss.BigShoot(leikbord);

            } else {
                tt.pause();
                boss.ChargeAttack(leikbord, tt);

            }
        }));
        phase1.setCycleCount(Timeline.INDEFINITE);

        entering.setOnFinished(e -> {
            tt.play();
            phase1.play();
        });

    }
}
