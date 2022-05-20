package Main;

import java.io.*;
import java.util.*;

import javax.management.StringValueExp;



class Solution {
	
	public static int count;
	public static ArrayList<Integer> list;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			count = 0;
			int target = Integer.parseInt(br.readLine());
			List<Integer> prime = new ArrayList<Integer>();
			for (int i = 2; i < target; i++) {
				boolean isPrime = true;
				for (int j = 2; j < i; j++) {
					if(i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) prime.add(i);
			}
			
			
			dfs(0,target, 0, prime,0);
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void dfs(int size,int target,int sum, List<Integer> prime,int previous) {
		if(size == 3) {
			if(sum == target) {
				count++;
			}
			sum = 0;
			return;
		}
		
		for (int i = 0; i < prime.size(); i++) {
			if(prime.get(i) >= previous ) {
				dfs(size+1,target, sum+prime.get(i), prime, prime.get(i));
			}
		}
	}
	
	
}
