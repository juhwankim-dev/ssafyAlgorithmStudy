package ssafyAlgorithmStudy.programmers.level2;

// 이번에 푼 답
public class Week2_문자열_압축 {
	static String compressedStr = "";

	public static int solution(String s) {
		int result = Integer.MAX_VALUE;

		for (int i = 1; i <= s.length() / 2; i++) {
			compressedStr = "";
			recurive(s, s.substring(0, i), i, 1);
			result = Math.min(result, compressedStr.length());
		}

		return (s.length() == 1) ? 1 : result;
	}

	public static void recurive(String s, String unit, int size, int cnt) {
		if (s.length() < size) {
			if (cnt > 1) compressedStr += cnt + unit;
			compressedStr += s;
			return;
		}

		String newStr = s.substring(size, s.length());
		String newUnit = (newStr.length() >= size) ? newStr.substring(0, size) : "";

		if (unit.equals(newUnit)) {
			recurive(newStr, unit, size, cnt + 1);
		} else {
			if (cnt > 1) compressedStr += cnt;
			compressedStr += unit;
			recurive(newStr, newUnit, size, 1);
		}
	}
}

// 예전에 풀었던 답
class 문자열_압축 {
    public static int solution(String s) {
        if(s.length() == 1) return 1;

        int min = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        StringBuilder compressedStr = new StringBuilder();
        String unit;

        for(int i=1; i<=s.length()/2; i++) { // 몇개의 단위로 잘라 압축할건지
            str.append(s);
            String pattern = "";
            int cnt=1;

            while(str.length() >= i) { // 더이상 자를 str이 없을 때까지 반복
                // 문자열 자르기
                unit = str.substring(0, i);
                str.delete(0, i);

                // 다음 문자열이 현재 패턴과 같다면
                if(unit.equals(pattern)) {
                    cnt++; // 카운트
                } else { // 같지 않다면
                    if(cnt != 1) {
                        compressedStr.append(cnt); // 숫자를 넣고
                        cnt = 1; // 숫자 초기화
                    }
                    compressedStr.append(unit); // 패턴을 넣고
                    pattern = unit; // 패턴 변경
                }
            }

            // 숫자를 못넣고 while문이 끝나는 경우를 위해
            if(cnt != 1) {
                compressedStr.append(cnt);
            }

            // 남은 문자열이 단위보다 작아서 남은 경우를 위해
            compressedStr.append(str.substring(0, str.length()));

            min = Math.min(min, compressedStr.length());
            compressedStr.setLength(0);
            str.setLength(0);
        }

        return min;
    }
}

