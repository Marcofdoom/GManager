package persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import persistence.domain.Avatar;
import util.ClassType;
import util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AvatarDataBaseRepository implements AvatarRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	@Inject
	private JSONUtil jsonUtil;

	@Transactional(REQUIRED)
	@Override
	public String addAvatar(int playerId, String jsonAvatarData) {
		return null;
	}

	@Transactional(REQUIRED)
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

	@Transactional(REQUIRED)
	@Override
	public String updateAvatar(String avatarName, String jsonAvatarData) {
		return null;
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteAvatar(String avatarName) {
		return null;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setJsonUtil(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}
}