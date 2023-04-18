package hi.verkefni.spaceinvaders;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.ArrayList;

public class Leikbord extends AnchorPane implements LeikHluturInterface {
    //controller stuff
    private SpaceController sc;
    private List<ImageView> enemies;
    private List<ImageView> lasers;



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
    public Leikbord() {FXML_Lestur.lesa(this,"leikbord-view.fxml");
            enemies = new ArrayList<>();
            lasers = new ArrayList<>();
        }


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

    public void nyrLeikur() {
        getChildren().clear();

        upphafsstilla();    // upphafsstilla eins og í byrjun
    }

    private void upphafsstilla() {
        //
    }

    public List<ImageView> getEnemies() {
        return enemies;
    }

    public List<ImageView> getLasers() {
        return lasers;
    }




    public void removeEnemy(ImageView enemy) {
        enemies.remove(enemy); // Remove the enemy from the enemies list
        getChildren().remove(enemy); // Remove the enemy ImageView from the game board
    }

    public void removeLaser(ImageView laser) {
        lasers.remove(laser); // Remove the laser from the lasers list
        getChildren().remove(laser); // Remove the laser ImageView from the game board
    }

    public boolean allEnemiesDestroyed() {
        return enemies.isEmpty(); // Return true if the enemies list is empty (no enemies left)
    }
}
