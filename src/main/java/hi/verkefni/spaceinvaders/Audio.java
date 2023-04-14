package hi.verkefni.spaceinvaders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Audio {
    private Parent root;

    public MediaPlayer getMp() {
        return mp;
    }

    private MediaPlayer mp;

    public Audio() {

    }

    public SpaceController getSC() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("playArea-view.fxml"));
        root = loader.load();
        SpaceController sc = loader.getController();
        return sc;
    }

    public void sfxPlayAudio() {
        try {
            String path = "src/main/resources/hi/verkefni/spaceinvaders/Audio/";
            URI uri = new File(path).toURI();
            Media media = new Media(uri.toString());
            mp = new MediaPlayer(media);
            getSC().mediaView.setMediaPlayer(mp);
            mp.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gameOverAudio() {
        try {
            String path = "src/main/resources/hi/verkefni/spaceinvaders/Audio/game-over.wav";
            URI uri = new File(path).toURI();
            Media media = new Media(uri.toString());
            mp = new MediaPlayer(media);
            getBC().mediaView.setMediaPlayer(mp);
            mp.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
