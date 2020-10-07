package GUI;

import java.sql.SQLException;

import DataBase.DatabaseMethods;
import DataBase.Methods;
import DataBase.NewMethods;
import javafx.geometry.Insets;	
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpC {
	public static void main(String[] args) {
}
	static Scene scene;
	static Stage window = new Stage();
	static boolean answer;
	static TextField first;
	static TextField last;
	static TextField address1;
	static TextField zipcode1;
	static TextField state1;
	static TextField ssn1;
	static TextField question1;
	static TextField answer1;
	static TextField tusername;
	static TextField tpassword;
	static TextField middle;
	
public static void signupScreen() throws Exception {
	window.setTitle("Registration");
	
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);

	//label firstname
	Label fName = new Label("First Name:");	
	GridPane.setConstraints(fName, 0, 0);
	
	//textField firstname
	first = new TextField();
	first.setPromptText("Thomas");
	GridPane.setConstraints(first, 1, 0);
			
	//label lastname
	Label lName = new Label("Last Name:");
	GridPane.setConstraints(lName, 3, 0);
	
	//textField lastname
	last = new TextField();
	last.setPromptText("Finch");
	GridPane.setConstraints(last, 4, 0);
	grid.setAlignment(Pos.CENTER);
			
	//label Address
	Label address = new Label("Address:");
	GridPane.setConstraints(address, 0, 1);
			
	//textField address
	address1 = new TextField();
	address1.setPromptText("4201 Whitmoore Dr.");
	GridPane.setConstraints(address1, 1, 1);
			
	//label zipcode
	Label zipcode = new Label("ZipCode:");
	GridPane.setConstraints(zipcode, 0, 3);
			
	//textField zipcode
	zipcode1 = new TextField();
	zipcode1.setPromptText("30021");
	GridPane.setConstraints(zipcode1, 1, 3);
	
	Label state = new Label("State:");
	GridPane.setConstraints(state, 3, 1);		
	ChoiceBox<String> state1 = new ChoiceBox<>();
	state1.getItems().addAll("Choose State/Province", "AL","AK","AS","AZ","AR","CA","CO","CT","DE","DC","FL","GA","GU","HI","ID",
								"IL","IN","IA","KS","KY","LA","ME","MD","MH","MA","MI","FM","MN","MS","MO",
								"MT","NE","NV","NH","NJ","NM","NY","NC","ND","NM","OH","OK","OR","PW","PA",
								"PR","RI","SC","SD","TN","TX","UT","VT","VA","VI","WA","WV","WI","WY");
	state1.getSelectionModel().select(0);

	
	state1.setValue("Choose State/Province");
	GridPane.setConstraints(state1, 4, 1);
	
	
	
	//label ssn
	Label ssn = new Label("SSN:");
	GridPane.setConstraints(ssn, 3, 3);
	ssn1 = new TextField();
	ssn1.setPromptText("542-23-1245");
	GridPane.setConstraints(ssn1, 4, 3);

	//label Question
	Label question = new Label("Question:");
	GridPane.setConstraints(question, 0, 4);
			
	//textField Question
	ChoiceBox<String> question1 = new ChoiceBox<>();
	question1.getItems().addAll("Please select", "What high school did you attend?", "What's your favorite rapper?", "In what town or city was your first full time job?",
			"Whats is your spouse or partner's mother's maiden name", "In what town or city did your mother and father meet",
			"What is your favorite type of liquor?", "What is your favorite team?", "If you could have one superpower, what would it be?");
	question1.setValue("Please select");
	GridPane.setConstraints(question1, 1, 4);
	
	//label Answer
	Label answer = new Label("Answer:");
	GridPane.setConstraints(answer, 3, 4);
			
	//textField answer
	answer1 = new TextField();
	GridPane.setConstraints(answer1, 4, 4);
			
	//label username
	Label Lusername = new Label("Username:");
	GridPane.setConstraints(Lusername, 0, 5);
			
	//textField username
	tusername = new TextField();
	tusername.setPromptText("FrequentFlyer34");
	GridPane.setConstraints(tusername, 1, 5);
		
	////label password
	Label Lpassword = new Label("Password:");
	GridPane.setConstraints(Lpassword, 3, 5);
			
	//textField password
	tpassword = new TextField();
	GridPane.setConstraints(tpassword, 4, 5);

	//button register
	Button cancelbutton = new Button("Back");
	GridPane.setConstraints(cancelbutton, 0, 6);
	
	Button signUpButton = new Button("Sign Up");
	GridPane.setConstraints(signUpButton, 1, 6);

	
	window.setOnCloseRequest(e -> {
	e.consume();
	closeProgram();
	});
	cancelbutton.setOnAction(e -> {
		e.consume();
		closeProgram();
		});
	signUpButton.setOnAction(e -> {	
		if(Methods.registerChecker(first.getText(), last.getText(), address1.getText(), zipcode1.getText(), ssn1.getText(), tusername.getText()) == false) {
			Methods.popup("Error", "Invalid input.");
		}
		else {
		String firstname 	= first.getText();
		String lastname 	= last.getText();
		String tempaddress 	= address1.getText();
		String tempzipcode 	= zipcode1.getText();
		String tempstate 	= state1.getValue();
		String tempusername = tusername.getText();
		String temppassword = tpassword.getText();
		String tempquestion = question1.getValue();
		String tempanswer 	= answer1.getText();
		String tempssn 	= ssn1.getText();
		
	DatabaseMethods.makeaccount(firstname, lastname, tempaddress, tempzipcode, tempstate, tempusername, temppassword, tempquestion, tempanswer, tempssn);
	
	try {
		DatabaseMethods.inputregister();
		window.close();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		}
	});
	
	grid.getChildren().addAll(fName, first, lName, last, address, address1, zipcode,zipcode1,state, state1, ssn, 
			ssn1, question, question1, answer, answer1, Lusername, tusername,Lpassword, tpassword,cancelbutton,signUpButton);
	scene = new Scene(grid, 750, 500);
	scene.getStylesheets().add("signup.css");
	window.setScene(scene);
	window.showAndWait();
	
}
public static boolean confirmBox(String title, String message) {
	
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	window.setTitle(title);
	window.setMinWidth(250);
	Label label = new Label(message);
	
	Button yesB = new Button("Yes");
	yesB.setOnAction(e -> {
		answer = true;
		window.close();
	});
	Button noB = new Button("No");
	noB.setOnAction(e -> {
	answer = false;
	window.close();
	});
	VBox layout = new VBox();
	layout.setPadding(new Insets(10,10,10,10));
	layout.getChildren().addAll(label, yesB, noB);
	layout.setAlignment(Pos.CENTER);
	Scene scene = new Scene(layout);
	window.setScene(scene);
	window.showAndWait();
	return answer;
}
public static void closeProgram() {
	boolean answer = SignUpC.confirmBox("Are you sure?", "Are you sure you want to exit the registration?");
	if(answer)
		window.close();
}
}