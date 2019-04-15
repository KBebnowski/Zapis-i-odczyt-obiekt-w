package nainterfejsie;

import java.io.Serializable;

public class Ocena implements Serializable {
    protected int wartosc;
    protected String opis;
    protected static int val = 80;      //DLA TESTU

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Ocena(int wartosc, String opis) {
        this.wartosc = wartosc;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Ocena: " + wartosc +
                ", opis: " + opis ;
    }
}

