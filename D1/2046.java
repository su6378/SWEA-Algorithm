import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		
		String sharp = "#";
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < num; i++) {
			sb.append(sharp);
		}
		
		System.out.println(sb.toString());
	}

}
