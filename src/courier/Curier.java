package courier;

import person.Persoana;

public class Curier extends Persoana{
    private int id_livrator;
    private int id_curier;

    public Curier(String nume, String prenume, String nr_telefon, int id_livrator) {
        super(nume, prenume, nr_telefon);
        this.id_livrator = id_livrator;
    }

    public int getId_livrator() {
        return id_livrator;
    }

    public void setId_livrator(int id_livrator) {
        this.id_livrator = id_livrator;
    }

    public int getId_curier() {
        return id_curier;
    }

    public void setId_curier(int id_curier) {
        this.id_curier = id_curier;
    }

    @Override
    public String toString() {
        return "Curier " + id_curier + '\n' +
                "ID Livrator " + id_livrator + '\n' +
                "ID Curier " + id_curier + '\n' +
                "Nume " + nume + '\n' +
                "Prenume " + prenume + '\n' +
                "Numar telefon " + nr_telefon + '\n';
    }


}
