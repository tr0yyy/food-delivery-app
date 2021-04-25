package services;

import courier.Curier;
import courier.Firma_livrare;
import courier.Masina;
import food.Ingredient;
import food.Local;
import food.Produs;
import jdk.internal.dynalink.beans.StaticClass;
import order.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromCSV {
    public static ArrayList<Local> ReadRestaurants(List<String> fisiereLocaluri) throws InstantiationException, IllegalAccessException{
        ArrayList<Local> localuri = new ArrayList<>();
        Local bufferLocal = Singleton.getInstance(Local.class);
        Produs bufferProdus = Singleton.getInstance(Produs.class);
        Ingredient ing = Singleton.getInstance(Ingredient.class);
        File localFileInfo = new File("src/food/localuri.csv");
        Scanner scannerInfo = null;
        try {
            scannerInfo = new Scanner(localFileInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        ArrayList<String[]> localuriInfo = new ArrayList<>();
        String dataFileInfo = scannerInfo.nextLine();
        while(scannerInfo.hasNextLine()){
            dataFileInfo = scannerInfo.nextLine();
            String[] localSplitted = dataFileInfo.split(",");
            localuriInfo.add(localSplitted);
        }
        int k = -1;
        for (String file:
             fisiereLocaluri) {
            k++;
            try {
                File my_file = new File(file);
                Scanner scanner = new Scanner(my_file);
                /// initializare date de baza
                String data = scanner.nextLine();
                String[] info_r = data.split(",");
                bufferLocal.setDenumire(localuriInfo.get(k)[0]);
                bufferLocal.setStrada(localuriInfo.get(k)[1]);
                bufferLocal.setOras(localuriInfo.get(k)[2]);
                List<Produs> produse = new ArrayList<Produs>();
                while (scanner.hasNextLine()) {
                    data = scanner.nextLine();
                    String[] info_prod = data.split(",");
                    bufferProdus.setDenumire(info_prod[0]);
                    bufferProdus.setPret(Float.parseFloat(info_prod[1]));
                    List<Ingredient> ingrediente = new ArrayList<>();
                    for(int i = 2 ; i < info_prod.length ; i+=2){
                        ing.setDenumire(info_prod[i]);
                        ing.setCantitate(Float.parseFloat(info_prod[i+1]));
                        ingrediente.add(new Ingredient(ing));
                    }
                    bufferProdus.setIngrediente(ingrediente);
                    produse.add(new Produs(bufferProdus));
                }
                bufferLocal.setLista_produse(produse);
                scanner.close();
                localuri.add(new Local(bufferLocal));
            } catch (FileNotFoundException e) {
                System.out.println("Lipseste fisierul de citire!");
                e.printStackTrace();
                System.exit(0);
            }
        }
        return localuri;
    }
    public static ArrayList<User> ReadUsers(String file_path) throws InstantiationException, IllegalAccessException{
        ArrayList<User> useri = new ArrayList<>();
        User userBuffer = Singleton.getInstance(User.class);
        try {
            File my_file = new File(file_path);
            Scanner scanner = new Scanner(my_file);
            String data = scanner.nextLine();
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                String[] info_prod = data.split(",");
                userBuffer.setNume(info_prod[0]);
                userBuffer.setPrenume(info_prod[1]);
                userBuffer.setNr_telefon(info_prod[2]);
                userBuffer.setUsername(info_prod[3]);
                userBuffer.setAdresa(info_prod[4]);
                useri.add(new User(userBuffer));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lipseste fisierul de citire!");
            e.printStackTrace();
            System.exit(0);
        }
        return useri;
    }
    public static Firma_livrare firma_livrare(String file_path, String denumire) throws InstantiationException, IllegalAccessException {
        Firma_livrare firmaLivrare = new Firma_livrare();
        Masina masinaBuffer = Singleton.getInstance(Masina.class);
        Curier curierBuffer = Singleton.getInstance(Curier.class);
        try {
            File my_file = new File(file_path);
            Scanner scanner = new Scanner(my_file);
            String data = scanner.nextLine();
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                String[] curier = data.split(",");
                String nume = curier[0];
                String prenume = curier[1];
                String telefon = curier[2];
                String marca = curier[3];
                String model = curier[4];
                String nr_inm = curier[5];
                masinaBuffer.setMarca(marca);
                masinaBuffer.setModel(model);
                masinaBuffer.setNr_inmatriculare(nr_inm);
                curierBuffer.setNume(nume);
                curierBuffer.setPrenume(prenume);
                curierBuffer.setNr_telefon(telefon);
                curierBuffer.setCar(new Masina(masinaBuffer));
                curierBuffer.setId_livrator(firmaLivrare.getId_livrator());
                firmaLivrare.setDenumire(denumire);
                firmaLivrare.add_curier(new Curier(curierBuffer));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Lipseste fisierul de citire!");
            e.printStackTrace();
            System.exit(0);
        }
        return firmaLivrare;
    }
}
