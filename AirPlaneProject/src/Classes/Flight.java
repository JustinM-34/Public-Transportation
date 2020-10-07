package Classes;

import java.util.ArrayList;

public class Flight {
	private String flightId;
	private String dateCreated;
	private String cityName ;
	private String destinationCity;
	private String timeIn;
	private String timeOut;
	private static ArrayList<Flight> newflight;
	
	
	public Flight() {
		this.flightId = "";
		this.dateCreated =  "";
		this.cityName = "";
		this.destinationCity = "";
		this.timeIn ="";
		this.timeOut ="";
	}
	public Flight(String flightId ,String dateCreated, String cityName, String destinationCity,String timeIn, String timeOut) {
		this.flightId = flightId;
		this.dateCreated = dateCreated;
		this.cityName = cityName;
		this.destinationCity = destinationCity;
		this.timeIn = timeIn;
		this.timeOut = timeOut;

	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
}