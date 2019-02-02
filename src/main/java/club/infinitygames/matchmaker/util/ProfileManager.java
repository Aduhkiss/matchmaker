package club.infinitygames.matchmaker.util;

import java.util.ArrayList;
import java.util.List;

import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import club.infinitygames.matchmaker.entity.Profile;

public class ProfileManager {
	public static List<Profile> profiles = new ArrayList<Profile>();
	
	public static void printAllProfiles() {
		for(Profile pro : profiles) {
			System.out.println(pro.toString());
		}
	}
	
	public static void setupStorage(Server server) {
		// When the system starts, we will be creating profiles for all users online and saving them in ram
		for(User u : server.getMembers()) {
			profiles.add(new Profile(u.getName(), u.getId()));
		}
	}

}
