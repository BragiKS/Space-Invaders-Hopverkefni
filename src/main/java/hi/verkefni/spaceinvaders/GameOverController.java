package hi.verkefni.spaceinvaders;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class GameOverController {
    @FXML
    private Label finalScore;
    @FXML
    private Label finalScoreLose;


    public void playagain(MouseEvent actionEvent) {
        SpaceController sc = (SpaceController) ViewSwitcher.lookup(View.SHOOTING);
        sc.newgame();

    }


    public void setFinalScoreLose() {
        SpaceController sc = (SpaceController) ViewSwitcher.lookup(View.SHOOTING);
        finalScoreLose.textProperty().bind(sc.leikur.stiginProperty().asString());
    }

    public void setFinalScore() {
        SpaceController sc = (SpaceController) ViewSwitcher.lookup(View.SHOOTING);
        finalScore.textProperty().bind(sc.leikur.stiginProperty().asString());
    }

}
