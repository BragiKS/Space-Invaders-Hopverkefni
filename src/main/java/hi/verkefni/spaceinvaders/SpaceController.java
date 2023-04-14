package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
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
    @FXML
    protected AnchorPane playArea;
    @FXML
    private ImageView fxSpaceShip;
    @FXML

    private static final double SPEED = 5.0;

    public Leikbord getFxLeikbord () {
        return fxLeikbord;
    }

    private final HashMap<KeyCode, Hreyfing> HreyfingMap = new HashMap<KeyCode, Hreyfing>();

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
                    }
                });
        time = new Timeline(k);
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();

    }

    public void initialize(){
        fxLeikbord.setSc(this);
        playArea.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.LEFT) {
                fxSpaceShip.setX(fxSpaceShip.getX() - SPEED);
            } else if (event.getCode() == KeyCode.RIGHT) {
                fxSpaceShip.setX(fxSpaceShip.getX() + SPEED);
            }
        });
    }

}