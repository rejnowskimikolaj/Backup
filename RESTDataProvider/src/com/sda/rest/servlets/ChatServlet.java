package com.sda.rest.servlets;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sda.rest.dao.ChatUsersService;
import com.sda.rest.dao.UserLoginService;
import com.sda.rest.model.LOGIN_RESULT;
import com.sda.rest.model.User;

@Path("/room")
public class ChatServlet {
	
	/**
	 * Pobiera u¿ytkowników chatu.
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Produces("application/json")
	public Response getUsers() throws JSONException {
		ChatUsersService service = new ChatUsersService();
		JSONObject responseResult = new JSONObject();
		
		List<User> users = service.getUsers();
		JSONArray array = new JSONArray();
		
		for(User u : users){
			array.put(new JSONObject(u));
		}
		responseResult.put("result", array);
        
        return Response.status(200).entity(responseResult.toString()).build();
	}
}