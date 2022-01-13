package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class 회의실 implements Comparable<회의실>{
	int start, end;
	public 회의실(int start, int end) {
		this.start = start; this.end = end;
	}
	@Override
	public int compareTo(회의실 o) {
		if (this.end==o.end) return this.start<o.start?-1:1;
		return this.end<o.end?-1:1;
	}

}
public class 회의실배정_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<회의실> queue = new PriorityQueue<회의실>();
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			queue.add(new 회의실(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		int count=0, time=0;
		while(!queue.isEmpty()) {
			회의실 node = queue.poll();
			if (node.start>=time) {
				time = node.end;
				count++;
			}
		}
		System.out.println(count);
		
		

	}

}
