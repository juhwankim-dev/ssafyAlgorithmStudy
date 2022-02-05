package programmers;

import java.util.ArrayList;

public class Week20_Ä³½Ã {
	
	public static int solution(int cacheSize, String[] cities) {
		int time = 0;

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		ArrayList<String> cache = new ArrayList<>();

		for (String city : cities) {
			city = city.toUpperCase();
			if (cache.contains(city)) {
				time++;
				cache.remove(city);
				cache.add(city);
			} else {
				time += 5;

				if (cache.size() == cacheSize) {
					cache.remove(0);
				}
				cache.add(city);
			}
		}

		return time;
	}

}
