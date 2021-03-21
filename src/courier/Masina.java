package courier;

public class Masina {
    private String marca;
    private String model;
    private String nr_inmatriculare;

    public Masina(String marca, String model, String nr_inmatriculare) {
        this.marca = marca;
        this.model = model;
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    @Override
    public String toString() {
        return
                "marca '" + marca + '\'' +
                ", model '" + model + '\'' +
                ", nr_inmatriculare '" + nr_inmatriculare + '\'';
    }
}
