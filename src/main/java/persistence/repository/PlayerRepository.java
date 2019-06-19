package persistence.repository;

public interface PlayerRepository {

	String addPlayer(String jsonPlayerInformation);
	
	String getPlayer(int playerId);
	
	String getAllPlayers();
	
	String getHighestListDKP();
	
	String getMostPlayed();
	
	String getLeastPlayed();
	
	String updatePlayer(int playerId, String newDetails);
	
	String deletePlayer(int playerId);
}