package club.infinitygames.matchmaker.util;

import java.util.Collection;
import java.util.Random;

public class ServerUtil {
	public static Object getRandomObject(Collection from) {
		   Random rnd = new Random();
		   int i = rnd.nextInt(from.size());
		   return from.toArray()[i];
	}
}
