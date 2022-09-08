import java.io.*;
import java.util.*;

class Info {
	double location; // 자성체의 좌표
	int m; // 자성체의 질량
}

public class Solution {

	static Info[] info; //좌표,질량 배열
	static int N;
	static double[] balancePoints;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			info = new Info[N];

			for (int i = 0; i < N; i++) {
				info[i] = new Info();
			}
			
			balancePoints = new double[N-1];

			StringTokenizer token = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				info[i].location = Double.parseDouble(token.nextToken());

			}

			for (int i = 0; i < N; i++) {
				info[i].m = Integer.parseInt(token.nextToken());
			}

			double result = 0.0;
			for (int i = 0; i < N-1; i++) {
				balancePoints[i] = balance(i, info[i].location, info[i+1].location); //균형점 배열에 값 넣어주기
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < balancePoints.length; i++) {
				bw.write(String.format("%.10f",balancePoints[i])+" "); //소수점 10자리까지 출력
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static double balance(int index, double left, double right) {
		double sum = 0.0; //인력
		double middle = 0.0; //균형점
		for (int i = 0; i < 100; i++) {
			middle = (left + right) / 2.0;
			
			sum = 0.0;
			
			for (int j = 0; j <= index; j++) {
				sum += info[j].m / ((info[j].location - middle) * (info[j].location - middle)); // 왼쪽 인력
			}

			for (int j = N - 1; j > index; j--) {
				sum -= info[j].m / ((info[j].location - middle) * (info[j].location - middle)); //오른쪽 인력
			}
			
			if (sum > 0.0) { //왼쪽으로 당기는 힘이 강하면 다음 왼쪽 좌표를 middle위치인 오른쪽으로 이동
				left = middle;
			}
			
			else if(sum < 0.0) {//오른쪽으로 당기는 힘이 강하면 다음 오른쪽 좌표를 middle위치인 오른쪽으로 이동
				right = middle;
			}
		}
		
		return middle;
	}
}
