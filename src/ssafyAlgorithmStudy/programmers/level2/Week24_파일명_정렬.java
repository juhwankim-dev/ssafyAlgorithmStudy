package programmers;

import java.util.Arrays;

public class Week24_파일명_정렬 {
	public String[] solution(String[] files) {
		File[] sortedFile = new File[files.length];
		for (int i = 0; i < files.length; i++) {
			String[] divided = divideFileName(files[i]);
			sortedFile[i] = new File(divided[0], divided[1], divided[2]);
		}
		Arrays.sort(sortedFile);

		String[] sortedName = new String[files.length];
		for (int i = 0; i < sortedName.length; i++) {
			sortedName[i] = sortedFile[i].toString();
		}

		return sortedName;
	}

	public static String[] divideFileName(String name) {
		String[] divided = new String[3];
		StringBuilder head = new StringBuilder();
		StringBuilder number = new StringBuilder();
		StringBuilder tail = new StringBuilder();

		int idx = 0;
		char ch = name.charAt(idx++);

		while (!Character.isDigit(ch)) {
			head.append(ch);
			ch = name.charAt(idx++);
		}
		divided[0] = head.toString();

		while (Character.isDigit(ch)) {
			number.append(ch);

			if (idx == name.length()) {
				divided[1] = number.toString();
				divided[2] = " ";
				return divided;
			}
			ch = name.charAt(idx++);
		}
		divided[1] = number.toString();

		while (idx < name.length()) {
			tail.append(ch);
			ch = name.charAt(idx++);
		}
		tail.append(ch);
		divided[2] = tail.toString();

		return divided;
	}
}

class File implements Comparable<File> {
	String head;
	String number;
	String tail;

	public File(String head, String number, String tail) {
		this.head = head;
		this.number = number;
		this.tail = tail;
	}

	@Override
	public int compareTo(File o) {
		String head1 = this.head.toUpperCase();
		String head2 = o.head.toUpperCase();
		
		int headCompareVal = head1.compareTo(head2);
		if (headCompareVal == 0) {
			return Integer.parseInt(this.number) - Integer.parseInt(o.number);
		}

		return headCompareVal;
	}

	public String toString() {
		return head + number + tail;
	}
}
