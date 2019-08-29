package Kakao_2017_PreliminaryRound;

public class Problem_1831 {
	/* 4단고음 */
	static int answer;
	public static int solution(int n) {
	      answer = 0;
	      dfs(n, 0);
	      
	      System.out.println(answer);
	      return answer;
	}
	
	public static void dfs(int n, int cnt) {
		if(n == 1) {
			if(cnt == 0) answer++;
			return;
		} else {
			int a = n;
			int b = 0;
			while(a/3 >= 1) {
				a/=3;
				b++;
			}
			if(b < cnt/2) return;
			if(cnt - 2 >= 0 && n%3 == 0) dfs(n/3,cnt-2);
			dfs(n-1, cnt+1);
		}
	}
	
	public static void main(String[] args) {
		solution(15); // 1 : *+*+++
		solution(24); // 0
		solution(41); // 2 : **++++*++, *+**+++++
		solution(2147483647); // 1735
	}
}
