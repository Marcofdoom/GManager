package persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Raid {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "raid_id")
	private int raidId;

	@Column(name = "raid_name")
	private String raidName;
}