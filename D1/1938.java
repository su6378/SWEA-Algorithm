package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer	token = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());
		
		bw.write(String.valueOf(a+b)+"\n");
		bw.write(String.valueOf(a-b)+"\n");
		bw.write(String.valueOf(a*b)+"\n");
		bw.write(String.valueOf(a/b)+"\n");
		
		bw.flush();
		bw.close();
	}
}

