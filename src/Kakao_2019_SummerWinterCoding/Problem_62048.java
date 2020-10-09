package Kakao_2019_SummerWinterCoding;

public class Problem_62048 {
	 public long solution(int w, int h) {
	        long answer = 0;
	        long w_ = w;
	        long h_ = h;
	        long a = w_ >= h_ ? w_ : h_;
	        long b = w_ >= h_ ? h_ : w_;
	         while(b > 0) {
	            long tmp = a;
	            a = b;
	            b = tmp%b;
	        }
	        
	        answer = w_*h_ - (w_+h_ - a);
	        return answer;
	    }
	 
	public static void main(String[] args) {
		// 최대공약수가 1일때, 1이 아닐때에서 공식 유도
		System.out.println(new Problem_62048().solution(12, 8));
	}
}