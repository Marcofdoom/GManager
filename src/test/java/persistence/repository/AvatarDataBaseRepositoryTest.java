package persistence.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import persistence.domain.Avatar;
import util.Constants;
import util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AvatarDataBaseRepositoryTest {

	@InjectMocks // Class under test
	private AvatarDataBaseRepository avatarDataBaseRepository;

	@Mock // What it requires
	private EntityManager entityManager;

	private JSONUtil jsonUtil;

	@Mock
	private Query query;

	@Before
	public void setup() {
		avatarDataBaseRepository.setEntityManager(entityManager);
		jsonUtil = new JSONUtil();
		avatarDataBaseRepository.setJsonUtil(jsonUtil);
	}

	@Test
	public void getAvatarPassTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi"))
				.thenReturn(jsonUtil.getObjectForJSON(Constants.GET_AVATAR_PASS, Avatar.class));

		assertEquals(Constants.GET_AVATAR_PASS, avatarDataBaseRepository.getAvatar("Kilrathi"));
	}

	@Test
	public void getAvatarFailTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi")).thenReturn(null);
		assertEquals(Constants.GET_AVATAR_FAIL_RESPONSE, avatarDataBaseRepository.getAvatar("Kilrathi"));
	}

	// @Test
	// public void getAllAvatarsTest() {
	//
	// }
	//
	// @Test
	// public void getAvatarTest() {
	//
	// }
	//
	// @Test
	// public void addAvatarTest() {
	//
	// }
}