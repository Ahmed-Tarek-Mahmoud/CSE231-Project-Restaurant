package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import personClasses.Customer;
import personClasses.Manager;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;


public class Main extends Application implements EventHandler<ActionEvent>  {
	
	
	private TextField usernameField;
    private PasswordField passwordField;
	@Override
	public void start(Stage primaryStage) {
		Controller cc = new Controller();
		primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 0);
        usernameField = new TextField();
        usernameField.setPromptText("username");
        grid.add(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 1);
        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        grid.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 2);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (isManager(username, password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Login successful");
                alert.showAndWait();
                // Add your code to open the main application window here
                openManagerWindow(primaryStage);
            } else if (isWaiter(username, password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Login successful");
                alert.showAndWait();
                // Add your code to open the main application window here
                openWaiterWindow(primaryStage);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isManager(String username, String password) {
        // Replace this with your actual validation logic
        return username.equals("manager") && password.equals("1234");
    
	}
    
    private boolean isWaiter(String username, String password) {
        // Replace this with your actual validation logic
        return username.equals("waiter") && password.equals("4321");
    
	}
    
    private void openManagerWindow(Stage primaryStage) {
    	Manager m = new Manager("kiereia",  "20",  "female",  "123",  "12234",  "kiki@example.com","cairo",  "manager",  "456", 20000);
    	m.setTables();
        primaryStage.close();
        BorderPane borderPane = new BorderPane();

        Stage mainWindow = new Stage();
        mainWindow.setTitle("Main Window");

        // Menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem logoutMenuItem = new MenuItem("Logout");
        logoutMenuItem.setOnAction(e ->{   
                primaryStage.show();     
                mainWindow.close(); 
                usernameField.clear();
                passwordField.clear();
        });
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().addAll(logoutMenuItem, new SeparatorMenuItem(), exitMenuItem);
        menuBar.getMenus().add(fileMenu);
        Menu ReservationMenu = new Menu("Reservations");
        MenuItem createReservation = new MenuItem("Create Reservation");
        
        createReservation.setOnAction(e -> Controller.openReservationWindow());
        
        ReservationMenu.getItems().add(createReservation);
        
        MenuItem viewTables = new MenuItem("Table View");
        
        viewTables.setOnAction(e -> Controller.openTablesStatus());
        
        ReservationMenu.getItems().add(viewTables);
        
        MenuItem viewRes = new MenuItem("Reservation View");
        
        viewRes.setOnAction(e -> Controller.openReservationManager());
        
        ReservationMenu.getItems().add(viewRes);
        
        
        
        menuBar.getMenus().add(ReservationMenu);
        
        // Logo image
        Image logoImage = new Image("file:///C:/Users/Ahmed%20Tarek/Downloads/logo%20rest.jpg");
        ImageView imageView = new ImageView(logoImage);
        
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());

        borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(imageView);

        Scene scene = new Scene(borderPane, 400, 300);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
    
       private void openWaiterWindow(Stage primaryStage) {
    	    
    	primaryStage.close();
        BorderPane borderPane = new BorderPane();

        Stage mainWindow = new Stage();
        mainWindow.setTitle("Main Window");

        // Menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem logoutMenuItem = new MenuItem("Logout");
        logoutMenuItem.setOnAction(e ->{   
                primaryStage.show();     
                mainWindow.close(); 
                usernameField.clear();
                passwordField.clear();
        });
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().addAll(logoutMenuItem, new SeparatorMenuItem(), exitMenuItem);
        menuBar.getMenus().add(fileMenu);
        
        Menu orderMenu = new Menu("Order...");
        MenuItem newOrder = new MenuItem("Create Order");
        newOrder.setOnAction(e -> {
        	Controller.createOrder(primaryStage);
        });
        orderMenu.getItems().add(newOrder);
        menuBar.getMenus().add(orderMenu);
        
        // Logo image
        Image logoImage = new Image("file:///C:/Users/Ahmed%20Tarek/Downloads/logo%20rest.jpg");
        ImageView imageView = new ImageView(logoImage);
        
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(mainWindow.widthProperty());
        imageView.fitHeightProperty().bind(mainWindow.heightProperty());

        borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(imageView);      

        Scene scene = new Scene(borderPane, 550 , 420);
        mainWindow.setScene(scene);
        mainWindow.show();
        
    }
    
	public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void handle(ActionEvent t) {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
