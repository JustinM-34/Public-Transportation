package GUI;

import javafx.scene.Scene;
import javafx.stage.*;	
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Classes.Account;
import DataBase.DatabaseMethods;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class MainMenuC extends Maindup {
static Scene scene;
static Account account;
static Stage window = new Stage();

public static void menuScreen() throws Exception {
window.setTitle("Welcome back " + DatabaseMethods.pullFirstName(LoginC.getlogin()) + " " + DatabaseMethods.pullLastName(LoginC.getlogin()) + "!");
GridPane grid = new GridPane();
grid.setPadding(new Insets(10,10,10,10));
grid.setHgap(8);
grid.setVgap(10);
grid.setAlignment(Pos.CENTER);

//after login button click bookflight
Button manageflight = new Button("Manage Flight");
GridPane.setConstraints(manageflight, 0, 0);
		
//account information
Button accountInfo = new Button("Account Information");	
GridPane.setConstraints(accountInfo, 0, 1);

//logout
Button logout = new Button("Log Out");
GridPane.setConstraints(logout, 0, 2);

//manageflight button clicked
manageflight.setOnAction(e -> {
	window.close();
	CustomerBookAFlight.bookflight();});

//accoung info button clicked
accountInfo.setOnAction(e -> {
	try {
		AccountInfoC.accountScreen();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
});
logout.setOnAction(e -> {
	window.close();
	try {
		window = LoginC.relog();
		window.show();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
});

grid.getChildren().addAll(manageflight, logout,accountInfo);
window.setResizable(false);
scene = new Scene(grid, 400, 500);
scene.getStylesheets().add("customer.css");
window.setScene(scene);
window.show();
}

}