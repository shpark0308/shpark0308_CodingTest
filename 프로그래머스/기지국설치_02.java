package ���α׷��ӽ�;

class ��������ġ_02_Solution {
    public int solution(int n, int[] stations, int w) {
    	int location = 1, width = 2*w+1, index=0;
    	
        int answer = 0;
        int l=0;
        while(true) {
        	if (index<stations.length&&location>=(stations[index]-w)) { /* �̰� �´°Ͱ��� */
        		System.out.println("AAAAAAAAAAAAa");
        		location = stations[index]+w;
        		index++;
        	}
        	else {
        		System.out.println("BBBBBBBBBBBBBB");
        		location += width;
            	answer++;
        	}
        	System.out.println("location = "+location+" answer "+answer);
        	l++;
        	if (l==5) break;
        }

        // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
        System.out.println("Hello Java");

        return answer;
    }
}
public class ��������ġ_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		��������ġ_02_Solution s = new ��������ġ_02_Solution();
		//s.solution(11, new int[] {4, 11}, 1);
		s.solution(16, new int[] {9}, 2);

	}

}
