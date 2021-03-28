package courier;

import java.util.SortedSet;
import java.util.TreeSet;

public class Firma_livrare {
    private static Integer count_firme_livrari = 0;
    private String denumire;
    private Integer id_livrator;
    private SortedSet<Curier> curieri = new TreeSet<>();

    public Firma_livrare(String denumire) {
        this.denumire = denumire;
        count_firme_livrari++;
        id_livrator = count_firme_livrari;
    }

    public Integer getId_livrator() {
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
