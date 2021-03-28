package services;

import courier.*;
import food.Local;
import food.Produs;

import java.util.List;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        Firma_livrare foodpanda = Init.firma_livrare("foodpanda.txt","src/courier/");
        Local mcdonalds = Init.restaurant("mcdonalds.txt","src/food/");
        Local kfc = Init.restaurant("kfc.txt","src/food/");
        Local hercule = Init.restaurant("hercule.txt","src/food/");
    }
}
