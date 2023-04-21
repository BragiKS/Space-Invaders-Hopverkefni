package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class SpaceController {


    public MediaView mediaView;
    private Timeline time;
    private Audio audio = new Audio();
    @FXML
    private Leikbord fxLeikbord;
    @FXML
    private Label fxStig;
    private Wave_1 wave1;
    private Wave_2 wave2;
    private Wave_3 wave3;
    private Wave_Boss bosswave;
    private Heart lifeCounter;
    private boolean canShoot = true;

    private boolean canBeHit = true;

    private int Wavecounter = 1; // Set to 1

    private final double shootCooldown = 0.2; // Cooldown duration in seconds //set it to 0.5

    private final double shieldTime = 3;

    private int playerLife = 3;

    Leikur leikur;



    public Leikbord getFxLeikbord () {
        return fxLeikbord;
    }

    public void startGame() {
        lifeCounter = new Heart(fxLeikbord);
        KeyFrame k = new KeyFrame(Duration.millis(10),
                e -> {
                    checkCollisions();
                    playerCollision();

                    if(playerLife == 2) {
                        fxLeikbord.removeHeartThree();
                    }

                    if(playerLife == 1) {
                        fxLeikbord.removeHeartTwo();
                    }

                    if (Wavecounter == 5) {
                        bossCollision();
                    }
                    if (playerLife == 0) {
                        //GAMEOVER!
                        ViewSwitcher.switchTo(View.OVER);
                        switch (Wavecounter) {
                            case 3:
                                wave2.stop();
                                break;
                            case 4:
                                wave3.stop();
                                break;
                            case 5:
                                bosswave.stop();
                                break;
                        }
                        time.stop();
                    }
                    if (fxLeikbord.allEnemiesDestroyed() && Wavecounter == 1) {

                        wave1 = new Wave_1(fxLeikbord);
                        Wavecounter++;
                    }
                    if (fxLeikbord.allEnemiesDestroyed() && Wavecounter == 2) {
                        wave2 = new Wave_2(fxLeikbord);
                        Wavecounter++;
                    }
                    if (fxLeikbord.allEnemiesDestroyed() && Wavecounter == 3) {
                        wave2.stop();
                        wave3 = new Wave_3(fxLeikbord);
                        Wavecounter++;
                    }
                    if (fxLeikbord.allEnemiesDestroyed() && Wavecounter == 4) {
                        wave3.stop();
                        bosswave = new Wave_Boss(fxLeikbord);
                        Wavecounter++;
                        //Boss music maybe?
                    }
                });
        time = new Timeline(k);
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
        audio.sfxPlayAudio();

    }

    private void victory() {
        //Here we need to end the game with maybe a victory screen or just use gameover
    }

    /**
     * Tengir örvatakka við fall sem á að keyra í controller
     **/
    public void orvatakkar() {
        // lambda fall - event er parameter
        fxLeikbord.getScene().addEventFilter(KeyEvent.ANY,
                event -> {
                    try {
                        if (event.getCode() == KeyCode.LEFT) {
                            fxLeikbord.getFxSpaceShip().Left();
                        } else if (event.getCode() == KeyCode.RIGHT) {
                            fxLeikbord.getFxSpaceShip().Right();
                        }
                        if (event.getCode() == KeyCode.SPACE) {
                            if (canShoot) {

                                fxLeikbord.getFxSpaceShip().Shoot(fxLeikbord);
                                canShoot = false;

                                // Start cooldown timer
                                PauseTransition cooldownTimer = new PauseTransition(Duration.seconds(shootCooldown));
                                cooldownTimer.setOnFinished(e -> canShoot = true);
                                cooldownTimer.play();
                            }
                        }
                    } catch (NullPointerException e) {
                        event.consume();        // Ef rangur lykill er sleginn inn þá höldum við áfram
                    }
                });
    }


    public void initialize(){
        fxLeikbord.setSc(this);
        leikur = new Leikur();      // búa til vinnsluna
        fxStig.textProperty().bind(leikur.stiginProperty().asString()); // binda stigin við viðmótið
        fxStig.setFocusTraversable(false);    // ekki hægt að focus-a á stigin

    }

    public void playerCollision() {
        List<ImageView> lasersToRemove = new ArrayList<>();

        //Checks if player has been hit recently and if an enemy hits the player lives go down.
        if (canBeHit) {
            for (ImageView laser : fxLeikbord.getEnemyLasers()) {
                if (laser.getBoundsInParent().intersects(fxLeikbord.getFxSpaceShip().getBoundsInParent())) {

                    lasersToRemove.add(laser);
                    playerLife--;
                    System.out.println("Player lives: "+playerLife);

                    canBeHit = false;
                    PauseTransition cooldownTimer = new PauseTransition(Duration.seconds(shieldTime));
                    cooldownTimer.setOnFinished(e -> canBeHit = true);
                    cooldownTimer.play();

                }
            }

            //This is to check if the charge attack in the boss fight hits the player.
            if (Wavecounter == 5) {
                if (fxLeikbord.getBoss().getBoundsInParent().intersects(fxLeikbord.getFxSpaceShip().getBoundsInParent())) {

                    playerLife--;
                    System.out.println("Player lives: "+playerLife);

                    canBeHit = false;
                    PauseTransition cooldownTimer = new PauseTransition(Duration.seconds(shieldTime));
                    cooldownTimer.setOnFinished(e -> canBeHit = true);
                    cooldownTimer.play();
                }
            }

            for (ImageView laser : lasersToRemove) {
                fxLeikbord.removeEnemyLaser(laser);
            }
        }
        }

    public void checkCollisions() {
        // Create a list to hold enemies and lasers to remove after the loop
        List<ImageView> enemiesToRemove = new ArrayList<>();
        List<ImageView> lasersToRemove = new ArrayList<>();

        // Iterate over lasers
        for (ImageView laser : fxLeikbord.getLasers()) {
            // Iterate over enemies
            for (ImageView enemy : fxLeikbord.getEnemies()) {
                // Check for collision between the laser and the enemy
                if (laser.getBoundsInParent().intersects(enemy.getBoundsInParent())) {

                    //explosion on enemy hit
                    fxLeikbord.explosion(enemy.getTranslateX(), enemy.getTranslateY());

                    //increase score when enemy is killed
                    leikur.haekkaStigin();

                    // Add the collided laser and enemy to the lists for removal
                    lasersToRemove.add(laser);
                    enemiesToRemove.add(enemy);

                }
            }
        }

        // Remove collided enemies and lasers
        for (ImageView enemy : enemiesToRemove) {
            fxLeikbord.removeEnemy(enemy);
        }
        for (ImageView laser : lasersToRemove) {
            fxLeikbord.removeLaser(laser);
        }
    }

    public void bossCollision() {
        List<ImageView> lasersToRemove = new ArrayList<>();

        for (ImageView laser : fxLeikbord.getLasers()) {
            if (laser.getBoundsInParent().intersects(fxLeikbord.getBoss().getBoundsInParent())) {

                lasersToRemove.add(laser);
                fxLeikbord.getBoss().decreaseLife();
                System.out.println("Boss Health: "+ fxLeikbord.getBoss().getBossLife());
                if (fxLeikbord.getBoss().getBossLife() <= 0) {
                    fxLeikbord.getChildren().remove(fxLeikbord.getBoss());
                    bosswave.stop();
                    victory();
                }
            }
        }

        for (ImageView laser : lasersToRemove) {
            fxLeikbord.removeEnemyLaser(laser);
        }

    }

    public void newgame() {

        if (Wavecounter == 5) {
            fxLeikbord.getChildren().remove(fxLeikbord.getBoss());
        } else if (!fxLeikbord.allEnemiesDestroyed()) {
            List<ImageView> enemiesToRemove = new ArrayList<>();

            for (ImageView enemy : fxLeikbord.getEnemies()) {
                enemiesToRemove.add(enemy);
            }
            for (ImageView enemyToremove : enemiesToRemove) {
                fxLeikbord.removeEnemy(enemyToremove);
            }
        }


        playerLife = 3;
        Wavecounter = 1;
        leikur.nyrLeikur();
        ViewSwitcher.switchTo(View.SHOOTING);
        time.play();
        lifeCounter = new Heart(fxLeikbord);
    }
}
