package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class IntroController implements Initializable {
	@FXML
	private TextArea txtA;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtA.appendText("Description:\n Gamma Basic Statistics Calculator is a simple program \n which is a compilation of "
				+ "different statistical methods like different sampling methods, \n ways to summarize and present data, and descriptive statistics." + "\n\n\n\n\n");
		txtA.appendText("Developers:\n Gamaliel E. Petralba & Jerome Enrico M. Requioma");
		
	}
	
	@FXML
	public void handle(KeyEvent ke)
    {
        if (ke.getCode().equals(KeyCode.ENTER))
        {
        	System.out.println("hello");
        }
    }
}
