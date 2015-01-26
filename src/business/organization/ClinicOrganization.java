/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.Order;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class ClinicOrganization extends Organization{
 private String street;
 private String city;
    private String State;
    private int pin;
    private int contact;
    private String email;
    private String status;
    private ArrayList<Order> orderList;
    private int totalVaccine;
    public ClinicOrganization(String name) {
        super(name);
       orderList = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Order addOrder()
{
    Order o = new Order();
    orderList.add(o);
    return o;
}

    public int getTotalVaccine() {
        return totalVaccine;
    }

    public void setTotalVaccine(int totalVaccine) {
        this.totalVaccine = totalVaccine;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

public void removeOrder(Order o)
{
    orderList.remove(o);
}
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
