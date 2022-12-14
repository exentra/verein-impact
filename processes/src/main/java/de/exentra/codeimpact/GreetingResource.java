package de.exentra.codeimpact;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.flowable.engine.ProcessEngine;

@Path("/hello")
public class GreetingResource
{

	@Inject
	ProcessEngine _processEngine;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello()
	{
		return "Hello from RESTEasy Reactive";
	}
}