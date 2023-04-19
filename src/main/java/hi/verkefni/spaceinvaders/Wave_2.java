package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Wave_2 {
    private int shootingtimer = 0;
    public Wave_2(Leikbord leikbord) {
        Alien_one alien1 = new Alien_one();
        leikbord.getEnemies().add(alien1);
        alien1.setTranslateX(100);

        Alien_one alien2 = new Alien_one();
        leikbord.getEnemies().add(alien2);
        alien2.setTranslateX(200);

        Alien_one alien3 = new Alien_one();
        leikbord.getEnemies().add(alien3);
        alien3.setTranslateX(300);

        Alien_one alien4 = new Alien_one();
        leikbord.getEnemies().add(alien4);
        alien4.setTranslateX(400);

        Alien_two shooter1 = new Alien_two();
        leikbord.getEnemies().add(shooter1);
        shooter1.setTranslateX(150);
        shooter1.setTranslateY(-100);

        Alien_two shooter2 = new Alien_two();
        leikbord.getEnemies().add(shooter2);
        shooter2.setTranslateX(250);
        shooter2.setTranslateY(-100);

        Alien_two shooter3 = new Alien_two();
        leikbord.getEnemies().add(shooter3);
        shooter3.setTranslateX(350);
        shooter3.setTranslateY(-100);

        leikbord.getChildren().add(alien1);
        leikbord.getChildren().add(alien2);
        leikbord.getChildren().add(alien3);
        leikbord.getChildren().add(alien4);
        leikbord.getChildren().add(shooter1);
        leikbord.getChildren().add(shooter2);
        leikbord.getChildren().add(shooter3);

        Timeline alienTimeline = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            if (alien1.getTranslateY() < 200) {
                alien1.setTranslateY(alien1.getTranslateY() + 5);
                alien2.setTranslateY(alien2.getTranslateY() + 5);
                alien3.setTranslateY(alien3.getTranslateY() + 5);
                alien4.setTranslateY(alien4.getTranslateY() + 5);
                shooter1.setTranslateY(shooter1.getTranslateY() + 5);
                shooter2.setTranslateY(shooter2.getTranslateY() + 5);
                shooter3.setTranslateY(shooter3.getTranslateY() + 5);
            }

            shootingtimer++;

            if (shootingtimer % 20 == 0 && shootingtimer > 59) {
                shooter1.Shoot(leikbord);
                shooter2.Shoot(leikbord);
                shooter3.Shoot(leikbord);
            }
        }));
        alienTimeline.setCycleCount(Timeline.INDEFINITE);
        alienTimeline.play();

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(5), alien1);
        translateTransition1.setAutoReverse(true);
        translateTransition1.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition1.setByX(80);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(5), alien2);
        translateTransition2.setAutoReverse(true);
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.setByX(80);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(5), alien3);
        translateTransition3.setAutoReverse(true);
        translateTransition3.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition3.setByX(80);
        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(5), alien4);
        translateTransition4.setAutoReverse(true);
        translateTransition4.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition4.setByX(80);
        translateTransition4.play();

        TranslateTransition translateTransition5 = new TranslateTransition(Duration.seconds(5), shooter1);
        translateTransition5.setAutoReverse(true);
        translateTransition5.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition5.setByX(80);
        translateTransition5.play();

        TranslateTransition translateTransition6 = new TranslateTransition(Duration.seconds(5), shooter2);
        translateTransition6.setAutoReverse(true);
        translateTransition6.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition6.setByX(80);
        translateTransition6.play();

        TranslateTransition translateTransition7 = new TranslateTransition(Duration.seconds(5), shooter3);
        translateTransition7.setAutoReverse(true);
        translateTransition7.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition7.setByX(80);
        translateTransition7.play();
    }
}
