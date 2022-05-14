import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int count = 0;
			String clap = "-";
			int num = i;
			while (num > 0) {
				int isClap = num % 10;
				num /= 10;
				if(isClap == 3 || isClap == 6 || isClap == 9) count++;
				
			}
			
			if(count == 0) bw.write(String.valueOf(i)+" ");
			else {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < count; j++) {
					sb.append(clap);
				}
				bw.write(sb.toString()+" ");
			}
		}
		
		bw.flush();
		bw.close();

	}

}
