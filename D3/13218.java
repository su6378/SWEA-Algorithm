import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int gruop = N / 3;
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(gruop)+'\n');
		}

		bw.flush();
		bw.close();
	}
}





