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
           
            int count = 0; //�ִ� ���̰� �Ǳ���� ���� ������ ����
            int day = 0;
            boolean[] checked = new boolean[N]; //�ִ� ���̰� �Ǿ����� üũ�ϴ� �迭
            
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                woods.add(Integer.parseInt(token.nextToken()));
            }
            
            Collections.sort(woods,Collections.reverseOrder()); //������������ ����
            
            int max = woods.get(0); //�ִ� ����
            
            for (int i = 0; i < woods.size(); i++) { //���� ���� �ʾƵ� �ִ� ������ ������ �����ϱ�
                if (woods.get(i) == max) {
                   count++;
                   checked[i] = true; 
                }
            }
            
            if (count != N) { //��� ������ �ִ� ���̰� �ƴ� ���
                while (true) {
                    day++;
                    if (count == N) break; //��� ������ �ִ� ���̰� �� ��� break;
                    
                    boolean isWater = false; //���� ����� üũ�ϴ� ����
                    for (int i = 0; i < woods.size(); i++) {
                        if (!checked[i]){
                            switch (day%2) { //Ȧ�� ¦���϶� ���� ���� ����
                            case 1: //Ȧ������ ��
                                if (woods.get(i) + 2 != max) { //+2�� �ִ������ ��� 1�� ������ �ʰ� ���� ������ ã�´�
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
                            case 0: //¦������ ��
                                if (woods.get(i) + 2 <= max ) { //+2�� �ִ� �����̰ų� ������ �����ش�.
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
