package main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Intro.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
			/*
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent ke)
			    {
			        if (ke.getCode().equals(KeyCode.ENTER))
			        {
			        	System.out.println("hello1");
			        	try {
			    			Parent root = FXMLLoader.load(getClass().getResource("/view/MainGui.fxml"));
			    			Scene scene = new Scene(root);
			    			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
			    			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			    				@Override
			    				public void handle(KeyEvent ke)
			    			    {
			    			        if (ke.getCode().equals(KeyCode.ENTER))
			    			        {
			    			        	System.out.println("hello2");
			    			        }
			    			    }
			    			});
			    		} catch(Exception e) {
			    			e.printStackTrace();
			    		}
			        }
			    }
			});
			*/
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
