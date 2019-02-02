package club.infinitygames.matchmaker.command;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import club.infinitygames.matchmaker.roles.RoleFinder;
import club.infinitygames.matchmaker.util.ServerUtil;
import club.infinitygames.matchmaker.util.Sexuality;

public class MatchMeCommand implements MessageCreateListener {
	@Override
	public void onMessageCreate(MessageCreateEvent ev) {
		Message message = ev.getMessage();
		if(message.getContent().equalsIgnoreCase("!matchme")) {
			User match = getRandomUser(ev);
			ev.getChannel().sendMessage(ev.getMessage().getAuthor().getDisplayName() + ", your match was " + match.getName() + "!");
		}
	}
	
	// Get a random user on the discord server who is not a bot
	
	// Here is the main algorithem that we need to work on
	public User getRandomUser(MessageCreateEvent ev) {
		User u = (User) ServerUtil.getRandomObject(ev.getMessage().getServer().get().getMembers());
		if(u.isBot()) {
			return getRandomUser(ev);
		}
		
		// You have to have Male or Female Tags to get flagged by the algorithm
		if(RoleFinder.hasRole(u, ev.getServer().get(), "Male") || RoleFinder.hasRole(u, ev.getServer().get(), "Female")) {
			// Ok
		}
		else {
			return getRandomUser(ev);
		}
		
		// Check if the user is gay
		if(RoleFinder.is(u, ev.getServer().get(), Sexuality.GAY)) {
			if(!RoleFinder.is(ev.getMessage().getAuthor().asUser().get(), ev.getServer().get(), Sexuality.GAY)) {
				return getRandomUser(ev);
			}
		}
		
		if(RoleFinder.is(u, ev.getServer().get(), Sexuality.LESBIAN)) {
			if(!RoleFinder.is(ev.getMessage().getAuthor().asUser().get(), ev.getServer().get(), Sexuality.LESBIAN)) {
				return getRandomUser(ev);
			}
		}
		
		if(RoleFinder.hasRole(u, ev.getServer().get(), "Single") || RoleFinder.hasRole(u, ev.getServer().get(), "Looking")) {
			// Ok, keep going
		}
		else {
			return getRandomUser(ev);
		}
		
		// Do our final algorithm checks
		// If I am a straight male, only flag other straight females
		if(RoleFinder.hasRole(ev.getMessageAuthor().asUser().get(), ev.getServer().get(), "Male") && RoleFinder.hasRole(ev.getMessageAuthor().asUser().get(), ev.getServer().get(), "Straight")) {
			if(RoleFinder.hasRole(u, ev.getServer().get(), "Male")) {
				return getRandomUser(ev);
			}
		}
		if(RoleFinder.hasRole(ev.getMessageAuthor().asUser().get(), ev.getServer().get(), "Female") && RoleFinder.hasRole(ev.getMessageAuthor().asUser().get(), ev.getServer().get(), "Straight")) {
			if(RoleFinder.hasRole(u, ev.getServer().get(), "Female")) {
				return getRandomUser(ev);
			}
		}
		return u;
	}
}
