package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import hi.verkefni.spaceinvaders.Leikur;
import java.util.HashMap;

public class SpaceController {


    public MediaView mediaView;
    private Timeline time;
    private Audio audio = new Audio();
    @FXML
    private Leikbord fxLeikbord;

    @FXML
    private Label fxStig;
    private boolean canShoot = true;
    private double shootCooldown = 0.5; // Cooldown duration in seconds
    private static final double SPEED = 5.0;

    private Timeline t; // tímalínan
    Leikur leikur;



    public Leikbord getFxLeikbord () {
        return fxLeikbord;
    }

    public void startGame() {
        KeyFrame k = new KeyFrame(Duration.millis(10),
                e -> {
                    fxLeikbord.afram();
                    fxLeikbord.getFxSpaceShip();
                    leikur.haekkaStigin();
                    //sja um stig
                    //leikurinn.haekkaStigin();
                    //ef skip er skotið
                    if (fxLeikbord.shipShoot()) {
                        //leikLokid("Boom!");
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

    /**
     * Stillir upp nýjum leik og byrjar hann
     */
    public void nyrLeikur() {
        leikur.nyrLeikur();
        fxLeikbord.nyrLeikur();
        t.play();
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

        leikur = new Leikur();      // búa til vinnsluna
        fxStig.textProperty().bind(leikur.stiginProperty().asString()); // binda stigin við viðmótið
        fxStig.setFocusTraversable(false);    // ekki hægt að focus-a á stigin

    }

}
