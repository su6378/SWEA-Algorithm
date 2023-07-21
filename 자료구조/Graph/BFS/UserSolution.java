class UserSolution {

    private static class Queue<T> {
        private static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> front; // 큐의 시작 (첫 번째 원소)
        private Node<T> rear; // 큐의 끝 (마지막 원소)
        private int size; // 큐의 길이

        public Queue() {
            front = null;
            rear = null;
            size = 0;
        }

        // 큐가 비어있는지 확인
        public boolean isQEmpty() {
            return size == 0;
        }

        // 큐의 길이 반환
        public int size() {
            return size;
        }

        // 큐의 맨 뒤에 원소 추가
        public void offer(T data) {
            Node<T> newNode = new Node<>(data);
            if (isQEmpty()) {
                front = newNode;
            } else {
                rear.next = newNode;
            }
            rear = newNode;
            size++;
        }

        // 큐의 맨 앞의 원소 제거 후 반환
        public T poll() {
            T data = front.data;
            front = front.next;
            size--;
            if (isQEmpty()) {
                rear = null; // 큐가 비었을 때 rear도 null로 설정
            }
            return data;
        }

        // 큐의 맨 앞의 원소 확인 (제거하지 않음)
        public T peek() {
            return front.data;
        }
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean[][] visited;
    private static int N;
    private static int[][] mapArr;
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void bfs_init(int map_size, int map[][]) {
        N = map_size;
        mapArr = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mapArr[i][j] = map[i][j];
            }
        }
    }

    int bfs(int x1, int y1, int x2, int y2) {
        visited = new boolean[N][N];
        visited[y1 - 1][x1 - 1] = true;

        Queue<Point> q = new Queue<>();
        q.offer(new Point(x1 - 1, y1 - 1));

        int count = 0;
        while (!q.isQEmpty()) {
            int qSize = q.size();
            count++;

            for (int i = 0; i < qSize; i++) {
                Point cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int r = cur.y + direction[j][0];
                    int c = cur.x + direction[j][1];

                    if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c] && mapArr[r][c] == 0) {
                        if (r == y2 - 1 && c == x2 - 1) return count;
                        visited[r][c] = true;
                        q.offer(new Point(c, r));
                    }
                }
            }


        }
        return -1;
    }
}
