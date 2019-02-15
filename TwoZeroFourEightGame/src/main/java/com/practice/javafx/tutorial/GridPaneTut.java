package com.practice.javafx.tutorial;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("restriction")
public class GridPaneTut extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		window = arg0;
		window.setTitle("GridPane Tut");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		// Name Label
		Label nameLabel = new Label("UserName:");
		GridPane.setConstraints(nameLabel, 0, 0);

		// Text Input
		TextField nameField = new TextField();
		nameField.setPromptText("username");
		GridPane.setConstraints(nameField, 1, 0);

		// Name Label
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);

		// Text Input
		TextField passField = new TextField();
		passField.setPromptText("password");
		GridPane.setConstraints(passField, 1, 1);

		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 1, 2);
		loginButton.setOnAction(e -> validatePassword(passField, passField.getText()));
		grid.getChildren().addAll(nameLabel, nameField, passLabel, passField, loginButton);
		Scene scene = new Scene(grid, 300, 200);
		window.setScene(scene);
		window.show();

	}

	private boolean validatePassword(TextField input, String message) {

		try {
			String patternString = "/[A-Za-z0-9_@]*/";
			Pattern pattern	=	Pattern.compile(patternString);
			Matcher matcher	=	pattern.matcher(message);
			if (matcher.matches() && message.length() <= 10) {
				System.out.println("Password is correct");
				return true;
			} else if (message.length() > 10) {
				throw new Exception("Password Length Cannot be greater than 10");
			} else {
				throw new Exception("Password Does Not Contain valid characters");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			input.applyCss();
			return false;
		}

	}

}
