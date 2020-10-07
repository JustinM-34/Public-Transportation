package DataBase;
import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Classes.Account;
import Classes.Flight;
import GUI.AdminFlightEdit;
import GUI.AdminTickets;
import GUI.LoginC;
import GUI.PasswordRecoveryC;
import javafx.collections.ObservableList;

public class DatabaseMethods {
static Account account;
static Flight flight;
	public static void main(String[] args) throws Exception {
		String a = returnFlightFormat(1);
		System.out.println(a);
	}
	//Returns true if the user exists and false if the user does not exist
	public static boolean userExists(String user) throws Exception {
		boolean exists = false;
		ArrayList<String> userlist = getUserList();
		for(int i = 0; i < userlist.size(); i++) {
			if(userlist.get(i).compareTo(user) == 0)
			exists = true;
		}
		return exists;
	}
	// creates a table into the database. not used
	public static void createTable() throws Exception {
		try {
		Connection con = getConnection();
		PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
		create.executeUpdate();
		}
		catch(Exception e) {
		System.out.println(e);
		}
		finally{
		System.out.println("Function complete.");	
		};
	}
	//used to connect to the database
	public static Connection getConnection() throws Exception {
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return conn;
	} 
	catch(Exception e) {
	System.out.println(e);
	}
	return null;
	}
	// ??
	public static void post() throws Exception {
		final String var1 = "John";
		final String var2 = "Miller";
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO Account(first, last) VALUES ('"+var1+"', '"+var2+"')");
			posted.executeUpdate();
		}
		catch(Exception e) {
		System.out.println(e);
		}
		finally {
		System.out.println("Insert Completed.");
		}
	}
	// gets an ArrayList of usernames as a String value
	public static ArrayList<String> getUserList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT username, password FROM Customer");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("username"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// gets an ArrayList of passwords as a String value
	public static ArrayList<String> getPasswordList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT password FROM Customer");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("password"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	//Returns the Integer index of a specific username entered
	public static int findUserIndex(String username) throws Exception {
		ArrayList<String> userList = getUserList();
		int index = userList.indexOf(username);
		return index;
	}
	// returns the password of an index
	public static String getPassword(int index) throws Exception {
		ArrayList<String> passList = getPasswordList();
		return passList.get(index);	
	}
	public static ArrayList<String> getFlightNumber() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_flight FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("password"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// Used for the status connection displayed on the login screen
	public static String isConnected() throws Exception	{
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return "Connected";
	} 
	catch(Exception e) {
	System.out.println(e);
	}
	return "Not Connected";
	}
	//Same method as connection
	public static String getAccount() throws Exception	{
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return "Connected";
	} 
	catch(Exception e) {
	System.out.println(e);
	}
	return "Not Connected";
	}
	//returns an address as a String for a specific user
	public static String pullAddress(String user) throws Exception {
	String address;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT address FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("address"));
			}
			address = array.get(0);
			return address;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a zipcode as a String for a specific user
	public static String pullZipCode(String user) throws Exception {
		String zipcode;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT zip_code FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("zip_code"));
			}
			zipcode = array.get(0);
			return zipcode;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a first name as a String for a specific user
	public static String pullFirstName(String user) throws Exception {
		String firstname;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT first_name FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("first_name"));
			}
			firstname = array.get(0);
			return firstname;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	//returns a last name as a String for a specific user
	public static String pullLastName(String user) throws Exception {
		String lastname;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT last_name FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("last_name"));
			}
			lastname = array.get(0);
			return lastname;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a password as a String for a specific user
	public static String pullPassword(String user) throws Exception {
		String password;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT password FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("password"));
			}
			password = array.get(0);
			return password;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a state as a String for a specific user
	public static String pullState(String user) throws Exception {
		String state;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT state FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("state"));
			}
			state = array.get(0);
			return state;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullUser(String id) throws Exception {
		String user;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT username FROM Customer WHERE username = '" + id + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("state"));
			}
			user = array.get(0);
			return user;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a customer id as a String for a specific user
	public static int pullCustomerId(String user) throws Exception {
		int id;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_customer FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<Integer> array = new ArrayList<Integer>();
			while(result.next()) {
				array.add(result.getInt("ID_customer"));
			}
			id = array.get(0);
			return id;
		}
		catch(Exception e) {
			System.out.println(e);
			return (Integer) null;
		}
	}
	//returns a security question as a String for a specific user
	public static String pullQuestion(String user) throws Exception {
		String question;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT security_question FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("security_question"));
			}
			question = array.get(0);
			return question;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a security question answer as a String for a specific user
	public static String pullAnswer(String user) throws Exception {
		String answer;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT security_answer FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("security_answer"));
			}
			answer = array.get(0);
			return answer;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a social security number as a String for a specific user
	public static String pullSsn(String user) throws Exception {
		String ssn;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ssn FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("ssn"));
			}
			ssn = array.get(0);
			return ssn;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns a social security number as a String for a specific user
		public static String pullDate(String id) throws Exception {
			String date;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT date FROM Flight WHERE username = '" + id + "'");
				ResultSet result = statement.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				while(result.next()) {
					array.add(result.getString("date"));
				}
				date = array.get(0);
				return date;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
		public static String pullCity(String id) throws Exception {
			String city;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT city_name FROM Flight WHERE username = '" + id + "'");
				ResultSet result = statement.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				while(result.next()) {
					array.add(result.getString("city_name"));
				}
				city = array.get(0);
				return city;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
		public static String pullDestination(String id) throws Exception {
			String destination;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT destination_city FROM Flight WHERE username = '" + id + "'");
				ResultSet result = statement.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				while(result.next()) {
					array.add(result.getString("destination_city"));
				}
				destination = array.get(0);
				return destination;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
		public static String pullArrival(String id) throws Exception {
			String arrival;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT arrival_time FROM Flight WHERE username = '" + id + "'");
				ResultSet result = statement.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				while(result.next()) {
					array.add(result.getString("arrival_time"));
				}
				arrival = array.get(0);
				return arrival;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
		public static String pullDeparture(String id) throws Exception {
			String arrival;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT departure_time FROM Flight WHERE username = '" + id + "'");
				ResultSet result = statement.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				while(result.next()) {
					array.add(result.getString("departure_time"));
				}
				arrival = array.get(0);
				return arrival;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
	//returns a ArrayList containing Flight Id number as a string value
	public static ArrayList<String> getFlightIdList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_flight FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("ID_flight"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// Returns an ArrayList containing flight dates as a string value
	public static ArrayList<String> getFlightDateList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT date FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("date"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// returns an arraylist containing cities as a string value
	public static ArrayList<String> getFlightCityList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT city_name FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("city_name"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// returns an arraylist containing flight destinations as a string value
	public static ArrayList<String> getFlightDestinationList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT destination_city FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("destination_city"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// returns an arraylist containing flight arrival times as a string value
	public static ArrayList<String> getArrivalTimeList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT arrival_time FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("arrival_time"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// returns an arraylist of departure times as a string value
	public static ArrayList<String> getDepartureTimeList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT departure_time FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("departure_time"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static ArrayList<String> getTicketId() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_ticket FROM Ticket");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("ID_ticket"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static ArrayList<String> getCustomerTicketId() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT FK_customer FROM Ticket");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("FK_customer"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static ArrayList<String> getFlightTicketId() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT FK_flight FROM Ticket");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("FK_flight"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//returns an Integer for the number of flights existing inside the database
	public static int numberOfFlights() throws Exception {
		ArrayList<String> a = getFlightIdList();
		return a.size();
	}
	//returns the flight of a specific row index as a string 
	public static String returnFlightIdFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> id = getFlightIdList();
		String id1 = id.get(i);
		format = id1;
		return format;
	}
	//returns a flight of a specific row index as a string
	public static String returnFlightDateFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> date = getFlightDateList();
		String date1 = date.get(i);
		format = date1;
		return format;
	}
	//returns a departure city of a specific row index as a string
	public static String returnFlightCityFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> city = getFlightCityList();
		String city1 = city.get(i);
		format = city1;
		return format;
	}
	//returns a destination of a specific row index as a string
	public static String returnFlightDestinationFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> destination = getFlightDestinationList();		
		String destination1 = destination.get(i);
		format = destination1;
		return format;
	}
	public static String returnTicketIdFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> ticketid = getTicketId();		
		String ticket1 = ticketid.get(i);
		format = ticket1;
		return format;
	}
	public static String returnFlightIdFormat1(int i) throws Exception {
		String format = "";
		ArrayList<String> flightid = getFlightTicketId();		
		String flight1 = flightid.get(i);
		format = flight1;
		return format;
	}
	public static String returnCustomerIdFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> customerid = getFlightTicketId();		
		String customerid1 = customerid.get(i);
		format = customerid1;
		return format;
	}
	//returns a flight time of arrival a specific row index as a string
	public static String returnFlightTimeInFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> timein = getArrivalTimeList();
		String timein1 = timein.get(i);
		format = timein1;
		return format;
	}
	//returns a flight time of departure a specific row index as a string
	public static String returnFlightTimeOutFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> timeout = getDepartureTimeList();
		String timeout1 = timeout.get(i);
		format = timeout1;
		return format;
	}
	//returns the flight information as a single string value
	public static String returnFlightFormat(int i) throws Exception {
		String format = "";
		ArrayList<String> id = getFlightIdList();
		ArrayList<String> date = getFlightDateList();
		ArrayList<String> city = getFlightCityList();
		ArrayList<String> destination = getFlightDestinationList();
		ArrayList<String> timein = getArrivalTimeList();
		ArrayList<String> timeout = getDepartureTimeList();
		
		String id1 = id.get(i);
		String date1 = date.get(i);
		String city1 = city.get(i);
		String destination1 = destination.get(i);
		String timein1 = timein.get(i);
		String timeout1 = timeout.get(i);
		format = id1 + " " + date1 + " " + city1 + " " + destination1 + " " + timein1 + " " + timeout1;
		return format;
	}
	
	
	//extracts a specific username's data and returns it inside of a account object
	public static Account extractor(String user) throws Exception {
		Account account = new Account();	
		account.setName(pullFirstName(user), pullLastName(user));
		account.setAddress(pullAddress(user));
		account.setZipcode(pullZipCode(user));
		account.setState(pullState(user));
		account.setAccountId(pullCustomerId(user));
		account.setQuestion(pullQuestion(user));
		account.setAnswer(pullAnswer(user));
		account.setSsn(pullSsn(user));
		return account;
}
	//extracts a specific flight id's data and returns it inside of a flight object
	public static Flight flightextractor(String id) throws Exception {
		Flight flight = new Flight();	
		flight.setCityName(pullCity(id));
		flight.setDateCreated(pullDate(id));
		flight.setDestinationCity(pullDestination(id));
		flight.setTimeIn(pullArrival(id));
		flight.setTimeOut(pullDeparture(id));
		return flight;
}
	public static void flightextractorlocal(String id) throws Exception {	
		flight.setCityName(pullCity(id));
		flight.setDateCreated(pullDate(id));
		flight.setDestinationCity(pullDestination(id));
		flight.setTimeIn(pullArrival(id));
		flight.setTimeOut(pullDeparture(id));
}
	public static void extractorLocal(String user) throws Exception {	
		account.setName(pullFirstName(user), pullLastName(user));
		account.setAddress(pullAddress(user));
		account.setZipcode(pullZipCode(user));
		account.setState(pullState(user));
		account.setAccountId(pullCustomerId(user));
		account.setQuestion(pullQuestion(user));
		account.setAnswer(pullAnswer(user));
		account.setSsn(pullSsn(user));
}
	public static void flightextractorLocal(String id) throws Exception {	
		account.setName(pullFirstName(id), pullLastName(id));
		account.setAddress(pullAddress(id));
		account.setZipcode(pullZipCode(id));
		account.setState(pullState(id));
		account.setAccountId(pullCustomerId(id));
		account.setQuestion(pullQuestion(id));
		account.setAnswer(pullAnswer(id));
		account.setSsn(pullSsn(id));
}
	public static void setLocal() throws Exception {
		extractorLocal(PasswordRecoveryC.getlogin());
	}
	public static void addSelectedFlights(ObservableList<Flight> selectedFlight) throws Exception {
		String flightId = selectedFlight.get(0).getFlightId();
		int customerId = pullCustomerId(LoginC.getlogin());
		registerTicket(Integer.parseInt(flightId), customerId);
		
	}
	public static void registerTicket(int flightid, int customerid) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("INSERT INTO Ticket(ID_ticket, FK_flight, FK_customer) Values "
					+ "('" + idMaker() + "', '" + flightid + "', '" + customerid + "');");
			statement.executeUpdate();
		}
		catch(Exception e) {
			Methods.popup("Error", "Flight has been booked already");
			System.out.println(e);
		}
	}
	
	public static void register(int customerid, String firstname, String lastname, String address, int zipcode, String state, String username, String password, String security_question, String security_answer, String ssn) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("INSERT INTO Customer(ID_customer, first_name, last_name, address, zip_code, state, username, password, security_question, security_answer, ssn) Values "
					+ "('" + customerid + "', '" + firstname + "', '" + lastname + "', '" + address + "', '" + zipcode + "', '" + state + "', '" + username + "', '" + password + "', '" + security_question + "', '" + security_answer + "', '" + ssn + "');");
			statement.executeUpdate();
		}
		catch(Exception e) {
			Methods.popup("Error", "Database error encountered.\n"
					+ "Please try again.");
			System.out.println(e);
		}
	}
	public static void registerflight(int flightIdnput, String dateinput, String origincitynput, String destinationitynput, String timeininput, String timeiutinput  ) throws Exception {
		try {
	Connection con = DatabaseMethods.getConnection();

	PreparedStatement statement= con.prepareStatement("INSERT INTO Flight(ID_flight, date, city_name, destination_city, arrival_time,departure_time) Values "
		+ "('" + flightIdnput + "', '" + dateinput + "', '" + origincitynput + "', '" + destinationitynput + "', '" + timeininput + "', '" + timeiutinput + "');");
	statement.executeUpdate();
		}
		catch(Exception e) {
	System.out.println(e);
	}

	}
	public static void registercustomer(int customerid, String firstname, String lastname, String address, int zipcode, String state, String username, String password, String security_question, String security_answer, String ssn) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("INSERT INTO Customer(ID_customer, first_name, last_name, address, zip_code, state, username, password, security_question, security_answer, ssn) Values "
					+ "('" + customerid + "', '" + firstname + "', '" + lastname + "', '" + address + "', '" + zipcode + "', '" + state + "', '" + username + "', '" + password + "', '" + security_question + "', '" + security_answer + "', '" + ssn + "');");
			statement.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void makeFlight(String ID_flight, String date, String city_name, String destination_city, String arrival_time, String departure_time) {
		flight = new Flight(ID_flight, date, city_name, destination_city, arrival_time, departure_time); 
	}
	public static void makeaccount(String firstname, String lastname, String tempaddress, String tempzipcode, String tempstate, String tempusername, String temppassword, String tempquestion, String tempanswer, String ssn) {
	account = new Account(firstname, lastname, tempaddress, tempzipcode, tempstate, tempusername, temppassword,tempquestion, tempanswer, ssn); 
	}
	public static int idMaker() {
		int id = (int)(Math.random() * 899999) + 100000;
		return id;
	}
	public static int flightIdMaker() {
		int id = (int)(Math.random() * 899999) + 100000;
		return id;
	}
	public static void inputregister() throws NumberFormatException, Exception {
		register(idMaker(), account.getFirstName(), account.getLastName(), account.getAddress(), Integer.parseInt(account.getZipcode()), account.getState(), account.getUserName(), account.getPassword(), account.getQuestion(), account.getAnswer(), account.getSsn());
	}
	public static void inputflightregister() throws NumberFormatException, Exception {
		registerflight(flightIdMaker(), flight.getDateCreated(), flight.getCityName(), flight.getDestinationCity(), flight.getTimeIn() , flight.getTimeOut());
	}
	public static void inputcustomerregister() throws NumberFormatException, Exception {
		register(account.getAccountId(), account.getFirstName(), account.getLastName(), account.getAddress(), Integer.parseInt(account.getZipcode()), account.getState(), account.getUserName(), account.getPassword(), account.getQuestion(), account.getAnswer(), account.getSsn());
	}
	
public static ArrayList<String> getCustomerTicketList(String customerid) throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT ID_ticket FROM Ticket WHERE FK_customer = '" + DatabaseMethods.pullCustomerId(customerid) + "'");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("ID_ticket"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getTicketList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT ID_ticket FROM Ticket");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("ID_ticket"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerFlightList(String customerid) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT FK_flight FROM Ticket WHERE FK_customer = '" + DatabaseMethods.pullCustomerId(customerid) + "'");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("FK_flight"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
}
public static void deleteCustomerFlight(String ticketid) throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("DELETE FROM Ticket WHERE ID_ticket = '" + ticketid + "'");
		statement.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);		
	}
}
public static void deleteFlight(String flightid) throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("DELETE FROM Flight WHERE ID_flight = '" + flightid + "'");
		statement.executeUpdate();
	}
	catch(Exception e) {
		Methods.popup("Error", "This flight has been booked.\n Delete tickets to remove.");
		AdminTickets.manageTickets();
		System.out.println(e);		
	}
}
public static void deleteCustomer(String customerid) throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("DELETE FROM Customer WHERE ID_customer = '" + customerid + "'");
		statement.executeUpdate();
	}
	catch(Exception e) {
		Methods.popup("Error", "Customer has existing flights.\n"
				+ "Delete flights to remove customer");
		AdminTickets.manageTickets();
		System.out.println(e);		
	}
}
public static String returnCustomerFlightTicketFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> ticketid = getCustomerTicketList(LoginC.getlogin());		
	String ticketid1 = ticketid.get(i);
	format = ticketid1;
	return format;
}
public static String returnCustomerFlightIDFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> flightid = getCustomerFlightList(LoginC.getlogin());		
	String flightid1 = flightid.get(i);
	format = flightid1;
	return format;
}
public static ArrayList<String> pullMyFlightList(String id) throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT ID_flight FROM Flight,Customer WHERE ID_customer = '" + id + "'");
		ResultSet result = statement.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("date"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static int numberOfMyFlights() throws Exception {
	ArrayList<String> a = getCustomerFlightList(LoginC.getlogin());
	return a.size();
}
// Customer table
public static ArrayList<String> getCustomerIdList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT ID_customer FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("ID_Customer"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerNameList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT first_name FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("first_name"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerLastNameList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT last_name FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("last_name"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerAddressList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT address FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("address"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerZipcodeList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT zip_code FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("zip_code"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerStateList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT state FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("state"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerUsernameList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT username FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("username"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerPasswordList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT password FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("password"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerQuestionList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT security_question FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("security_question"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerAnswerList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT security_answer FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("security_answer"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static ArrayList<String> getCustomerSsnList() throws Exception {
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT ssn FROM Customer");
		ResultSet result = statement.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("ssn"));
		}
		return array;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
public static String returnAdminCustomerIdFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String id1 = Integer.toString(pullCustomerId(user.get(i)));
	format = id1;
	return format;
}
public static String returnCustomerNameFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String name1 = pullFirstName(user.get(i));
	format = name1;
	return format;
}
public static String returnCustomerLastNameFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String lastname1 = pullLastName(user.get(i));
	format = lastname1;
	return format;
}
public static String returnCustomerAddressFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String address1 = pullAddress(user.get(i));
	format = address1;
	return format;
}
public static String returnCustomerZipcodeFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String zipcode1 = pullZipCode(user.get(i));
	format = zipcode1;
	return format;
}
public static String returnCustomerStateFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String state1 = pullState(user.get(i));
	format = state1;
	return format;
}
public static String returnCustomerUsernameFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String username1 = user.get(i);
	format = username1;
	return format;
}
public static String returnCustomerPasswordFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String password1 = pullPassword(user.get(i));
	format = password1;
	return format;
}
public static String returnCustomerQuestionFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String question1 = pullQuestion(user.get(i));
	format = question1;
	return format;
}
public static String returnCustomerAnswerFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String answer1 = pullAnswer(user.get(i));
	format = answer1;
	return format;
}
public static String returnCustomerSsnFormat(int i) throws Exception {
	String format = "";
	ArrayList<String> user = getCustomerUsernameList();
	String ssn1 = pullSsn(user.get(i));
	format = ssn1;
	return format;
}
public static void makeCustomer(String id, String first, String last, String address,
	String zipcode, String state, String user, String pass, String question, String answer, String ssn ) {
	account = new Account(first, last, address, zipcode, state, user, pass, question, answer, ssn);
	account.setAccountId(Integer.parseInt(id));
}
}