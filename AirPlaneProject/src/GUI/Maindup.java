package GUI;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import DataBase.Methods;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class Maindup extends Application {
	static Stage window;
	public static void main(String[] args) throws Exception {
		launch(args);
		
	}
	
	@Override
	public void start(Stage window) throws Exception {
		splash.splash();
		PauseTransition delay = new PauseTransition(Duration.seconds(5));
		delay.setOnFinished( event ->{
			try {
				Methods.startApp(LoginC.loginScreen());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		delay.play();
	}
	public static void restart() throws Exception {
		Methods.startApp(LoginC.loginScreen());
	}
}