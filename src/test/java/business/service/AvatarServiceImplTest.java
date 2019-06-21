package business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import persistence.repository.AvatarRepository;
import util.Constants;
import util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AvatarServiceImplTest {

	@InjectMocks // Class under test
	private AvatarServiceImpl avatarServiceImpl;

	@Mock
	private AvatarRepository avatarRepository;

	@Mock
	private JSONUtil JSONUtil;

	@Test
	public void addAvatarTest() {
		Mockito.when(avatarRepository.addAvatar(Constants.SINGLE_AVATAR_JSON))
				.thenReturn(Constants.ADD_AVATAR_PASS_RESPONSE);
		assertEquals(Constants.ADD_AVATAR_PASS_RESPONSE, avatarServiceImpl.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}

	@Test
	public void getAvatarTest() {
		Mockito.when(avatarRepository.getAvatar("Kilrathi")).thenReturn(Constants.SINGLE_AVATAR_JSON);
		assertEquals(Constants.SINGLE_AVATAR_JSON, avatarServiceImpl.getAvatar("Kilrathi"));
	}

	@Test
	public void updateAvatarTest() {
		Mockito.when(avatarRepository.updateAvatar("Kilrathi", Constants.SINGLE_AVATAR_UPDATE_JSON))
				.thenReturn(Constants.SINGLE_AVATAR_UPDATE_JSON);
		assertEquals(Constants.SINGLE_AVATAR_UPDATE_JSON,
				avatarRepository.updateAvatar("Kilrathi", Constants.SINGLE_AVATAR_UPDATE_JSON));
	}

	@Test
	public void deleteAvatar() {
		Mockito.when(avatarRepository.deleteAvatar("Kilrathi"))
				.thenReturn(Constants.REMOVE_AVATAR_PASS_RESPONSE);
		assertEquals(Constants.REMOVE_AVATAR_PASS_RESPONSE, avatarRepository.deleteAvatar("Kilrathi"));
	}

	@Test
	public void getAllAvatars() {
		Mockito.when(avatarRepository.getAllAvatars()).thenReturn(Constants.GET_ALL_AVATAR_QUERY);
		assertEquals(Constants.GET_ALL_AVATAR_QUERY, avatarRepository.getAllAvatars());
	}
}