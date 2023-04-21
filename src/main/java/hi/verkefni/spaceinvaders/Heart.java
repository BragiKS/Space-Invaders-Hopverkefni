package hi.verkefni.spaceinvaders;

import javafx.scene.image.ImageView;

public class Heart extends ImageView {
    private Heart one;
    private Heart two;
    private Heart three;
    private int heartCounter = 3;

    public Heart() {
        FXML_Lestur.lesa(this, "Heart-view.fxml");
    }
    public Heart(Leikbord leikbord){
        one = new Heart();
        two = new Heart();
        three = new Heart();

        one.setTranslateX(10);
        one.setTranslateY(10);
        leikbord.getChildren().add(one);

        two.setTranslateX(40);
        two.setTranslateY(10);
        leikbord.getChildren().add(two);

        three.setTranslateX(70);
        three.setTranslateY(10);
        leikbord.getChildren().add(three);

    }

    public void removeHeart(Leikbord leikbord) {
        if (heartCounter == 3) {
            leikbord.getChildren().remove(three);
        } else if (heartCounter == 2) {
            leikbord.getChildren().remove(two);
        } else {
            leikbord.getChildren().remove(one);
        }
        heartCounter--;
    }

    public void addHearts() {
        three.setVisible(true);
        two.setVisible(true);
        one.setVisible(true);
    }
}
