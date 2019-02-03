package com.practice.javafx.tutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Modality;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class AlertBoxHelper extends Application {

	public static void display(String title, String message) {

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMaxWidth(500);

		Circle circle = createCircle(); // This function is to form a circle.
		Text text = new Text("42");
		Text text1 = new Text("36");
		text.setBoundsType(TextBoundsType.VISUAL);
		text1.setBoundsType(TextBoundsType.VISUAL);
		GridPane box = new GridPane();
		// box.setConstraints(text, 2, 0); commented this out to check if it was not
		// causing problem but still didn't work
		// box.setConstraints(text1, 2, 1);
		// box.setAlignment(Pos.CENTER); Even used this to center the gridPane didn't
		// work either.
		StackPane stack = new StackPane();
		box.getChildren().addAll(text, text1);
		stack.getChildren().addAll(box, circle);

		Scene scene = new Scene(stack);
		window.setScene(scene);
		window.showAndWait();
	}

	

	@Override
	public void start(Stage arg0) throws Exception {
		
//		window.initModality(Modality.APPLICATION_MODAL);
		arg0.setTitle("Text Boxes In circle");
		arg0.setMaxWidth(500);

		Circle circle = createCircle(); // This function is to form a circle.
		Text text = new Text("42");
		Text text1 = new Text("36");
		text.setBoundsType(TextBoundsType.VISUAL);
		text1.setBoundsType(TextBoundsType.VISUAL);
		GridPane box = new GridPane();
		// box.setConstraints(text, 2, 0); commented this out to check if it was not
		// causing problem but still didn't work
		// box.setConstraints(text1, 2, 1);
		// box.setAlignment(Pos.CENTER); Even used this to center the gridPane didn't
		// work either.
		StackPane stack = new StackPane();
		box.getChildren().addAll(text, text1);
		stack.getChildren().addAll(box, circle);

		Scene scene = new Scene(stack);
		arg0.setScene(scene);
		arg0.show();

		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private static Circle createCircle() {
		final Circle circle = new Circle(100);
		circle.setStroke(Color.FORESTGREEN);
		circle.setStrokeWidth(10);
		circle.setStrokeType(StrokeType.INSIDE);
		circle.setFill(Color.AZURE);
		return circle;
	}
	// Label label = new Label();
	// label.setText(message);
	//
	// Button button = new Button();
	// button.setText("Close this window");
	// button.setOnAction(e -> window.close());
	//
	// VBox layout = new VBox(30);
	// layout.getChildren().addAll(label, button);
	// layout.setAlignment(Pos.CENTER);

}
