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
		Mockito.when(avatarService.addAvatar(Constants.SINGLE_AVATAR_JSON))
				.thenReturn(Constants.ADD_AVATAR_PASS_RESPONSE);
		assertEquals(Constants.ADD_AVATAR_PASS_RESPONSE, avatarEndPoint.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}

	@Test
	public void getAvatarTest() {
		Mockito.when(avatarService.getAvatar("Kilrathi")).thenReturn(Constants.SINGLE_AVATAR_JSON);
		assertEquals(Constants.SINGLE_AVATAR_JSON, avatarEndPoint.getAvatar("Kilrathi"));
	}

	@Test
	public void updateAvatarTest() {
		Mockito.when(avatarService.updateAvatar("Kilrathi", Constants.SINGLE_AVATAR_UPDATE_JSON))
				.thenReturn(Constants.SINGLE_AVATAR_UPDATE_JSON);
		assertEquals(Constants.SINGLE_AVATAR_UPDATE_JSON,
				avatarEndPoint.updateAvatar("Kilrathi", Constants.SINGLE_AVATAR_UPDATE_JSON));
	}

	@Test
	public void deleteAvatar() {
		Mockito.when(avatarService.deleteAvatar("Kilrathi")).thenReturn(Constants.REMOVE_AVATAR_PASS_RESPONSE);
		assertEquals(Constants.REMOVE_AVATAR_PASS_RESPONSE, avatarEndPoint.deleteAvatar("Kilrathi"));
	}

	@Test
	public void getAllAvatars() {
		Mockito.when(avatarService.getAllAvatars()).thenReturn(Constants.GET_ALL_AVATAR_QUERY);
		assertEquals(Constants.GET_ALL_AVATAR_QUERY, avatarEndPoint.getAllAvatars());
	}
}