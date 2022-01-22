package programmers;

import java.util.Arrays;

public class Week19_구명보트 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int solo = 0;
		int couple = 0;
		int idx = people.length;
		int i = 0;

		while (i < idx--) {
			if (people[i] + people[idx] > limit) {
				solo++;
			} else {
				couple++;
				i++;
			}
		}

		return solo + couple;
	}
}
