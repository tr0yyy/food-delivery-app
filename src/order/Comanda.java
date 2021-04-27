package order;

import food.Produs;

import java.util.*;

public class Comanda {
    static int nr_comenzi = 0;
    private Integer ID_comanda;
    private String username;
    private String local;
    private Integer ID_firma_livrare;
    private Float pret = 0.0f;
    private List<Produs> produse = new ArrayList<>();



    public Comanda(String username, String local, Integer ID_firma_livrare) {
        nr_comenzi++;
        this.ID_comanda = nr_comenzi;
        this.username = username;
        this.local = local;
        this.ID_firma_livrare = ID_firma_livrare;
    }

    public Comanda() {
        nr_comenzi++;
        this.ID_comanda = nr_comenzi;
    }

    public void setID_comanda(Integer ID_comanda) {
        this.ID_comanda = ID_comanda;
    }

    public Integer getID_comanda() {
        return ID_comanda;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getID_firma_livrare() {
        return ID_firma_livrare;
    }

    public void setID_firma_livrare(Integer ID_firma_livrare) {
        this.ID_firma_livrare = ID_firma_livrare;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public void add_produse(Produs p){
        produse.add(p);
        pret = pret + p.getPret();
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "ID_comanda=" + ID_comanda +
                ", username='" + username + '\'' +
                ", local='" + local + '\'' +
                ", ID_firma_livrare=" + ID_firma_livrare +
                ", pret=" + pret +
                ", produse=" + produse +
                '}';
    }
}
