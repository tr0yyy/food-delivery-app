package order;

import person.Persoana;

public class User extends Persoana {
    private String username;
    private String adresa;

    User(){
        super();
        username = "";
        adresa = "";
    }

    User(String nume, String prenume, String nr_telefon, String username, String adresa){
        super(nume,prenume,nr_telefon);
        this.username = username;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Nume " + nume + '\n' +
                "Prenume " + prenume + '\n' +
                "Numar telefon " + nr_telefon + '\n' +
                "Username " + username + '\n' +
                "Adresa " + adresa + '\n';
    }
}
