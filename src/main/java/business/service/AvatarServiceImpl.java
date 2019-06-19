package business.service;

import javax.inject.Inject;

import persistence.repository.AvatarRepository;
import util.JSONUtil;

public class AvatarServiceImpl implements AvatarService {

	@Inject
	private AvatarRepository avatarRepository;

	@Override
	public String addAvatar(int playerId, String jsonAvatarData) {
		return null;
	}

	@Override
	public String addAvatar(String jsonAvatarData) {
		return null;
	}

	@Override
	public String getAvatar(String avatarName) {
		return null;
	}

	@Override
	public String getAllAvatars() {
		return null;
	}

	@Override
	public String getAvatarCount() {
		return null;
	}

	@Override
	public String getNumberAvatarPerPlayer() {
		return null;
	}

	@Override
	public String updateAvatar(String avatarName, String jsonAvatarData) {
		return null;
	}

	@Override
	public String deleteAvatar(String avatarName) {
		return null;
	}
}