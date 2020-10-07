package GUI;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

import Classes.Flight;
import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class CustomerBookAFlight{
	static Stage window = new Stage();
	static Scene scene1,scene2;
	static TableView<Flight> table;

	public static void bookflight() {
	window.setTitle("Book a flight");
	
	 ////Creating table
	//flight Id column
	TableColumn<Flight, String> flightIdColumn = new TableColumn<>("Flight Id");
	flightIdColumn.setMinWidth(200);
	flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightId")); 
	
	
	////Date column
	TableColumn< Flight, String> dateColumn = new TableColumn<>("Date");
	dateColumn.setMinWidth(200);
	dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
	

	
	//origin city column
	TableColumn< Flight, String> originCityColumn = new TableColumn<>("Departure City");
	originCityColumn.setMinWidth(200);
	originCityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
	
	
	//Destinantion city column
	TableColumn< Flight, String> destinationCityColumn = new TableColumn<>("Destination City");
	destinationCityColumn.setMinWidth(200);
	destinationCityColumn.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
	
    //limit column
	TableColumn<Flight, String> timeInColumn = new TableColumn<>("Arrival Time");
	timeInColumn.setMinWidth(150);
	timeInColumn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
	
	//paasenger column
	TableColumn<Flight, String> timeOutColumn = new TableColumn<>("Departure Time");
	timeOutColumn.setMinWidth(150);
	timeOutColumn.setCellValueFactory(new PropertyValueFactory<>("timeOut"));

	
   //add Button
	Button addButton= new Button("Add");
	addButton.setOnAction(e -> {
	ObservableList<Flight> flightSelected, allFlights;
	allFlights = table.getItems();
	flightSelected = table.getSelectionModel().getSelectedItems();		
	try {
		DatabaseMethods.addSelectedFlights(flightSelected);
	} catch (Exception e1) {
		Methods.popup("Error", "No Field Selected");
		e1.printStackTrace();
	}
	});
	
	//Check your flight
	Button checkButton = new Button("Check Your Flight");
	checkButton.setOnAction(e ->{
		try {
			CustomerAddedFlight.customerTickets();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	//Main menu button
	Button mainmenu = new Button("MainMenu");
	mainmenu.setOnAction(e ->{
		try {
			CustomerAddedFlight.closeCustomerFlights();
			MainMenuC.menuScreen();
			window.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	window.setOnCloseRequest(e -> {
		try {
			CustomerAddedFlight.closeCustomerFlights();
			MainMenuC.menuScreen();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	});
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(addButton , checkButton,mainmenu );
	
	//table 1
	//table 1
	table = new TableView<>();
	try {
		table.setItems(getFlight());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	table.getColumns().addAll(flightIdColumn,dateColumn, originCityColumn, destinationCityColumn,timeInColumn, timeOutColumn);
	

	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
	
	scene1 = new Scene(layout);
	window.setResizable(false);
	window.setScene(scene1);
	window.show();
}
	


//table1
public static ObservableList<Flight> getFlight() throws Exception{
	ObservableList<Flight> flight = FXCollections.observableArrayList();
	for(int i = 0; i < DatabaseMethods.numberOfFlights(); i++) {
		flight.add(new Flight(DatabaseMethods.returnFlightIdFormat(i), DatabaseMethods.returnFlightDateFormat(i), DatabaseMethods.returnFlightCityFormat(i),
				DatabaseMethods.returnFlightDestinationFormat(i), DatabaseMethods.returnFlightTimeInFormat(i), DatabaseMethods.returnFlightTimeOutFormat(i)));
	}

	return flight;
}

}