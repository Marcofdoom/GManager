package business.service;

import javax.inject.Inject;

import persistence.repository.PlayerRepository;

public class PlayerServiceImpl implements PlayerService {

	@Inject
	private PlayerRepository playerRepository;
	
	@Override
	public String addPlayer(String jsonPlayerData) {
		return null;
	}

	@Override
	public String getPlayer(int playerId) {
		return null;
	}

	@Override
	public String getAllPlayers() {
		return null;
	}

	@Override
	public String getHighestListDKP() {
		return null;
	}

	@Override
	public String getMostPlayed() {
		return null;
	}

	@Override
	public String getLeastPlayed() {
		return null;
	}

	@Override
	public String updatePlayer(int playerId, String jsonPlayerData) {
		return null;
	}

	@Override
	public String deletePlayer(int playerId) {
		return null;
	}
}