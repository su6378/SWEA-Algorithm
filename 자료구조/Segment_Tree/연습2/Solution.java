import java.io.*;
import java.util.*;

class SegmentTree {
    private long[] segmentTree;
    private long[] arr;

    public SegmentTree(long[] inputArray) {
        int n = inputArray.length;
        arr = inputArray;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        segmentTree = new long[maxSize];
        buildSegmentTree(0, 0, n - 1);
    }

    private long buildSegmentTree(int index, int left, int right) {
        if (left == right) {
            segmentTree[index] = arr[left];
            return segmentTree[index];
        }

        int mid = left + (right - left) / 2;
        segmentTree[index] = buildSegmentTree(2 * index + 1, left, mid) +
                buildSegmentTree(2 * index + 2, mid + 1, right);
        return segmentTree[index];
    }

    public long query(int queryLeft, int queryRight) {
        return query(0, 0, arr.length - 1, queryLeft, queryRight);
    }

    private long query(int index, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left)
            return 0;  // Out of range
        if (queryLeft <= left && queryRight >= right)
            return segmentTree[index];  // Current segment is fully within range

        int mid = left + (right - left) / 2;
        return query(2 * index + 1, left, mid, queryLeft, queryRight) +
                query(2 * index + 2, mid + 1, right, queryLeft, queryRight);
    }

    public void update(int index, long newValue) {
        long diff = newValue - arr[index];
        arr[index] = newValue;
        update(0, 0, arr.length - 1, index, diff);
    }

    private void update(int segmentIndex, int left, int right, int index, long diff) {
        if (index < left || index > right)
            return;  // Out of range

        segmentTree[segmentIndex] += diff;
        if (left != right) {
            int mid = left + (right - left) / 2;
            update(2 * segmentIndex + 1, left, mid, index, diff);
            update(2 * segmentIndex + 2, mid + 1, right, index, diff);
        }
    }
}

public class Solution{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

            long[] arr = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (i % 2 == 0) arr[i] = num;
                else arr[i] = -num;
            }

            SegmentTree segmentTree = new SegmentTree(arr);

            bw.write("#" + tc + " ");

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());

                switch (Integer.parseInt(st.nextToken())) {
                    case 0: {
                        int idx = Integer.parseInt(st.nextToken());
                        int value = Integer.parseInt(st.nextToken());
                        if (idx % 2 != 0) value *= -1;
                        segmentTree.update(idx, value);
                        break;
                    }
                    case 1: {
                        int start = Integer.parseInt(st.nextToken());
                        int end = Integer.parseInt(st.nextToken());
                        if (start % 2 == 0) bw.write(segmentTree.query(start, end - 1)+" ");
                        else bw.write(-segmentTree.query(start, end - 1)+" ");
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}