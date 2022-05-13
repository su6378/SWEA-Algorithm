import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine().toString();
		
		str = str.toUpperCase();
		
		System.out.println(str);
		
		bw.flush();
		bw.close();

	}

}
