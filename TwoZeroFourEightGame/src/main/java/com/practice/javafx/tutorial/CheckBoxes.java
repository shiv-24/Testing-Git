package com.practice.javafx.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


@SuppressWarnings("restriction")
public class CheckBoxes extends Application{

	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		window	=	arg0;
		
		Button button	=	new Button("Click Me");
		
		StackPane layout	=	new StackPane();
		layout.getChildren().add(button);
		
		Scene scene	=	new Scene(layout,200,200);
		window.setScene(scene);
		window.show();
				
		
		
	}

}
