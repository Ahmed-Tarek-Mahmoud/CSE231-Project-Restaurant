package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import OrderClasses.Item;
import OrderClasses.Menu;
import OrderClasses.Order;
import Systems.Reservation;
import Systems.ReservationManager;
import Systems.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paymentClasses.Payment;
import paymentClasses.Receipt;
import personClasses.Customer;
import personClasses.Manager;

public class Controller {
	
	
	static TableView <Reservation> table;
	static LocalDateTime currentDateTime;
	static Manager manager1 = new Manager( "kiereia",  "20",  "female",  "123",  "12234",  "kiki@example.com","cairo",  "manager",  "456", 20000);
	static ObservableList <Reservation> list = FXCollections.observableArrayList();
	
	protected Controller() {
		    Menu.addItem( "Burger",  "Juicy Beef Burger",  "",  "",   250);
		    Menu.addItem("Pizza",  "Delicious Gourmet Pizza",  "salty",  "",   300);
		    Menu.addItem( "Pasta",  "Satisfying Pasta Delight",  "salty",  "",   200);
		    Menu.addItem( "Mix Grill",  "Delectable Mixed Grill",  "salty",  "",   500);
		    Menu.addItem( "Molokhya",  "Traditional Egyptian Molokhya",  "salty",  "",   200);
		    
	}
	
	protected static void openReservationWindow() {
		 
	    	TextField nameField = new TextField();
	        TextField ageField = new TextField();
	        TextField emailField = new TextField();
	        ComboBox<String> genderComboBox = new ComboBox<>();
	        TextField phoneField = new TextField();
	        TextField idField = new TextField();
	        TextField addressField = new TextField();
	        TextField guestsField = new TextField();
	        
	        genderComboBox.getItems().addAll("Male", "Female");

	        // Creating labels for input fields
	        Label nameLabel = new Label("Name:");
	        Label ageLabel = new Label("Age:");
	        Label emailLabel = new Label("Email:");
	        Label genderLabel = new Label("Gender:");
	        Label phoneLabel = new Label("Phone:");
	        Label idLabel = new Label("Id:");
	        Label addressLabel = new Label("Address:");
	        Label guestsLabel = new Label("Guests:");
	        //Label tostring = new Label(manager1.Rlist.get(0).toString());

	        // Creating submit button
	        Button submitButton = new Button("Submit");
	        submitButton.setOnAction(event -> {
	        	if(isFieldsFilled(nameField,ageField,emailField,phoneField,idField,addressField,guestsField)) {	        		
	            // Process input data here
	            String name = nameField.getText();
	            String age = ageField.getText();
	            String email = emailField.getText();
	            String gender = genderComboBox.getValue();
	            String phone = phoneField.getText();
	            String id = idField.getText();
	            String address = addressField.getText();
	            String guests = guestsField.getText();
	            
	            // Get the current date and time
	            currentDateTime = LocalDateTime.now();

	            // Format the current date and time as per the given format "yyyy-MM-dd/HH:mm"
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");
	            String currentDateTimeFormatted = currentDateTime.format(formatter);
	            
	            Customer customer1 = new Customer( name,  age,  gender,  id,  phone,  email, address);
	            manager1.Reserve(customer1,Integer.parseInt(guests),currentDateTimeFormatted);
	            System.out.println(manager1.Rlist.get(manager1.Rlist.size()-1).toString());
	           
	          
	        	}else {
	        		 submitButton.setStyle("-fx-border-color: red;");
	        	}
	        });

	     // Layout for first column
	        VBox column1 = new VBox(5);
	        column1.getChildren().addAll(nameLabel, nameField, ageLabel, ageField, emailLabel, emailField, genderLabel, genderComboBox);

	        // Layout for second column
	        VBox column2 = new VBox(5);
	        column2.getChildren().addAll(phoneLabel, phoneField, idLabel, idField, addressLabel, addressField, guestsLabel, guestsField, submitButton);

	        // Outer HBox to contain the two VBox elements
	        HBox outerHBox = new HBox(10);
	        outerHBox.setPadding(new Insets(10));
	        outerHBox.getChildren().addAll(column1, column2);
	        // Creating scene with layout
	        Scene scene = new Scene(outerHBox, 400, 250);


	    	
	        Stage newStage = new Stage();
	        Button newBtn = new Button("Close");
	        newBtn.setOnAction(event -> newStage.close());

	
	        newStage.setTitle("New Window");
	        newStage.setScene(scene);
	        newStage.show();
	    }
		

	private static boolean isFieldsFilled(TextField... fields) {
	    for (TextField field : fields) {
	        if (field.getText().isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}

	protected static void openTablesStatus() {
		
        // Create a GridPane to hold table boxes
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        int i=0,j=0;
        for(Table table:Manager.tables) {
        
                String status;
                if(table.getStatus()) status = "Occupied";
                else status = "Free";

                Rectangle tableBox = new Rectangle(60, 60);
                tableBox.setStroke(Color.BLACK);
                tableBox.setStrokeWidth(2);

                if (status.equals("Free")) {
                    tableBox.setFill(Color.GREEN);
                } else {
                    tableBox.setFill(Color.RED);
                }
                
                gridPane.add(tableBox, i,j );
                i++;
                if(i==5) {
                	i=0;
                	j++;
                }
            }
        
     // Create a BorderPane to center the GridPane
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        

        // Create scene
        Scene scene = new Scene(root, 500, 500);
        

        Stage primaryStage = new Stage();
		// Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Table Status");
        primaryStage.show();
    }

	 
	 static void openReservationManager() {

	 Stage res = new Stage();
	 res.initModality(Modality.APPLICATION_MODAL);

	 BorderPane border = new BorderPane();
	 //sets the table
	 table = new TableView <>();

	 TableColumn<Reservation,String> namecolumn = new TableColumn<>("Name");
	 namecolumn.setMinWidth(200);
	 namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));


	 TableColumn<Reservation,String> guestscolumn = new TableColumn<>("Guests");
	 guestscolumn.setMinWidth(200);
	 guestscolumn.setCellValueFactory(new PropertyValueFactory<>("guests"));


	 TableColumn<Reservation,String> datecolumn = new TableColumn<>("date");
	 datecolumn.setMinWidth(200);
	 datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));



	 table.setItems(getReservation());
	 table.getColumns().addAll(namecolumn,guestscolumn,datecolumn);
	 table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	 //setting input boxes for data
	 HBox hbox = new HBox();
	 TextField guests = new TextField();
	 guests.setPromptText("no.Guests");
	 TextField date = new TextField();
	 date.setPromptText("Date");
	 Button editbutton = new Button("Edit");
	 editbutton.setOnAction(e -> 
	 {
	 editTableReservation(Integer.parseInt(guests.getText()),date.getText());
	 guests.clear();
	 date.clear();
	 list.clear();
	 list.addAll(ReservationManager.Rlist);
	 table.setItems(getReservation());
	 }); 

	 Button removebutton = new Button("Remove");
	 removebutton.setOnAction(e -> 
	 {
	 removeTableReservation();
	 });

	 hbox.getChildren().addAll(guests,date,editbutton,removebutton);

	 border.setCenter(table);
	 border.setBottom(hbox);
	 Scene scene = new Scene(border,550 , 420);
	 res.setScene(scene);
	 res.show();
	 }


	 private static void removeTableReservation() {
	 
	 ObservableList<Reservation> reservationSelected,allReservations;
	 allReservations = table.getItems();
	 reservationSelected = table.getSelectionModel().getSelectedItems();
	try {
	 for (int i=0; i<reservationSelected.size(); i++){

		 manager1.removeReservation(reservationSelected.get(i));
	 }
	 reservationSelected.forEach(allReservations::remove);
	 
	 }catch (Exception e){
		 System.out.println("Removal Done");
	 }}

	 public static ObservableList<Reservation> getReservation(){
	 list.clear();
	 list.addAll(ReservationManager.Rlist);
	 return list;
	 }

	 
	 private static void editReservation(Reservation item,int newguests,String newDate) {
 		
		    manager1.editReservation(item, newguests, newDate);
		    System.out.println(item.toString());
	    }	
	    
	 private static void editTableReservation(int guests, String date) {
		Reservation reservationSelected = table.getSelectionModel().getSelectedItem();
		editReservation(reservationSelected,guests,date);
	}
	 
	 protected static void createOrder(Stage stage) {
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
	               
	                
	            // here
	                Stage stage2 = new Stage();
	                stage2.setTitle("Choose Payment Method");
	                
	                // Create a ComboBox for payment method selection
	                ComboBox<String> paymentComboBox = new ComboBox<>();
	                paymentComboBox.getItems().addAll("Cash", "Credit");
	                paymentComboBox.setPromptText("Select Payment Method");
	                
	                // Create a button to confirm payment method selection
	                Button confirmButton = new Button("Confirm");
	                confirmButton.setOnAction(e2 -> {
	                    String selectedPaymentMethod = paymentComboBox.getValue();
	                    if (selectedPaymentMethod != null) {
	                        // Proceed with the selected payment method
	                        Payment p = new Payment(currentOrder, selectedPaymentMethod);
	                        Receipt r = new Receipt(currentOrder, p);
	                        System.out.println(r.printReceipt());
	                        Order.removeOrder();
	                        stage2.close(); // Close the payment window
	                    } else {
	                        System.out.println("Please select a payment method.");
	                    }
	                });
	                
	                // Create a layout and add the ComboBox and Button
	                VBox vbox = new VBox(10);
	                vbox.setPadding(new Insets(10));
	                vbox.getChildren().addAll(paymentComboBox, confirmButton);
	                
	                Scene scene = new Scene(vbox, 200, 100);
	                stage2.setScene(scene);
	                stage2.show();
	             
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
}

