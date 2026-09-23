package fr.bordeaux.miage.s7.poo.td3;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private String nom;
    private double prix;
    private UUID uuid;

    public Product(String nom, double prix){
        this.uuid = UUID.randomUUID();
        this.nom = nom;
        this.prix = prix;
    }

    public boolean isProductEquals(Product otherProduct){
        return otherProduct.getProductName().equals(this.getProductName()) && otherProduct.getProductPrice() == this.getProductPrice();
    }

    @Override 
    public boolean equals(Object obj){
        if (obj instanceof Product){
            Product otherProduct = (Product) obj;
            return isProductEquals(otherProduct);
        } else
            return false;
        }

    @Override
    public int hashCode(){
        return Objects.hash(this.getProductName(), this.getProductPrice());
    }

    public UUID getProductUuid(){
        return uuid;
    }

    public String getProductName(){
        return nom;
    }
    
    public double getProductPrice(){
        return prix;
    }
}
