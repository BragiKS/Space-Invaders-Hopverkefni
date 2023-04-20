package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Wave_Boss {

    private double degreeForCone = 0;
    private double counterForCone = 0;
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

        //Boss movement back and forth
        TranslateTransition tt = new TranslateTransition(Duration.seconds(3), boss);
        tt.setAutoReverse(true);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setByX(200);

        //Triple fire attack pattern
        Timeline Tripleshot = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            boss.TripleFire(leikbord);
        }));
        Tripleshot.setCycleCount(20);

        //Cone fire attack pattern
        Timeline Coneshot = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            boss.ConeSpray(leikbord, degreeForCone);

            if (counterForCone > 5 && counterForCone <= 10) {
                degreeForCone--;
            } else if (counterForCone > 15) {
                degreeForCone--;
            } else {
                degreeForCone++;
            }
            counterForCone++;
        }));
        Coneshot.setCycleCount(20);

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
                        degreeForCone = 0;
                        counterForCone = 0;
                        tt.play();
                    });
                }
            }
        }));
        battle.setCycleCount(Timeline.INDEFINITE);

        //When boss is done entering it starts battle, back and forth movement
        entering.setOnFinished(e -> {
            tt.play();
            battle.play();
        });

    }

    public void stop() {
        battle.stop();
    }
}
