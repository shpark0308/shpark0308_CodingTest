package 归霖;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class 模备匙飘况农 {
	public static HashMap<String, String> parent = new HashMap<String, String>();
	public static HashMap<String, ArrayList<String>> set = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int F = Integer.parseInt(br.readLine());
			
			for (int f=0; f<F; f++) {
				String[] friend = br.readLine().split(" ");
				if (!parent.containsKey(friend[0])) parent.put(friend[0], friend[0]);
				if (!parent.containsKey(friend[1])) parent.put(friend[1], friend[1]);
				if (!set.containsKey(friend[0])) set.put(friend[0], new ArrayList<String>());
				if (!set.containsKey(friend[1])) set.put(friend[1], new ArrayList<String>());
				
				String aRoot = find(friend[0]);
				String bRoot = find(friend[1]);
				if (!aRoot.equals(bRoot)) {
					parent.put(bRoot, aRoot);
					set.get(aRoot).add(bRoot);
					set.get(aRoot).addAll(set.get(bRoot));
					set.remove(bRoot);
				}
				
				
			}
			System.out.println(set);
			parent.clear();
			set.clear();
		}
	}
	public static String find(String name) {
		if (parent.get(name).equals(name)) return name;
		return parent.put(parent.get(name), find(parent.get(name)));
	}

}
