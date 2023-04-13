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

    }

    public boolean shipShoot() {
        //ef líf klárast
        return true;
    }
}
