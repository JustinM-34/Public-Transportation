package GUI;

import Classes.Account;
import Classes.Flight;
import Classes.Ticket;
import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerC {

	static Stage window = new Stage();
	static Scene scene;
	static TableView<Account> table;
	static TextField customerIdInput, customerFirstInput, customerLastInput, customerAddressInput,
	customerZipInput, customerStateInput, customerUserInput,customerPassInput, customerQuestionInput,
	customerAnswerInput, customerSsnInput;
	

	public static void manageCustomers() throws Exception {
	window.setTitle("Manage Customers(D = Delete, A = Add)");
	
	 ////Creating table
	//flight Id column
	TableColumn<Account, Integer> accountId = new TableColumn<>("Account Id");
	accountId.setMinWidth(200);
	accountId.setCellValueFactory(new PropertyValueFactory<>("accountId"));
	
	////Date column
	TableColumn<Account ,String> firstName = new TableColumn<>("First Name");
	firstName.setMinWidth(200);
	firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	
	//origin city column
	TableColumn<Account , String> lastName = new TableColumn<>("Last Name");
	lastName.setMinWidth(200);
	lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	
	//origin city column
	TableColumn<Account , String> address = new TableColumn<>("Address");
	address.setMinWidth(200);
	address.setCellValueFactory(new PropertyValueFactory<>("address"));
	
	TableColumn<Account , String> state = new TableColumn<>("State");
	state.setMinWidth(200);
	state.setCellValueFactory(new PropertyValueFactory<>("state"));
	
	TableColumn<Account , Integer> zipcode = new TableColumn<>("Zipcode");
	zipcode.setMinWidth(200);
	zipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
	
	TableColumn<Account , String> username = new TableColumn<>("Username");
	username.setMinWidth(200);
	username.setCellValueFactory(new PropertyValueFactory<>("userName"));
	
	TableColumn<Account , String> password = new TableColumn<>("Password");
	password.setMinWidth(200);
	password.setCellValueFactory(new PropertyValueFactory<>("password"));
	
	TableColumn<Account , String> question = new TableColumn<>("Question");
	question.setMinWidth(200);
	question.setCellValueFactory(new PropertyValueFactory<>("question"));
	
	TableColumn<Account , String> answer = new TableColumn<>("Answer");
	answer.setMinWidth(200);
	answer.setCellValueFactory(new PropertyValueFactory<>("answer"));
	
	TableColumn<Account , String> ssn = new TableColumn<>("SSN");
	ssn.setMinWidth(200);
	ssn.setCellValueFactory(new PropertyValueFactory<>("ssn"));
	
	//customer id input
	customerIdInput = new TextField();
	customerIdInput.setPromptText("Account Id");
	customerIdInput.setMinWidth(15);
	//customer first name input
	customerFirstInput = new TextField();
	customerFirstInput.setPromptText("First Name");
	customerFirstInput.setMinWidth(15);
	
	//customer last name 
	customerLastInput = new TextField();
	customerLastInput.setPromptText("Last Name");
	customerLastInput.setMinWidth(15);

	//customer address input
	customerAddressInput = new TextField();
	customerAddressInput.setPromptText("Address");
	customerAddressInput.setMinWidth(15);
	
	//customer address input
	customerZipInput = new TextField();
	customerZipInput.setPromptText("Zipcode");
	customerZipInput.setMinWidth(15);
	
	//customer state input
	customerStateInput = new TextField();
	customerStateInput.setPromptText("State");
	customerStateInput.setMinWidth(15);
	
	//customer username input
	customerUserInput = new TextField();
	customerUserInput.setPromptText("Username");
	customerUserInput.setMinWidth(15);
	
	//customer password input
	customerPassInput = new TextField();
	customerPassInput.setPromptText("Password");
	customerPassInput.setMinWidth(15);
	//customer question input
	customerQuestionInput = new TextField();
	customerQuestionInput.setPromptText("Security Question");
	customerQuestionInput.setMinWidth(15);
	
	customerAnswerInput = new TextField();
	customerAnswerInput.setPromptText("Security Answer");
	customerAnswerInput.setMinWidth(15);
	
	customerSsnInput = new TextField();
	customerSsnInput.setPromptText("SSN");
	customerSsnInput.setMinWidth(15);
	
   //delete Button
	Button deleteButton= new Button("D");
	deleteButton.setOnAction(e ->{
		try {
			DatabaseMethods.deleteCustomer(Integer.toString(table.getSelectionModel().getSelectedItem().getAccountId()));
			deleteClicked();
			refreshCustomers();
		} catch (Exception e2) {
			Methods.popup("Error", "Textfield input is invalid");
			e2.printStackTrace();
		}
	});	
	Button addButton= new Button("A");
	addButton.setOnAction(e -> {
		try {
			addbuttonClicked();
			refreshCustomers();
		} catch (Exception e1) {
			Methods.popup("Error", "Textfield input is invalid");
			e1.printStackTrace();
		}
	});
	window.setOnCloseRequest(e -> {
		try {
			AdminMainMenu.AdminmenuScreen();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(deleteButton, addButton, customerIdInput, customerFirstInput, customerLastInput, customerAddressInput,
			customerZipInput, customerStateInput, customerUserInput, customerPassInput, customerQuestionInput,
			customerAnswerInput, customerSsnInput);
	
	//table 1
	table = new TableView<>();
	table.setItems(getCustomers());
	table.getColumns().addAll(accountId, firstName, lastName, address, state, zipcode, username, password, question, answer, ssn);
	

	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);		
	scene = new Scene(layout, 1300, 400);
	window.setResizable(false);
	window.setScene(scene);
	window.show();
}
	
	private static void deleteClicked() throws Exception {
		ObservableList<Account> customerSelected, allCustomers;
		allCustomers = table.getItems();
		customerSelected = table.getSelectionModel().getSelectedItems();
		customerSelected.forEach(allCustomers::remove);
	}
	public static void addbuttonClicked() throws Exception {
		Account Account = new Account();
		String id = customerIdInput.getText();
		String first = customerFirstInput.getText();
		String last = customerLastInput.getText();
		String address = customerAddressInput.getText();
		String zipcode = customerZipInput.getText();
		String state = customerStateInput.getText();
		String user	= customerUserInput.getText();
		String pass = customerPassInput.getText();
		String question = customerQuestionInput.getText();
		String answer = customerAnswerInput.getText();
		String ssn = customerSsnInput.getText();
		
		if((id.length() == 0 || first.length() == 0 || last.length() ==0 || address.length() == 0 ||
				zipcode.length() ==0 || state.length() == 0 || user.length() == 0 ||
				pass.length() == 0 || ssn.length() == 0 || question.length() == 0 || answer.length() == 0)){
			Methods.popup("Error", "Textfield input is empty.");
		}
		else {
		table.getItems().add(Account);
		DatabaseMethods.makeCustomer(id, first, last, address, zipcode, state, user, pass, question, answer, ssn);
		DatabaseMethods.inputcustomerregister();
		customerIdInput.clear();
		customerFirstInput.clear();
		customerLastInput.clear();
		customerAddressInput.clear();
		customerZipInput.clear();
		customerStateInput.clear();
		customerUserInput.clear();
		customerPassInput.clear();
		customerQuestionInput.clear();
		customerAnswerInput.clear();
		customerSsnInput.clear();
		}
	}


//table1
public static ObservableList<Account> getCustomers() throws Exception {
	ObservableList<Account> account = FXCollections.observableArrayList();
	for(int i = 0; i < DatabaseMethods.getCustomerIdList().size(); i++) {
		account.add(new Account(DatabaseMethods.returnCustomerNameFormat(i), DatabaseMethods.returnCustomerLastNameFormat(i),
		DatabaseMethods.returnCustomerAddressFormat(i), DatabaseMethods.returnCustomerZipcodeFormat(i),
		DatabaseMethods.returnCustomerStateFormat(i), DatabaseMethods.returnCustomerUsernameFormat(i),
		DatabaseMethods.returnCustomerPasswordFormat(i), DatabaseMethods.returnCustomerQuestionFormat(i),
		DatabaseMethods.returnCustomerAnswerFormat(i), DatabaseMethods.returnCustomerSsnFormat(i)));
		account.get(i).setAccountId(Integer.parseInt(DatabaseMethods.returnAdminCustomerIdFormat(i)));
	}
	return account;	
}

public static void refreshCustomers() throws Exception {
manageCustomers();
}
public static void closeCustomerManager() {
	window.close();
}
}