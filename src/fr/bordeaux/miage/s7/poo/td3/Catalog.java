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

        this.uuidProduct = new HashMap<>();

        this.quantityProduct = new HashMap<>();
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

    public Product showProduct(UUID id){
        return this.uuidProduct.get(id);
    }
    
    public void modifyPrice(Product oldProduct, String newProductName ,double NewProductPrice, int newQuantity) throws Exception{
        products.remove(oldProduct);
        quantityProduct.remove(oldProduct.getProductUuid());
        uuidProduct.remove(oldProduct.getProductUuid());

        Product productWithNewPrice = new Product(oldProduct.getProductUuid(), newProductName, NewProductPrice);
        addProduct(productWithNewPrice, newQuantity);
        //Il y a un problème puisque pour les paniers, le produit modifié n'existe plus. Ils ont gardé en référence l'UUID de l'ancien produit, pas du nouveau et l'ancien produit n'est plus référencé puisqu'il est supprimé des trois collections.

        //Pour régler le problème il faut attribuer l'UUID de l'ancien produit au nouveau.
    }


}