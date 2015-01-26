package business;


import business.OrderItem;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dev
 */
public class Order {

    private ArrayList<OrderItem> order;
    private int totalAmount=0;
    private Date timestamp;
    private int id;
    private static int count =0;
    private String status;
    private Date shippingdate;
    public Order() {
        count++;
        id = count;
        order = new ArrayList<OrderItem>();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getShippingdate() {
        return shippingdate;
    }

    public void setShippingdate(Date shippingdate) {
        this.shippingdate = shippingdate;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    

    

    public ArrayList<OrderItem> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<OrderItem> order) {
        this.order = order;
    }

    public OrderItem addOrderItem() {
        OrderItem oi = new OrderItem();
        order.add(oi);
        return oi;
    }

    public void removeOrderItem(OrderItem o) {
        order.remove(o);
    }
}
