package domain;

import javafx.util.Pair;

/**
 * Strategy for human player.
 * @author Yogesh
 *
 */
public class HumanStrategy implements IStrategy {

	@Override
	public void reinforcement(Player player,Territory selectedTerritory, int numberOfArmies, PhaseViewModel phaseViewModel) {
		selectedTerritory.setArmyCount(selectedTerritory.getArmyCount() + numberOfArmies);
		player.setArmyCount(player.getArmyCount() - numberOfArmies);
		phaseViewModel.setPhaseInfo(String.valueOf(numberOfArmies) + " armies moved to " + selectedTerritory.getName());
	}

	@Override
	public void fortify(Territory from, Territory to, int armiesToMove) {
		from.setArmyCount(from.getArmyCount() - armiesToMove);
		to.setArmyCount(to.getArmyCount() + armiesToMove);

	}

	@Override
	public Pair<Boolean, Integer> attack() {
		// TODO Auto-generated method stub
		return null;
	}

}
