/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderClasses;
import java.util.*;

/**
 *
 * @author pc
 */
public class Order {

    private static ArrayList <Order> currentOrders = new ArrayList<Order>();
    private ArrayList <Item> items = new ArrayList<Item>();
    private int orderNumber;
    private int tableNumber;
    private int cost;
    
    
    public Order(int tableNumber ) {
    	this.tableNumber = tableNumber;
    }
    
    public Order( ArrayList <Item> items) {
        
        this.items.addAll(items);
    }
   
    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<Item> getItems() {
		return items;
	}
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCost() {
        int acc=0;
        for(Item item : items)
            acc+=item.getPrice()*item.getQuantity();
        cost=acc;
        return cost;
    }

    public static ArrayList<Order> getCurrentOrders() {
        return currentOrders;
    }
    
    public static void addOrder(Order order) {
        currentOrders.add(order);
    }
    
    public static void removeOrder() {
        currentOrders.remove(currentOrders.size()-1);
    }
   
}
