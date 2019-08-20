package Kakao_2017_PreliminaryRound;

public class Problem_1832 {
	static int MOD = 20170805;

	public static int solution(int m, int n, int[][] cityMap) {

		int[][] below = new int[m][n];
		int[][] right = new int[m][n];
		int a = 1;
		
		for (int i = 1; i < m; i++) {
			if (cityMap[i][0] == 1)
				a = 0;
			below[i][0] = a;
		}
		a = 1;
		for (int j = 1; j < n; j++) {
			if (cityMap[0][j] == 1)
				a = 0;
			right[0][j] = a;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (cityMap[i - 1][j] == 0) {
					below[i][j] += (below[i-1][j]+right[i-1][j])%MOD;
					below[i][j] %= MOD;

				} else if (cityMap[i - 1][j] == 2) {
					below[i][j] += below[i-1][j];
					below[i][j] %= MOD;
				}

				if (cityMap[i][j-1] == 0) {
					right[i][j] += (below[i][j-1]+right[i][j-1])%MOD;
					right[i][j] %= MOD;
				} else if (cityMap[i][j-1] == 2) {
					right[i][j] += right[i][j-1];
					right[i][j] %= MOD;
				}
			}
		}
		
		int answer = below[m - 1][n - 1] + right[m - 1][n - 1];
		return answer % MOD;
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 6;
		
		int[][] city_map = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		System.out.println(solution(m, n, city_map));
	}
}
