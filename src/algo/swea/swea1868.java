package algo.swea;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class swea1868 {

	static int[] dx = { 0, 0, -1, -1, -1, 1, 1, 1 };
	static int[] dy = { 1, -1, -1, 0, 1, -1, 0, 1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(sc.next());

			char[][] map = new char[n][n];
			int[][] list = new int[n][n];
			boolean[][] visited = new boolean[n][n];

			int answer = 0;

			for (int i = 0; i < n; i++) {
				map[i] = sc.next().toCharArray();
//				System.out.println(Arrays.toString(map[i]));
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.') {
						for (int k = 0; k < 8; k++) {
							int ni = i + dy[k];
							int nj = j + dx[k];
							if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
								if (map[ni][nj] == '*') {
									list[i][j] += 1;
								}
							}
						}
					} else {
						list[i][j] = -1;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (list[i][j] > 0) {
						int zeroCnt = 0;
						for (int k = 0; k < 8; k++) {

							int ni = i + dy[k];
							int nj = j + dx[k];

							if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
								if (list[ni][nj] == 0) {
									zeroCnt++;
								}
							}

						}
						if (zeroCnt == 0)
							answer++;
					} else if (list[i][j] == 0 && !visited[i][j]) {
						answer++;
						Queue<int[]> q = new ArrayDeque<>();
						q.add(new int[] { i, j });
						visited[i][j] = true;
						while (!q.isEmpty()) {
							int[] now = q.poll();
							
							for (int k = 0; k < 8; k++) {
								int ni = now[0] + dy[k];
								int nj = now[1] + dx[k];
								if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
									if (list[ni][nj] == 0 && !visited[ni][nj]) {
										q.add(new int[] { ni, nj });
										visited[ni][nj] = true;
									}
								}
							}
						}

					}

				}
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
