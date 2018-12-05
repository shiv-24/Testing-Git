package domain;

import javafx.util.Pair;

/**
 * Strategy for aggressive player.
 * @author Yogesh
 *
 */
public class AggressiveStrategy implements IStrategy {

	@Override
	public void reinforcement(Player player,Territory selectedTerritory, int numberOfArmies, PhaseViewModel phaseViewModel) {
		System.out.println("AggressiveStrategy reinforcement" );
		selectedTerritory = player.getTerritories().get(0);
		selectedTerritory.setArmyCount(selectedTerritory.getArmyCount()+1);
		player.setArmyCount(player.getArmyCount()-1);
		phaseViewModel.setPhaseInfo("AggressiveStrategy reinforcement");
		/*selectedTerritory.setArmyCount(selectedTerritory.getArmyCount() + numberOfArmies);
		player.setArmyCount(player.getArmyCount() - numberOfArmies);
		phaseViewModel.setPhaseInfo(String.valueOf(numberOfArmies) + " armies moved to " + selectedTerritory.getName());
*/
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
