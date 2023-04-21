package hi.verkefni.spaceinvaders;

import javafx.scene.image.ImageView;

public class Heart extends ImageView {

    public Heart() {
        FXML_Lestur.lesa(this, "Heart-view.fxml");
    }
    public Heart(Leikbord leikbord){
        Heart one = new Heart();
        Heart two = new Heart();
        Heart three = new Heart();

        leikbord.setHeartTwo(two);
        leikbord.setHeartThree(three);



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
}
