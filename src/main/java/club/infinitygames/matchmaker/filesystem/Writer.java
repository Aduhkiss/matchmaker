package club.infinitygames.matchmaker.filesystem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	public static String readFile(String name) {
		StringBuilder builder = new StringBuilder();
		try {
			FileReader reader = new FileReader(name);
			int character;
			
			while((character = reader.read()) != -1) {
				builder.append((char) character);
			}
			reader.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static void writeFile(String name, String payload) {
		try {
			FileWriter writer = new FileWriter(name);
			writer.write(payload);
			writer.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void append(String name, String payload) {
		try {
			FileWriter writer = new FileWriter(name, true);
			writer.write(payload);
			writer.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void appendLine(String name, String payload) {
		try {
			FileWriter writer = new FileWriter(name, true);
			writer.write(payload);
			writer.write("\n");
			writer.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
