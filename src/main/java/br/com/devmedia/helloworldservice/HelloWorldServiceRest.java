package br.com.devmedia.helloworldservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/helloworldservice")
public class HelloWorldServiceRest {

	@GET
	@Path("/hello")
	@Produces("application/json")
	public String hello(@QueryParam("nome") String name) {
		return null;
	}

}
