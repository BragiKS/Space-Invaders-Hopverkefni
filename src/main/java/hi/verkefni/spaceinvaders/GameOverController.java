package hi.verkefni.spaceinvaders;

import javafx.scene.input.MouseEvent;

public class GameOverController {

    public void playagain(MouseEvent actionEvent) {
        SpaceController sc = (SpaceController) ViewSwitcher.lookup(View.SHOOTING);
        sc.newgame();
    }
}
