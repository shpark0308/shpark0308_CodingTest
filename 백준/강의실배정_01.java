package 백준;

import java.util.*;
import java.awt.*;



public class 강의실배정_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Point> classroom = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x==o2.x) return o1.y<o2.y?-1:1; // 끝나는 시간이 먼저인 애들
				return o1.x<o2.x?-1:1;
			}
		});
		for (int i=0; i<N; i++) {
			classroom.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		PriorityQueue<Integer> array = new PriorityQueue<Integer>();
		array.add(0);
		while(!classroom.isEmpty()) {
			Point node = classroom.poll();
			if (array.peek()<=node.x) {
				array.poll();
				array.add(node.y);
			}
			else array.add(node.y);
			System.out.println(array);
		}

	}

}
