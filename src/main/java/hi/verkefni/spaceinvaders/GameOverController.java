package hi.verkefni.spaceinvaders;

import javafx.event.ActionEvent;

public class GameOverController {

    public void playagain(ActionEvent actionEvent) {
        SpaceController sc = (SpaceController) ViewSwitcher.lookup(View.SHOOTING);
        sc.newgame();
    }
}
