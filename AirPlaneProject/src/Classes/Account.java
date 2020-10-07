package Classes;
import java.util.Date;	
import java.util.Random;
public class Account {
public int accountId; // 10-digit account number...... generated when creating an account
private String firstName = " N/a";
private String lastName = "N/a";
private String address = "N/a";
private String state = "N/a";
public String userName = "N/a";		// username made-up by user | Login info
private String password = "00000000"; //password initally 8 zeros  |  Login info
private String question = "N/a";
private String answer = "N/a";
private String zipcode = "000000";
private String ssn = "000-00-0000";
	
public Account(){
	
}
public Account(String firstname, String lastname, String address, String zipcode, String state, String username, String password, String security_question, String security_answer, String ssn) {
	this.firstName = firstname;
	this.lastName = lastname;
	this.address = address;
	this.zipcode = zipcode;
	this.state = state;
	this.userName = username;
	this.password = password;
	this.question = security_question;
	this.answer = security_answer;
	this.ssn = ssn;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public int getAccountId() {
	return accountId;
}
public String getFullName() {
	String fullName = (firstName + " " + lastName);
	return fullName;
}

public void setName(String fName, String lName) {
	this.firstName = fName;
	this.lastName  = lName;	
}
public String getAddress() {
	return address;
}
public void setAddress(String newAddress) {
	this.address = newAddress;
}
public String getUserName() {
	return userName;
}
public void setUserName(String newUserName) {
	this.userName = newUserName;
}

public String getPassword() {
	return password;
}
public void setPassword(String newPassword) {
	this.password = newPassword;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSsn() {
	return ssn;
}
public void setSsn(String ssn) {
	this.ssn = ssn;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}

}