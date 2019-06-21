package rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import business.service.PlayerService;
import util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class PlayerEndPointTest {

	@InjectMocks
	private PlayerEndPoint playerEndPoint;

	@Mock
	private PlayerService playerService;

	@Test
	public void addPlayer() {
		Mockito.when(playerService.addPlayer(Constants.SINGLE_PLAYER_JSON))
				.thenReturn(Constants.ADD_PLAYER_PASS_RESPONSE);
		assertEquals(Constants.ADD_PLAYER_PASS_RESPONSE, playerEndPoint.addPlayer(Constants.SINGLE_PLAYER_JSON));
	}

	// test
	@Test
	public void getPlayerTest() {
		Mockito.when(playerService.getPlayer(10)).thenReturn(Constants.SINGLE_PLAYER_JSON);
		assertEquals(Constants.SINGLE_PLAYER_JSON, playerEndPoint.getPlayer(10));
	}

	@Test
	public void updatePlayerTest() {
		Mockito.when(playerService.updatePlayer(10, Constants.SINGLE_PLAYER_UPDATE_JSON))
				.thenReturn(Constants.SINGLE_PLAYER_UPDATE_JSON);
		assertEquals(Constants.SINGLE_PLAYER_UPDATE_JSON,
				playerEndPoint.updatePlayer(10, Constants.SINGLE_PLAYER_UPDATE_JSON));
	}

	@Test
	public void deletePlayer() {
		Mockito.when(playerService.deletePlayer(10)).thenReturn(Constants.REMOVE_PLAYER_PASS_RESPONSE);
		assertEquals(Constants.REMOVE_PLAYER_PASS_RESPONSE, playerEndPoint.deletePlayer(10));
	}

	@Test
	public void getAllPlayers() {
		Mockito.when(playerService.getAllPlayers()).thenReturn(Constants.GET_ALL_PLAYER_QUERY);
		assertEquals(Constants.GET_ALL_PLAYER_QUERY, playerEndPoint.getAllPlayers());
	}

}
