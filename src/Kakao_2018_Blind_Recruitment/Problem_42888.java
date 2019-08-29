package Kakao_2018_Blind_Recruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_42888 {
	/* 오픈채팅방 */
	public static String[] solution(String[] record) {
		String[] answer = {};
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> hm = new HashMap<>();
		StringTokenizer st;
		String str;
		for (String rec : record) {
			st = new StringTokenizer(rec, " ");
			str = st.nextToken();
			if (str.equals("Enter")) {
				hm.put(st.nextToken(), st.nextToken());
			} else if (str.equals("Change")) {
				hm.put(st.nextToken(), st.nextToken());
			}
		}
		for (String rec : record) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(rec, " ");
			str = st.nextToken();
			if (str.equals("Enter")) {
				sb.append(hm.get(st.nextToken())).append("님이 들어왔습니다.");
				list.add(sb.toString());
			} else if (str.equals("Leave")) {
				sb.append(hm.get(st.nextToken())).append("님이 나갔습니다.");
				list.add(sb.toString());
			}

		}
		answer = new String[list.size()];
		for(int i = 0 ; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
		solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" });
	}
}
