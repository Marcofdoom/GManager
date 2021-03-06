package business.service;

public interface AvatarService {

	String addAvatar(int playerId, String jsonAvatarData);
	
	String addAvatar(String jsonAvatarData);
	
	String getAvatar(String avatarName);
	
	String getAllAvatars();
	
	String getAvatarCount();
	
	String getNumberAvatarPerPlayer();
	
	String updateAvatar(String avatarName, String jsonAvatarData);
	
	String deleteAvatar(String avatarName);
}