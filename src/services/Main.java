package services;

import courier.*;
import food.Local;
import food.Produs;
import order.Comanda;
import order.Review;
import order.User;

import java.util.*;

public class Main {
    public static void initMeniu(){
        System.out.println("--------------------NICOI ALEXANDRU // GRUPA 253 // ELEMENTE AVANSATE DE PROGRAMARE--------------------");
        System.out.println("-----------------------FOOD DELIVERY - ETAPA 1-----------------------");
        System.out.println("-----------Pentru a utiliza o functie a meniului, tastati cifra corespunzatoare functiei alese-------------");
        System.out.println();
        System.out.println("1. Adaugare curier in cadrul companiei de livrari.");
        System.out.println("2. Listare curieri care sunt angajati la un anumit livrator.");
        System.out.println("3. Listare produse specifice unui local.");
        System.out.println("4. Listare ingrediente dintr-un produs.");
        System.out.println("5. Plasare comanda.");
        System.out.println("6. Adaugare review asupra comenzii.");
        System.out.println("7. Adaugare User care va folosi platforma.");
        System.out.println("8. Listare comenzi plasate de catre un anumit user.");
        System.out.println("9. Cautare un anumit produs in mai multe localuri.");
        System.out.println("10. Cautare local in functie de oras.");
        System.out.println("0. Iesire.");
    }
    public static void main(String[] args) {
        /// init data entries
        Firma_livrare foodpanda = Init.firma_livrare("foodpanda.txt","src/courier/");
        ArrayList<Local> localuri = new ArrayList<>();
        Local mcdonalds = Init.restaurant("mcdonalds.txt","src/food/");
        localuri.add(mcdonalds);
        Local kfc = Init.restaurant("kfc.txt","src/food/");
        localuri.add(kfc);
        Local hercule = Init.restaurant("hercule.txt","src/food/");
        localuri.add(hercule);
        ArrayList<User> useri = Init.users("useri.txt","src/order/");
        List<Comanda> comenzi = new ArrayList<>();

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
                    Serviciu.adaugare_curier(foodpanda);
                    System.out.println("Curier adaugat");
                    break;
                case 2:
                    Serviciu.listare_curieri(foodpanda);
                    break;
                case 3:
                    boolean OK = false;
                    System.out.println("Selecteaza localul:");
                    String localStr = scanner.next();
                    for (Local local:
                         localuri) {
                        if(local.getDenumire().equalsIgnoreCase(localStr))
                        {
                            Serviciu.listare_produse(local);
                            OK = true;
                            break;
                        }
                    }
                    if(!OK)
                        System.out.println("Localul nu exista!");
                    break;
                case 4:
                    OK = false;
                    System.out.println("Selecteaza produsul:");
                    String produsStr = scanner.next();
                    for (Local local :
                            localuri) {
                        for (Produs produs :
                                local.getLista_produse()) {
                            if(produsStr.equalsIgnoreCase(produs.getDenumire())){
                                OK = true;
                                Serviciu.listare_ingrediente(produs);
                                break;
                            }
                        }
                    }
                    if(!OK)
                        System.out.println("Produsul nu exista!");
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
