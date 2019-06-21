package persistence.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void deletePlayerDoesNotExistTest() {
		Mockito.when(entityManager.find(Player.class, 10)).thenReturn(null);
		assertEquals(Constants.REMOVE_PLAYER_DOES_NOT_EXIST_RESPONSE, playerDataBaseRepository.deletePlayer(10));
	}

	@Test
	public void deletePlayerDoesExistTest() {
		Mockito.when(entityManager.find(Player.class, 10)).thenReturn(new Player(10, "Marc", "Partington", 0));
		assertEquals(Constants.REMOVE_PLAYER_PASS_RESPONSE, playerDataBaseRepository.deletePlayer(10));
	}

	@Test
	public void updatePlayerDoesExistTest() {

		Mockito.when(entityManager.find(Player.class, 10)).thenReturn(new Player(10, "Marc", "Partington", 0));

		assertEquals(Constants.UPDATE_PLAYER_PASS_RESPONSE,
				playerDataBaseRepository.updatePlayer(10, Constants.SINGLE_PLAYER_UPDATE_JSON));
	}

	@Test
	public void updatePlayerDoesNotExistTest() {
		Mockito.when(entityManager.find(Player.class, "Steve")).thenReturn(new Player(10, "Marc", "Partington", 0));

		assertEquals(Constants.UPDATE_PLAYER_DOES_NOT_EXIST_RESPONSE,
				playerDataBaseRepository.updatePlayer(12, Constants.SINGLE_PLAYER_UPDATE_JSON));
	}

	@Test
	public void getHighestDKPTest() {
		assertTrue(playerDataBaseRepository.getHighestListDKP() == null);
	}

	@Test
	public void getMostPlayedTest() {
		assertTrue(playerDataBaseRepository.getMostPlayed() == null);
	}

	@Test
	public void getLeastPlayedTest() {
		assertTrue(playerDataBaseRepository.getLeastPlayed() == null);
	}
}