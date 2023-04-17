<<<<<<< Updated upstream
package hi.verkefni.spaceinvaders;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Leikbord extends AnchorPane implements LeikHluturInterface {
    //controller stuff
    private SpaceController sc;
    public SpaceController getSc(){
        return sc;
    }
    public void setSc(SpaceController sc){
        this.sc = sc;
    }

    //spilari
    @FXML
    private Player fxSpaceShip;
    public Player getFxSpaceShip(){
        return fxSpaceShip;
    }

    //lesari
    public Leikbord() {FXML_Lestur.lesa(this,"leikbord.fxml");}
    public static void main(String[] args) {

    }
    @Override
    public void afram() {
       /* if (fxSpaceShip.getEnemies() == null) { // bolti er ekki á neinum palli
            fxSpaceShip.afram(); // eitt skref vinstri eða hægri en svo ...
           // fxenemies.setStefna(.DOWN); // niður
        } else {
            fxBolti.aframAPalli(); // má færa bolta til vinstri eða hægri
        }*/
    }

    public boolean shipShoot() {
        //ef líf klárast
        return true;
    }
}
=======
package hi.verkefni.spaceinvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Leikbord extends AnchorPane implements LeikHluturInterface {
    //controller stuff
    private SpaceController sc;
    public SpaceController getSc(){
        return sc;
    }
    public void setSc(SpaceController sc){
        this.sc = sc;
    }

    //spilari
    @FXML
    private Player fxSpaceShip;
    public Player getFxSpaceShip(){
        return fxSpaceShip;
    }

    //lesari
    public Leikbord() {FXML_Lestur.lesa(this,"leikbord-view.fxml");}
    public static void main(String[] args) {

    }


    @Override
    public void afram() {
       /* if (fxSpaceShip.getEnemies() == null) { // bolti er ekki á neinum palli
            fxSpaceShip.afram(); // eitt skref vinstri eða hægri en svo ...
           // fxenemies.setStefna(.DOWN); // niður
        } else {
            fxBolti.aframAPalli(); // má færa bolta til vinstri eða hægri
        }*/
    }

    public boolean shipShoot() {
        //ef líf klárast
        return true;
    }
}
>>>>>>> Stashed changes
