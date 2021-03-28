package courier;

import person.Persoana;

import java.util.Scanner;

public class Curier extends Persoana{
    private Integer id_livrator;
    private Masina car;

    public Curier() {
    }

    public Curier(String nume, String prenume, String nr_telefon, Masina car) {
        super(nume, prenume, nr_telefon);
        this.car = car;
    }

    public Integer getId_livrator() {
        return id_livrator;
    }

    public void setId_livrator(Integer id_livrator) {
        this.id_livrator = id_livrator;
    }

    public Masina getCar() {
        return car;
    }

    public void setCar(Masina car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "ID Firma Livrare " + id_livrator + '\n' +
                "Nume " + nume + '\n' +
                "Prenume " + prenume + '\n' +
                "Numar telefon " + nr_telefon + '\n' +
                "Masina " + car + '\n';
    }

}
