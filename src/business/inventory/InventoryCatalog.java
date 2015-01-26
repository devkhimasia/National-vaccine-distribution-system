/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.inventory;

import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class InventoryCatalog {
    ArrayList<Inventory> inventoryList;
    public InventoryCatalog(){
        inventoryList = new ArrayList<>();
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
    public Inventory add(){
        Inventory i = new Inventory();
        inventoryList.add(i);
        return i;
    }
}
