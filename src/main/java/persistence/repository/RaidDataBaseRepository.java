package persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class RaidDataBaseRepository implements RaidRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	@Inject
	private JSONUtil jsonUtil;

	@Transactional(REQUIRED)
	@Override
	public String addNewRaidRecord() {
		return null;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setJsonUtil(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}
}