package Classes;

import java.util.ArrayList;

import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.scene.control.TextField;

public class Ticket {
	private int idTicket;
	private int idFlight;
	private int idCustomer;
	public static void main(String[] args) throws Exception {
	}
	public Ticket() {
		this.idTicket = 0;
		this.idFlight = 0;
		this.idCustomer = 0;
	}
	public Ticket(int idTicket, int idFlight, int idCustomer) {
		this.idTicket = idTicket;
		this.idFlight = idFlight;
		this.idCustomer = idCustomer;
	}
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public int getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	

}