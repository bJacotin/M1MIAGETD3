package fr.bordeaux.miage.s7.poo.td3;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("---------------------------------");
        Product bottes = new Product("Bottinnes", 15.00);
        System.out.println(bottes);
        Product bottesrouges = new Product("Bottes", 15.55);
        System.out.println(bottesrouges);
        Catalog catalogue = new Catalog();
        catalogue.addProduct(bottesrouges, 2);
        catalogue.addProduct(bottes, 3);
        System.out.println(catalogue);
    }
}
