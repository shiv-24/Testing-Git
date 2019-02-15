package com.practice.javafx.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CloseProgramProperly extends Application {

	Stage window;
	Scene scene;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		window = arg0;
		window.setTitle("Close Program Properly");
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		Button button = new Button("Close This program");

		button.setOnAction(e -> closeProgram());
		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		scene = new Scene(layout, 500, 500);
		window.setScene(scene);
		window.show();
	}

	private void closeProgram() {
		boolean ifClosed = ConfirmBoxSimilarToAlertBox.display("Exit Window", "Sure You Want To Exit?");

		if (ifClosed) {
			window.close();
		}
	}

}
