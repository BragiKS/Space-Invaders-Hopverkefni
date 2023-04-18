package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class Wave_1 {
    public Wave_1(Leikbord leikbord) {

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
        Alien_one alien5 = new Alien_one();
        leikbord.getEnemies().add(alien5);
        alien5.setTranslateX(100);
        alien5.setTranslateY(-100);
        Alien_one alien6 = new Alien_one();
        leikbord.getEnemies().add(alien6);
        alien6.setTranslateX(200);
        alien6.setTranslateY(-100);
        Alien_one alien7 = new Alien_one();
        leikbord.getEnemies().add(alien7);
        alien7.setTranslateX(300);
        alien7.setTranslateY(-100);
        Alien_one alien8 = new Alien_one();
        leikbord.getEnemies().add(alien8);
        alien8.setTranslateX(400);
        alien8.setTranslateY(-100);

        leikbord.getChildren().add(alien1);
        leikbord.getChildren().add(alien2);
        leikbord.getChildren().add(alien3);
        leikbord.getChildren().add(alien4);
        leikbord.getChildren().add(alien5);
        leikbord.getChildren().add(alien6);
        leikbord.getChildren().add(alien7);
        leikbord.getChildren().add(alien8);

        Timeline alienTimeline = new Timeline(new KeyFrame(Duration.millis(160), e -> {
            if (alien1.getTranslateY() < 200) {
                alien1.setTranslateY(alien1.getTranslateY() + 5);
                alien2.setTranslateY(alien2.getTranslateY() + 5);
                alien3.setTranslateY(alien3.getTranslateY() + 5);
                alien4.setTranslateY(alien4.getTranslateY() + 5);
                alien5.setTranslateY(alien5.getTranslateY() + 5);
                alien6.setTranslateY(alien6.getTranslateY() + 5);
                alien7.setTranslateY(alien7.getTranslateY() + 5);
                alien8.setTranslateY(alien8.getTranslateY() + 5);

            }
        }));
        alienTimeline.setCycleCount(Timeline.INDEFINITE);
        alienTimeline.play();

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(4), alien1);
        translateTransition1.setAutoReverse(true);
        translateTransition1.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition1.setByX(80);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(4), alien2);
        translateTransition2.setAutoReverse(true);
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.setByX(80);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(4), alien3);
        translateTransition3.setAutoReverse(true);
        translateTransition3.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition3.setByX(80);
        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(4), alien4);
        translateTransition4.setAutoReverse(true);
        translateTransition4.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition4.setByX(80);
        translateTransition4.play();

        TranslateTransition translateTransition5 = new TranslateTransition(Duration.seconds(4), alien5);
        translateTransition5.setAutoReverse(true);
        translateTransition5.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition5.setByX(80);
        translateTransition5.play();

        TranslateTransition translateTransition6 = new TranslateTransition(Duration.seconds(4), alien6);
        translateTransition6.setAutoReverse(true);
        translateTransition6.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition6.setByX(80);
        translateTransition6.play();

        TranslateTransition translateTransition7 = new TranslateTransition(Duration.seconds(4), alien7);
        translateTransition7.setAutoReverse(true);
        translateTransition7.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition7.setByX(80);
        translateTransition7.play();

        TranslateTransition translateTransition8 = new TranslateTransition(Duration.seconds(4), alien8);
        translateTransition8.setAutoReverse(true);
        translateTransition8.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition8.setByX(80);
        translateTransition8.play();

    }
}
