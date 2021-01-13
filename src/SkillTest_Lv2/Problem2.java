package SkillTest_Lv2;

public class Problem2 {
	public int solution(String s) {
		int Length = s.length();
		int answer = Integer.MAX_VALUE;
		
		if(Length == 1) return 1;
		
		for(int i = 1; i*2<=s.length(); i++) {
			String cmpStr1 = "";
			String result = "";
			int cnt = 1;
			for(int j = 0; j<Length/i; j++) {
				String cmpStr2 = s.substring(i*j, i*j + i);
				if(cmpStr1.equals(cmpStr2)) {
					cnt++;
					continue;
				}
				if(cnt > 1) result += cnt + cmpStr1;
				else result += cmpStr1;
				cmpStr1 = cmpStr2;
				cnt = 1;
			}
			if(cnt > 1) result += cnt + cmpStr1;
			else result += cmpStr1;
			if(s.length() % i != 0) 
				result += s.substring(s.length() - (s.length()%i), s.length());
			answer = Math.min(answer, result.length());
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(new Problem2().solution("ababcdcdababcdcd"));
	}
}
