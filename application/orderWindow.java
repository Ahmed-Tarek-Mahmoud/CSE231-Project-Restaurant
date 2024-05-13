package application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class orderWindow {

	protected static void buildWindow(Stage primaryStage) {
		Stage newStage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 300);
        newStage.setScene(scene);

        // Close the current stage
        primaryStage.close();

        // Show the new stage
        newStage.show();
	}
}
