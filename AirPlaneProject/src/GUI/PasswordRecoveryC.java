package GUI;

import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordRecoveryC {
static TextField usernameTxt;
public static void passwordRecovery() {
	Stage window = new Stage();
	window.setTitle("Password Recovery");
	window.initModality(Modality.APPLICATION_MODAL);
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);
	Label label = new Label("Enter your username:");
	GridPane.setConstraints(label, 0, 0);
	
	usernameTxt = new TextField();
	GridPane.setConstraints(usernameTxt, 1, 0);
	
	Button button = new Button("Enter");
	GridPane.setConstraints(button, 0, 1);
	button.setOnAction(e -> {
		try {
			if(DatabaseMethods.userExists(usernameTxt.getText())) {
			try {
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			try {
			SecurityQuestionC.securityPopup();
			} catch (Exception e1) {
				System.out.println("Wrong");
				e1.printStackTrace();
			}
			}
			else
				Methods.popup("Error", "Username does not exist.");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	});
	grid.getChildren().addAll(label, usernameTxt,button);
	Scene scene = new Scene(grid, 350, 90);
	window.setResizable(false);;
	window.setScene(scene);
	window.showAndWait();
}
public static String getlogin() {
	return usernameTxt.getText();
}
}