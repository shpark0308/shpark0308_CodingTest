package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Boggle_01 {
	public static int[] go_X = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int[] go_Y = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static String[][] board = new String[4][4];
	public static boolean[][] visited;
	public static Set<String> findanswer = new HashSet<String>();
	public static boolean check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 방문했던 곳을 다시 가면 안됌
		int w = Integer.parseInt(br.readLine());
		ArrayList<String> dictionary = new ArrayList<String>();
		for (int i=0; i<w; i++) dictionary.add(br.readLine());
		Collections.sort(dictionary); // -> 비슷한 애들끼리 찾기 위해
		
		
		br.readLine();
		int b = Integer.parseInt(br.readLine());
		for (int t=0; t<b; t++) { // 총 TestCase 종류
			visited = new boolean[4][4];
			for (int a=0; a<4;a++) {
				String[] str = br.readLine().split("");
				System.arraycopy(str, 0, board[a], 0, 4);
			} // 여러번 찾은 경우에도 1번 찾은 것으로 간주한다.
			
			for (String word : dictionary) {
				/* start point 찾기 */
				check = false;
				for (int p=0; (p<4)&&(!check); p++) {
					for (int q=0; q<4&&(!check); q++) {
						if (board[p][q].equals(word.charAt(0)+"")) {
							visited[p][q] = true;
							dfs(word.charAt(0)+"", word, p,q);
							visited[p][q] = false;
						}
					}
				}
			}
			ArrayList<String> answer = new ArrayList<String>();
			int sum=0, maxlen;
			/* 점수 계산하기 */
			for (String dic : findanswer) {
				sum+=score(dic);
				answer.add(dic);
			}
			Collections.sort(answer, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					if (o1.length()==o2.length()) return o1.compareTo(o2);
					return o1.length()>o2.length()?-1:1;
				}
			});
			maxlen = answer.get(0).length();
			System.out.println(sum+" "+answer.get(0)+" "+findanswer.size());				
			findanswer.clear();
			if (t<(b-1)) br.readLine();
			
		}

	}
	public static void dfs(String current, String target, int cx, int cy) { // 재귀함수 쓰기
		if (current.equals(target)) { // 일단 목적지 작성
			findanswer.add(current);
			check = true;
			return;
		}
		for (int i=0; i<8;i++) {
			int nx = cx + go_X[i];
			int ny = cy + go_Y[i];
			if (nx<0||nx>=4||ny<0||ny>=4||visited[nx][ny]) continue;
			if (board[nx][ny].equals(target.charAt(current.length())+"")) {
				visited[nx][ny] = true;
				dfs(current+board[nx][ny], target, nx, ny);
				visited[nx][ny] = false;
			}
		}
	}
	public static int score(String word) {
		switch(word.length()) {
		case 1: case 2: return 0;
		case 3: case 4: return 1;
		case 5: return 2;
		case 6: return 3;
		case 7: return 5;
		default: return 11;
		}
	}

}
