/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.inventory;

import business.Vaccine;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dev
 */
public class Inventory {
    private Vaccine vaccine;
    ArrayList<InventoryItem> inventoryItemList;
   // private int totalQuantity=0;

    public Inventory(){
        inventoryItemList = new ArrayList<>();
    }
    public int getTotalQuantity() {
        int total=0;
        for(InventoryItem ii: inventoryItemList){
            total+=ii.getQuantity();
        }
        return total;
    }

   
    
    
    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public ArrayList<InventoryItem> getInventoryItemList() {
        return inventoryItemList;
    }

    public void setInventoryItemList(ArrayList<InventoryItem> inventoryItemList) {
        this.inventoryItemList = inventoryItemList;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccine);
    }

    
    
}
