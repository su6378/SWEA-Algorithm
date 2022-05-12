package Main;

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int t = Integer.parseInt(br.readLine());
         
         
        for (int i = 1; i <= t; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(token.nextToken());
                if (num % 2 != 0) sum += num;
            }
             
            bw.write("#"+String.valueOf(i)+" "+String.valueOf(sum)+"\n");
        }
         
        bw.flush();
        bw.close();
    }
}