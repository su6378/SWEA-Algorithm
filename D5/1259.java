import java.io.*;
import java.util.*;

public class Solution {

	static class Screw { // 나사 클래스
		int male;
		int female;

		public Screw(int male, int female) {
			super();
			this.male = male;
			this.female = female;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<Screw> screws = new ArrayList();
			int max = 0;
			int[] screwArr = new int[N * 2];

			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N * 2; i += 2) {
				screwArr[i] = Integer.parseInt(token.nextToken());
				screwArr[i + 1] = Integer.parseInt(token.nextToken());
				max = Math.max(max, Math.max(screwArr[i], screwArr[i + 1]));
			}

			int[] check = new int[max + 1]; // 암수나사 쌍 배열

			for (int i = 0; i < screwArr.length; i++) {
				check[screwArr[i]]++;
			}

			int target = -1;

			for (int i = 1; i < check.length; i++) { // 시작 나사 세팅
				if (check[i] == 1) {
					for (int j = 0; j < screwArr.length; j += 2) {
						if (i == screwArr[j]) {
							target = screwArr[j + 1];
							screws.add(new Screw(screwArr[j], screwArr[j + 1]));
						}
					}
				}
			}

			int chagne = 1;

			while (chagne <= N) { // N만큼 루프
				for (int i = 0; i < screwArr.length; i += 2) {
					if (screwArr[i] == target) {
						target = screwArr[i + 1];
						screws.add(new Screw(screwArr[i], screwArr[i + 1]));
					}
				}
				chagne++;
			}

			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < screws.size(); i++) {
				bw.write(screws.get(i).male+" "+screws.get(i).female+" ");
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}

