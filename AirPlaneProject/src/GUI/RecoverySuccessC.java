package GUI;

import DataBase.DatabaseMethods;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RecoverySuccessC {

public static void recoveryWindow() throws Exception {
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	StackPane layout = new StackPane();
	Label label = new Label("Your password is " + DatabaseMethods.pullPassword(PasswordRecoveryC.getlogin()));
	
	layout.getChildren().add(label);
	Scene scene = new Scene(layout, 350, 90);
	window.setScene(scene);
	window.setResizable(false);
	window.showAndWait();
}
}