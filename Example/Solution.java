import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            ArrayList<Integer> woods = new ArrayList<Integer>();
           
            int count = 0; //최대 높이가 되기까지 남은 나무의 개수
            int day = 0;
            boolean[] checked = new boolean[N]; //최대 높이가 되었는지 체크하는 배열
            
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                woods.add(Integer.parseInt(token.nextToken()));
            }
            
            Collections.sort(woods,Collections.reverseOrder()); //내림차순으로 정렬
            
            int max = woods.get(0); //최대 높이
            
            for (int i = 0; i < woods.size(); i++) { //물을 주지 않아도 최대 높이인 나무는 제외하기
                if (woods.get(i) == max) {
                   count++;
                   checked[i] = true; 
                }
            }
            
            if (count != N) { //모든 나무가 최대 높이가 아닌 경우
                while (true) {
                    day++;
                    if (count == N) break; //모든 나무가 최대 높이가 될 경우 break;
                    
                    boolean isWater = false; //물을 줬는지 체크하는 변수
                    for (int i = 0; i < woods.size(); i++) {
                        if (!checked[i]){
                            switch (day%2) { //홀수 짝수일때 나무 길이 갱신
                            case 1: //홀수날일 때
                                if (woods.get(i) + 2 != max) { //+2가 최대높이일 경우 1을 더하지 않고 다음 나무를 찾는다
                                    woods.set(i, woods.get(i)+1);
                                    if (woods.get(i) == max) {
                                        count++;
                                        checked[i] = true; 
                                    }
                                    isWater = true;
                                }else if (woods.get(i) + 2 == max && count != N-1) { 
                                    woods.set(i, woods.get(i)+1);
                                    isWater = true;
                                }
                                break;
                            case 0: //짝수날일 때
                                if (woods.get(i) + 2 <= max ) { //+2가 최대 높이이거나 작으면 더해준다.
                                   woods.set(i, woods.get(i)+2);
                                   isWater = true;
                                   if (woods.get(i) == max) {
                                       count++;
                                       checked[i] = true; 
                                   }
                                }
                                break;
                            }
                            
                            if (isWater) break;    
                        }
                    }
                    
                    if (count == N) break;
                  
                }
            }
            
            bw.write("#"+String.valueOf(tc)+" "+String.valueOf(day)+"\n");
            
        }
        bw.flush();
        bw.close();
    }
}
