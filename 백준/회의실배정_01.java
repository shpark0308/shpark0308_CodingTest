package ����;

import java.awt.Point;
import java.util.*;

public class ȸ�ǽǹ���_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		/*
		 * 1. �ϴ� �� ���� ȸ�ǽ� �ִ��� ���� ȸ�� : ���� ������ ����� �о����
		 * 2. ���� �ð��� ������ ���� ������ �ַ� �о����
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
