package business.service;

public interface PlayerService {

	String addPlayer(String jsonPlayerData);
	
	String getPlayer(int playerId);
	
	String getAllPlayers();
	
	String getHighestListDKP();
	
	String getMostPlayed();
	
	String getLeastPlayed();
	
	String updatePlayer(int playerId, String jsonPlayerData);
	
	String deletePlayer(int playerId);
}