package rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.service.AvatarService;

@Path("/avatar")
public class AvatarEndPoint {

	@Inject
	private AvatarService avatarService;

	@Path("/addAvatar/{playerId}")
	@POST
	@Produces({ "application/json" })
	public String addAvatar(@PathParam("playerId") int playerId, String jsonAvatarData) {
		return null;
	}

	@Path("/addAvatar")
	@POST
	@Produces({ "application/json" })
	public String addAvatar(String jsonAvatarData) {
		return avatarService.addAvatar(jsonAvatarData);
	}

	@Path("/getAvatar/{avatarName}")
	@GET
	@Produces({ "application/json" })
	public String getAvatar(@PathParam("avatarName") String avatarName) {
		return avatarService.getAvatar(avatarName);
	}

	@Path("/getAllAvatars")
	@GET
	@Produces({ "application/json" })
	public String getAllAvatars() {
		return avatarService.getAllAvatars();
	}

	public String getAvatarCount() {
		return null;
	}

	public String getNumberAvatarPerPlayer() {
		return null;
	}

	@Path("/updateAvatar/{avatarName}")
	@PUT
	@Produces({ "application/json" })
	public String updateAvatar(@PathParam("avatarName") String avatarName, String jsonAvatarData) {
		return null;
	}

	@Path("/deleteAvatar/{avatarName}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAvatar(@PathParam("avatarName") String avatarName) {
		return avatarService.deleteAvatar(avatarName);
	}
}