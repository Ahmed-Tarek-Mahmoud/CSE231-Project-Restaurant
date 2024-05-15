package Systems;

import OrderClasses.*;
/**
 *
 * @author Kiere
 */
import java.util.ArrayList;

public interface MenuManager {
    ArrayList<Item> list= new ArrayList<>();
    default void addItem(String name, String description, String category, String recipe,int id, int price){
        Item menuItem = new Item( name,  description,  category,  recipe,   price);
        list.add(menuItem);
    }
    default void editItem(Item menuItem, String recipe, ArrayList<Ingredients> ingredients){
        menuItem.setRecipe(recipe);
        // nasr will add a modify method
        menuItem.editIngredients(ingredients);
    }
    default void removeItem(Item menuItem){
        list.remove(menuItem);
    }
}

