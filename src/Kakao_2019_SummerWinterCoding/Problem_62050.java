package Kakao_2019_SummerWinterCoding;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_62050 {
	int[] dx = { 0, -1, 0, 1 };
	int[] dy = { 1, 0, -1, 0 };
	int[] union;
	
	class Data implements Comparable<Data>{
		int distance;
		int gr1, gr2;
		public Data(int distance, int gr1, int gr2) {
			super();
			this.distance = distance;
			this.gr1 = gr1;
			this.gr2 = gr2;
		}
		@Override
		public int compareTo(Data o) {
			return this.distance - o.distance;
		}
		@Override
		public String toString() {
			return "Data [distance=" + distance + ", gr1=" + gr1 + ", gr2=" + gr2 + "]";
		}
		
		
	}
	public int solution(int[][] land, int height) {
		int answer = 0;
		int I = land.length;
		int J = land[0].length;

		int[][] groups = new int[I][J];
		boolean[][] isvisited = new boolean[I][J];
		int gNum = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (groups[i][j] == 0 && !isvisited[i][j]) {
					isvisited[i][j] = true;
					groups[i][j] = ++gNum;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] data = q.poll();
						for(int k = 0; k <4; k++) {
							int x_ = dx[k] + data[0];
							int y_ = dy[k] + data[1];
							
							if(x_ < 0 || x_ >= I || y_ < 0 || y_ >= J) continue;
							
							int d = land[data[0]][data[1]];
							int dt = land[x_][y_];
							
							if(Math.abs(d-dt) <= height && !isvisited[x_][y_]) {
								isvisited[x_][y_] = true;
								groups[x_][y_] = gNum;
								q.add(new int[] { x_,y_ });
							}
						}
					}
				}
			}
		}
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		union = new int[gNum+1];
		for(int i = 0; i <union.length;i++) union[i] = i;
		
		for(int i = 0; i<I; i++) {
			for(int j = 0; j<J;j++) {
				for(int k = 0; k<4;k++) {
					int x_ = dx[k] + i;
					int y_ = dy[k] + j;
					
					if(x_ < 0 || x_ >= I || y_ < 0 || y_ >= J) continue;
					
					if(groups[i][j] != groups[x_][y_])
						pq.add(new Data(Math.abs(land[i][j] - land[x_][y_]),groups[i][j], groups[x_][y_]));
				}
			}
		}
		
		
		//System.out.println(Arrays.toString(pq.toArray()));
		while(!pq.isEmpty()) {
			Data d = pq.poll();
			
			if(find(d.gr1) != find(d.gr2)) {
				union(d.gr1, d.gr2);
				answer += d.distance;
			}
		}
	
		return answer;
	}
	
	public int find(int x) {
		if(union[x] == x) return union[x];
		else return find(union[x]);
	}
	
	public void union(int x, int y) {
		int r_x = find(x);
		int r_y = find(y);
		
		if(r_x != r_y) union[r_y] = r_x;
	}

	public static void main(String[] args) {
		//int[][] land = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };
		 int[][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2,
		 1}};
		//int height = 3;
		 int height = 1;
		int result = new Problem_62050().solution(land, height);
		// 15 , 18

		System.out.println(result);

	}
}
