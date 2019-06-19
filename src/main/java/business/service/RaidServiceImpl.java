package business.service;

import javax.inject.Inject;

import persistence.repository.PlayerRepository;
import persistence.repository.RaidRepository;

public class RaidServiceImpl implements RaidService {

	@Inject
	private RaidRepository raidRepository;

	@Override
	public String addNewRaidRecord() {
		return null;
	}
}