import java.io.*;
import java.util.*;

class Solution {
	public static int max;
	public static boolean isContinue;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			max = -1;
			isContinue = true;
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}
			
			if(N == 1) {
				String str = String.valueOf(arr[0]);
				if(str.length() == 1) max = arr[0];
				else {
					for (int i = 0; i < str.length()-1; i++) {
						int num = Character.getNumericValue(str.charAt(i));
						int num2 = Character.getNumericValue(str.charAt(i+1));
						if(num+1 == num2) {
							continue;
						}else { 
							isContinue = false;
							break;
						}	
					}
					if(isContinue) max = arr[0];
				}
			}else {
				combination(0,0,1,arr);
			}
			
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(max)+"\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void combination(int size, int idx,int multiply,int[] arr) {
		if(size == 2) {
			isContinue = true;
			String str = String.valueOf(multiply);
			if(str.length() == 1) {
				if(max < multiply) max = multiply;
			}else {
				for (int i = 0; i < str.length()-1; i++) {
					int num = Character.getNumericValue(str.charAt(i));
					int num2 = Character.getNumericValue(str.charAt(i+1));
					if(num+1 == num2) continue;
					else {
						isContinue = false;
						break;
					}
				}
				if(isContinue) {
					if(max < multiply) max = multiply;
				}
			}
			return;
		}else {
			for (int i = idx; i < arr.length; i++) {
				combination(size+1,i+1,multiply * arr[i],arr);
			}
		}
	}
}
