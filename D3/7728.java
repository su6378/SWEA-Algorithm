import java.io.*;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			String number = br.readLine();
			HashSet<Character> variety = new HashSet<Character>();
			
			for (int j = 0; j < number.length(); j++) {
				variety.add(number.charAt(j));
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(variety.size())+"\n");
		}

		bw.flush();
		bw.close();
	}
}






