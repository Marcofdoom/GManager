package persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import util.ClassType;
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

	@Test
	public void getAllAvatarsTest() {
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Avatar> avatars = new ArrayList<Avatar>();
		avatars.add(new Avatar("Kilrathi", ClassType.druid, 100));
		Mockito.when(query.getResultList()).thenReturn(avatars);
		Assert.assertEquals(Constants.GET_ALL_AVATAR_QUERY, avatarDataBaseRepository.getAllAvatars());
	}

	@Test
	public void addAvatarAlreadyExistsTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi"))
				.thenReturn(new Avatar("Kilrathi", ClassType.druid, 100));

		assertEquals(Constants.ADD_AVATAR_ALREADY_EXISTS_RESPONSE,
				avatarDataBaseRepository.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}

	@Test
	public void addAvatarDoesNotExist() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi")).thenReturn(null);

		assertEquals(Constants.ADD_AVATAR_PASS_RESPONSE,
				avatarDataBaseRepository.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}
}