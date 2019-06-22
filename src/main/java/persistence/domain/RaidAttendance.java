package persistence.domain;

import javax.persistence.*;

@Entity
public class RaidAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "instance_id")
	private int instanceId;

	@Column(name = "instance_date")
	private int instanceDate;

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	public int getInstanceDate() {
		return instanceDate;
	}

	public void setInstanceDate(int instanceDate) {
		this.instanceDate = instanceDate;
	}
}