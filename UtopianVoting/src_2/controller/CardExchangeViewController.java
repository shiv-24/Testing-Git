package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import domain.Card;
import domain.CardExchangeViewModel;
import domain.Player;
import domain.Territory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;


public class CardExchangeViewController implements Observer {

	/**
	 * Variable for reference for Label in CardExchange.fxml.
	 */
	@FXML
	private Label playerNameForCardExchange;

	/**
	 * Variable for reference for Label in CardExchange.fxml.
	 */
	@FXML
	private Label totalNumberOfCards;

	/**
	 * Variable for reference for Button in CardExchange.fxml.
	 */
	@FXML
	private Button handIn;

	/**
	 * Variable for reference for the BUtton in CardExchange.fxml
	 */
	@FXML
	private Button close;

	/**
	 * Variables for reference for GridPane in CardExchange.fxml.
	 */
	@FXML
	private GridPane exchangeViewPane;

	/**
	 * Variable for reference for ListView in CardExchange.fxml
	 */
	@FXML
	ListView<Card> selectedCardsList;

	/**
	 * Variable for reference for ListView in CardExchange.fxml
	 */
	@FXML
	ListView<Card> playerCardsList;

	/**
	 * Variable holds the value of current player.
	 */
	private Player currentPlayer;

	/**
	 * Variable holds the value of CardExchangeViewModel.
	 */
	private CardExchangeViewModel model;

	/**
	 * Variable is true in case the card exchanged by the player is of the territory
	 * owned by the player itself.
	 */
	Boolean ifPlayerHasCardTerritory = false;
	
	/**
	 * Variable refer to the territory owned by the player and if the player had the
	 * card of the same territory.
	 */
	Territory cardAndOwnedTerritory;

	/**
	 * This methods updated the ui when called by the Subject
	 */
	@Override
	public void update(Observable o, Object arg) {

		model = (CardExchangeViewModel) o;
		currentPlayer = model.getCurrentPlayer();
		List<Card> playerCards = new LinkedList<>(model.getCurrentPlayerCards(currentPlayer));
		int totalCards = playerCards.size();
		playerNameForCardExchange.setText(currentPlayer.getName());
		totalNumberOfCards.setText(String.valueOf(totalCards));
		playerCardsList.setItems(FXCollections.observableList(playerCards));
	}

	/**
	 * This method handle {@link CardExchangeViewController#handIn} button event. It
	 * exchanges the number of cards entered by player.
	 * 
	 * @param event:
	 *            ActionEvent instance which is generated by user.
	 */
	public void exchangeCards(ActionEvent event) {
		
		//Validate if exchange is possible or not. 
		if (validateIfExchangePossible()) {
			removeCardsFromPlayer();
			model.setTotalNumberOfExchanges(model.getTotalNumberOfExchanges() + 1);
			if (ifPlayerHasCardTerritory) {
				model.setPlayerArmyCount(currentPlayer, 2, cardAndOwnedTerritory);
			} else {
				model.setPlayerArmyCount(currentPlayer, 0, null);
			}
			String info = "Cards Exchanged";
			showInformation(info);
			selectedCardsList.setItems(FXCollections.observableList(new ArrayList<Card>()));
			//set the view again for the player who has exchange the card just now.
			model.setViewForCurrentPlayer(currentPlayer);
			model.setCardAndOwnedTerritory(cardAndOwnedTerritory);

		} else {
			String error = "Card Cannot be Exchanged";
			showError(error);
		}

	}

	/**
	 * This method closes the card exchange view.
	 * 
	 * @param event:
	 *            ActionEvent instance which is generated by user.
	 */
	public void closeCardExchangeView(ActionEvent event) {
		Node source = (Node) event.getSource();
		Window stage = source.getScene().getWindow();
		//hide the stage where card exchange view is presented. 
		stage.hide();
	}

	/**
	 * This method adds the selected card to the list of cards.
	 * 
	 * @param event:
	 *            ActionEvent instance which is generated by user.
	 */
	public void addSelectedCard(ActionEvent event) {
		Card selectedCard = playerCardsList.getSelectionModel().getSelectedItem();
		// Base case.
		if (selectedCard == null) {
			showError("Please select Card To Add");
			return;
		}
		List<Card> tempList = selectedCardsList.getItems();
		tempList.add(selectedCard);
		selectedCardsList.setItems(FXCollections.observableList(tempList));
		playerCardsList.getItems().remove(selectedCard);
		playerCardsList.setItems(FXCollections.observableList(playerCardsList.getItems()));
	}

	/**
	 * This method removes the selected card from the list of cards.
	 * 
	 * @param event:
	 *            ActionEvent instance which is generated by user.
	 */
	public void removeSelectedCard(ActionEvent event) {
		Card selectedCard = selectedCardsList.getSelectionModel().getSelectedItem();
		// Base case
		if (selectedCard == null) {
			showError("Please select Card To Remove");
			return;
		}
		List<Card> tempList = playerCardsList.getItems();
		tempList.add(selectedCard);
		playerCardsList.setItems(FXCollections.observableList(tempList));
		selectedCardsList.getItems().remove(selectedCard);
		selectedCardsList.setItems(FXCollections.observableList(selectedCardsList.getItems()));
	}

	/**
	 * This method removes the card exchanged by the player and add the removed
	 * cards to the initial deck of cards
	 */
	private void removeCardsFromPlayer() {

		Queue<Card> removedCards = new LinkedList<>();
		Iterator<Card> ite = model.getCurrentPlayerCards(currentPlayer).iterator();
		List<Card> inputCard = selectedCardsList.getItems();
		// Iterate over the cards that player is having
		while (ite.hasNext()) {
			Card playerCard = ite.next();
			if (inputCard.contains(playerCard)) {
				ite.remove();
				removedCards.add(playerCard);
				if (currentPlayer.getTerritories().contains(playerCard.getCardTerritory())) {
					ifPlayerHasCardTerritory = true;
					cardAndOwnedTerritory = playerCard.getCardTerritory();
				}
			}
		}
		//add the exchanged cards to the initial deck of cards again. 
		model.getAllCards().addAll(removedCards);

	}

	/**
	 * This method checks if the user can exchange the cards or not.
	 * 
	 * @return : true if the user can exchange else returns false.
	 */
	private boolean validateIfExchangePossible() {
		if (selectedCardsList.getItems().size() != 3) {
			return false;
		}
		int cardType1 = 0;
		int cardType2 = 0;
		int cardType3 = 0;
		// gets the cards from the list of the cards and increment the count when a card
		// of specific type is encountered.
		for (int i = 0; i < selectedCardsList.getItems().size(); i++) {
			Card card = selectedCardsList.getItems().get(i);
			if (card.getCardType().equalsIgnoreCase(CardExchangeViewModel.INFANTRY_ARMY)) {
				cardType1++;
			} else if (card.getCardType().equalsIgnoreCase(CardExchangeViewModel.CAVALRY_ARMY)) {
				cardType2++;
			} else {
				cardType3++;
			}
		}

		if (cardType1 == 1 && cardType2 == 1 && cardType3 == 1) {
			return true;
		} else if (cardType1 == 3 || cardType2 == 3 || cardType3 == 3) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This method is used to show am alert to user informing about various
	 * validation errors.
	 * 
	 * @param error:
	 *            Error to show to user.
	 */
	private void showError(String error) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(error);
		alert.showAndWait();
	}

	/**
	 * This method is used to show information to user about various events.
	 * 
	 * @param state:
	 *            state to show to user.
	 */
	private void showInformation(String state) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Information");
		alert.setHeaderText(null);
		alert.setContentText(state);
		alert.showAndWait();
	}

}