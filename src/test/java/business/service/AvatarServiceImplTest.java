package business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import persistence.repository.AvatarDataBaseRepository;
import util.Constants;
import util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AvatarServiceImplTest {

	@InjectMocks // Class under test
	private AvatarServiceImpl avatarServiceImpl;

	@Mock
	private AvatarDataBaseRepository avatarDataBaseRepository;

	@Mock
	private JSONUtil JSONUtil;

	@Test
	public void addAvatarTest() {
		Mockito.when(avatarDataBaseRepository.addAvatar(Constants.SINGLE_AVATAR_JSON))
				.thenReturn(Constants.GET_AVATAR_PASS);
		assertEquals(Constants.GET_AVATAR_PASS, avatarServiceImpl.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}

	@Test
	public void getAllAvatars() {
		// return avatarRepository.getAllAvatars();
		// Mockito.when(avatarDataBaseRepository.getAllAvatars()).thenReturn(Constants.GET_ALL_AVATAR_QUERY);
		// assertEquals("", "a");
	}
}