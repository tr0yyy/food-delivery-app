package order;

public class Review {
    private Integer ID_Review;
    private Integer ID_User;
    private Integer ID_Comanda;
    private Integer stele;
    private String recenzie;

    public Review() {
    }

    public Review(Integer ID_Review, Integer ID_User, Integer ID_Comanda, Integer stele, String recenzie) {
        this.ID_Review = ID_Review;
        this.ID_User = ID_User;
        this.ID_Comanda = ID_Comanda;
        this.stele = stele;
        this.recenzie = recenzie;
    }

    public Integer getID_Review() {
        return ID_Review;
    }

    public void setID_Review(Integer ID_Review) {
        this.ID_Review = ID_Review;
    }

    public Integer getID_User() {
        return ID_User;
    }

    public void setID_User(Integer ID_User) {
        this.ID_User = ID_User;
    }

    public Integer getID_Comanda() {
        return ID_Comanda;
    }

    public void setID_Comanda(Integer ID_Comanda) {
        this.ID_Comanda = ID_Comanda;
    }

    public Integer getStele() {
        return stele;
    }

    public void setStele(Integer stele) {
        this.stele = stele;
    }

    public String getRecenzie() {
        return recenzie;
    }

    public void setRecenzie(String recenzie) {
        this.recenzie = recenzie;
    }
}
