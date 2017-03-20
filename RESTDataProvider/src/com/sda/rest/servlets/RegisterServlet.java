package com.sda.rest.servlets;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.sda.rest.dao.UserLoginService;
import com.sda.rest.model.LOGIN_RESULT;

@Path("/register")
public class RegisterServlet {
	/**
	 * Rejestruje u¿ytkownika (jeœli nie istnieje) lub próbuje go zalogowaæ
	 * (jeœli istnieje).
	 * 
	 * @param data
	 * @return
	 * @throws JSONException
	 */
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response register(String data) throws JSONException {
		UserLoginService service = new UserLoginService();
		JSONObject responseResult = new JSONObject();

		JSONObject obj = new JSONObject(data);
		LOGIN_RESULT result = service.tryLogin(obj.getString("login"), obj.getString("password_hash"));

		if (result == LOGIN_RESULT.USER_DOES_NOT_EXIST) {
			service.register(obj.getString("login"), obj.getString("password_hash"));
			responseResult.put("result", "REGISTERED");
		} else if (result == LOGIN_RESULT.SUCCESS) {
			responseResult.put("result", "OK");
		} else {
			responseResult.put("result", "SERVER ERROR");
		}

		return Response.status(200).entity(responseResult.toString()).build();
	}
}