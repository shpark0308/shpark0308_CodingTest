package 동적계획법02;

import java.io.*;
import java.util.*;
import java.awt.*;

public class 공장_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		String[] str = br.readLine().split(" ");
		for (int i=0; i<str.length; i++) hashmap.put(Integer.parseInt(str[i]), i+1);
		ArrayList<Point> array = new ArrayList<Point>();
		str = br.readLine().split(" ");
		for (int i=0; i<str.length; i++) array.add(new Point(hashmap.get(Integer.parseInt(str[i])), i+1));
		Collections.sort(array, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.x<o2.x?-1:1;
			}
		});
		int count=0;
		for (int a=0; a<array.size();a++) {
			int ny = array.get(a).y;
			for (int b=(a+1); b<array.size(); b++) {
				if (array.get(b).y<ny) count++;
			}
		}
		System.out.println(count);

	}

}
