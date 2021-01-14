package tn.esprit.PidevService.Interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Mission;
import tn.esprit.Pidev_Entities.User;


@Remote
public interface MissionRemoteService {
	public int addMission(Mission m);
	public void deleteMission(int id);
	public void updateMission(Mission m);
	public Mission getMissionById(int id);
	public List<Mission> getAllMission();
	public void participate(int id, User employee);
}
