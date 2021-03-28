package services;

import courier.*;
import food.*;
import order.*;
import person.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Init {
    public static Firma_livrare firma_livrare(String file_name, String file_path) {
        Firma_livrare my_new_food_delivery = new Firma_livrare(file_name.substring(0, file_name.length() - 4));
        try {
            File my_file = new File(file_path+file_name);
            Scanner scanner = new Scanner(my_file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] curier = data.split(",");
                String nume = curier[0];
                String prenume = curier[1];
                String telefon = curier[2];
                String marca = curier[3];
                String model = curier[4];
                String nr_inm = curier[5];
                Masina m = new Masina(marca, model, nr_inm);
                Curier c = new Curier(nume, prenume, telefon, m);
                c.setId_livrator(my_new_food_delivery.getId_livrator());
                my_new_food_delivery.add_curier(c);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Lipseste fisierul de citire!");
            e.printStackTrace();
            System.exit(0);
        }
        return my_new_food_delivery;
    }
    public static Local restaurant(String file_name, String file_path){
        Local my_new_restaurant = new Local();
        try {
            File my_file = new File(file_path+file_name);
            Scanner scanner = new Scanner(my_file);
            /// initializare date de baza
            String data = scanner.nextLine();
            String[] info_r = data.split(",");
            my_new_restaurant.setDenumire(info_r[0]);
            my_new_restaurant.setStrada(info_r[1]);
            my_new_restaurant.setOras(info_r[2]);
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                String[] info_prod = data.split(",");
                Produs p = new Produs();
                p.setDenumire(info_prod[0]);
                p.setPret(Float.parseFloat(info_prod[1]));
                for(int i = 2 ; i < info_prod.length ; i+=2){
                    Ingredient ing = new Ingredient(info_prod[i], Float.parseFloat(info_prod[i+1]));
                    p.add_ingredient(ing);
                }
                my_new_restaurant.add_produs(p);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Lipseste fisierul de citire!");
            e.printStackTrace();
            System.exit(0);
        }
        return my_new_restaurant;
    }
    public static ArrayList<User> users(String file_name, String file_path){
        ArrayList<User> useri = new ArrayList<>();
        try {
            File my_file = new File(file_path+file_name);
            Scanner scanner = new Scanner(my_file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] info_prod = data.split(",");
                User u = new User(info_prod[0],info_prod[1],info_prod[2],info_prod[3],info_prod[4]);
                useri.add(u);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lipseste fisierul de citire!");
            e.printStackTrace();
            System.exit(0);
        }
        return useri;
    }

}
