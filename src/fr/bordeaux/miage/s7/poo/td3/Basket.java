package fr.bordeaux.miage.s7.poo.td3;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Basket {
    
    private Map<UUID, Integer> orderedQuantity;
    private Catalog catalogue;

    public Basket(Catalog catalogue){
        this.orderedQuantity = new HashMap<>();
        this.catalogue = catalogue;
    }

    public void inc(UUID id, int quantity) throws Exception {
        if (!this.catalogue.isProductExist(id)){
            throw new Exception("Erreur, le produit n'existe pas");
        } else { 
            if (this.catalogue.productInStock(id) < quantity) {
                throw new Exception("Erreur, quantité insuffisante");
            } else {
                this.catalogue.removeQuantityByUUID(id, quantity);
                orderedQuantity.put(id, orderedQuantity.getOrDefault(id, 0) + quantity);
            }
        }   
    }

    public void dec(UUID id, int quantity) throws Exception {
        if (!this.catalogue.isProductExist(id)){
            throw new Exception("Erreur, le produit n'existe pas");
        } else { 
            if (orderedQuantity.getOrDefault(id, 0) >= quantity) {
                this.catalogue.removeQuantityByUUID(id, -quantity);
                orderedQuantity.put(id, orderedQuantity.getOrDefault(id, 0) - quantity);
            } else {
                throw new Exception("Erreur, quantité insuffisante");
            }
        }   
    }
    
    @Override
    public String toString(){
        String result = "Basket :\n";
        for (UUID id : orderedQuantity.keySet()){
            Product p = this.catalogue.showProduct(id);
            int quantity = orderedQuantity.get(id);
            result = result + "Produit : " + p.getProductName() + " - " + "Prix : " + p.getProductPrice() + " (Quantité : " + quantity + ")" + "\n";
        }
        return result;
    }
}
