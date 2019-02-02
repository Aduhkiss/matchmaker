package club.infinitygames.matchmaker.roles;

import java.util.Collection;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import club.infinitygames.matchmaker.util.Sexuality;

public class RoleFinder {
	public static boolean hasRole(User user, Server server, String roleName) {
		Collection<Role> allRoles = user.getRoles(server);
		for(Role r : allRoles) {
			if(r.getName().equalsIgnoreCase(roleName)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean is(User user, Server server, Sexuality sexuality) {
		if(sexuality == Sexuality.STRAIGHT) { if(hasRole(user, server, "Straight")) { return false; } }
		if(sexuality == Sexuality.BISEXUAL) { if(hasRole(user, server, "Bisexual")) { return false; } }
		if(sexuality == Sexuality.GAY) { if(hasRole(user, server, "Gay")) { return false; } }
		if(sexuality == Sexuality.LESBIAN) { if(hasRole(user, server, "Lesbian")) { return false; } }
		if(sexuality == Sexuality.PANSEXUAL) { if(hasRole(user, server, "Pansexual")) { return false; } }
		
		// Shouldn't happen, however if all else fails...
		return false;
	}
}
