package 백준;

import java.util.*;
import java.io.*;

public class 생태학_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		TreeMap<String, Double> tree = new TreeMap<String, Double>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double total = 0;
		while(true) {
			String name = br.readLine();
			if (name.length()==0||name==null) break;
			tree.put(name,tree.getOrDefault(name, 0.0)+1);
			total++;
		}

		for(Map.Entry<String, Double> entry : tree.entrySet()) {
			double num = (double)(entry.getValue()*100.0/total);
			System.out.println(entry.getKey()+" "+String.format("%.4f", num));
		}
	}

}
