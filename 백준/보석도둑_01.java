package 백준;

import java.util.*;
import java.io.*;
import java.awt.*;

public class 보석도둑_01 {
	public static int N, K;
	public static ArrayList<Point> jewelry = new ArrayList<Point>();
	public static Queue<Integer> baglist = new PriorityQueue<Integer>();
	
	public static Queue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			return o1.y>o2.y?-1:1; // 무게 순으로 정렬하기
		}
	});
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]); K = Integer.parseInt(str[1]);
		
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			jewelry.add(new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		
		Collections.sort(jewelry, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if (o1.x==o2.x) return o2.y - o1.y;
				return o1.x-o2.x;
			}
		});
		
		for (int i=0; i<K; i++) baglist.add(Integer.parseInt(br.readLine()));
		
		System.out.println(jewelry);
		System.out.println(baglist);
		
		long sum = 0;
		int i=0;

		while(!baglist.isEmpty()) {
			int bag_weight = baglist.poll();
			
			for (; i<jewelry.size()&&jewelry.get(i).x<=bag_weight;i++) { // queue에 담기
				queue.add(jewelry.get(i));
			}
			if (queue.isEmpty()) continue;
			System.out.println(">> "+queue);
			Point jewel = queue.poll();
			
			sum+=jewel.y;
			System.out.println(bag_weight+" / "+jewel+" "+sum);
		}
		
		System.out.println(sum);
	}

}
