package 백준;

import java.awt.Point;
import java.util.*;

public class 회의실배정_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		/*
		 * 1. 일단 한 개의 회의실 최대한 많은 회의 : 빨리 끝나는 순대로 밀어넣음
		 * 2. 같은 시간에 끝나면 빨리 시작한 애로 밀어넣음
		 */
		
		ArrayList<Point> classline = new ArrayList<Point>();
		for (int i=0; i<N; i++) classline.add(new Point(sc.nextInt(), sc.nextInt()));
		Collections.sort(classline, new Comparator<Point>() {
			@Override
			public int compare(Point o1,Point o2) {
				if (o1.y==o2.y) return o1.x-o2.x;
				else return o1.y-o2.y;
			}
		});
		int time=0, count=0;
		for (int i=0; i<classline.size();i++) {
			if (classline.get(i).x<time) continue;
			time = classline.get(i).y;
			count++;
		}
		System.out.println(count);
		

	}

}
