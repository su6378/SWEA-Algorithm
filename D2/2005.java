import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write("#"+String.valueOf(i)+"\n");
			
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= j; k++) {
					if (j == 1 || j == 2) {
						list2.add(1);
					} else {
						if(k == 1) list2.add(1);
						else if(k < j) {
							list2.add(list1.get(k-2)+list1.get(k-1));
						}else list2.add(1);
						
					}
				}
				list1.clear();
				for (int k = 0; k < list2.size(); k++) {
					list1.add(list2.get(k));
					bw.write(String.valueOf(list2.get(k))+" ");
				}
				
				bw.write("\n");

				list2.clear();
			}
		}
		bw.flush();
		bw.close();

	}

}
