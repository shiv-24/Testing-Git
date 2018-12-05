package domain;

import javafx.util.Pair;

/**
 * Interface for player strategy.
 * @author Yogesh
 *
 */
public interface IStrategy {

	public void reinforcement(Player player, Territory selectedTerritory, int numberOfArmies, PhaseViewModel phaseViewModel);
	public void fortify(Territory from, Territory to, int armiesToMove);
	public Pair<Boolean, Integer> attack();
	
}
