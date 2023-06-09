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


    private MediaPlayer mp;

    public Audio() {

    }

    public SpaceController getSC() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("space-view.fxml"));
        root = loader.load();
        SpaceController sc = loader.getController();
        return sc;
    }

    public void sfxPlayAudio() {
        try {
            String path = "/theme.mp3";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile); // Assign the mediaPlayer object to the instance variable mp
            mp.setCycleCount(MediaPlayer.INDEFINITE); // Set cycle count to repeat indefinitely
            mp.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shootSound() {
        try {
            String path = "/shoot.wav";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile);
            mp.setVolume(0.1);
            mp.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enemyShootSound() {
        try {
            String path = "/enemy-shoot.mp3";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile);
            mp.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enemyDestroyedSound() {
        try {
            String path = "/invaderkilled.wav";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile);
            mp.setVolume(0.2);
            mp.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void bossSound() {
        try {
            String path = "/Boss.mp3";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile);
            mp.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        mp.stop();
    }

    public void victorySound() {
        try {
            String path = "/Victory.mp3";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile);
            mp.setVolume(0.3);
            mp.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void gameOverAudio() {
        try {
            String path = "/game-over.wav";
            Media audioFile = new Media(getClass().getResource(path).toExternalForm());
            mp = new MediaPlayer(audioFile);
            mp.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
