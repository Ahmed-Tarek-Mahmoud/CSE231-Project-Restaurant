/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;
import java.util.*;
/**
 *
 * @author pc
 */
public class Ingredients {
    private String name;
    private int id;
    private String unitOfMeasurment;
    private int quantity;

    public Ingredients(String name, int id, String unitOfMeasurment,  int quantity) {
        this.name = name;
        this.unitOfMeasurment = unitOfMeasurment;
        this.id = id;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitOfMeasurment() {
        return unitOfMeasurment;
    }

    public void setUnitOfMeasurment(String unitOfMeasurment) {
        this.unitOfMeasurment = unitOfMeasurment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    public boolean isAvailable() {
        return (quantity > 0) ;
    }
}
/*
    lets make code for id ==> id of ingredient start with 10


*/