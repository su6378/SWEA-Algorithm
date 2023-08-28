import java.io.*;
import java.util.*;

public class Solution {

    static int[] arr;
    static int[] segTree1;
    static int[] segTree2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];
            segTree1 = new int[4 * (n + 1)];
            segTree2 = new int[4 * (n + 1)];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            makeTree1(1, 1, n);
            makeTree2(1, 1, n);

            bw.write("#" + tc + " ");

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());

                switch (Integer.parseInt(st.nextToken())) {
                    case 0: {
                        int idx = Integer.parseInt(st.nextToken());
                        int value = Integer.parseInt(st.nextToken());
                        updateTree1(1,1,n,idx + 1,value);
                        updateTree2(1,1,n,idx + 1,value);
                        break;
                    }
                    case 1: {
                        int start = Integer.parseInt(st.nextToken());
                        int end = Integer.parseInt(st.nextToken());

                        int max = findTree1(1,1,n,start + 1,end);
                        int min = findTree2(1,1,n,start + 1,end);
                        bw.write(max - min + " ");
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static int makeTree1(int idx, int start, int end){
        int mid = (start + end) / 2;

        if(start == end)
            return segTree1[idx] = arr[start];
        else
            return segTree1[idx] = Math.max(makeTree1(2 * idx, start, mid), makeTree1(2 * idx + 1, mid + 1, end));
    }

    static int makeTree2(int idx, int start, int end){
        int mid = (start + end) / 2;

        if(start == end)
            return segTree2[idx] = arr[start];
        else
            return segTree2[idx] = Math.min(makeTree2(2 * idx, start, mid), makeTree2(2 * idx + 1, mid + 1, end));
    }

    static int findTree1(int idx, int start, int end, int fs, int fe){
        if(fe < start || fs > end)
            return 0;
        else if(fs <= start && end <= fe)
            return segTree1[idx];
        else{
            int mid = (start + end) / 2;
            return Math.max(findTree1(2 * idx, start, mid, fs, fe), findTree1(2 * idx + 1, mid + 1, end, fs, fe));
        }
    }

    static int findTree2(int idx, int start, int end, int fs, int fe){
        if(fe < start || fs > end)
            return 1000000000;
        else if(fs <= start && end <= fe)
            return segTree2[idx];
        else{
            int mid = (start + end) / 2;
            return Math.min(findTree2(2 * idx, start, mid, fs, fe), findTree2(2 * idx + 1, mid + 1, end, fs, fe));
        }
    }

    static void updateTree1(int idx, int start, int end, int targetIdx, int newValue) {
        if (start == end && start == targetIdx) {
            segTree1[idx] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        if (targetIdx <= mid) {
            updateTree1(2 * idx, start, mid, targetIdx, newValue);
        } else {
            updateTree1(2 * idx + 1, mid + 1, end, targetIdx, newValue);
        }
        segTree1[idx] = Math.max(segTree1[2 * idx], segTree1[2 * idx + 1]);
    }

    static void updateTree2(int idx, int start, int end, int targetIdx, int newValue) {
        if (start == end && start == targetIdx) {
            segTree2[idx] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        if (targetIdx <= mid) {
            updateTree2(2 * idx, start, mid, targetIdx, newValue);
        } else {
            updateTree2(2 * idx + 1, mid + 1, end, targetIdx, newValue);
        }
        segTree2[idx] = Math.min(segTree2[2 * idx], segTree2[2 * idx + 1]);
    }
}