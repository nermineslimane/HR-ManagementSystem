package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.*;

@Remote
public interface BugServiceRemote {
	public int AddBug(Bug bug);
	public int UpdateBug(Bug bug);
	public Bug getBugById(int id);
	public List<Bug> getAll();
	public void removeBug(int id);
}