package rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.service.PlayerService;

@Path("/player")
public class PlayerEndPoint {

	@Inject
	private PlayerService playerService;

	@Path("/addPlayer")
	@POST
	@Produces({ "application/json" })
	public String addPlayer(String jsonPlayerData) {
		return null;
	}

	@Path("/getPlayer/{playerId}")
	@GET
	@Produces({ "application/json" })
	public String getPlayer(@PathParam("playerId") int playerId) {
		return null;
	}

	@Path("/getAllPlayers")
	@GET
	@Produces({ "application/json" })
	public String getAllPlayers() {
		return null;
	}

	public String getHighestListDKP() {
		return null;
	}

	public String getMostPlayed() {
		return null;
	}

	public String getLeastPlayed() {
		return null;
	}

	@Path("/updatePlayer/{playerId}")
	@PUT
	@Produces({ "application/json" })
	public String updatePlayer(@PathParam("playerId") int playerId, String jsonPlayerData) {
		return null;
	}

	@Path("/removePlayer/{playerId}")
	@DELETE
	@Produces({ "application/json" })
	public String deletePlayer(@PathParam("playerId") int playerId) {
		return null;
	}
}