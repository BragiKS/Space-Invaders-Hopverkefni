module hi.verkefni.spaceinvaders {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.verkefni.spaceinvaders to javafx.fxml;
    exports hi.verkefni.spaceinvaders;
}