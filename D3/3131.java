import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		boolean isPrime = true;
		for (int i = 2; i <= 1000000; i++) {
			for (int j = 2; j <= Math.sqrt(i) ; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) sb.append(String.valueOf(i)+" ");
			isPrime = true;
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
