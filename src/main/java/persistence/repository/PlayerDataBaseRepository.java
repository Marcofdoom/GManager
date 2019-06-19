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
		return null;
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
		return null;
	}

	@Transactional(REQUIRED)
	@Override
	public String deletePlayer(int playerId) {
		return null;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setJsonUtil(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}
}