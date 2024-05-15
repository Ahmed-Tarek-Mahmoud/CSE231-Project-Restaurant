package Order;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class App extends Application implements EventHandler<ActionEvent> {

    @Override
    public void start(Stage stage) {
     
        GridPane grid =new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setVgap(10);
        grid.setHgap(20);

        Label id =new Label("#");    
        Label quantity =new Label("Quantity");
        Label price =new Label("Price");
        Label item =new Label("Item");
        GridPane.setConstraints(id,  0, 0);
        GridPane.setConstraints(quantity, 3, 0);
        GridPane.setConstraints(price, 2, 0);
        GridPane.setConstraints(item, 1, 0);
        grid.getChildren().addAll(id,quantity,price,item);
        ArrayList <Item> menu =Menu.getMenu();
        ArrayList <TextField> fields = new ArrayList<TextField>();
        ArrayList <Integer> labelOfprice = new ArrayList<Integer>();
        
        int i=1;
        for (;i<=Menu.getSize();i++){
            Label itemId=new Label(String.valueOf(i));    
            TextField itemQuantity=new TextField("0");
            Label itemPricee=new Label( String.valueOf(menu.get(i-1).getPrice() ) +"                 ");
            Label itemName=new Label( String.valueOf(menu.get(i-1).getName() ));
            itemName.setStyle("-fx-font-weight: bold;");
            Label itemDisc=new Label( String.valueOf(menu.get(i-1).getDescription() ));
            VBox nameDisc=new VBox();
            nameDisc.getChildren().addAll(itemName,itemDisc);
            fields.add(itemQuantity);
            labelOfprice.add(menu.get(i-1).getPrice());
            
            GridPane.setConstraints(itemId,  0, i);
            GridPane.setConstraints(itemQuantity, 3, i);
            GridPane.setConstraints(itemPricee, 2, i);
            GridPane.setConstraints(nameDisc, 1, i);
            grid.getChildren().addAll(itemId,itemQuantity,itemPricee,nameDisc);
        }
        
        Label amount =new Label("Amount:");    
        Label orderamount =new Label();
        
        amount.setStyle("-fx-font-size: 17px; -fx-font-weight: bold;");
        orderamount.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        
        GridPane.setConstraints(amount, 1, i);
        GridPane.setConstraints(orderamount, 2, i);
        grid.getChildren().addAll(amount,orderamount);
        
        i++;
        Label error =new Label("");
        error.setStyle("-fx-font-weight: bold; -fx-text-fill: red;");
        
        GridPane.setConstraints(error,  1, i);
        grid.getChildren().add(error);
        i++;
        Button bt =new Button("Request Receipt");
        GridPane.setConstraints(bt,  1, i);
        grid.getChildren().add(bt);
        
        bt.setOnAction(e ->{
            if("".equals(error.getText())){
                ArrayList <Item> orderItems = new ArrayList<Item>();
                for(int j=0;j<Menu.getSize();j++){
                    if(Integer.parseInt(fields.get(j).getText())>0){
                        Item currentItem=Menu.getMenu().get(j);
                        orderItems.add(new Item(currentItem.getName(),Integer.parseInt(fields.get(j).getText()),currentItem.getPrice()) );
                    }
                        
                }
                Order currentOrder=new Order(orderItems);
                Order.addOrder(currentOrder);
                System.out.println(Order.getCurrentOrders().get(0).getCost());
                Order.removeOrder();
            //Scene tarek  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
            /*  
                after u finish remove order from static method "removeOrder()"
            */
            }
        
        });
        
       
        for(int j=0;j<fields.size();j++){
            
            TextField t=fields.get(j);

            t.setOnKeyReleased(e -> {
                 int total=0;
                 int errorNum=0;
                 for(int k=0;k<fields.size();k++){
                    TextField tt=fields.get(k);
                    int pp=labelOfprice.get(k);
                    String texttext=tt.getText();
                    int qq=0;
                    if(texttext.length()!=0){
                        try{                      
                            qq=Integer.parseInt(texttext);
                            if(qq<0)
                                throw new IllegalArgumentException();
                            total+=(pp*qq);
                            if(errorNum==0)
                                error.setText("");
                        }catch(IllegalArgumentException expt){
                            error.setText("Enter a valid Quantity!!");
                            errorNum++;
                        }
                        
                    }
                    
                 }
                     
                orderamount.setText(String.valueOf(total));
                });
        }
         
        stage.setTitle("MENU");
        Scene scene = new Scene(grid, 550 , 420);
        stage.setScene(scene);
        stage.show();
          
    }

    public static void main(String[] args) {
    Menu.addItem( "Burger",  "Juicy Beef Burger",  "",  "",   250);
    Menu.addItem("Pizza",  "Delicious Gourmet Pizza",  "salty",  "",   300);
    Menu.addItem( "Pasta",  "Satisfying Pasta Delight",  "salty",  "",   200);
    Menu.addItem( "Mix Grill",  "Delectable Mixed Grill",  "salty",  "",   500);
    Menu.addItem( "Molokhya",  "Traditional Egyptian Molokhya",  "salty",  "",   200);
    
        launch(args);
    }

    @Override
    public void handle(ActionEvent t) {
        
    }

}