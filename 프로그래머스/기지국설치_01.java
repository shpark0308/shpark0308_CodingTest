package ���α׷��ӽ�;

class ��������ġ_01_Solution {
    public int solution(int n, int[] stations, int w) {
    	int lastindex = 0, answer = 0;
    	int width = 2*w+1;
    	for (int i=0; i<=stations.length; i++) {
    		if (i==stations.length&&lastindex<n) {
    			int temp = n-(lastindex);
    			int rest = temp%width!=0?temp/width+1:temp/width;
    			answer+=rest;
    			System.out.println("answer = "+answer);
    		}
    		else if (i<stations.length){
    			int temp = stations[i]-lastindex-1-w;
    			int rest = temp%width!=0?temp/width+1:temp/width;
    			answer+=rest;
    			System.out.println("answer = "+answer);
    			lastindex = stations[i]+w;
    		}
    	}
    	System.out.println("���� answer = "+answer);


        // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
        System.out.println("Hello Java");

        return answer;
    }
}

public class ��������ġ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* �ϴ� �غ��� */
		��������ġ_01_Solution s = new ��������ġ_01_Solution();
		//s.solution(11, new int[] {4,11}, 1);
		s.solution(16, new int[] {9}, 2);

	}

}
