package com.practice.javafx.tutorial;

import javafx.scene.*;

import java.util.Arrays;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;

@SuppressWarnings("restriction")
public class TestClass extends Application{

	Button button,button2;
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		arg0.setTitle("Testing Window");

//		button = new Button();
//		button.setText("Click Me");
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(Act6ionEvent event) {
//				System.out.println("Anonymous Class Implementation");
//				
//			}
//		});
//		
//		button2	=	new Button();
//		button2.setText("Click Me Second");
//		button2.setOnAction(e->{ 
//			System.out.println("Lamda Works???");
//			System.out.println("Yeah It Does!!!");
//			});
//
//		StackPane layout = new StackPane();
//		layout.getChildren().addAll(Arrays.asList(button2));
		
		Parent root	=	FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
//		root.getChildrenUnmodifiable().add(new TextField("Dynamic Adding"));
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}

//	public void handle(ActionEvent arg0) {
//		if(arg0.getSource()==button) {
//			
//			System.out.println("C");
//		}else if(arg0.getSource()==button2) {
//			
//			System.out.println("E");
//		}
//		
//	}

}
