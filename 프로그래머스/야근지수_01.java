package ���α׷��ӽ�;

import java.util.*;

class �߱�����_01_Solution {
    public long solution(int n, int[] works) {
    	/* �ϴ� �ϱ� */
    	int[] array;
    	int index = 0;
    	long answer = 0;
    	if (Arrays.stream(works).sum()<=n) {
    		answer = 0;
    		System.out.println(answer);
    	}
    	else {
    		while(n>0) {
        		int average = Arrays.stream(works).sum() / works.length; // 1. ��� �� �κ��� ��� ���ص� ��
        		Arrays.sort(works);
        		array = Arrays.copyOf(works, works.length);
        		int subtractsum = 0;
        		System.out.println("N = "+n+" AVERAGE = "+average);
        		for (int a=works.length-1; a>=0&&works[a]>average;a--) {
        			subtractsum+=(works[a]-average);
        			array[a] = average;
        		}
        		if (subtractsum==0||subtractsum>n) { /* ��� �Ȱ��� ��� */
        			array = Arrays.copyOf(works, works.length);
        			index = array.length-1;
        			while(n>0) {
        				if (array[index]>=average) {
        					array[index]-=1;
        					n-=1;
        					System.out.println(Arrays.toString(array)+" / N = "+n);
        				}
        				index--;
        				if (index<0) {
        					average = Arrays.stream(array).sum() / works.length;
        					index = array.length-1;
        				}
        			}
        		}
        		else {
        			n-=subtractsum;
        		}
        		works = Arrays.copyOf(array, array.length);
        		System.out.println(Arrays.toString(works));
        		if (index++==4) break;
        		
        	}
        	System.out.println("���� : "+Arrays.toString(works));
        	for (int i=0; i<works.length;i++) {
        		answer+=(long)Math.pow(works[i], 2);
        	}
    	}
    	System.out.println("ANSWER = "+answer);
        return answer;
    }
}
public class �߱�����_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		�߱�����_01_Solution s = new �߱�����_01_Solution();
		//s.solution(4, new int[] {4,3,3});
		//s.solution(1, new int[] {2,1,2});
		//s.solution(3, new int[] {1,1});
		//s.solution(99, new int[] {2,15,22,55,55});
		//s.solution(15, new int[] {11,5,3,2,1});
		s.solution(2, new int[] {1,1,99});

	}

}
