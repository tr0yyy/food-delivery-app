package order;

public class Review {
    static Integer count_reviewuri = 0;
    private final Integer ID_Review;
    private String username;
    private Integer ID_Comanda;
    private Integer stele;
    private String recenzie;

    public Review() {
        count_reviewuri++;
        this.ID_Review = count_reviewuri;
    }

    public Review(Integer ID_Review, String username, Integer ID_Comanda, Integer stele, String recenzie) {
        count_reviewuri++;
        this.ID_Review = count_reviewuri;
        this.username = username;
        this.ID_Comanda = ID_Comanda;
        this.stele = stele;
        this.recenzie = recenzie;
    }

    public Integer getID_Review() {
        return ID_Review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
