package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class ȸ�ǽ� implements Comparable<ȸ�ǽ�>{
	int start, end;
	public ȸ�ǽ�(int start, int end) {
		this.start = start; this.end = end;
	}
	@Override
	public int compareTo(ȸ�ǽ� o) {
		if (this.end==o.end) return this.start<o.start?-1:1;
		return this.end<o.end?-1:1;
	}

}
public class ȸ�ǽǹ���_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<ȸ�ǽ�> queue = new PriorityQueue<ȸ�ǽ�>();
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			queue.add(new ȸ�ǽ�(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		int count=0, time=0;
		while(!queue.isEmpty()) {
			ȸ�ǽ� node = queue.poll();
			if (node.start>=time) {
				time = node.end;
				count++;
			}
		}
		System.out.println(count);
		
		

	}

}
