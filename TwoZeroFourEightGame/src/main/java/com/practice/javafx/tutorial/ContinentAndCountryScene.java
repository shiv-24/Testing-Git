package com.practice.javafx.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContinentAndCountryScene {

	private static List<String> countries = new ArrayList<>();

	public static void display(String title, Integer numberOfCountries, Integer numberOfContinents) {

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);

		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20, 20, 20, 20));
		rootPane.setVgap(8);
		rootPane.setHgap(10);

		List<HBox> continentboxList = new ArrayList<>();
		List<TextField> contNameList = new ArrayList<>();
		List<TextField> controlValList = new ArrayList<>();
		List<TextField> countryNumberList = new ArrayList<>();
		List<TextField> countryNameList = new ArrayList<>();

		for (int i = 0; i < numberOfContinents; i++) {
			HBox pane = new HBox();
			Label label = new Label();
			label.setText("Continent" + (i + 1));
			label.setId("Continent" + i);
			pane.getChildren().add(label);
			rootPane.setConstraints(pane, i, 0);
			rootPane.getChildren().add(pane);
			continentboxList.add(pane);
		}

		Label continentName, controlValue, countryNumber, countryName;

		continentName = new Label("Name Of The Continent");
		controlValue = new Label("Control Value");
		countryNumber = new Label("Number Of Countries");
		countryName = new Label("Name Of the countries");

		GridPane.setConstraints(continentName, 0, 1);
		GridPane.setConstraints(controlValue, 1, 1);
		GridPane.setConstraints(countryNumber, 2, 1);
		GridPane.setConstraints(countryName, 3, 1);

		rootPane.getChildren().addAll(continentName, controlValue, countryNumber, countryName);
		int j = 2;
		for (int i = 0; i < numberOfContinents; i++) {
			TextField contName = new TextField();
			contName.setPromptText("Continent" + i);
			// Label label =(Label) continentboxList.get(i).lookup(".label");
			//// System.out.println(label.getId());
			// contName.setOnKeyReleased(e->{
			// label.setText(contName.getText());
			// });
			contNameList.add(contName);

			TextField controlVal = new TextField();
			controlVal.setPromptText("Enter Valid Integer");
			// controlVal.setOnKeyReleased(e->{
			// if(!controlVal.getText().matches("[1-9][0-9]*")) {
			// controlVal.setPromptText("Enter Valid Integer");
			// controlVal.setText("");
			// }
			// });
			controlValList.add(controlVal);

			TextField countryVal = new TextField();
			countryVal.setPromptText("Enter Valid Integer");
			countryNumberList.add(countryVal);

			TextField nameOfCountry = new TextField();
			nameOfCountry.setPromptText("Enter Comma Seperated Names");
			countryNameList.add(nameOfCountry);

			GridPane.setConstraints(contName, 0, j);
			GridPane.setConstraints(controlVal, 1, j);
			GridPane.setConstraints(countryVal, 2, j);
			GridPane.setConstraints(nameOfCountry, 3, j);
			j++;
			rootPane.getChildren().addAll(contName, controlVal, countryVal, nameOfCountry);

		}

		Button saveConfiguration = new Button("Save");
		Label resultLabel	=	new Label();
		resultLabel.setVisible(false);
		saveConfiguration.setOnAction(e -> {

			boolean isCorrect = validate(contNameList, controlValList, countryNumberList, countryNameList,
					continentboxList, numberOfCountries);
			if(isCorrect) {
				resultLabel.setVisible(true);
				resultLabel.setText("You May Proceed");
			}else {
				resultLabel.setVisible(true);
				resultLabel.setText("Something is Wrong");
			}
		});
		
		GridPane.setConstraints(resultLabel, 3, j);
		GridPane.setConstraints(saveConfiguration, 2, j);
		
		rootPane.getChildren().addAll(resultLabel,saveConfiguration);

		Scene scene = new Scene(rootPane, 500, 500);
		window.setScene(scene);
		window.show();

	}

	private static boolean validate(List<TextField> contNameList, List<TextField> controlValList,
			List<TextField> countryNumberList, List<TextField> countryNameList, List<HBox> continentboxList,
			Integer numberOfCountries) {

		boolean ifCorrect = false;
		for (int i = 0; i < contNameList.size(); i++) {
			Label label = (Label) continentboxList.get(i).lookup(".label");
			TextField tf = contNameList.get(i);
			label.setText(tf.getText());
		}

		for (int i = 0; i < controlValList.size(); i++) {
			TextField tf = contNameList.get(i);

			try {
				Integer val = Integer.parseInt(tf.getText());
				if (val > 0) {
					ifCorrect = true;
				} else {
					return ifCorrect;
				}
			} catch (NumberFormatException e) {
				ifCorrect = false;
			}
		}
		int sumOfCountryNumber = 0;
		for (int i = 0; i < countryNumberList.size(); i++) {
			TextField tf = countryNumberList.get(i);
			TextField countryNameString = countryNameList.get(i);
			String[] arr = countryNameString.getText().split(",");
			try {
				Integer val = Integer.parseInt(tf.getText());
				if (val > 0 && arr.length == val) {
					sumOfCountryNumber += val;
					countries.addAll(Arrays.asList(arr));
				} else {
					return ifCorrect;
				}
			} catch (NumberFormatException e) {
				ifCorrect = false;
			}
		}

		if (sumOfCountryNumber != numberOfCountries) {
			ifCorrect = false;
			return ifCorrect;
		}

		return ifCorrect;
	}
}
