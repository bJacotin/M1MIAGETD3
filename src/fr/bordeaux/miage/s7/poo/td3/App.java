package fr.bordeaux.miage.s7.poo.td3;

import java.util.UUID;

public class App {
    public static void main(String[] args) throws Exception {

        Catalog catalogue = new Catalog();

        Product bottes = new Product("Bottes", 15.55);
        Product gants = new Product("Gants", 8.99);

        catalogue.addProduct(bottes, 5);
        catalogue.addProduct(gants, 10);

        UUID idBottes = bottes.getProductUuid();
        UUID idGants = gants.getProductUuid();

        System.out.println(catalogue);

        Basket panier = new Basket(catalogue);
        panier.inc(idBottes, 2);
        panier.inc(idGants, 3);

        System.out.println(panier);

        System.out.println("Stock bottes après commande : " + catalogue.productInStock(idBottes));
        System.out.println("Stock gants après commande : " + catalogue.productInStock(idGants));

        panier.dec(idGants, 1);

        System.out.println(panier);
        System.out.println("Stock gants après retour : " + catalogue.productInStock(idGants));

        catalogue.modifyPrice(bottes, "Bottes", 19.99, 5);
        System.out.println(catalogue);
        System.out.println(panier);
    }
}