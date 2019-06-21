package rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import business.service.AvatarService;
import util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class AvatarEndPointTest {

	@InjectMocks
	private AvatarEndPoint avatarEndPoint;

	@Mock
	private AvatarService avatarService;

	@Test
	public void addAvatar() {
		Mockito.when(avatarService.addAvatar(Constants.SINGLE_PLAYER_JSON))
				.thenReturn(Constants.ADD_AVATAR_PASS_RESPONSE);
		assertEquals(Constants.ADD_AVATAR_PASS_RESPONSE, avatarEndPoint.addAvatar(Constants.SINGLE_PLAYER_JSON));
	}
}