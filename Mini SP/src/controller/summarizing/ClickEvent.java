package controller.summarizing;

import javafx.scene.control.CheckBox;

public class ClickEvent {
	
	private CbCollapse source;
	private CheckBox checkBoxSource;
	
	public ClickEvent(CbCollapse source) {
		this.source = source;
	}
	
	public CbCollapse getSource() {
		return source;
	}
	
	public CheckBox getCheckBoxSource() {
		return checkBoxSource;
	}
}
