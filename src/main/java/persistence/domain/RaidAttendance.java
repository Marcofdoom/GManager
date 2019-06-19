package persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class RaidAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "instance_id")
	private int instanceId;

	@Column(name = "instance_date")
	private int instanceDate;

//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<Player> players;
}