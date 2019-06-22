package util;

public class Constants {

    public static final String SINGLE_PLAYER_JSON = "{\"playerId\":10,\"playerFirstName\":\"Marc\",\"playerLastName\":\"Partington\",\"playerDKP\":0}";
    public static final String SINGLE_PLAYER_UPDATE_JSON = "{\"playerId\":10,\"playerFirstName\":\"Steve\",\"playerLastName\":\"Partington\",\"playerDKP\":10}";
    public static final String SINGLE_AVATAR_JSON = "{\"avatarName\":\"Kilrathi\",\"className\":\"DRUID\",\"avatarLevel\":100}";
    public static final String SINGLE_AVATAR_UPDATE_JSON = "{\"avatarName\":\"Kilrathi\",\"className\":\"DRUID\",\"avatarLevel\":90}";

    // AVATAR
    public static final String GET_ALL_AVATAR_QUERY = "[{\"avatarName\":\"Kilrathi\",\"className\":\"DRUID\",\"avatarLevel\":100}]";
    public static final String GET_AVATAR_PASS = "{\"avatarName\":\"Kilrathi\",\"className\":\"DRUID\",\"avatarLevel\":100}";
    public static final String GET_AVATAR_FAIL_RESPONSE = "{\"message\": \"No Avatar exists\"}";

    public static final String ADD_AVATAR_PASS_RESPONSE = "{\"message\": \"Avatar added\"}";
    public static final String ADD_AVATAR_ALREADY_EXISTS_RESPONSE = "{\"message\": \"Avatar already exists\"}";
    public static final String ADD_AVATAR_FAIL_RESPONSE = "{\"message\": \"Avatar not added\"}";

    public static final String REMOVE_AVATAR_DOES_NOT_EXIST_RESPONSE = "{\"message\": \"Avatar does not exist\"}";
    public static final String REMOVE_AVATAR_PASS_RESPONSE = "{\"message\": \"Avatar removed\"}";

    public static final String UPDATE_AVATAR_DOES_NOT_EXIST_RESPONSE = "{\"message\": \"Avatar does not exist, cannot update\"}";
    public static final String UPDATE_AVATAR_PASS_RESPONSE = "{\"message\": \"Avatar details updated\"}";

    // PLAYERS
    public static final String GET_ALL_PLAYER_QUERY = "[{\"playerId\":10,\"playerFirstName\":\"Marc\",\"playerLastName\":\"Partington\",\"playerDKP\":0}]";
    public static final String GET_PLAYER_PASS = "{\"playerId\":10,\"playerFirstName\":\"Marc\",\"playerLastName\":\"Partington\",\"playerDKP\":0}";
    public static final String GET_PLAYER_FAIL_RESPONSE = "{\"message\": \"No Player exists\"}";

    public static final String ADD_PLAYER_PASS_RESPONSE = "{\"message\": \"Player added\"}";
    public static final String ADD_PLAYER_FAIL_RESPONSE = "{\"message\": \"Player not added\"}";

    public static final String REMOVE_PLAYER_DOES_NOT_EXIST_RESPONSE = "{\"message\": \"Player does not exist\"}";
    public static final String REMOVE_PLAYER_PASS_RESPONSE = "{\"message\": \"Player removed\"}";

    public static final String UPDATE_PLAYER_DOES_NOT_EXIST_RESPONSE = "{\"message\": \"Player does not exist, cannot update\"}";
    public static final String UPDATE_PLAYER_PASS_RESPONSE = "{\"message\": \"Player details updated\"}";

    private Constants() {

    }
}
