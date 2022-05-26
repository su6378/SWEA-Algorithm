import java.io.*;
import java.util.Arrays;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String num = br.readLine();
			int[] arr = new int[num.length()];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Character.getNumericValue(num.charAt(i)); 
			}
			
			Arrays.sort(arr);
			
			boolean possible = false;
			int multiply = 2;
			String num2 = num;
			
			while (true) {
				
				
				int multiply_num = Integer.valueOf(num) * multiply;
				num2 = String.valueOf(multiply_num);
				
				if(num2.length() > num.length()) break;
				else {
					int[] arr2 = new int[num2.length()];
					for (int i = 0; i < arr2.length; i++) {
						arr2[i] = Character.getNumericValue(num2.charAt(i)); 
					}
					
					Arrays.sort(arr2);
					
					if(Arrays.equals(arr,arr2)) {
						possible = true;
						break;
					}else multiply++;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			if(possible) bw.write("possible\n");
			else bw.write("impossible\n");
			
			
			

		}
		bw.flush();
		bw.close();
	}

}
