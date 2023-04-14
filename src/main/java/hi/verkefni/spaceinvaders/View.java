package hi.verkefni.spaceinvaders;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    LEIKBORD("leikbord.fxml"),
    SHOOTING("playArea-view.fxml");


    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
