package zaj1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String imie, nazwisko;
    private int nr_indeksu;
    public ArrayList<Ocena> listaocen;
    private Ocena o;


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(int nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }


    public Student(String imie, String nazwisko, int nr_indeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
        this.listaocen = new ArrayList<Ocena>();
    }

    public int printValue(){
        return o.val;           // DLA TESTU
    }

    public ArrayList<Ocena> getListaocen() {
        return listaocen;
    }

    public void setListaocen(int wartosc,String opis) {
        listaocen.add(new Ocena(wartosc,opis));
    }

    @Override
    public String toString() {
        return "Imie: "+ getImie()+" nazwisko: "+getNazwisko()+" numer indeksu: "+ getNr_indeksu()+" " + listaocen;
    }
}