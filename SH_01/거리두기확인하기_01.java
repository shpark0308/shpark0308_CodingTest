
import java.util.*;
import java.awt.*;

class �Ÿ��α�Ȯ���ϱ�_01_Solution {
	public static int[] indexarr = { 0, 1, 2, 1, 0 };
	/* backtracking���� Ǯ�� */
    public int[] solution(String[][] places) {

        int[] answer = {};
        return answer;
    }
    public void isCheck(Point point, String[][] places) {
    	for (int a=(point.x-2), index = 0; a<=(point.x+2); a++, index++) {
    		if (a<0||a>=5) continue;
    		for (int b=(point.y-indexarr[index]); b<=(point.y+indexarr[index]); b++) {
    			if (a<0||a>=5||b<0||b>=5) continue;
    			if (a==point.x&&b==point.y) continue;
    			if (places[a][b].equals("P")) {
    				
    			}
    		}
    	}
    }
}
public class �Ÿ��α�Ȯ���ϱ�_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		�Ÿ��α�Ȯ���ϱ�_01_Solution s = new �Ÿ��α�Ȯ���ϱ�_01_Solution();
		s.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});

	}

}
