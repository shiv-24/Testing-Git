package com.practice.javafx.tutorial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ListViewController {

	@FXML
	private Button proceed;
	
	@FXML
	private Label numberOfContinents;
	
	@FXML
	private Label numberOfCountries;
	
	@FXML
	private Label ifValid;
	
	@FXML
	private TextField countriesNo;
	
	@FXML
	private TextField continentsNo;
	
	public void actionOnProceed(ActionEvent event) {
		
		boolean isCorrect	=	ifValidNumbers(countriesNo.getText(), continentsNo.getText());
		
		if(!isCorrect) {
			return;
		}
		
		Integer countryNumber		=	Integer.parseInt(countriesNo.getText());
		Integer continentNumber		=	Integer.parseInt(continentsNo.getText());	
		ContinentAndCountryScene.display("Continent And Countries Mapping Screen", countryNumber , continentNumber);
		
	}
	
	public boolean ifValidNumbers(String countriesNumber, String continentsNumber) {
		
		boolean isCorrect	=	false;
		
		try {
			Integer countryNumber		=	Integer.parseInt(countriesNumber);
			Integer continentNumber		=	Integer.parseInt(continentsNumber);
			if(countryNumber<=42 && continentNumber<=8) 
			isCorrect	=	true;
			else
			isCorrect	=	false;	
		}catch(NumberFormatException e) {
			
			ifValid.setText("Enter Correct Values");
		}
		
		return isCorrect;
	}
}

