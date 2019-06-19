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
import util.Constants;
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
		Avatar avatar = jsonUtil.getObjectForJSON(jsonAvatarData, Avatar.class);

		if (entityManager.find(Avatar.class, avatar.getAvatarName()) != null) {
			return Constants.ADD_AVATAR_ALREADY_EXISTS_RESPONSE;
		}

		entityManager.persist(avatar);

		return Constants.ADD_AVATAR_PASS_RESPONSE;
	}

	@Override
	public String getAvatar(String avatarName) {
		if (entityManager.find(Avatar.class, avatarName) != null) {
			return jsonUtil.getJSONForObject(entityManager.find(Avatar.class, avatarName));
		}

		return Constants.GET_AVATAR_FAIL_RESPONSE;
	}

	@Override
	public String getAllAvatars() {
		Query query = entityManager.createQuery("SELECT a FROM Avatar a");
		return jsonUtil.getJSONForObject(query.getResultList());
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
		Avatar existingDetails = entityManager.find(Avatar.class, avatarName);

		if (existingDetails == null) {
			return Constants.UPDATE_AVATAR_DOES_NOT_EXIST_RESPONSE;
		}

		Avatar avatar = jsonUtil.getObjectForJSON(jsonAvatarData, Avatar.class);
		existingDetails.setAvatarLevel(avatar.getAvatarLevel());
		entityManager.persist(existingDetails);

		return Constants.UPDATE_AVATAR_PASS_RESPONSE;
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteAvatar(String avatarName) {
		Avatar avatar = entityManager.find(Avatar.class, avatarName);

		if (avatar == null) {
			return Constants.REMOVE_AVATAR_DOES_NOT_EXIST_RESPONSE;
		}

		entityManager.remove(avatar);

		return Constants.REMOVE_AVATAR_PASS_RESPONSE;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setJsonUtil(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}
}