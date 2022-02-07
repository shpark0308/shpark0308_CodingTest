package ÇØÄ¿·©Å©;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int[] parents;
    public static ArrayList<Integer> keyset;
    
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        parents = new int[n];
        for (int a=0; a<n; a++) parents[a] = a;
        
        HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<Integer, ArrayList<Integer>>();
        for (int a=0; a<n; a++) {
            ArrayList<Integer> array = new ArrayList<Integer>();
            array.add(a);
            hashmap.put(a, array);
        }
        for (int a=0; a<astronaut.size(); a++){
            int num_a = find(astronaut.get(a).get(0));
            int num_b = find(astronaut.get(a).get(1));
            if (num_a!=num_b){
                parents[num_a] = num_b;
                hashmap.get(num_b).addAll(hashmap.get(num_a));
                hashmap.remove(num_a);
            }
        }
        keyset = new ArrayList<Integer>(hashmap.keySet());
        int sum=0;
        for (int a=0; a<keyset.size()-1; a++){
            for (int b=(a+1); b<keyset.size(); b++){
                sum+=(hashmap.get(keyset.get(a)).size())*(hashmap.get(keyset.get(b)).size());
            }
        }
        
        
        return sum;

    }
    public static int find(int num){
        if (parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


public class JourneyToTheMoon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
