package persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import persistence.domain.Player;
import util.Constants;
import util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class PlayerDataBaseRepositoryTest {

	@InjectMocks // Class under test
	private PlayerDataBaseRepository playerDataBaseRepository;

	@Mock // What it requires
	private EntityManager entityManager;

	private JSONUtil jsonUtil;

	@Mock
	private Query query;

	@Before
	public void setup() {
		playerDataBaseRepository.setEntityManager(entityManager);
		jsonUtil = new JSONUtil();
		playerDataBaseRepository.setJsonUtil(jsonUtil);
	}

	@Test
	public void getPlayerPassTest() {
		Mockito.when(entityManager.find(Player.class, 1))
				.thenReturn(jsonUtil.getObjectForJSON(Constants.GET_PLAYER_PASS, Player.class));

		assertEquals(Constants.GET_PLAYER_PASS, playerDataBaseRepository.getPlayer(1));
	}

	@Test
	public void getPlayerFailTest() {
		Mockito.when(entityManager.find(Player.class, 1)).thenReturn(null);
		assertEquals(Constants.GET_PLAYER_FAIL_RESPONSE, playerDataBaseRepository.getPlayer(1));
	}

	@Test
	public void getAllPlayersTest() {
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(10, "Marc", "Partington", 0));
		Mockito.when(query.getResultList()).thenReturn(players);
		assertEquals(Constants.GET_ALL_PLAYER_QUERY, playerDataBaseRepository.getAllPlayers());
	}

	@Test
	public void addPlayerTest() {
		assertEquals(Constants.ADD_PLAYER_PASS_RESPONSE,
				playerDataBaseRepository.addPlayer(Constants.SINGLE_PLAYER_JSON));
	}
}