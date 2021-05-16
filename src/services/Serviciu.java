package services;

import courier.Curier;
import courier.FirmaLivrare;
import courier.Masina;
import food.Ingredient;
import food.Local;
import food.Produs;
import order.Comanda;
import order.Review;
import order.User;

import java.util.*;

public class Serviciu {
    public static void adaugareCurier(FirmaLivrare self){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nume: ");
        String nume = scanner.next();
        System.out.print("Prenume: ");
        String prenume = scanner.next();
        System.out.print("Nr telefon: ");
        String nrTel = scanner.next();
        System.out.print("Marca: ");
        String marca = scanner.next();
        System.out.print("Model: ");
        String model = scanner.next();
        System.out.print("Nr inmatriculare: ");
        String nrInm = scanner.next();
        Masina m = new Masina(marca, model, nrInm);
        Curier c = new Curier(nume, prenume, nrTel, m);
        c.setIdLivrator(self.getIdLivrator());
        self.addCurier(c);
    }
    public static void listareIngrediente(Produs self){
        List<Ingredient> ingrediente = self.getIngrediente();
        for(Ingredient ingredient : ingrediente)
            System.out.println(ingredient);
    }
    public static Comanda plasareComanda(ArrayList<Local> localuri, ArrayList<User> useri){
        Comanda c = new Comanda();
        Scanner scanner = new Scanner(System.in);
        boolean OKUser = false;
        String username = "";
        while(!OKUser){
            System.out.print("Username: ");
            username = scanner.next();
            for (User user : useri)
                if(username.equalsIgnoreCase(user.getUsername())){
                    OKUser = true;
                    break;}
            if(!OKUser)
                System.out.println("Username negasit in baza de date de useri!");}
        System.out.print("Local: ");
        String local = scanner.next();
        System.out.print("ID Firma livrare: ");
        Integer idFirma = scanner.nextInt();
        Float pret = 0.f;
        boolean OK = false;
        for (Local myLocal :
                localuri) {
            if (local.equalsIgnoreCase(myLocal.getDenumire())) {
                OK = true;
                System.out.println("Aici aveti produsele disponibile: ");
                List<Produs> produse = myLocal.getListaProduse();
                for(Produs produs : produse)
                    System.out.println(produs);
                while (true) {
                    System.out.println("Alegeti un produs:");
                    scanner.useDelimiter("\n");
                    String choice = scanner.next();
                    scanner.reset();
                    boolean OKProdus = false;
                    for (Produs p :
                            myLocal.getListaProduse()){
                        if (choice.equalsIgnoreCase(p.getDenumire())) {
                            c.addProduse(p);
                            pret += p.getPret();
                            OKProdus = true;
                        }
                        if(OKProdus)
                            break;
                    }
                    if(!OKProdus)
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
        c.setIDFirmaLivrare(idFirma);
        System.out.println("PRET FINAL COMANDA: " + c.getPret());
        return c;
    }
    public static Review addReview(Comanda c){
        Review myRev = new Review();
        myRev.setUsername(c.getUsername());
        myRev.setIdComanda(c.getIDComanda());
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
        String nrTel = scanner.next();
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Adresa: ");
        scanner.useDelimiter("\n");
        String adresa = scanner.next();
        scanner.reset();
        return new User(nume,prenume,nrTel,username,adresa);
    }
    public static void searchProduct(String denumireProdus, ArrayList<Local> localuri){
        boolean OK = false;
        for (Local local :
                localuri) {
            List<Produs> produseLocal = local.getListaProduse();
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
