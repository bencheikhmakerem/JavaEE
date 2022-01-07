package org.makerem.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.makerem.model.Commune;
import org.makerem.model.CommuneEJB;

@Path("commune")

public class CommuneRs {
	@EJB //injection des dépendences
	private CommuneEJB communeEJB;
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	
	public Response findById(@PathParam("id") long id) {
		Commune commune = communeEJB.findCommuneById(id);
		if(commune != null) {
			return Response.ok(commune).build();
		}
		else {
			return Response
					.status(Status.NOT_FOUND.getStatusCode(), "Commune " + id + "not found")
					.build();
		}
		
	}
	
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createCommune(@FormParam("name") String name) {
		Commune commune = new Commune (name);
		long id = communeEJB.createCommune(commune);
		//mecanisme de création en DB
		return Response.ok(id).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateCommune(@PathParam("id") long id, @FormParam("name") String name){
		Commune commune = communeEJB.findCommuneById(id);
		if(commune != null) {
			commune.setName(name);
			communeEJB.updateCommuneById(commune);
			return Response.ok(commune).build();		
		}
		else {
			Commune commune1 = new Commune(name);
			id = communeEJB.createCommune(commune1);
			return Response.ok(id).build();
		}
				

	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCommune(@PathParam("id") long id){
		if(communeEJB.deleteCommuneById(id) == true) {
			return Response.ok(id).build();
		}
		else {
			
			return Response
					.status(Status.NOT_FOUND.getStatusCode(), "Commune " + id + "not found")
					.build();
			
		}
	}
	

	
	
	
	
	

}