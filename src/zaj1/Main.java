package zaj1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student a1 = new Student("ala", "nogal", 1);
        a1.setListaocen(4, "sprawdzian");
        a1.setListaocen(5, "kartkowka");

        Student a2 = new Student("Emilka", "Franek", 2);
        a2.setListaocen(2, "sprawdzian");
        a2.setListaocen(3, "kartkowka");

        /*System.out.println("Imie: " + a1.getImie() + " nazwisko: " + a1.getNazwisko() + " numer indeksu: " +
                a1.getNr_indeksu() + " ocena: " + a1.listaocen.get(0).getWartosc() + " opis: " + a1.listaocen.get(0).getOpis() + "\n");
        System.out.println(a1);
        System.out.println();
        System.out.println(a1.printValue());
*/
        zapis("Dziennik", a1);
        zapis("Dziennik", a2);          //Obiekt a2 nadpisal obiekt a1
        odczyt("Dziennik");
        dopisanie("Dziennik", a1);
        odczyt("Dziennik");                    //odczytuje tylko 1 obiekt
        odczytCalego("Dziennik");      //odczytuje wszystkie obiekty z pliku
    }


    // Zapisuje dokładnie jeden obiekt do pliku
    public static void zapis(String nazwaPl, Student obiekt) throws IOException {
        ObjectOutputStream pl = null;
        try {
            pl = new ObjectOutputStream(new FileOutputStream(nazwaPl));
            pl.writeObject(obiekt);
            pl.flush();
        } finally {
            if (pl != null)
                pl.close();
        }
    }

    // Odczytuje dokładnie jeden obiekt z pliku i wyświetla o nim informację
    public static void odczyt(String nazwaPl)throws IOException,ClassNotFoundException{
        ObjectInputStream pl2=null;
        Student obiekt = null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
            obiekt=(Student)pl2.readObject();

            System.out.println(obiekt);

        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }
    }

    public static void dopisanie(String nazwaPl, Student obiekt)throws IOException, ClassNotFoundException{
        // Najwpierw odczytujemy z plkiu to, co było tam wcześniej
        Student[] tab = new Student[100]; // do tablicy
        ObjectInputStream pl2=null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
            int l=0;
            while(true)
                tab[l++]=(Student)pl2.readObject();

        } catch (EOFException ex) {
            // Program przeskakuje w to miejsce, kiedy dojdzie do końca pliku,
            // czyli kiedy wszystko już odczyta.
            // Teraz zamykamy plik, otwieramy w trybie zapisu i wpisujemy
            // do niego wszystko oraz dopisujemy to, co ma być dodane
            if(pl2!=null)
                pl2.close();

            ObjectOutputStream pl=null;
            try{
                pl=new ObjectOutputStream(new FileOutputStream(nazwaPl));
                // Wpisujemy do pliku to, co w nim już było
                for(int i=0; tab[i]!=null; i++)
                    pl.writeObject(tab[i]);

                // i dopisujemy nowy obiekt
                pl.writeObject(obiekt);
                pl.flush();
            }
            finally{
                if(pl!=null)
                    pl.close();
            }
        }
    }

    // Odczytuje wiele obiektów z pliku (wszystkie) i wyświetla o nim informację
    public static void odczytCalego(String nazwaPl)throws IOException,ClassNotFoundException{
        ObjectInputStream pl2=null;
        Student obiekt = null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
            int l=1;
            while(true){
                obiekt=(Student)pl2.readObject();
                System.out.println("\nObiekt" + l++);
                System.out.println(obiekt);
            }

        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }


    }
}