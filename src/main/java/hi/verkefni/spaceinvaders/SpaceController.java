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
<<<<<<< Updated upstream

=======
    private ImageView fxAlien_one;
    @FXML
    private ImageView fxShot;
>>>>>>> Stashed changes
    private static final double SPEED = 5.0;

    // Býr til beinan aðgang frá KeyCode og í heiltölu. Hægt að nota til að fletta upp
    // heiltölu fyrir KeyCode
    private static final HashMap<KeyCode, Hreyfing> map = new HashMap<KeyCode, Hreyfing>();

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

    /**
     * Tengir örvatakka við fall sem á að keyra í controller
     **/
    public void orvatakkar() {
        map.put(KeyCode.RIGHT, Hreyfing.LEFT);
        map.put(KeyCode.LEFT, Hreyfing.RIGHT);
        // lambda fall - event er parameter
<<<<<<< Updated upstream
       // fxStig.getScene().addEventFilter(KeyEvent.ANY,      //KeyEvents eru sendar á Scene
         //       this::adgerdLykill); // tilvísun í aðferðina (method reference) - kallað verður á aðferðina adgerdLykill
=======
        fxLeikbord.getScene().addEventFilter(KeyEvent.ANY,
                event -> {
                    try {
                        if (event.getCode() == KeyCode.LEFT) {
                            fxLeikbord.getFxSpaceShip().Left();
                        } else if (event.getCode() == KeyCode.RIGHT) {
                            fxLeikbord.getFxSpaceShip().Right();
                        } else if (event.getCode() == KeyCode.SPACE) {
                            System.out.println("YOOO bag alerttt");
                            fxLeikbord.getFxSpaceShip().Shoot(fxLeikbord);
                        }
                    } catch (NullPointerException e) {
                        event.consume();        // Ef rangur lykill er sleginn inn þá höldum við áfram
                    }
                });
>>>>>>> Stashed changes
    }

    public void initialize(){
        fxLeikbord.setSc(this);

    }

}
