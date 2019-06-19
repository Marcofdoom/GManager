package persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import util.ClassType;

@Data
@Entity
public class Avatar {

	@Id
	@Column(name = "avatar_name")
	private String avatarName;

	@Enumerated(EnumType.STRING)
	@Column(name = "class_name")
	private ClassType className;

	@Column(name = "avatar_level")
	private int avatarLevel;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "player", nullable = false)
//	private Player player;

//	public Avatar() {
//
//	}
//
//	public Avatar(String avatarName, ClassType className, int avatarLevel, Player player) {
//		this.avatarName = avatarName;
//		this.className = className;
//		this.avatarLevel = avatarLevel;
//		this.player = player;
//	}
}