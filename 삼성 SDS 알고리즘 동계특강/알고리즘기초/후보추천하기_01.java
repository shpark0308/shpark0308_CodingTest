package 알고리즘기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Candidate implements Comparable<Candidate>{
	int num, count, time;
	public Candidate(int num, int count, int time) {
		this.num = num; this.count = count; this.time = time;
	}
	@Override
	public int compareTo(Candidate o) {
		if (this.count==o.count) return this.time<o.time?-1:1;
		return this.count<o.count?-1:1;
	}
	
}

public class 후보추천하기_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		ArrayList<Candidate> candidate = new ArrayList<Candidate>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i=0; i<C; i++) {
			Collections.sort(candidate);
			for (Candidate cand : candidate) {
				System.out.print("["+cand.num+","+cand.count+"] ");
			}
			System.out.println("-----------------------");
			int num = sc.nextInt();
			if (candidate.size()<N) {
				if (arr.contains(num)) {
					for (Candidate cand : candidate) {
						if (cand.num==num) {
							cand.count++;
							break;
						}
					}
				}
				else {
					candidate.add(new Candidate(num, 1, i));
					arr.add(num);
				}
				
			}
			else {
				if (arr.contains(num)) {
					for (Candidate cand : candidate) {
						if (cand.num==num) {
							cand.count++;
							break;
						}
					}
				}
				else {
					arr.remove(arr.indexOf(candidate.get(0).num));
					candidate.remove(0);
					arr.add(num);
					candidate.add(new Candidate(num, 1, i));
				}
				
			}
		}
		Collections.sort(arr);
		for (int i=0; i<arr.size(); i++) System.out.println(arr.get(i)+" ");
		

	}

}
