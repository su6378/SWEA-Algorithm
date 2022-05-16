import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 10; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			String password = token.nextToken();
			
			LinkedList<Character> removed_pw = new LinkedList<Character>();
			for (int j = 0; j < password.length(); j++) {
				removed_pw.add(password.charAt(j));
			}
			
			boolean isRemove = true;
			while (isRemove) {
				LinkedList<Integer> idx = new LinkedList<Integer>();
				for (int j = 0; j < removed_pw.size()-1; j++) {
					if (removed_pw.get(j) == removed_pw.get(j+1)) {
						idx.add(j);
						isRemove = true;
						break;
					}else isRemove = false;
				}
				
				if (idx.isEmpty()) continue;
				else {
					for (int j = 0; j < 2; j++) {
						int remove_idx = idx.get(0);
						removed_pw.remove(remove_idx);
					}
				}
				
			}
			bw.write("#"+String.valueOf(i)+" ");
			
			for (int j = 0; j < removed_pw.size(); j++) {
				bw.write(String.valueOf(removed_pw.get(j)));
			}
			
			bw.write("\n");
			
	
		}

		bw.flush();
		bw.close();
	}
}







