package persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
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

//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<RaidAttendance> raidAttendances;

//	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
//	private Set<Avatar> avatars;
}