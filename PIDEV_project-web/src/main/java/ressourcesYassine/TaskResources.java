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
import tn.esprit.Pidev_Entities.Task;

@Path("tasks")
@SessionScoped
public class TaskResources {
@EJB 
ProjectService ps;
@EJB
EmployeService em;
@EJB
TaskService ts;

	@GET
	@Path("alltasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTasks() {
		return Response.ok(ts.getAllTasks()).build();
	}
	
	
	@GET
	@Path("task/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Task getProjectById(@PathParam("id") int id) {
		Task p =ts.getTasksById(id);
		if (p != null) {
			return p;
		}
		return null;	
	}
		
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addTask(Task task) {
	ts.AddTask(task);
	return ("Task added");	
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateTask(Task task) {
			ts.UpdateTask(task);
			return ("Task updated");
		}
	

	
	@DELETE
	@Path("delete/{id}")
    public String deleteTask(@PathParam("id") int id) {
          ts.removeTask(id);	
         return ("Task Removed");
		}
	

}
