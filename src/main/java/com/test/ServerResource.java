package com.test;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("server")
public class ServerResource {
	
	//curl http://localhost:8080/restweb/webapi/server/info
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHi(@Context HttpServletRequest request) {
    	System.out.println("real path = "+request.getServletContext().getRealPath(""));
    	Map<String,String> map = new HashMap<>();
    	map.put("path",request.getServletContext().getRealPath(""));
    	map.put("name",request.getServerName());
    	map.put("address",request.getLocalAddr());
        return JSONObject.toJSONString(map);    	
    }

}
