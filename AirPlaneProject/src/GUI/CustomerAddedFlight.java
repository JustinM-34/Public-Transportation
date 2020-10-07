
package GUI;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Classes.Flight;
import Classes.Ticket;
import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class CustomerAddedFlight {
	static Stage window = new Stage();
	static Scene scene1,scene2;
	static TableView<Ticket> table;

	

	public static void customerTickets() throws Exception {
	window.setTitle("My Tickets");
	
	 ////Creating table
	//flight Id column
	TableColumn< Ticket, Integer> ticketId = new TableColumn<>("Ticket Id");
	ticketId.setMinWidth(200);
	ticketId.setCellValueFactory(new PropertyValueFactory<>("idTicket"));
	
	
	////Date column
	TableColumn< Ticket,Integer> flightId = new TableColumn<>("Flight Id");
	flightId.setMinWidth(200);
	flightId.setCellValueFactory(new PropertyValueFactory<>("idFlight"));
	

	
	//origin city column
	TableColumn< Ticket, Integer> customerId = new TableColumn<>("Customer Id ");
	customerId.setMinWidth(200);
	customerId.setCellValueFactory(new PropertyValueFactory<>("idCustomer"));
	
	

	
   //delete Button
	Button deleteButton= new Button("Delete");
	deleteButton.setOnAction(e ->{
		try {
			DatabaseMethods.deleteCustomerFlight(Integer.toString(table.getSelectionModel().getSelectedItem().getIdTicket()));
			refreshFlights();
			deleteClicked();
		} catch (NullPointerException e2) {
			Methods.popup("Error", "Textfield input is invalid");
		} catch (Exception e2) {
			Methods.popup("Error", "No Field Selected");
			e2.printStackTrace();
		}
	});	
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(deleteButton);
	
	//table 1
	table = new TableView<>();
	table.setItems(getTicket());
	table.getColumns().addAll(ticketId,flightId);
	

	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
			
	scene1 = new Scene(layout, 400, 300);
	window.setResizable(false);
	window.setScene(scene1);
	window.show();
}
private static void deleteClicked() throws Exception {
	ObservableList<Ticket> flightSelected, allflight;
	allflight = table.getItems();
	flightSelected = table.getSelectionModel().getSelectedItems();
	flightSelected.forEach(allflight::remove);
}

//table1
public static ObservableList<Ticket> getTicket() throws Exception{
	ObservableList<Ticket> ticket = FXCollections.observableArrayList();
	for(int i = 0; i < DatabaseMethods.numberOfMyFlights(); i++) {
		ticket.add(new Ticket(Integer.parseInt(DatabaseMethods.returnCustomerFlightTicketFormat(i)),
				Integer.parseInt(DatabaseMethods.returnCustomerFlightIDFormat(i)),
			DatabaseMethods.pullCustomerId(LoginC.getlogin())));
	}
	return ticket;
}
public static void refreshFlights() throws Exception {
customerTickets();
}
public static void closeCustomerFlights(){
	window.close();
}
}