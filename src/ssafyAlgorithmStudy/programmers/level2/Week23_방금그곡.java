package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Week23_¹æ±Ý±×°î {
	static HashMap<String, String> hs = new HashMap<>();

	public static String solution(String m, String[] musicinfos) {
		hs.put("A#", "H");
		hs.put("C#", "I");
		hs.put("D#", "J");
		hs.put("F#", "K");
		hs.put("G#", "L");

		String keyword = changePound(m);
		ArrayList<Music> list = new ArrayList<>();
		int index = 0;

		for (String s : musicinfos) {
			String[] info = s.split(",");
			String fullSong = changePound(info[3]);

			int diffMin = getDiffMin(info[0], info[1]);
			int replayCnt = diffMin / fullSong.length();

			StringBuilder sb = new StringBuilder();
			if (fullSong.length() > diffMin) {
				sb.append(fullSong.substring(0, diffMin));
			} else {
				for (int i = 0; i < replayCnt; i++) {
					sb.append(fullSong);
				}
				sb.append(fullSong.substring(0, diffMin % fullSong.length()));
			}

			if (sb.toString().contains(keyword)) {
				list.add(new Music(info[2], diffMin, index++));
			}
		}

		Collections.sort(list);

		return list.size() == 0 ? "(None)" : list.get(0).title;
	}

	public static int getDiffMin(String time1, String time2) {
		String[] start = time1.split(":");
		String[] end = time2.split(":");

		int s0 = Integer.parseInt(start[0]);
		int s1 = Integer.parseInt(start[1]);
		int e0 = Integer.parseInt(end[0]);
		int e1 = Integer.parseInt(end[1]);

		return (e0 * 60 + e1) - (s0 * 60 + s1);
	}

	public static String changePound(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				String changed = hs.get(s.charAt(i - 1) + "#");
				sb.deleteCharAt(sb.length() - 1);
				sb.append(changed);
			} else {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}
}

class Music implements Comparable<Music> {
	String title;
	int playTime;
	int index;

	public Music(String title, int playTime, int index) {
		this.title = title;
		this.playTime = playTime;
		this.index = index;
	}

	@Override
	public int compareTo(Music m) {
		if (m.playTime == this.playTime) {
			return this.index - m.index;
		}

		return m.playTime - this.playTime;
	}
}