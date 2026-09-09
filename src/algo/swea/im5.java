package algo.swea;

import java.util.Scanner;

public class im5 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n;
	static int[][] map;
	static boolean[][] isVisited;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			map = new int[n][n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					isVisited = new boolean[n][n];
					max = Math.max(max, move(i, j));
				}
			}
			System.out.println("#" + test_case + " " + max);

		}
	}

	public static int move(int y, int x) throws Exception {
		isVisited[y][x] = true;
		int min = Integer.MAX_VALUE;
		int next = -1;
		for (int i = 0; i < 4; i++) {
			if (y + dy[i] >= 0 && x + dx[i] >= 0 && y + dy[i] < n && x + dx[i] < n ) {
				if (min > map[y + dy[i]][x + dx[i]] && map[y][x] > map[y + dy[i]][x + dx[i]]) {
					min = map[y + dy[i]][x + dx[i]];
					next = i;

				}
			}
		}
		if (next == -1 || isVisited[y + dy[next]][x + dx[next]]) {
			return 1;
		}
		return 1 + move(y + dy[next], x + dx[next]);
	}
}
/*
3
5
67 23 89 45 12
78 34 91 56 3
82 19 47 95 61
8  1  28 84 37
69 15 52 96 41
5
25 24 23 22 21
20 19 18 17 16
15 14 13 12 11
10 9  8  7  6
5  4  3  2  1
5
14 93 67 38 72
49 26 81 55 17
63 44 29 76 88
31 95 12 58 83
42 69 35 91 24
*/