package food;

import java.util.ArrayList;
import java.util.List;

public class Produs {
    private String denumire;
    private Integer pret;
    private List<Ingredient> ingrediente = new ArrayList<Ingredient>();

    public Produs() {
    }

    public Produs(String denumire, Integer pret, List<Ingredient> ingrediente) {
        this.denumire = denumire;
        this.pret = pret;
        this.ingrediente = ingrediente;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public List<Ingredient> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(List<Ingredient> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void add_ingredient(Ingredient i){
        ingrediente.add(i);
    }

    
}
