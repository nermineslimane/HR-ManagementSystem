package ressourcesYassine;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.PidevService.Impl.BugService;
import tn.esprit.PidevService.Impl.ProjectService;
import tn.esprit.Pidev_Entities.Bug;






@Path("bug")
@SessionScoped
public class BugResources {
	
@EJB 
ProjectService ps;

@EJB
BugService bs;


@GET
@Path("all")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllBugs() {
	return Response.ok(bs.getAll()).build();
}



@GET
@Path("bug/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Bug getTaskById(@PathParam("id") int id) {
	Bug t=bs.getBugById(id);
	if (t != null) {
		return t;
	}
	return null;	
}

@POST
@Path("add")
@Consumes(MediaType.APPLICATION_JSON)
public String addBug(Bug bug) {	
int a =bs.AddBug(bug);
System.out.println(a);
return ("Task added");	
}

@PUT
@Path("update")
@Consumes(MediaType.APPLICATION_JSON)
public String updateBug(Bug bug) {
		bs.UpdateBug(bug);
		return ("1");
}

@DELETE
@Path("delete/{id}")
public String removeBug(@PathParam("id") int id) {
	bs.removeBug(id);
	return ("Task Removed");
}

}
