/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.Order;
import business.network.Network;
import business.role.Role;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Dev
 */
public class HospitalOrganization extends Organization {

    private String street;
    private String city;
    private String State;
    private int pin;
    private int contact;
    private String email;
    ArrayList<ImageIcon> images;
    private String status;
    private ArrayList<Order> orderList;
    private Network stateNetwork;
    private String licenseNo;
    private Date expiry;
    private int totalVaccine;
    public HospitalOrganization(String name) {
        super(name);
        images = new ArrayList<>();
        orderList = new ArrayList<>();
    }

    public int getTotalVaccine() {
        return totalVaccine;
    }

    public void setTotalVaccine(int totalVaccine) {
        this.totalVaccine = totalVaccine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Order addOrder() {
        Order o = new Order();
        orderList.add(o);
        return o;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public Network getStateNetwork() {
        return stateNetwork;
    }

    public void setStateNetwork(Network stateNetwork) {
        this.stateNetwork = stateNetwork;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ImageIcon> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageIcon> images) {
        this.images = images;
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

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
