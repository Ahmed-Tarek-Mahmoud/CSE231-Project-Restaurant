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
public class Item {

    private ArrayList <Ingredients> ingreds = new ArrayList<Ingredients>();
    private String name;
    private String description;
    private String category;
    private String recipe;
    private int id;
    private int quantity;
    private int price;
    
    public Item(String name, String description, String category, String recipe, int price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.recipe = recipe;
        this.price = price;
    }
    
    public Item(String name, int quantity, int price) {
        this.name = name;
        this.quantity=quantity;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    public void addIngredients(String name, int id, String unitOfMeasurment,  int quantity){
        ingreds.add(new Ingredients( name, id, unitOfMeasurment, quantity));
    }
    
    public void removeIngredients(int id){
        for (Ingredients ingred : ingreds) {
            if(ingred.getId()==id){
                ingreds.remove(ingred);
                break;
            }
        }
    }
    
    public void editIngredients(ArrayList<Ingredients> ingredients) {
    	while(this.ingreds.size()>0) this.ingreds.remove(0);
    	for (Ingredients ingred : ingredients) {         
                this.ingreds.add(ingred);         
        }
    }
    
    public Ingredients searchIngredient(int id){
        Ingredients localItem = null;
        for (Ingredients ingred : ingreds) {
            if(ingred.getId()==id){
                localItem =ingred;
                break;
            }
        }
        return localItem;
    }
}
/*
    should i make modify method(s) wla faks
*/