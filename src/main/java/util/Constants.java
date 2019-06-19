package util;

public class Constants {

	public static final String SINGLE_PLAYER_JSON = "{\"playerId\":10,\"playerFirstName\":\"Marc\",\"playerLastName\":\"Partington\",\"playerDKP\":0}";
	public static final String SINGLE_AVATAR_JSON = "{\"avatarName\":\"Kilrathi\",\"className\":\"druid\",\"avatarLevel\":100}";

	public static final String GET_ALL_AVATAR_QUERY = "[{\"avatarName\":\"Kilrathi\",\"className\":\"druid\",\"avatarLevel\":100}]";
	public static final String GET_AVATAR_PASS = "{\"avatarName\":\"Kilrathi\",\"className\":\"druid\",\"avatarLevel\":100}";
	public static final String GET_AVATAR_FAIL_RESPONSE = "{\"message\": \"No Avatar exists\"}";

	public static final String ADD_AVATAR_PASS_RESPONSE = "{\"message\": \"Avatar added\"}";
	public static final String ADD_AVATAR_ALREADY_EXISTS_RESPONSE = "{\"message\": \"Avatar already exists\"}";
	public static final String ADD_AVATAR_FAIL_RESPONSE = "{\"message\": \"Avatar not added\"}";

	public static final String GET_ALL_PLAYER_QUERY = "[{\"playerId\":10,\"playerFirstName\":\"Marc\",\"playerLastName\":\"Partington\",\"playerDKP\":0}]";
	public static final String GET_PLAYER_PASS = "{\"playerId\":10,\"playerFirstName\":\"Marc\",\"playerLastName\":\"Partington\",\"playerDKP\":0}";
	public static final String GET_PLAYER_FAIL_RESPONSE = "{\"message\": \"No Player exists\"}";

	public static final String ADD_PLAYER_PASS_RESPONSE = "{\"message\": \"Player added\"}";
	public static final String ADD_PLAYER_FAIL_RESPONSE = "{\"message\": \"Player not added\"}";
}
