package rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import business.service.RaidService;

@Path("/raid")
public class RaidEndPoint {

	@Inject
	private RaidService raidService;
	
	@Path("/addRaid")
	@POST
	@Produces({ "application/json" })
	public String addRaid() {
		return null;
	}
}