package GUI;

import java.awt.Color;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class preloading extends Application{
	static StackPane sd = new StackPane();
	static Stage window = new Stage();

    public JFrame getInitWindow() {

        JFrame loadingFrame = new JFrame();

        URL url = this.getClass().getResource("viper.css");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        
        window.setTitle("Splash");
    	sd = new StackPane();
        Scene scene = new Scene(sd, 500,500);
        scene.getStylesheets().add("splash.css");
    	window.setScene(scene);
    	window.initStyle(StageStyle.TRANSPARENT);
    	window.show();

        loadingFrame.setIconImage(new ImageIcon(getClass().getResource("viper.css").getPath()).getImage());
        loadingFrame.setUndecorated(true);
        loadingFrame.setBackground(new Color(0f, 0f, 0f, 0f));

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        loadingFrame.setLocation((int) ((screenBounds.getWidth() - 600) / 2), (int) ((screenBounds.getHeight() - 0) / 2));

        loadingFrame.getContentPane().add(label);
        loadingFrame.pack();
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setVisible(true);

        return loadingFrame;
    }

	@Override
	public void start(Stage arg0) throws Exception {
		getInitWindow();		
	}

}