package ���α׷��ӽ�;

class ���̽�ƽ_01_Solution {
    public int solution(String name) {
    	char[] arr = name.toCharArray();
    	int count1=0, temp;
    	int len = arr.length, count2 = len-1;
    	
    	for (int i=0; i<len; i++) {
    		temp = arr[i]<='M'?arr[i]-'A':26-arr[i]+'A';
    		count1+=temp;
    		
    		int next = i+1;
    		while (next<len&&arr[next]=='A') {
    			next++;
    		}
    		count2 = Math.min(count2, 2*i+(len-next));
    	}
        return count1+count2;
    }
}

public class ���̽�ƽ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		���̽�ƽ_01_Solution s = new ���̽�ƽ_01_Solution();
		s.solution("JEROEN");
		s.solution("JAN");

	}

}
