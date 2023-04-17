module hi.verkefni.spaceinvaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens hi.verkefni.spaceinvaders to javafx.fxml;
    exports hi.verkefni.spaceinvaders;


}