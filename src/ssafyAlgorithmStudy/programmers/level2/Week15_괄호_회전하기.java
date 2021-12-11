package programmers;

import java.util.*;

public class Week15_괄호_회전하기 {

    public static int solution(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            cnt += isRight(s.substring(i, s.length()) + s.substring(0, i)) ? 1 : 0;
        }
        
        return cnt;
    }

    public static boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            } else if(ch == '}') {
                if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            } else if(ch == ']') {
                if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            } else {
                stack.add(ch);
            }
        }
        
        return stack.isEmpty();
    }
}
