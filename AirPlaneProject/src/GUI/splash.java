package GUI;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class splash {
static StackPane sd = new StackPane();
static Stage window = new Stage();
public static void splash() {
    window.setTitle("Splash");
	sd = new StackPane();
    Scene scene = new Scene(sd, 500,500);
    scene.getStylesheets().add("splash.css");
	window.setScene(scene);
	scene.setFill(Color.TRANSPARENT);
	window.initStyle(StageStyle.TRANSPARENT);
	window.show();
	PauseTransition delay = new PauseTransition(Duration.seconds(5));
	delay.setOnFinished( event -> window.close() );
	delay.play();

}
}
