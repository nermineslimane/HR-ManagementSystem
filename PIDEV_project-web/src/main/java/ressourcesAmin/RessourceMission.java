package ressourcesAmin;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.PidevService.Impl.MissionService;
import tn.esprit.Pidev_Entities.Mission;

@Path("mission")
@RequestScoped
public class RessourceMission {

	/*@EJB 
	MissionService missionServise;

	
	@DELETE
	@Path("delete/{id}")
    public String deleteMission(@PathParam("id") int id) {
		
		missionServise.deleteMission(id); 
		return (" supprimé avec succés");

		}
	
	@GET
	@Path("liste")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployes() {
		return Response.ok(missionServise.getAllMission()).build();
	}
	
	@POST
	@Path("ajouter")
	@Consumes("application/xml")
	public String addMission(Mission m) {
		
		missionServise.addMission(m);
			return ("Ajout avec succés");	
	}
	@PUT
	@Path("update")
	@Consumes("application/xml")
	public String updateMission(Mission m) {
		missionServise.updateMission(m);
			return ("Modidié avec succés");
		
		}


	
	*/
}
