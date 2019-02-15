package com.practice.javafx.tutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class EmbededLayouts extends Application{

	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
	
		window	=	arg0;
		
		window.setTitle("Embeded Layouts");
		ListView<String> list	=	new ListView<String>();
		HBox layoutH	=	new  HBox();
		Button buttonA	=	new Button("File");
		
		//TODO Complete the action on this button click
		
		buttonA.setOnAction(e->{
			
			ObservableList<String> items =FXCollections.observableArrayList (
				    "Single", "Double", "Suite", "Family App");
			list.setItems(items);
			VBox layoutVertical	=	new VBox();
			layoutVertical.getChildren().add(list);
			Scene scene1	=	new Scene(layoutVertical,200,300);
			window.setScene(scene1);
		});
		Button buttonB	=	new Button("Edit");
		Button buttonC	=	new Button("Source");
		layoutH.getChildren().addAll(buttonA,buttonB,buttonC);
		
		VBox layoutV	=	new  VBox();
		Button buttonD	=	new Button("New");
		Button buttonE	=	new Button("Options");
		Button buttonF	=	new Button("Git");
		layoutV.getChildren().addAll(buttonD,buttonE,buttonF);
		
		BorderPane borderPane	=	new BorderPane();
		borderPane.setTop(layoutH);
		borderPane.setLeft(layoutV);
		
		Scene scene	=	new Scene(borderPane,500,500);
		window.setScene(scene);
		window.show();
		
		
	}

}
