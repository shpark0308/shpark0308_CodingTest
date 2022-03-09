import java.util.Arrays;

class DevMatching_01_Solution {
    public int[] solution(String[] purchase) {
    	long[] calen = new long[366];
    	int[] month = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
    	for (int i=0; i<purchase.length; i++) {
    		String[] str1 = purchase[i].split(" ");
    		String[] str2 = str1[0].split("/");
    		int money = Integer.parseInt(str1[1]);
    		
    		int start_time = month[Integer.parseInt(str2[1])-1]+Integer.parseInt(str2[2]);
    		int end_time = start_time+30;
    		
    		for (int time = start_time ; time<end_time; time++) calen[time]+=money;
    	}
    	
    	int[] answer = new int[5];
    	for (int i=1; i<366; i++) answer[calc(calen[i])]++;
    	System.out.println(Arrays.toString(answer));
    	
    	
        return answer;
    }
    
    public int calc(long num) {
    	if (num>=0&&num<10000) return 0;
    	else if (num<20000) return 1;
    	else if (num<50000) return 2;
    	else if (num<100000) return 3;
    	else return 4;
    }
}

public class DevMatching_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DevMatching_01_Solution s = new DevMatching_01_Solution();
		s.solution(new String[] {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"});
		s.solution(new String[] {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"});
		//315, 9, 11, 20,10
		//245, 30, 30, 30, 30

	}

}
