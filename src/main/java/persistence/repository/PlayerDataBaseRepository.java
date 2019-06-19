package persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import persistence.domain.Player;
import util.Constants;
import util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class PlayerDataBaseRepository implements PlayerRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	@Inject
	private JSONUtil jsonUtil;

	@Transactional(REQUIRED)
	@Override
	public String addPlayer(String jsonPlayerInformation) {
		Player player = jsonUtil.getObjectForJSON(jsonPlayerInformation, Player.class);
		entityManager.persist(player);

		return Constants.ADD_PLAYER_PASS_RESPONSE;
	}

	@Override
	public String getPlayer(int playerId) {
		if (entityManager.find(Player.class, playerId) != null) {
			return jsonUtil.getJSONForObject(entityManager.find(Player.class, playerId));
		}

		return Constants.GET_PLAYER_FAIL_RESPONSE;
	}

	@Override
	public String getAllPlayers() {
		Query query = entityManager.createQuery("SELECT a FROM Player a");
		return jsonUtil.getJSONForObject(query.getResultList());
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

	@Transactional(REQUIRED)
	@Override
	public String updatePlayer(int playerId, String newDetails) {
		Player existingDetails = entityManager.find(Player.class, playerId);

		if (existingDetails == null) {
			return Constants.UPDATE_PLAYER_DOES_NOT_EXIST_RESPONSE;
		}

		Player player = jsonUtil.getObjectForJSON(newDetails, Player.class);
		existingDetails.setPlayerDKP(player.getPlayerDKP());
		existingDetails.setPlayerFirstName(player.getPlayerFirstName());
		existingDetails.setPlayerLastName(player.getPlayerLastName());

		entityManager.persist(existingDetails);
		return Constants.UPDATE_PLAYER_PASS_RESPONSE;
	}

	@Transactional(REQUIRED)
	@Override
	public String deletePlayer(int playerId) {
		Player player = entityManager.find(Player.class, playerId);

		if (player == null) {
			return Constants.REMOVE_PLAYER_DOES_NOT_EXIST_RESPONSE;
		}

		entityManager.remove(player);
		return Constants.REMOVE_PLAYER_PASS_RESPONSE;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setJsonUtil(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}
}