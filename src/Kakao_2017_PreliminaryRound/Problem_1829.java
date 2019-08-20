package Kakao_2017_PreliminaryRound;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1829 {
	/* 문제제목 : 카카오프렌즈 컬러링북 */
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		boolean[][] isvisited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();
		int temp = -1;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!isvisited[i][j] && picture[i][j] > 0) {
					temp = picture[i][j];
					isvisited[i][j] = true;
					numberOfArea += 1;
					q.offer(new int[] { i, j });
					cnt = 1;
				}

				while (!q.isEmpty()) {
					int x = q.peek()[0];
					int y = q.poll()[1];
					for (int k = 0; k < 4; k++) {
						int x_ = x + dx[k];
						int y_ = y + dy[k];
						if (x_ < 0 || y_ < 0 || x_ >= m || y_ >= n)
							continue;
						if (!isvisited[x_][y_] && picture[x_][y_] == temp) {
							isvisited[x_][y_] = true;
							cnt++;
							q.offer(new int[] { x_, y_ });
						}
					}
				}
				if (cnt > maxSizeOfOneArea)
					maxSizeOfOneArea = cnt;
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m,n,arr)));
	}
}
