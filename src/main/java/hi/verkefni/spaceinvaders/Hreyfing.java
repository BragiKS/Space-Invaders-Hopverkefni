package hi.verkefni.spaceinvaders;

public enum Hreyfing {
    LEFT(180), RIGHT(0);

    public int getDegrees() {return degrees;}
    private int degrees;

    Hreyfing(int degrees) {
        this.degrees = degrees;
    }
}
