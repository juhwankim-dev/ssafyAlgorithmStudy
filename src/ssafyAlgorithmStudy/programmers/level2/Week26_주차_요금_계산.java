package programmers;

import java.util.Arrays;
import java.util.TreeMap;

public class Week26_주차_요금_계산 {

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };

		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

		int[] result = solution(fees, records);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] fees, String[] records) {
		Park.BASIC_TIME = fees[0];
		Park.BASIC_CHARGE = fees[1];
		Park.UNIT_TIME = fees[2];
		Park.UNIT_CHARGE = fees[3];

		TreeMap<String, Park> tm = new TreeMap<>();
		for (String record : records) {
			String[] r = record.split(" ");

			if (!tm.containsKey(r[1])) {
				tm.put(r[1], new Park());
			}

			if (r[2].equals("IN")) {
				tm.get(r[1]).parkIn(r[0]);
			} else {
				tm.get(r[1]).parkOut(r[0]);
			}
		}

		int[] result = new int[tm.size()];
		int i = 0;
		for (String key : tm.keySet()) {
			result[i++] = tm.get(key).chargeForParking();
		}

		return result;
	}
}

class Park {
	static int BASIC_TIME;
	static int BASIC_CHARGE;
	static int UNIT_TIME;
	static int UNIT_CHARGE;
	String inTime;
	String outTime;
	int totalTime = 0;

	public void parkIn(String inTime) {
		this.inTime = inTime;
		outTime = "23:59";
	}

	public void parkOut(String outTime) {
		totalTime += convert24ToMin(outTime) - convert24ToMin(inTime);
		inTime = this.outTime = "None";
	}

	private int convert24ToMin(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3, 5));

		return hour * 60 + minute;
	}

	public int getSurcharge() {
		if (totalTime <= BASIC_TIME) {
			return 0;
		} else {
			return (int) Math.ceil((totalTime - BASIC_TIME) / (double) UNIT_TIME) * UNIT_CHARGE;
		}
	}

	public int chargeForParking() {
		if (inTime.equals("None") == false) {
			parkOut("23:59");
		}

		return BASIC_CHARGE + getSurcharge();
	}
}