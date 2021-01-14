package ressourscesIheb;

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
import tn.esprit.Pidev_Entities.Role;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Entities.User;

@Path("users")
@SessionScoped
public class UserRessource {
@EJB 
EmployeService employeServise;
	@GET
	@Path("liste")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployes() {
		return Response.ok(employeServise.getAllUser()).build();
	}
	@GET
	@Path("login/{cin}/{motdp}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("cin") String cin,@PathParam("motdp") String motdp) {
		return Response.ok(employeServise.getUserByEmailAndPassword(cin, motdp)).build();

	}
	
	@POST
	@Path("add/{cin}/{nom}/{prenom}/{adresseMail}/{motdp}/{photo}/{cv}/{ville}/{tel}/{solde_conge}/{solde_absence}/{salaire}/{role}/{specialite}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String ajouterEmploye(@PathParam("cin") String cin,@PathParam("nom") String nom,@PathParam("prenom") String prenom,@PathParam("adresseMail") String adresseMail,
			@PathParam("motdp") String motdp, @PathParam("photo") String photo,@PathParam("cv") String cv,@PathParam("ville") String ville,
			@PathParam("tel") String tel,@PathParam("solde_conge") int solde_conge,@PathParam("solde_absence") int solde_absence,@PathParam("salaire") Double salaire,
			@PathParam("role") Role role,@PathParam("specialite") Specialite specialite) {
		System.out.println("tttttttttttttt");
		User u =new User(cin, nom, prenom, adresseMail, motdp, photo, cv, ville, tel,solde_conge,solde_absence,salaire,role,specialite);
	employeServise.ajouterUser(u);
			return ("employé ajouté");	
	}
	
	@PUT
	@Path("update")
	@Consumes("application/xml")
	public String modifierEmploye(User user) {
			employeServise.updateUser(user);
			return ("employé modifié");
		
		}
	@DELETE
	@Path("delete/{id}")
    public String removeEmploye(@PathParam("id") int id) {
		
		employeServise.deleteUserById(id); 
		return ("employé supprimé");

		}

}
