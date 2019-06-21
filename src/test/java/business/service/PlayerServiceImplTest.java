package business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import persistence.repository.PlayerRepository;
import util.Constants;
import util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImplTest {

	@InjectMocks // Class under test
	private PlayerServiceImpl playerServiceImpl;

	@Mock
	private PlayerRepository playerRepository;

	@Mock
	private JSONUtil JSONUtil;

	@Test
	public void addPlayerTest() {
		Mockito.when(playerRepository.addPlayer(Constants.SINGLE_PLAYER_JSON)).thenReturn(Constants.ADD_AVATAR_PASS_RESPONSE);
		assertEquals(Constants.ADD_AVATAR_PASS_RESPONSE, playerServiceImpl.addPlayer(Constants.SINGLE_PLAYER_JSON));
	}

	@Test
	public void getPlayerTest() {
		Mockito.when(playerRepository.getPlayer(10)).thenReturn(Constants.SINGLE_PLAYER_JSON);
		assertEquals(Constants.SINGLE_PLAYER_JSON, playerServiceImpl.getPlayer(10));
	}

	@Test
	public void updatePlayerTest() {
		Mockito.when(playerRepository.updatePlayer(10, Constants.SINGLE_PLAYER_UPDATE_JSON))
				.thenReturn(Constants.SINGLE_PLAYER_UPDATE_JSON);
		assertEquals(Constants.SINGLE_PLAYER_UPDATE_JSON,
				playerRepository.updatePlayer(10, Constants.SINGLE_PLAYER_UPDATE_JSON));
	}

	@Test
	public void deletePlayer() {
		Mockito.when(playerRepository.deletePlayer(10)).thenReturn(Constants.REMOVE_PLAYER_PASS_RESPONSE);
		assertEquals(Constants.REMOVE_PLAYER_PASS_RESPONSE, playerRepository.deletePlayer(10));
	}

	@Test
	public void getAllPlayers() {
		Mockito.when(playerRepository.getAllPlayers()).thenReturn(Constants.GET_ALL_PLAYER_QUERY);
		assertEquals(Constants.GET_ALL_PLAYER_QUERY, playerRepository.getAllPlayers());
	}
}