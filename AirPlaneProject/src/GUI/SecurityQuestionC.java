package GUI;

import Classes.Account;
import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SecurityQuestionC {
static int customertest;
static Label question;
static TextField answer;
public static void securityPopup(){
	Stage window = new Stage();
	window.setTitle("Password Recovery");
	window.initModality(Modality.APPLICATION_MODAL);
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);
	
	try {
		question = new Label(DatabaseMethods.pullQuestion(PasswordRecoveryC.getlogin()));
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	GridPane.setConstraints(question, 0, 0);
	
	answer  = new TextField();
	answer.setPromptText("Security Answer");
	GridPane.setConstraints(answer, 0, 1);
	
	Button answerB = new Button("Enter");
	GridPane.setConstraints(answerB, 0, 2);
	
	answerB.setOnAction(e -> {
		try {
			customertest = DatabaseMethods.pullAnswer(PasswordRecoveryC.getlogin()).compareTo(answer.getText());
		} catch (Exception e1) {
			System.out.println("a");
			e1.printStackTrace();
		}
		if (customertest == 0)
			try {
				RecoverySuccessC.recoveryWindow();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		else
			Methods.popup("Incorrect", "Answer is incorrect.");
	});
	
	grid.getChildren().addAll(question, answerB, answer);
	Scene scene = new Scene(grid, 400, 120);
	window.setResizable(false);
	window.setScene(scene);
	window.show();
	
}
}