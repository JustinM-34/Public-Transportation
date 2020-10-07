package GUI;
import java.util.ArrayList;

import Classes.Account;
import Classes.Admin;
import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.application.Preloader;
import javafx.geometry.Insets;	
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginC extends Account{
	static boolean isCorrect;
	private static PasswordField p;
	private static TextField name;
	static Account account;
	static Stage window;
	
	public static Stage loginScreen() throws Exception {
	window = new Stage();
	window.setTitle("QuickFly");
	
	//panel 1
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);
	
	//label username
	Label username = new Label("Username");
	GridPane.setConstraints(username, 0, 0);
	
	//textField
	name = new TextField();
	name.setPromptText("username");
	GridPane.setConstraints(name, 1, 0);
	
	//label password
	Label password = new Label("Password");
	GridPane.setConstraints(password, 0, 1);
	
	p = new PasswordField();
	p.setPromptText("password");
	GridPane.setConstraints(p, 1, 1);
	grid.setAlignment(Pos.CENTER);
	
	//Button login
	Button logInbutton = new Button("Log In");
	GridPane.setConstraints(logInbutton, 0, 2);
	
	// Button sign up
	Button signupbutton =new Button("Sign Up");
	GridPane.setConstraints(signupbutton, 1, 2);
	
	//label forgotpassword
	Hyperlink forgot = new Hyperlink("Forgot Password");
	GridPane.setConstraints(forgot, 1, 11);
	
	// Connection Label
	Label connectionStatus = new Label("Status: " + DatabaseMethods.isConnected());
	GridPane.setConstraints(connectionStatus, 1, 12);
	
	forgot.setOnMousePressed(e -> {
		try {
		PasswordRecoveryC.passwordRecovery();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	});
	logInbutton.setOnAction(e -> {
		try {
			if(isAdmin())
				adminloginButtonClick();
			else 
				customerLoginButtonClick();
		}catch(NullPointerException e1) {
			Methods.popup("Error", "Invalid Username/Password");
			}

		 catch (Exception e1) {
			Methods.popup("Error", "Invalid Username/Password");
			e1.printStackTrace();
		}
	});
	signupbutton.setOnAction(e -> {
		try {
			SignUpC.signupScreen();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	grid.getChildren().addAll(username, name, password, p , logInbutton, signupbutton, connectionStatus, forgot);
	Scene scene = new Scene(grid, 400, 500);
	scene.getStylesheets().add("viper.css");
	window.setResizable(false);
	window.setScene(scene);
	return window;
	
	}
	public static String getlogin() {
		return name.getText();
	}
	public static void adminloginButtonClick() {
			try {	
			 if ((Admin.getUsername().compareTo(name.getText()) == 0) &&
			(Admin.getPassword().compareTo(p.getText()) == 0)){
				window.close();
				AdminMainMenu.AdminmenuScreen();;
			}

			} catch (Exception e1) {
				Methods.popup("Error", "Invalid Username/Password");
				e1.printStackTrace();
			}		
	}
	public static void customerLoginButtonClick() throws Exception {
		int customertest = DatabaseMethods.pullPassword(name.getText()).compareTo(p.getText());
		try {
		if (customertest == 0) {
			window.close();
			MainMenuC.menuScreen();
		}
		}
		catch (Exception e1) {
			e1.printStackTrace();
			Methods.popup("Error", "Invalid Username/Password");
		}		
	}
	public static boolean isUser() throws Exception {
		int customertest = DatabaseMethods.pullPassword(name.getText()).compareTo(p.getText());
		if (customertest == 0)
			return true;
		else 
			return false;
	}
	public static boolean isAdmin() throws Exception{
		if ((Admin.getUsername().compareTo(name.getText()) == 0) &&
				(Admin.getPassword().compareTo(p.getText()) == 0))
			return true;
		else 
			return false;
		}
	public static Stage relog() throws Exception {
		// TODO Auto-generated method stub
		return loginScreen();
	}
	
}