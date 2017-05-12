package main;
	
import com.google.common.eventbus.EventBus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			EventBus eventBus = new EventBus();
			MainFields2.setEventBus(eventBus);
			Parent root = FXMLLoader.load(getClass().getResource("/view/Intro.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
			primaryStage.setTitle("Gamma Basic Statistics Calculator");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
