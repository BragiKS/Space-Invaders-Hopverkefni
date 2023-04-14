package hi.verkefni.spaceinvaders;

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
