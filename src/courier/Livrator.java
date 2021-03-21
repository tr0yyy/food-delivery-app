package courier;

import java.util.SortedSet;
import java.util.TreeSet;

public class Livrator {
    static int count_livratori = 0;
    private String denumire;
    private int id_livrator;
    private SortedSet<Curier> curieri = new TreeSet<>();

    public Livrator(String denumire) {
        this.denumire = denumire;
        count_livratori++;
        id_livrator = count_livratori;
    }

    public int getId_livrator() {
        return id_livrator;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void add_curier(Curier c){
        c.setId_livrator(id_livrator);
        curieri.add(c);
    }

}
