package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_42626 {
	/* 더 맵게 */
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 > o2 ? 1: -1;
			}
			
		});
		

		for(int i = 0 ; i < scoville.length;i++) {
			pq.offer(scoville[i]);
		}
		int temp;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(temp >= K) break;
			if(pq.isEmpty()) {
				answer = -1;
				break;
			}
			pq.offer(temp + pq.poll()*2);
			answer++;
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		// 2
		int a = solution(new int[] {1,2,3,9,10,12},7);
		System.out.println(a);
	}
}
