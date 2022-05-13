package Main;

import java.io.*;


class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		int temp = 0;
		while (temp <= count) {
			int result = (int)Math.pow(2,temp);
			bw.write(String.valueOf(result)+" ");
			temp++;
		}
		
		
		bw.flush();
		bw.close();
	}
}

