package ������ȹ��01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �����ձ��ϱ�4_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* ��� Ǯ��� ȿ�������� Ǯ �� ���� �� ��� */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]), K = Integer.parseInt(str[1]);
		int[] number = new int[N+1], summation = new int[N+1];
		
		str = br.readLine().split(" ");
		int sum = 0;
		for (int i=1; i<=N; i++) {
			number[i] = Integer.parseInt(str[i-1]);
			sum+=number[i];
			summation[i] = sum;
		}
		for (int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]), end = Integer.parseInt(str[1]);
			System.out.println(summation[end]-summation[start-1]);
		}

	}

}
