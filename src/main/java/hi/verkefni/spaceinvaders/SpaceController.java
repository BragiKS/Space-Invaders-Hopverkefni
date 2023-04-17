package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.HashMap;

public class SpaceController {


    private Timeline time;
    @FXML
    private Leikbord fxLeikbord;
    private boolean canShoot = true;
    private double shootCooldown = 0.5; // Cooldown duration in seconds
    private static final double SPEED = 5.0;

    private Audio audio = new Audio();

    // Býr til beinan aðgang frá KeyCode og í heiltölu. Hægt að nota til að fletta upp
    // heiltölu fyrir KeyCode

    public Leikbord getFxLeikbord () {
        return fxLeikbord;
    }

    @FXML
    protected void muteAudio() {
        if (audio.getMp().isMute()) {
            audio.getMp().setMute(false);
        } else {
            audio.getMp().setMute(true);
        }
    }

    public void startGame() {
        KeyFrame k = new KeyFrame(Duration.millis(10),
                e -> {
                    fxLeikbord.afram();
                    fxLeikbord.getFxSpaceShip();
                    //sja um stig
                    //leikurinn.haekkaStigin();
                    //ef skip er skotið
                    if (fxLeikbord.shipShoot()) {
                        //leikLokid("Boom!");
                        //audio.gameOverAudio();
                    }
                });
        time = new Timeline(k);
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
        audio.sfxPlayAudio();
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
                        } else if (event.getCode() == KeyCode.SPACE) {
                            if (canShoot) {
                                System.out.println("YOOO bag alerttt");
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
        new Wave_2(fxLeikbord);
        /*playArea.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.LEFT) {
                fxSpaceShip.setX(fxSpaceShip.getX() - SPEED);
            } else if (event.getCode() == KeyCode.RIGHT) {
                fxSpaceShip.setX(fxSpaceShip.getX() + SPEED);
            }
        });*/
    }

}
