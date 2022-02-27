package programmers;

public class Week22_��ųƮ�� {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String reg = "[^" + skill +"]";
        
    	for(String tree : skill_trees) {
        	String temp = tree.replaceAll(reg, "");
    		
        	if(temp.isEmpty() || skill.contains(temp)) {
        		answer++;
        	}
    	}
    	
    	return answer;
    }
}
