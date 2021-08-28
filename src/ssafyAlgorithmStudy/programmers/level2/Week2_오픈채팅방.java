package ssafyAlgorithmStudy.programmers.level2;

import java.util.*;

// 이번에 푼 답
public class Week2_오픈채팅방 {
	public static ArrayList<String> solution(String[] record) {
		ArrayList<String> chatRecord = new ArrayList<>();
		HashMap<String, String> users = new HashMap<>();
		StringTokenizer st;
		
		// 유저 아이디와 이름 입력받기
		for(String r : record) {
			st = new StringTokenizer(r);
			if(!st.nextToken().equals("Leave")) {
				String id = st.nextToken();
				String name = st.nextToken();
				users.put(id, name);
			}
		}
		
		for(String r : record) {
			st = new StringTokenizer(r);
			String command = st.nextToken();
			String name = users.get(st.nextToken());
			if(command.equals("Enter")) {
				chatRecord.add(name + "님이 들어왔습니다.");
			} else if(command.equals("Leave")) {
				chatRecord.add(name + "님이 나갔습니다.");
			}
		}
		
		return chatRecord;
	}
}


// 예전에 풀었던 방법
class 오픈채팅방 {
   public static ArrayList<String> solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        int recordSize = record.length;
        
        // 사용하기 편하게 분리 & 최종 닉네임 구하기
        String[] log = new String[recordSize*3];
        for(int i=0; i<recordSize; i++) {
        	StringTokenizer st = new StringTokenizer(record[i]);
        	
        	log[i*3] = st.nextToken();
        	log[i*3 + 1] = st.nextToken();
        	if(log[i*3].equals("Leave"))
        		continue;
        	
        	log[i*3 + 2] = st.nextToken();
        	map.put(log[i*3 + 1], log[i*3 + 2]);
        }
        
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder(20);
        for(int i=0; i<recordSize; i++) {
        	sb.setLength(0);
        	switch(log[i*3]){
        		case "Enter" :
        			sb.append(map.get(log[i*3  + 1])).append("님이 들어왔습니다.");
        			answer.add(sb.toString());
        			break;
        		case "Leave" :
        			sb.append(map.get(log[i*3  + 1])).append("님이 나갔습니다.");
        			answer.add(sb.toString());
        			break;
        	}
        }
        
        return answer;
    }
}