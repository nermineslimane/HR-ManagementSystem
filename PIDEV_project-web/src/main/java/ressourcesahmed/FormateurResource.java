package ressourcesahmed;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import tn.esprit.Pidev_Services.AffectationService;
import tn.esprit.Pidev_Services.FormateurService;
import tn.esprit.Pidev_Services.FormationService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.Pidev_Entities.Disponible;
import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Entities.Formation;
import tn.esprit.Pidev_Entities.Specialite;

import javax.ws.rs.Produces; 

@Path("formateur")
@SessionScoped
public class FormateurResource {
	@EJB
	FormationService formationService;
	@EJB
	FormateurService formateurService;
@EJB
AffectationService aff;
	@GET
	@Path("liste")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFormateur() {
		return Response.ok(formateurService.getAllFormateurs()).build();
	}
	@GET
	@Path("listeaff")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(aff.getAllAffectation()).build();
	}
	@GET
	@Path("listefor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFormation() {
		return Response.ok(formationService.getAllFormation()).build();
	}

	@POST
	@Path("add")
	@Consumes("application/xml")
	public String ajouterFormateur(Formateur f) {
		System.out.println("ahmeddddddddddddddddddddddddddddddddddddd1");
		formateurService.ajouterFormateur(f);
		System.out.println("ahmeddddddddddddddddddddddddddddddddddddd2");

			return ("Formateur ajouté");

		
	}
	@POST
	@Path("add/{nom}/{prenom}/{email}/{numero}/{Disponible}/{Specialite}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String ajouterEmploye(
			@PathParam("nom") String nom,
			@PathParam("prenom") String prenom,
			@PathParam("email") String email,
			@PathParam("numero") String numero,
			@PathParam("Disponible") Disponible Disponible,
			@PathParam("Specialite") Specialite Specialite
			)
	{
		System.out.println("tttttttttttttt");
		Formateur ft =new Formateur( nom, prenom,email,numero,Disponible,Specialite);
	formateurService.ajouterFormateur(ft);
			return ("Formateur ajouté");	
	}
	
	@PUT
	@Path("update")
	@Consumes("application/xml")
	public String modifierFormation(Formation f) {
		formationService.modifierFormation(f);
			return ("Formateur modifié");
		
		}

//	@POST
//	@Path("update/{id}/{nom}/{prenom}/{email}/{numero}/{Disponible}/{Specialite}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String modifierEmploye(
//			@PathParam("id") int id,
//			@PathParam("nom") String nom,
//			@PathParam("prenom") String prenom,
//			@PathParam("email") String email,
//			@PathParam("numero") String numero,
//			@PathParam("Disponible") Disponible Disponible,
//			@PathParam("Specialite") Specialite Specialite
//			)
//	{
//		System.out.println("tttttttttttttt");
//		Formateur ft =new Formateur( id,nom, prenom,email,numero,Disponible,Specialite);
//	formateurService.modifierFormateur(ft);
//			return ("Formateur modifier");	
//	}
	
	@DELETE
	@Path("delete/{id}")
    public String removeFormateur(@PathParam("id") int id) {
		
		formateurService.SupprimerFormateur(id); 
		return ("Formateur supprimé");

		}
	
	
	
}
