package services;

import courier.Curier;
import courier.Firma_livrare;
import courier.Masina;
import food.Ingredient;
import food.Local;
import food.Produs;
import order.Comanda;
import order.Review;
import order.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

public class Serviciu {
    public static void adaugare_curier(Firma_livrare self){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nume: ");
        String nume = scanner.next();
        System.out.print("Prenume: ");
        String prenume = scanner.next();
        System.out.print("Nr telefon: ");
        String nr_tel = scanner.next();
        System.out.print("Marca: ");
        String marca = scanner.next();
        System.out.print("Model: ");
        String model = scanner.next();
        System.out.print("Nr inmatriculare: ");
        String nr_inm = scanner.next();
        Masina m = new Masina(marca, model, nr_inm);
        Curier c = new Curier(nume, prenume, nr_tel, m);
        c.setId_livrator(self.getId_livrator());
        self.add_curier(c);
    }
    public static void listare_curieri(Firma_livrare self){
        SortedSet<Curier> curieri = self.getCurieri();
        for(Curier curier : curieri)
            System.out.println(curier);
    }
    public static void listare_produse(Local self){
        List<Produs> produse = self.getLista_produse();
        for(Produs produs : produse)
            System.out.println(produs);
    }
    public static void listare_ingrediente(Produs self){
        List<Ingredient> ingrediente = self.getIngrediente();
        for(Ingredient ingredient : ingrediente)
            System.out.println(ingredient);
    }
    public static Comanda plasare_comanda(ArrayList<Local> localuri, ArrayList<User> useri){
        Comanda c = new Comanda();
        Scanner scanner = new Scanner(System.in);
        boolean OK_User = false;
        String username = "";
        while(!OK_User){
            System.out.print("Username: ");
            username = scanner.next();
            for (User user : useri)
                if(username.equalsIgnoreCase(user.getUsername())){
                    OK_User = true;
                    break;}
            if(!OK_User)
                System.out.println("Username negasit in baza de date de useri!");}
        System.out.print("Local: ");
        String local = scanner.next();
        System.out.print("ID Firma livrare: ");
        Integer id_firma = scanner.nextInt();
        Float pret = 0.f;
        boolean OK = false;
        for (Local my_local :
                localuri) {
            if (local.equals(my_local.getDenumire())) {
                OK = true;
                System.out.println("Aici aveti produsele disponibile: ");
                listare_produse(my_local);
                while (true) {
                    System.out.println("Alegeti un produs:");
                    scanner.useDelimiter("\n");
                    String choice = scanner.next();
                    scanner.reset();
                    boolean OK_Produs = false;
                    for (Produs p :
                            my_local.getLista_produse()){
                        if (choice.equalsIgnoreCase(p.getDenumire())) {
                            c.add_produse(p);
                            pret += p.getPret();
                            OK_Produs = true;
                        }
                        if(OK_Produs)
                            break;
                    }
                    if(!OK_Produs)
                        System.out.println("Produsul nu se afla in lista localului! Doriti sa cautati alt produs? Y/N");
                    else
                        System.out.println("Doriti sa cautati alt produs? Y/N");
                    scanner.useDelimiter("\n");
                    choice = scanner.next();
                    scanner.reset();
                    if (!choice.equals("Y"))
                        break;
                }
            }
            if(OK)
                break;
        }
        c.setUsername(username);
        c.setLocal(local);
        c.setPret(pret);
        c.setID_firma_livrare(id_firma);
        System.out.println("PRET FINAL COMANDA: " + c.getPret());
        return c;
    }
    public static Review addReview(Comanda c){
        Review myRev = new Review();
        myRev.setUsername(c.getUsername());
        myRev.setID_Comanda(c.getID_comanda());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scrie review-ul (mesajul se va termina la enter): ");
        scanner.useDelimiter("\n");
        String reviewStr = scanner.next();
        myRev.setRecenzie(reviewStr);
        scanner.reset();
        System.out.println("Cate stele oferi?");
        Integer stele = scanner.nextInt();
        myRev.setStele(stele);
        return myRev;
    }
    public static User addUser(){
        //String nume, String prenume, String nr_telefon, String username, String adresa
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nume: ");
        String nume = scanner.next();
        System.out.print("Prenume: ");
        String prenume = scanner.next();
        System.out.print("Nr telefon: ");
        String nr_tel = scanner.next();
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Adresa: ");
        scanner.useDelimiter("\n");
        String adresa = scanner.next();
        scanner.reset();
        return new User(nume,prenume,nr_tel,username,adresa);
    }
    public static void searchProduct(String denumireProdus, ArrayList<Local> localuri){
        boolean OK = false;
        for (Local local :
                localuri) {
            List<Produs> produseLocal = local.getLista_produse();
            for (Produs produs :
                    produseLocal) {
                if(produs.getDenumire().equalsIgnoreCase(denumireProdus)) {
                    System.out.println("PRODUS GASIT IN LOCALUL " + local.getDenumire());
                    OK = true;
                }
            }
        }
        if(!OK)
            System.out.println("PRODUSUL NU A FOST GASIT IN NICIUN LOCAL!");
    }
    public static void searchLocal(String oras, ArrayList<Local> localuri){
        boolean OK = false;
        for (Local local :
                localuri) {
            if (local.getOras().equalsIgnoreCase(oras)){
                System.out.println(local.getDenumire() + " ");
                OK = true;
            }
        }
        if(!OK)
            System.out.println("Nu exista niciun local in orasul " + oras);
    }
    public static void searchAllOrders(String username, List<Comanda> comenzi){
        boolean OK = false;
        for (Comanda comanda :
                comenzi) {
            if(comanda.getUsername().equalsIgnoreCase(username)) {
                System.out.println(comanda);
                OK = true;
            }
        }
        if(!OK)
            System.out.println("Userul " + username + " nu a realizat nicio comanda");
    }
}
