import java.util.Arrays;

class 양궁대회_01_Solution {
	public static int[] leastnum = new int[11];
	public static int maxnum = Integer.MIN_VALUE;
	public static int[] answer = new int[11];
	
    public int[] solution(int n, int[] info) {
    	/* 일단 해보기 */
    	for (int i=0; i<info.length; i++) leastnum[i] = info[i]+1;
        int[] arr = new int[11];
    	findcase(n, arr);
    	
    	if (Arrays.stream(answer).sum()==0) {
    		answer = new int[1]; answer[0] = -1;
    	}
    	System.out.println("정답은 = "+Arrays.toString(answer));
    	return answer;
    }
    
    public static void findcase(int n, int[] arr) {
    	if (n==0) {
    		int apeach=0, ryon=0;
    		for (int i=10; i>=0; i--) {
    			if ((leastnum[10-i]-1)==0&&arr[10-i]==0) continue;
    			if ((leastnum[10-i]-1)>=arr[10-i]) apeach+=i;
    			else ryon+=i;
    		}
    		System.out.println(Arrays.toString(arr)+" / "+apeach+" / "+ryon);
    		if (ryon>apeach&&(ryon-apeach)>=maxnum) {
    			maxnum = ryon-apeach;
    			System.arraycopy(arr, 0, answer, 0, 11);
    			System.out.println(ryon+" / "+apeach+"   **   "+Arrays.toString(answer));
    		}
    		return;
    	}
    	for (int i=0; i<=10&&arr[i]<=(leastnum[i]-1); i++) {
    		arr[i]++;
    		findcase(n-1, arr);
    		arr[i]--;
    	}
    	
    }
    
    
}
public class 양궁대회_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		양궁대회_01_Solution s = new 양궁대회_01_Solution();
		//s.solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0});
		//s.solution(1, new int[] {1,0,0,0,0,0,0,0,0,0,0});
		//s.solution(9, new int[] {0,0,1,2,0,1,1,1,1,1,1});
		//s.solution(10, new int[] {0,0,0,0,0,0,0,0,3,4,3});
		s.solution(3, new int[] {1,1,1,0,0,0,0,0,0,0,0});

	}

}
