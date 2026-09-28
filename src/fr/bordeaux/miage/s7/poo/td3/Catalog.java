package fr.bordeaux.miage.s7.poo.td3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Catalog{

    private Set<Product> products;
    private Map<UUID ,Product> uuidProduct;
    private Map<UUID, Integer> quantityProduct;

    public Catalog(){
        this.products = new HashSet<>();
        //products.add(product);

        this.uuidProduct = new HashMap<>();
        //uuidProduct.put(product.getProductUuid(), product);

        this.quantityProduct = new HashMap<>();
        //quantityProduct.put(product.getProductUuid(), quantity);
    }

    public void addProduct(Product product, int quantity) throws Exception{
        if (this.products.contains(product)){
            throw new Exception("ce produit existe déjà dans le catalogue");
            
        } else {
            products.add(product);
            uuidProduct.put(product.getProductUuid(), product);
            quantityProduct.put(product.getProductUuid(), quantity);
        }
    }

    @Override 
    public String toString(){
        String result = "Catalogue :\n";
        for (Product p : this.products){
            result = result + "Produit : " +p.getProductName() + " - " + "Prix : " + p.getProductPrice() + " (Quantité : " + this.quantityProduct.get(p.getProductUuid()) +")" +"\n";
        }
        return result;
    }

    public boolean isProductExist(UUID uuid){
        return this.quantityProduct.containsKey(uuid);
    }

    public int productInStock(UUID uuid){
        return this.quantityProduct.get(uuid);
    }

    public void removeQuantityByUUID(UUID uuid, int quantity){
        int newQuantity = this.productInStock(uuid)-quantity;
        quantityProduct.put(uuid, newQuantity);
    }

}