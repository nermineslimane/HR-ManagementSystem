package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.*;

@Local
public interface BugServiceLocal {
	public int AddBug(Bug bug);
	public int UpdateBug(Bug bug);
	public Bug getBugById(int id);
	public List<Bug> getAll();
	public void removeBug(int id);
	
}