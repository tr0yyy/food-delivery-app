package services;

import courier.*;
import food.Local;
import food.Produs;
import order.Comanda;
import order.Review;
import order.User;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void initMeniu(){
        System.out.println("--------------------NICOI ALEXANDRU // GRUPA 253 // ELEMENTE AVANSATE DE PROGRAMARE--------------------");
        System.out.println("-----------------------FOOD DELIVERY - ETAPA 2-----------------------");
        System.out.println("-----------Pentru a utiliza o functie a meniului, tastati numarul corespunzator functiei alese-------------");
        System.out.println();
        System.out.println("1. Adaugare curier in cadrul companiei de livrari.");
        System.out.println("2. Listare produse specifice unui local.");
        System.out.println("3. Listare ingrediente dintr-un produs.");
        System.out.println("4. Plasare comanda.");
        System.out.println("5. Adaugare review asupra comenzii.");
        System.out.println("6. Adaugare User care va folosi platforma.");
        System.out.println("7. Listare comenzi plasate de catre un anumit user.");
        System.out.println("8. Cautare un anumit produs in mai multe localuri.");
        System.out.println("9. Cautare local in functie de oras.");
        System.out.println("0. Iesire.");
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ArrayList<String> fisiereLocaluri = new ArrayList<>();
        fisiereLocaluri.add("src/food/mcdonalds.csv");
        fisiereLocaluri.add("src/food/kfc.csv");
        fisiereLocaluri.add("src/food/hercule.csv");
        ArrayList<Local> localuri = CSVTools.readRestaurants(fisiereLocaluri);
        //ReadFromCSV.ReadUsers();
        /// init data entries
        FirmaLivrare foodpanda = CSVTools.readFirmaLivrare("src/courier/foodpanda.csv","FoodPanda");
        ArrayList<User> useri = CSVTools.readUsers("src/order/useri.csv");
        List<Comanda> comenzi = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();



        ///the_real_main
        Scanner scanner = new Scanner(System.in);
        int opt;
        initMeniu();
        do {
            System.out.println("\n");
            System.out.println("Optiunea aleasa: ");
            opt = scanner.nextInt();
            switch (opt)
            {
                case 1:
                    Serviciu.adaugareCurier(foodpanda);
                    System.out.println("Curier adaugat");
                    break;
                case 2:
                    boolean OK = false;
                    System.out.println("Selecteaza localul:");
                    String localStr = scanner.next();
                    for (Local local:
                         localuri) {
                        if(local.getDenumire().equalsIgnoreCase(localStr))
                        {
                            List<Produs> produse = local.getListaProduse();
                            for(Produs produs : produse)
                                System.out.println(produs);
                            OK = true;
                            break;
                        }
                    }
                    if(!OK)
                        System.out.println("Localul nu exista!");
                    break;
                case 3:
                    OK = false;
                    System.out.println("Selecteaza produsul:");
                    String produsStr = scanner.next();
                    for (Local local :
                            localuri) {
                        for (Produs produs :
                                local.getListaProduse()) {
                            if(produsStr.equalsIgnoreCase(produs.getDenumire())){
                                OK = true;
                                Serviciu.listareIngrediente(produs);
                                break;
                            }
                        }
                    }
                    if(!OK)
                        System.out.println("Produsul nu exista!");
                    break;
                case 4:
                    Comanda c = Serviciu.plasareComanda(localuri,useri);
                    try {
                        File myFile = new File("src/comenzi.csv");
                        if(myFile.exists())
                            if(!myFile.delete())
                            {
                                System.out.println("Fisierul este de tip Read-Only!");
                                break;
                            }
                        CSVTools.writeOrderToFile(c, "src/comenzi.csv");
                        CSVTools.auditComanda("src/audit.csv", c);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    comenzi.add(c);
                    break;
                case 5:
                    OK = false;
                    System.out.println("Ce ID are comanda dvs? ");
                    Integer idComanda = scanner.nextInt();
                    for (Comanda comanda :
                            comenzi) {
                        if(comanda.getIDComanda().equals(idComanda)){
                            OK = true;
                            Serviciu.addReview(comanda);
                            break;
                        }
                    }
                    if(!OK)
                        System.out.println("Comanda nu exista!");
                    break;
                case 6:
                    useri.add(Serviciu.addUser());
                    System.out.println("User adaugat!");
                    break;
                case 7:
                    System.out.println("Username: ");
                    scanner.useDelimiter("\n");
                    String choice = scanner.next();
                    scanner.reset();
                    Serviciu.searchAllOrders(choice, comenzi);
                    break;
                case 8:
                    System.out.println("Denumire produs: ");
                    scanner.useDelimiter("\n");
                    choice = scanner.next();
                    scanner.reset();
                    Serviciu.searchProduct(choice, localuri);
                    break;
                case 9:
                    System.out.println("Denumire oras: ");
                    scanner.useDelimiter("\n");
                    choice = scanner.next();
                    scanner.reset();
                    Serviciu.searchLocal(choice, localuri);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPTIUNE INVALIDA!");
            }
        }while(opt != 0);
    }
}
