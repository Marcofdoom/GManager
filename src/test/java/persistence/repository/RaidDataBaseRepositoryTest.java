package persistence.repository;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RaidDataBaseRepositoryTest {

	@InjectMocks // Class under test
	private RaidDataBaseRepository raidDataBaseRepository;

	@Mock // What it requires
	private EntityManager entityManager;

	private JSONUtil jsonUtil;

	@Mock
	private Query query;

	@Before
	public void setup() {
		raidDataBaseRepository.setEntityManager(entityManager);
		jsonUtil = new JSONUtil();
		raidDataBaseRepository.setJsonUtil(jsonUtil);
	}

	@Test
	public void getHighestDKPTest() {
		assertTrue(raidDataBaseRepository.addNewRaidRecord() == null);
	}
}