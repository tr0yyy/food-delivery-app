package courier;

public final class Masina {
    private final String marca;
    private final String model;
    private final String nr_inmatriculare;

    public Masina(String marca, String model, String nr_inmatriculare) {
        this.marca = marca;
        this.model = model;
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    @Override
    public String toString() {
        return
                "marca '" + marca + '\'' +
                ", model '" + model + '\'' +
                ", nr_inmatriculare '" + nr_inmatriculare + '\'';
    }
}
