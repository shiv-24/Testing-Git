package com.practice.javafx.tutorial;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.*;

@SuppressWarnings("restriction")
public class AlertBox extends Application{

	Stage window;
	Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
	
		window = arg0;
		window.setTitle("Alert Boxes, i.e New Window Pop Up");
		Label label	=	new Label();
		Button button	=	new Button("Click Me");
		button.setOnAction(e->AlertBoxHelper.display("Hello There", "Ho ho ho"));
//		button.setOnAction(e->{
//			
////			boolean answer	=	ConfirmBoxSimilarToAlertBox.display("Window's Title", "Will You Fuck me??");
//			if(answer) 
//			label.setText("She Said Yes!!");
//			else
//			label.setText("She Said No!!");
//		});
		
//		StackPane layout	=	new StackPane();
		Pane newPane	=	new Pane();
		
		VBox layout	=	new VBox(20);
		layout.getChildren().addAll(label,button);
		layout.setAlignment(Pos.CENTER);
//		layout.setLayoutX(100);
//		layout.setLayoutY(100);
//		VBox layout1	=	new VBox(20);
//		layout1.getChildren().addAll(label,button);
////		layout1.setAlignment(Pos.CENTER);
//		layout.setLayoutX(500);
//		layout.setLayoutY(500);
	
		Circle c	=	new Circle();
//		c.setF
		newPane.getChildren().addAll(layout);
		scene	=	new Scene(newPane,300,300);
		window.setScene(scene);
		window.show();
	}

}
