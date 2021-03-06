package persistence.repository;

import static org.junit.Assert.*;

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
		avatars.add(new Avatar("Kilrathi", ClassType.DRUID, 100));
		Mockito.when(query.getResultList()).thenReturn(avatars);
		Assert.assertEquals(Constants.GET_ALL_AVATAR_QUERY, avatarDataBaseRepository.getAllAvatars());
	}

	@Test
	public void addAvatarAlreadyExistsTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi"))
				.thenReturn(new Avatar("Kilrathi", ClassType.DRUID, 100));

		assertEquals(Constants.ADD_AVATAR_ALREADY_EXISTS_RESPONSE,
				avatarDataBaseRepository.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}

	@Test
	public void addAvatarDoesNotExistTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi")).thenReturn(null);

		assertEquals(Constants.ADD_AVATAR_PASS_RESPONSE,
				avatarDataBaseRepository.addAvatar(Constants.SINGLE_AVATAR_JSON));
	}

	@Test
	public void deleteAvatarDoesNotExistTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi")).thenReturn(null);
		assertEquals(Constants.REMOVE_AVATAR_DOES_NOT_EXIST_RESPONSE,
				avatarDataBaseRepository.deleteAvatar("Kilrathi"));
	}

	@Test
	public void deleteAvatarDoesExistTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi"))
				.thenReturn(new Avatar("Kilrathi", ClassType.DRUID, 100));
		assertEquals(Constants.REMOVE_AVATAR_PASS_RESPONSE, avatarDataBaseRepository.deleteAvatar("Kilrathi"));
	}

	@Test
	public void updateAvatarDoesExistTest() {
		Mockito.when(entityManager.find(Avatar.class, "Kilrathi"))
				.thenReturn(new Avatar("Kilrathi", ClassType.DRUID, 100));

		assertEquals(Constants.UPDATE_AVATAR_PASS_RESPONSE,
				avatarDataBaseRepository.updateAvatar("Kilrathi", Constants.SINGLE_AVATAR_UPDATE_JSON));
	}

	@Test
	public void updateAvatarDoesNotExistTest() {
		Mockito.when(entityManager.find(Avatar.class, "Steve")).thenReturn(new Avatar("Steve", ClassType.DRUID, 100));

		assertEquals(Constants.UPDATE_AVATAR_DOES_NOT_EXIST_RESPONSE,
				avatarDataBaseRepository.updateAvatar("Kilrathi", Constants.SINGLE_AVATAR_UPDATE_JSON));
	}

	@Test
	public void addAvatarTwoParamTest() {
		assertTrue(avatarDataBaseRepository.addAvatar(1, "") == null);
	}

	@Test
	public void getAvatarCountTest() {
		assertTrue(avatarDataBaseRepository.getAvatarCount() == null);
	}

	@Test
	public void getNumberAvatarPerPlayerTest() {
		assertTrue(avatarDataBaseRepository.getNumberAvatarPerPlayer() == null);
	}
}