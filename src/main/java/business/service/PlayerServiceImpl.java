package business.service;

import javax.inject.Inject;

import persistence.repository.PlayerRepository;

public class PlayerServiceImpl implements PlayerService {

	@Inject
	private PlayerRepository playerRepository;

	@Override
	public String addPlayer(String jsonPlayerData) {
		return playerRepository.addPlayer(jsonPlayerData);
	}

	@Override
	public String getPlayer(int playerId) {
		return playerRepository.getPlayer(playerId);
	}

	@Override
	public String getAllPlayers() {
		return playerRepository.getAllPlayers();
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