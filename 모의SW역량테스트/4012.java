import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[][] ingredients; // 재료 배열
	static boolean[] selected; // 재료 선택 배열
	static boolean[] visited; // 재료 중복 체크 배열
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			ingredients = new int[N][N];
			selected = new boolean[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredients[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			
			permulation(0, 1);
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
		}

		bw.flush();
		bw.close();
	}

	static void permulation(int index, int next) {

		if (index == N / 2) {
			make();
			return;
		}

		for (int i = next; i <= N; i++) {
			if (index == 0 && i >= N / 2 ) { // N/2 보다 클 경우는 이미 탐색 했으므로 백트래킹
					return;
			}
			selected[i] = true;
			permulation(index + 1, i + 1);
			selected[i] = false;
		}
	}

	static void make() {

		int[] food1 = new int[N / 2];
		int[] food2 = new int[N / 2];
		int index1 = 0;
		int index2 = 0;
		for (int i = 1; i <= N; i++) {
			if (selected[i]) { // 선택한 재료 각각 요리 배열에 담기
				food1[index1] = i;
				index1++;
			} else {
				food2[index2] = i;
				index2++;
			}
		}
		//재료들의 시너지 합 구하기
		int sum1 = getSum(food1);
		int sum2 = getSum(food2);
		
		int diff = Math.abs(sum1 - sum2);
		
		min = Math.min(min, diff);

	}

	static int getSum(int[] food) {
		
		int sum = 0;

		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < food.length; j++) {
				if (i != j) { //같은 거는 패스
					sum += ingredients[food[i]-1][food[j]-1];
				}
			}
		}

		return sum;
	}
}
