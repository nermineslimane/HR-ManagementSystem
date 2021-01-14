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

import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.PidevService.Impl.ProjectService;
import tn.esprit.PidevService.Impl.TaskService;
import tn.esprit.Pidev_Entities.Project;

@Path("projects")
@SessionScoped
public class ProjectResources {
@EJB 
ProjectService ps;
@EJB
EmployeService em;
@EJB
TaskService ts;

	@GET
	@Path("allProjects")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProjects() {
		return Response.ok(ps.getAllProjects()).build();
	}
	
	@GET
	@Path("finishedProjects")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFinishedProjects() {
		return Response.ok(ps.getFinishedProjects()).build();
	}
	
	@GET
	@Path("project/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Project getProjectById(@PathParam("id") int id) {
		Project p =ps.getProjectById(id);
		if (p != null) {
			return p;
		}
		return null;	
	}
		
	@GET
	@Path("project/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProjectsByUser(@PathParam("id") int id) {
		return Response.ok(ps.getProjectByOwner(em.getUserById(id))).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addProject(Project project) {
	ps.AddProjects(project);
	return ("Project added");	
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateProject(Project project) {
			ps.UpdateProject(project);
			return ("1");
		}
	
	@PUT
	@Path("Close")
	@Consumes(MediaType.APPLICATION_JSON)
	public String closeProject(Project project) {	   
			ps.finishProject(project.getId());
			return ("Project updated");
		}
	
	@DELETE
	@Path("delete/{id}")
    public String removeProject(@PathParam("id") int id) {
		ps.deleteProject(id); 
		return ("Project Removed");
		}
	
	
	@GET
	@Path("project/{id}/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response getTaskByProjectId(@PathParam("id") int id) {
		return Response.ok(ts.getTasksByProject(id)).build();
	}
	

}
