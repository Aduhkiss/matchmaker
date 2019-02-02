package club.infinitygames.matchmaker.command;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class HelpCommand implements MessageCreateListener {
	
	@Override
	public void onMessageCreate(MessageCreateEvent ev) {
		Message message = ev.getMessage();
		if(message.getContent().equalsIgnoreCase("!help")) {
			ev.getChannel().sendMessage("=== MATCH MAKER COMMAND LIST ===");
			ev.getChannel().sendMessage("- !help = Show command list");
			ev.getChannel().sendMessage("- !matchme = Get a random match");
		}
		
		// I am sneaking some logging code in here
	}

}
