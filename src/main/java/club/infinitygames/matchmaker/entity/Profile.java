package club.infinitygames.matchmaker.entity;

import com.google.gson.Gson;

public class Profile {
	String displayName;
	long ID;
	public Profile(String displayName, long ID) {
		this.displayName = displayName;
		this.ID = ID;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public long getID() {
		return ID;
	}
	
	public String asJson() {
		return new Gson().toJson(this);
	}
	
	public String toString() {
		return displayName + " -x- " + ID;
	}
}
