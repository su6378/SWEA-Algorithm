import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			int cal_length = Integer.parseInt(br.readLine());
			String sik = br.readLine();
			
			int result = Character.getNumericValue(sik.charAt(0));
			for (int i = 1; i < sik.length(); i++) {
				char buho = sik.charAt(i);
				if(buho == '+') {
					result += Character.getNumericValue(sik.charAt(i+1));
				}
			}
			
			bw.write("#"+T+" "+result+"\n");
			
		}
		bw.flush();
		bw.close();
		
	}

}