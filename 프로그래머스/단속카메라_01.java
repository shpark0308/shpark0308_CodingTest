package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

class 단속카메라_01_Solution {
    public int solution(int[][] routes) {
    	Arrays.sort(routes, new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			if (o1[0]==o2[0]) return o1[1]<o2[0]?-1:1;
    			return o1[0]<o2[0]?-1:1;
    		}
		});
    	for (int i=0; i<routes.length;i++) System.out.print(Arrays.toString(routes[i])+" / ");
    	System.out.println();
    	
    	
    	int answer = 0, start=-30000, end = 30000;
    	for (int i=0; i<routes.length;i++) {
    		if (end<routes[i][0]) {
    			System.out.print("3 ");
    			answer++;
    			start = routes[i][0];
    			end = routes[i][1];
    		}
    		else if (start<=routes[i][0]&&routes[i][1]<=end) {
    			System.out.print("1 ");
    			start = routes[i][0];
    			end = routes[i][1];
    		}
    		else if (start<=routes[i][0]&&end<routes[i][1]) {
    			System.out.print("2 ");
    			start = routes[i][0];
    		}
    		System.out.println(Arrays.toString(routes[i])+"  "+start+" / "+end);
    	}
    	if (start<=end) answer++;
    	System.out.println(answer);
        return answer;
    }
}

public class 단속카메라_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		단속카메라_01_Solution s = new 단속카메라_01_Solution();
		//s.solution(new int[][] {{-2,-1}, {1,2},{-3,0}}); // 2
		//s.solution(new int[][] {{0,0}}); // 1
		//s.solution(new int[][] {{0,1}, {0,1}, {1,2}}); // 1
		//s.solution(new int[][] {{0,1}, {2,3}, {4,5}, {6,7}}); // 4
		//s.solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}); // 2
		//s.solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}); // 2
		s.solution(new int[][] {{-20,15}, {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}); // 2

	}

}
