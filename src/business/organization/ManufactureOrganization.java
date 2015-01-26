/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.Vaccine;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class ManufactureOrganization extends Organization{
private String street;
private int pin;
private int contact;
private String email;
private String city;
private String state;
private ArrayList<Vaccine> productCatalog;
private String status;
    public ManufactureOrganization(String name) {
        super(name);
        productCatalog = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Vaccine> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ArrayList<Vaccine> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
