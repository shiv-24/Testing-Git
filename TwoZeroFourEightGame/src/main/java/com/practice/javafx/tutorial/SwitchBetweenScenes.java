package com.practice.javafx.tutorial;

import javafx.scene.*;

import java.util.Arrays;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

@SuppressWarnings("restriction")
public class SwitchBetweenScenes extends Application{

	Stage window;
	Scene scene1,scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		window	=	arg0;
		
		Label label	=	new Label("Welcome to scene 1");
		Button button1	=	new Button("Click to Go to Scene 2");
		button1.setOnAction(e->window.setScene(scene2));
		
		VBox	 layout1	=	new VBox(20);
		layout1.getChildren().addAll(label,button1);
		scene1	=	new Scene(layout1,300,300);
		
		Label label2	=	new Label("Welcome to Scene 2");
		Button button2	=	new Button("Click to Go to Scene 1");
		button2.setOnAction(e->window.setScene(scene1));
		
		StackPane	 layout	=	new StackPane();
		layout.getChildren().add(button2);
		scene2	=	new Scene(layout,600,300);
		
		window.setScene(scene1);
		window.setTitle("Where there is a will there is a way");
		window.show();
	}

	
}
