package com.practice.javafx.tutorial;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.ddogleg.struct.FastQueue;

import boofcv.alg.filter.binary.GThresholdImageOps;
import boofcv.alg.filter.binary.ThresholdImageOps;
import boofcv.alg.shapes.ellipse.BinaryEllipseDetector;
import boofcv.factory.shape.FactoryShapeDetector;
import boofcv.gui.ListDisplayPanel;
import boofcv.gui.feature.VisualizeShapes;
import boofcv.gui.image.ShowImages;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {

//	@FXML
//	private Button OneFileButton;
//
//	@FXML
//	private Button MultipleFileButton;
//
//	@FXML
//	private ImageView imageViewForBMP;
//
//	public void button1Action(ActionEvent event) {
//
//		FileChooser fc = new FileChooser();
//		// fc.setSelectedExtensionFilter();
//		fc.setTitle("Open Resource File");
//		fc.getExtensionFilters().addAll(
//				// new ExtensionFilter("Text Files", "*.txt"),
//				// new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif","*.bmp")
//				new ExtensionFilter("Image Files", "*.bmp")
//		// new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//		// new ExtensionFilter("All Files", "*.*")
//		);
//		File selectedFiles = fc.showOpenDialog(null);
//		try {
//			Image image = new Image(selectedFiles.toURI().toString());	
//			BufferedImage imageForBoofCV	=	ImageIO.read(selectedFiles);
//			
//			
//
//			if (selectedFiles != null) {
////				imageViewForBMP.setImage(image);
//				ellipseDetection(imageForBoofCV,imageViewForBMP,selectedFiles.getName());
//			} else {
//				System.out.println("File is not valid");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// selectedFiles.
//
//	}
//
//	public void ellipseDetection(BufferedImage image,ImageView imageViewForBMP,String fileName) {
//
//		BinaryEllipseDetector<GrayU8> detector = FactoryShapeDetector.ellipse(null, GrayU8.class);
//		ListDisplayPanel panel = new ListDisplayPanel();
//		
//		GrayU8 input	=	ConvertBufferedImage.convertFromSingle(image, null, GrayU8.class);
//		GrayU8 binary 	=	new GrayU8(input.width, input.height);
//		
//		int threshold = (int)GThresholdImageOps.computeOtsu(input, 0, 255);
//		ThresholdImageOps.threshold(input, binary, threshold, true);
//		
//		detector.process(input, binary);
//		
//		FastQueue<BinaryEllipseDetector.EllipseInfo> found = detector.getFound();
//		Graphics2D g2 = image.createGraphics();
//		g2.setStroke(new BasicStroke(3));
//		g2.setColor(Color.RED);
//		for (int i = 0; i < found.size; i++) {
//			VisualizeShapes.drawEllipse(found.get(i).ellipse, g2);
//		}
//		
//		panel.addImage(image,new File(fileName).getName());
//		
//		ShowImages.showWindow(panel,"Detected Ellipses",true);
//		 
//		Image imageForImageView = SwingFXUtils.toFXImage(image, null);
//		
//		imageViewForBMP.setImage(imageForImageView);
//	}
	

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
	
	@FXML
	private AnchorPane paneToAddTextField;
	
	
	public void actionOnProceed(ActionEvent event) {
		
		boolean isCorrect	=	ifValidNumbers(countriesNo.getText(), continentsNo.getText());
		
		if(!isCorrect) {
			paneToAddTextField.getChildren().add(new TextField("Not Valid"));
			return;
		}
		
		ifValid.setVisible(false);
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
			else if(countryNumber>42)
			{	
			isCorrect	=	false;
			ifValid.setVisible(true);
			ifValid.setText("Number Of Countries Cannot Exceed by 42");
			}else {
			isCorrect	=	false;	
			ifValid.setVisible(true);
			ifValid.setText("Number Of Continents Cannot Exceed by 8");
			}
		}catch(NumberFormatException e) {
			ifValid.setVisible(true);
			ifValid.setText("Enter Correct Values");
		}
		
		return isCorrect;
	}

}
