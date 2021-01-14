package ressourceskacem;

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
import tn.esprit.PidevService.Impl.EvaluationService;
import tn.esprit.Pidev_Entities.Evaluation;

@Path("evaluations")
@SessionScoped
public class evaluationRessources {

	@EJB 
	EvaluationService evaluationServise;
		@GET
		@Path("liste")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAllEvaluations() {
			return Response.ok(evaluationServise.getAllEvaluations()).build();
		}
		
		@POST
		@Path("add")
		@Consumes("application/xml")
		public String ajouterEvaluation(Evaluation e) {
			
			evaluationServise.ajouterEvaluation(e);
				return ("evaluation ajouté");	
		}
		@PUT
		@Path("update")
		@Consumes("application/xml")
		public String modifierEvaluation(Evaluation e) {
				evaluationServise.updateEvaluation(e);
				return ("evaluation modifié");
			
			}
		@DELETE
		@Path("delete/{id}")
	    public String removeEvaluation(@PathParam("id") int id) {
			
			evaluationServise.deleteEvaluationById(id);
			return ("evaluation supprimé");

			}

}
