package club.infinitygames.matchmaker;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.server.Server;

import com.google.gson.Gson;

import club.infinitygames.matchmaker.entity.Profile;
import club.infinitygames.matchmaker.filesystem.Writer;
import club.infinitygames.matchmaker.logging.Loggs;
import club.infinitygames.matchmaker.util.ProfileManager;

public class Main {
	static DiscordApi api;
	static Loggs logger;
	static boolean shouldRun = false;
	public static ListenerManager manager;
	static String TOKEN = "wow leaked this again...";
	public static void main(String[] args) { 
		System.out.println("Starting Match Maker Java...");
		System.out.println("System created by Atticus Zambrana");
		
		// Create the logger
		logger = new Loggs();
		
		if(shouldRun) {
			api = new DiscordApiBuilder()
					.setToken(TOKEN)
					.login()
					.join();
			
			// Create the command manager
			manager = new ListenerManager(api);
			// Register all of the commands into the bot
			manager.registerCommands();
			manager.registerListeners();
		}
		
		Server server = api.getServerById("521606350359363591").get();
		
		if(server == null) {
			System.out.println("ALERT! Match Maker was unable to establish a connection to the Rhythm Server! Shutting down application.");
			System.exit(0);
		}
		
		// Create all the profiles for all users
		ProfileManager.setupStorage(server);
		
		// For debuging reasons, we can print all users currently connected to the server
		//ProfileManager.printAllProfiles();
		
		for(Profile pro : ProfileManager.profiles) {
			System.out.println(pro.asJson());
		}
		
		// Code testing
		Writer.writeFile("testing.txt", "Hello World!");
		
		Writer.append("wow.txt", "Hello");
		Writer.append("wow.txt", " World");
		
		Writer.appendLine("OkThx.txt", "Hello");
		Writer.appendLine("OkThx.txt", "World");
	}
	
	public static DiscordApi getBot() {
		return api;
	}
	
	public static ListenerManager getListenerManager() {
		return manager;
	}
	
	public static Loggs getLogger() {
		return logger;
	}
}
