import java.util.ArrayList;

public class Programmers_2018Summer_12984 {
    public static void main(String[] args) {
        int[][] stub1 = {
                {1, 2},
                {2, 3}
        };
        int[][] stub2 = {
                {4, 4, 3},
                {3, 2, 2},
                {2, 1, 0}
        };

        System.out.println(solution(stub1, 3, 2));
        System.out.println(solution(stub2, 5, 3));
    }

    public static long fistsolution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        int maxLevel = -1;
        int N = land.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maxLevel < land[i][j]) {
                    maxLevel = land[i][j];
                }
            }
        }

        for (int level = 0; level <= maxLevel; level++) {
            long cost = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int diff = level - land[i][j];
                    if (diff < 0) { // 없앨때
                        cost += -diff * Q;
                    }
                    if (diff > 0) {
                        cost += diff * P;
                    }
                }
            }

            if (answer > cost) {
                answer = cost;
            }
        }

        return answer;
    }

}
