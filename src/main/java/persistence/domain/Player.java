package persistence.domain;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "player_first_name")
    private String playerFirstName;

    @Column(name = "player_last_name")
    private String playerLastName;

    @Column(name = "player_dkp")
    private int playerDKP;

    public Player() {

    }

    public Player(int playerId, String playerFirstName, String playerLastName, int playerDKP) {
        this.playerId = playerId;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerDKP = playerDKP;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public int getPlayerDKP() {
        return playerDKP;
    }

    public void setPlayerDKP(int playerDKP) {
        this.playerDKP = playerDKP;
    }
}