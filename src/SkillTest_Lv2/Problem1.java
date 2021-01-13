package SkillTest_Lv2;

public class Problem1 {

	static public int solution(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		int number = 0;
		int a = 0; int b = 1;
		
		for(int i = 1; i<=n; i++) {
			number = (a + b) % 1234567;
			b = a;
			a = number;
		}
		
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(100));
	}
}
