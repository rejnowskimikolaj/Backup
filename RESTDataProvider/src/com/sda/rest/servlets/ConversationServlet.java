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
import com.sda.rest.dao.ConversationService;
import com.sda.rest.dao.UserLoginService;
import com.sda.rest.model.LOGIN_RESULT;
import com.sda.rest.model.Message;
import com.sda.rest.model.User;

@Path("/conversation")
public class ConversationServlet {

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	// consumes login token,
	public Response getConversation(String data) throws JSONException {
		// extract from passed data
		JSONObject obj = new JSONObject(data);
		int sender_id = Integer.parseInt(obj.getString("sender_id"));
		int recipient_id = Integer.parseInt(obj.getString("recipient_id"));

		ConversationService service = new ConversationService();
		JSONObject responseResult = new JSONObject();

		List<Message> messages = service.getConversationBetweenUsers(sender_id, recipient_id);
		JSONArray array = new JSONArray();

		for (Message u : messages) {
			array.put(new JSONObject(u));
		}
		responseResult.put("result", array);

		return Response.status(200).entity(responseResult.toString()).build();
	}

	@POST
	@Path("/send")
	@Produces("application/json")
	@Consumes("application/json")
	// consumes login token,
	public Response sendMessage(String data) throws JSONException {
		// extract from passed data
		JSONObject obj = new JSONObject(data);

		int sender_id = Integer.parseInt(obj.getString("sender_id"));
		int recipient_id = Integer.parseInt(obj.getString("recipient_id"));
		String content = obj.getString("content");

		ConversationService service = new ConversationService();
		JSONObject responseResult = new JSONObject();

		if (service.sendMessage(sender_id, recipient_id, content)) {
			responseResult.put("result", "OK");
		} else {
			responseResult.put("result", "FAILED");
		}

		return Response.status(200).entity(responseResult.toString()).build();
	}

	@POST
	@Path("/getUnread")
	@Produces("application/json")
	@Consumes("application/json")
	// consumes login token,
	public Response getUnread(String data) throws JSONException {
		// extract from passed data
		JSONObject obj = new JSONObject(data);
		int sender_id = Integer.parseInt(obj.getString("sender_id"));
		int recipient_id = Integer.parseInt(obj.getString("recipient_id"));

		ConversationService service = new ConversationService();
		JSONObject responseResult = new JSONObject();

		List<Message> messages = service.getUnreadMessages(sender_id, recipient_id);
		JSONArray array = new JSONArray();

		for (Message u : messages) {
			array.put(new JSONObject(u));
		}
		responseResult.put("result", array);

		return Response.status(200).entity(responseResult.toString()).build();
	}
}