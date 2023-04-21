package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class Wave_Boss {

    private double degreeForCone;
    private Random spreadDegree;
    private Timeline battle;
    private Timeline healthTimeline;
    private ProgressBar healthBar;
    public Wave_Boss(Leikbord leikbord) {

        //Adding Boss to the screen
        Alien_three boss = new Alien_three();
        leikbord.setBoss(boss);

        boss.setTranslateX(250);
        boss.setTranslateY(-100);

        leikbord.getChildren().add(boss);

        //Adding health bar.
        healthBar = new ProgressBar(1.0);
        healthBar.setPrefSize(400, 20);
        healthBar.setTranslateX(100);
        healthBar.setTranslateY(50);
        healthBar.setStyle("-fx-accent: red;");

        healthTimeline = new Timeline(new KeyFrame(Duration.millis(20), e -> {
            healthBar.setProgress((double) leikbord.getBoss().getBossLife() / 2250);
        }));
        healthTimeline.setCycleCount(Timeline.INDEFINITE);

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

                int rndmnumber = random.nextInt(4);

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

                int rndmnumber = random.nextInt(6);

                if (rndmnumber == 1) {
                    boss.BigShoot(leikbord);
                }
                else if (rndmnumber == 2) {
                    tt.pause();
                    boss.ChargeAttack(leikbord, tt);
                }
                else if (rndmnumber == 3 || rndmnumber == 4) {
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
            leikbord.getChildren().add(healthBar);
            healthTimeline.play();
            battle.play();
        });
        ttEntering.setOnFinished(e -> {
            tt.play();
        });

    }

    public void stop() {
        battle.stop();
        healthTimeline.stop();
    }

    public ProgressBar getHealthBar() {
        return this.healthBar;
    }
}
