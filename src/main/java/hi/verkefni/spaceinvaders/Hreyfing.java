package hi.verkefni.spaceinvaders;

public enum Hreyfing {
    LEFT(180), RIGHT(0),DOWN (270);;
    private int degrees;
    public int getDegrees() {return degrees;}


    Hreyfing(int degrees) {
        this.degrees = degrees;
    }
}
