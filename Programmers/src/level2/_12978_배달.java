class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < road.length; i++) {
            int x = road[i][0], y = road[i][1], w = road[i][2];
            if (map[x][y] == 0 || (map[x][y] != 0 && map[x][y] > w)) {
                map[x][y] = map[y][x] = w;
            }
        }

        // dijkstra start
        int[] distance = new int[N + 1]; // 최단 거리를 저장할 변수
        boolean[] check = new boolean[N + 1]; // 해당 노드를 방문했는지 체크할 변수

        // distance값 초기화.
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 시작노드값 초기화.
        distance[1] = 0;
        check[1] = true;

        // 연결노드 distance갱신
        for (int i = 1; i < N + 1; i++) {
            if (!check[i] && map[1][i] != 0) {
                distance[i] = map[1][i];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            // 원래는 모든 노드가 true될때까지 인데
            // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            // 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            // 최소값 찾기
            for (int j = 1; j < N + 1; j++) {
                if (!check[j] && distance[j] != Integer.MAX_VALUE) {
                    if (distance[j] < min) {
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

            check[min_index] = true;
            for (int j = 1; j < N + 1; j++) {
                if (!check[j] && map[min_index][j] != 0) {
                    if (distance[j] > distance[min_index] + map[min_index][j]) {
                        distance[j] = distance[min_index] + map[min_index][j];
                    }
                }
            }

        }
        // dijkstra end

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= K)
                answer++;
        }

        return answer;
    }
}