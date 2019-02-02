package club.infinitygames.matchmaker.listener;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

import club.infinitygames.matchmaker.Main;
import club.infinitygames.matchmaker.settings.MainframeConfig;
import club.infinitygames.matchmaker.util.TimeUtil;

public class WelcomeListener implements ServerMemberJoinListener {
	
	@Override
	public void onServerMemberJoin(ServerMemberJoinEvent ev) {
		ev.getServer().getChannelById(MainframeConfig.DEFAULT_CHANNEL).get().asServerTextChannel().get().sendMessage("Welcome " + ev.getUser().getName() + " to Rhythm Dating!");
		Main.getLogger().info("User " + ev.getUser().getName() + " has entered the server.");
		// Create an EmbedBuilder for the logs
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle("Guild Join Alert!")
				.addField("Username", ev.getUser().getName())
				.addField("Timestamp", TimeUtil.getCurrentTimeDate())
				.setFooter("© 2019 Infinity Game Studios");
		
		ev.getServer().getChannelById(MainframeConfig.LOGS_CHANNEL).get().asServerTextChannel().get().sendMessage(embed);
	}

}
