import java.io.*;
import java.util.*;


public class Solution {
	
	static int N;
	static int M;
	static int C;
	static int[] honey; // 꿀 배열
	static List<Integer> sumList; // 각 행에 얻을 수 있는 합의 최대값
	static boolean[] selected; //꿀 선택 중복 체크 배열
	static int maxSum; // 각 행의 최대 합

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			C = Integer.parseInt(token.nextToken());

			int[][] hive = new int[N][N]; // 벌통

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					hive[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			sumList = new ArrayList<Integer>();

			for (int i = 0; i < hive.length; i++) {
				maxSum = Integer.MIN_VALUE;
				honey = new int[M];
				for (int j = 0; j+M <= N ; j++) { //M개의 꿀 조합
					int index = 0;
					for (int k = j; k < j+M; k++) {
						honey[index] = hive[i][k]; 
						index++;
					}
					selected = new boolean[M];
					getSum(0, honey, 0, 0, 0);
				}
				sumList.add(maxSum);
			}

			Collections.sort(sumList, Collections.reverseOrder());

			int result = 0;
			int count = 0;
			while (count < 2) { //최대값 2개 뽑기
				result += sumList.get(count);
				count++;
			}

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(result) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void getSum(int size, int[] honey, int sum, int honeySum,int last) { //최대 벌꿀 합 구하기
		if (sum >= C) {
			if (sum != C) {
				honeySum -= (int) Math.pow(last, 2);
			}
			maxSum = Math.max(maxSum, honeySum);
			return;
		}else if(size == M) {
			maxSum = Math.max(maxSum, honeySum);
			return;
		}
		

		for (int i = 0; i < honey.length; i++) {
			if (!selected[i]) {
				selected[i] = true;
				getSum(size+1,honey, sum + honey[i], honeySum + ((int) Math.pow(honey[i], 2)), honey[i]);
				selected[i] = false;
			}
		}
	}
}
