package DataBase;

import java.awt.Button;

import Classes.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Methods {	
		//using wrong username/password method
		public static void popup(String title, String message) {
			Stage popup = new Stage();
			popup.initModality(Modality.APPLICATION_MODAL);
			popup.setTitle(title);
			Label label = new Label(message);
			
			StackPane layout = new StackPane();
			layout.getChildren().add(label);
			Scene scene = new Scene(layout, 300, 200);
			scene.getStylesheets().add("alert.css");
			popup.setScene(scene);		
			popup.showAndWait();
		}
		
	public static ObservableList<Flight> getFlight(){
			ObservableList<Flight> flight = FXCollections.observableArrayList();

			return flight;
		}
	public static void startApp(Stage stage) {
			stage.show();
		}
	public static boolean nameChecker(String name) {
			return name.matches("[a-zA-Z]+");
		}
	public static boolean addressChecker(String address) {
			return address.matches("[A-Za-z0-9'\\.\\-\\s]+");
		}
	public static boolean ssnChecker(String ssn) {
			return ssn.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
		}
	public static boolean zipcodeChecker(String zipcode) {
			return zipcode.matches("^[0-9]{5}(?:-[0-9]{4})?$");
		}
	public static boolean usernameChecker(String username) {
			return username.matches("^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$");
		}
		
	public static boolean registerChecker(String firstName, String lastName, String address, String zipcode, String ssn, String username) {
		if(nameChecker(firstName) && 
				nameChecker(lastName) && 
				addressChecker(address) && zipcodeChecker(zipcode) 
				&& ssnChecker(ssn) && usernameChecker(username)) {
			return true;
		}
		return false;
		}
}