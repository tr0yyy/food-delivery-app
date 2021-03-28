package order;

import food.Local;
import food.Produs;

import java.util.*;

public class Comanda {
    private Integer ID_comanda;
    private Integer ID_user;
    private Integer ID_local;
    private Integer ID_firma_livrare;
    private Integer pret = 0;
    private List<Produs> produse = new ArrayList<>();

    public Comanda(Integer ID_comanda, Integer ID_user, Integer ID_local, Integer ID_firma_livrare) {
        this.ID_comanda = ID_comanda;
        this.ID_user = ID_user;
        this.ID_local = ID_local;
        this.ID_firma_livrare = ID_firma_livrare;
    }

    public Comanda() {
    }

    public Integer getID_comanda() {
        return ID_comanda;
    }

    public void setID_comanda(Integer ID_comanda) {
        this.ID_comanda = ID_comanda;
    }

    public Integer getID_user() {
        return ID_user;
    }

    public void setID_user(Integer ID_user) {
        this.ID_user = ID_user;
    }

    public Integer getID_local() {
        return ID_local;
    }

    public void setID_local(Integer ID_local) {
        this.ID_local = ID_local;
    }

    public Integer getID_firma_livrare() {
        return ID_firma_livrare;
    }

    public void setID_firma_livrare(Integer ID_firma_livrare) {
        this.ID_firma_livrare = ID_firma_livrare;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
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
}
