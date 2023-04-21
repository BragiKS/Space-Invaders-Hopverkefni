package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Wave_Boss {

    private double degreeForCone;
    private Random spreadDegree;
    private Timeline battle;
    public Wave_Boss(Leikbord leikbord) {

        Alien_three boss = new Alien_three();
        leikbord.setBoss(boss);

        boss.setTranslateX(250);
        boss.setTranslateY(-100);

        leikbord.getChildren().add(boss);

        //Boss entering the screen movement
        Timeline entering = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            boss.setTranslateY(boss.getTranslateY() + 5);
        }));
        entering.setCycleCount(40);
        entering.play();

        //Boss move left after entering is finished
        TranslateTransition ttEntering = new TranslateTransition(Duration.seconds(3), boss);
        ttEntering.setCycleCount(1);
        ttEntering.setByX(-200);

        //Boss movement back and forth
        TranslateTransition tt = new TranslateTransition(Duration.seconds(6), boss);
        tt.setAutoReverse(true);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setByX(400);

        //Triple fire attack pattern
        Timeline Tripleshot = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            boss.TripleFire(leikbord);
        }));
        Tripleshot.setCycleCount(20);

        //Cone fire attack pattern
        spreadDegree = new Random();
        Timeline Coneshot = new Timeline(new KeyFrame(Duration.millis(100), e -> {

            degreeForCone = spreadDegree.nextDouble(-10, 10);
            boss.ConeSpray(leikbord, degreeForCone);

        }));
        Coneshot.setCycleCount(30);

        Random random = new Random();

        //Battle Timeline with different phases depending on boss health remaining
        battle = new Timeline(new KeyFrame(Duration.seconds(4), e -> {

            //Phase 1
            if (boss.getBossLife() > 1500) {

                int rndmnumber = random.nextInt(2);

                if (rndmnumber == 1) {
                    boss.BigShoot(leikbord);
                }
                else {
                    tt.pause();
                    boss.ChargeAttack(leikbord, tt);
                }
            }
            //Phase 2
            else if (boss.getBossLife() > 750) {

                int rndmnumber = random.nextInt(3);

                if (rndmnumber == 1) {
                    boss.BigShoot(leikbord);
                }
                else if (rndmnumber == 2) {
                    tt.pause();
                    boss.ChargeAttack(leikbord, tt);
                }
                else {
                    tt.pause();
                    Tripleshot.play();
                    Tripleshot.setOnFinished(e2 -> tt.play());
                }
            }

            //Phase 3
            else {

                int rndmnumber = random.nextInt(4);

                if (rndmnumber == 1) {
                    boss.BigShoot(leikbord);
                }
                else if (rndmnumber == 2) {
                    tt.pause();
                    boss.ChargeAttack(leikbord, tt);
                }
                else if (rndmnumber == 3) {
                    tt.pause();
                    Tripleshot.play();
                    Tripleshot.setOnFinished(e2 -> tt.play());
                }
                else {
                    tt.pause();
                    Coneshot.play();
                    Coneshot.setOnFinished(e2 -> {
                        tt.play();
                    });
                }
            }
        }));
        battle.setCycleCount(Timeline.INDEFINITE);

        //When boss is done entering it starts battle, back and forth movement
        entering.setOnFinished(e -> {
            ttEntering.play();
            battle.play();
        });
        ttEntering.setOnFinished(e -> {
            tt.play();
        });

    }

    public void stop() {
        battle.stop();
    }
}
