package 프로그래머스;

import java.util.*;
import java.util.stream.Collectors;

class 단어변환_Solution {
	int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
    	int[] visited = new int[words.length];
    	dfs(begin, target, 0, visited, words);
    	System.out.println("ANSWER = "+answer);
    	if (answer==Integer.MAX_VALUE) answer=0;
        return answer;
    }
    public void dfs(String word, String target, int level, int[] visited, String[] words) {
    	System.out.println(word+" / "+level+" / "+Arrays.toString(visited));
    	if (word.equals(target)) {
    		answer = Math.min(answer, level);
    		return;
    	}
    	for (int i=0; i<words.length;i++) {
    		if (visited[i]==0&&compare(word, words[i])) {
    			visited[i]=1;
    			dfs(words[i], target, level+1, visited, words);
    			visited[i]=0;
    		}
    	}
    }
    public boolean compare(String str1, String str2) {
    	if (str1.length()!=str2.length()) return false;
    	int count=0;
    	for (int i=0; i<str1.length();i++) {
    		if (!(str1.charAt(i)+"").equals(str2.charAt(i)+"")) count++;
    		if (count>1) break;
    	}
    	if (count==1) return true;
    	else return false;
    	
    }
}

public class 단어변환_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 일단 해보기 */
		단어변환_Solution s = new 단어변환_Solution();
		//s.solution("aaa", "aab", new String[] {"hhh","hht"});
		s.compare("adaa", "aacb");

	}

}
