package hi.verkefni.spaceinvaders;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/******************************************************************************
 *  Lýsing  : Vinnsluhlutur fyrir leik. Heldur aðallega utan um stigin
 *****************************************************************************/
public class Leikur {

    private final IntegerProperty stigin = new SimpleIntegerProperty();

    public IntegerProperty stiginProperty() {
        return stigin;
    }

    public int getStigin() {
        return stigin.get();
    }


    public void haekkaStigin() {
        stigin.setValue(stigin.getValue()+50);
    }

    public void nyrLeikur() {
        stigin.setValue(0);
    }

}