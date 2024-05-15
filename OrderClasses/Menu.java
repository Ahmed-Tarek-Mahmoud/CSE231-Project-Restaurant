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
public class Menu {
    private static ArrayList <Item> menu = new ArrayList<Item>();
    private static int size;
    
    public static void addItem(String name, String description, String category, String recipe, int price){
        menu.add(new Item(  name,  description,  category,  recipe,  price));
        size++;
    }
    
    public static void removeItem(int id){
        for (Item item : menu) {
            if(item.getId()==id){
                menu.remove(item);
                break;
            }
        }
        size--;
    }
    
    public static Item searchItem(int id){
        Item localItem = null;
        for (Item item : menu) {
            if(item.getId()==id){
                localItem =item;
                break;
            }
        }
        return localItem;
    }
    
    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Menu.size = size;
    }

    public static ArrayList<Item> getMenu() {
        return menu;
    }
    
    
    
}
