package club.infinitygames.matchmaker;

import org.javacord.api.DiscordApi;

import club.infinitygames.matchmaker.command.HelpCommand;
import club.infinitygames.matchmaker.command.MatchMeCommand;
import club.infinitygames.matchmaker.listener.WelcomeListener;

public class ListenerManager {
	DiscordApi discordApi;
	
	public ListenerManager(DiscordApi discordApi) {
		this.discordApi = discordApi;
	}
	
	public void registerCommands() {
		// Register all commands here
		discordApi.addListener(new HelpCommand());
		discordApi.addListener(new MatchMeCommand());
	}
	
	public void registerListeners() {
		discordApi.addListener(new WelcomeListener());
	}
}
