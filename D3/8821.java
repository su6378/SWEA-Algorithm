import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc= 1; tc <= T; tc++) {
			String str = br.readLine();
			
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < str.length(); i++) {
				int num = Character.getNumericValue(str.charAt(i));
				if (list.contains(num)) list.remove(Integer.valueOf(num));
				else  list.add(num);
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(list.size())+"\n");
		}
		bw.flush();
		bw.close();
	}
}


