package person;

import order.User;

public class Persoana implements Comparable<Persoana> {
    protected String nume;
    protected String prenume;
    protected String nr_telefon;

    public Persoana(){
        nume = "";
        prenume = "";
        nr_telefon = "";
    }

    public Persoana(String nume, String prenume, String nr_telefon){
        this.nume = nume;
        this.prenume = prenume;
        this.nr_telefon = nr_telefon;
    }

    public Persoana(Persoana persoana) {
        this.nume = persoana.nume;
        this.prenume = persoana.prenume;
        this.nr_telefon = persoana.nr_telefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    @Override
    public String toString() {
        return "Nume " + nume + '\n' +
                "Prenume " + prenume + '\n' +
                "Numar telefon " + nr_telefon + '\n';
    }

    @Override
    public int compareTo(Persoana p){
        String fullname = this.nume + this.prenume;
        String p_fullname = p.nume + p.prenume;
        return fullname.compareTo(p_fullname);
    }
}
