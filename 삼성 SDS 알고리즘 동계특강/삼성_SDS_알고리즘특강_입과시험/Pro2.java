package 삼성_SDS_알고리즘특강_입과시험;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


public class Pro2 {
	public static ArrayList<Set<Integer>> comarr1 = new ArrayList<Set<Integer>>();
	public static ArrayList<String[]> card = new ArrayList<String[]>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println("NN : "+N);
			for (int a=0; a<N; a++) {
				card.add(br.readLine().split(""));
				System.out.println(Arrays.toString(card.get(a)));
			}
			combination(N, new ArrayList<Integer>(), 3);
			Collections.sort(comarr1, new Comparator<Set<Integer>>() {
				@Override
				public int compare(Set<Integer> o1, Set<Integer> o2) {
					// TODO Auto-generated method stub
					return o1.size()>o2.size()?-1:1;
				}
			});
			System.out.println(comarr1);
			System.out.println("#"+i+" "+comarr1.get(0).size()/3);
			comarr1.clear();
			card.clear();
		}

	}
	public static void combination(int N, ArrayList<Integer> arr1, int index) {
		if (index==0) {
			check(arr1);
			return;
		}
		int count = arr1.isEmpty()?0:arr1.get(arr1.size()-1)+1;
		for (int i=count; i<N; i++) {
			arr1.add(i);
			combination(N, new ArrayList<Integer>(arr1), index-1);
			arr1.remove(arr1.size()-1);
		}
	}
	
	public static void check(ArrayList<Integer> arr1) {
		String[] str1 = card.get(arr1.get(0));
		String[] str2 = card.get(arr1.get(1));
		String[] str3 = card.get(arr1.get(2));
		boolean f1 = false, f2 = false, f3 = false, f4 = false;
		if (str1[0].equals(str2[0])&&str1[0].equals(str3[0])) f1 = true;
		else if ((!str1[0].equals(str2[0]))&&(!str1[0].equals(str3[0])&&(!str2[0].equals(str3[0])))) f1=true;
		
		if (!f1) return;
		
		if (str1[1].equals(str2[1])&&str1[1].equals(str3[1])) f2 = true;
		else if ((!str1[1].equals(str2[1]))&&(!str1[1].equals(str3[1])&&(!str2[1].equals(str3[1])))) f2=true;
		
		if (!f2) return;
		
		if (str1[2].equals(str2[2])&&str1[2].equals(str3[2])) f3 = true;
		else if ((!str1[2].equals(str2[2]))&&(!str1[2].equals(str3[2])&&(!str2[2].equals(str3[2])))) f3=true;
		
		if (!f3) return;
		
		if (str1[3].equals(str2[3])&&str1[3].equals(str3[3])) f4 = true;
		else if ((!str1[3].equals(str2[3]))&&(!str1[3].equals(str3[3])&&(!str2[3].equals(str3[3])))) f4=true;
		
		if (!f4) return;
		
		if (f1&&f2&&f3&&f4) {
			for (int i=0; i<comarr1.size();i++) {
				if (!comarr1.get(i).contains(arr1.get(0))&&!comarr1.get(i).contains(arr1.get(1))&&!comarr1.get(i).contains(arr1.get(2))) {
					comarr1.get(i).add(arr1.get(0));
					comarr1.get(i).add(arr1.get(1));
					comarr1.get(i).add(arr1.get(2));
				}
			}
			Set<Integer> set = new HashSet<Integer>();
			set.add(arr1.get(0)); set.add(arr1.get(1)); set.add(arr1.get(2));
			comarr1.add(set);
		}
		
	}

}
