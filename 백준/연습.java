package ��������;

import java.awt.Point;
import java.util.HashMap;

public class ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(1,2);
		HashMap<Point, Integer> hashmap = new HashMap<Point, Integer>();
		hashmap.put(p1, 1);
		Point p2 = new Point(1,2);
		if (hashmap.containsKey(p2)) {
			System.out.println("�� ����");
			hashmap.put(p2, hashmap.get(p1)+1);
		}
		else {
			System.out.println("���� Ʋ���� �ν��ϳ�����");
		}

	}

}
