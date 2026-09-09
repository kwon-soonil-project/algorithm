package algo.swea;

import java.util.*;
import java.util.Scanner;

public class swea1767 {
	static int maxCore;
	static int minWire;
	static int n;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static List<List<Integer>> cores; // [[y,x] [y,x] ....] 각 코어 좌표
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			n = sc.nextInt();
			arr = new int[n][n];
			visited = new boolean[n][n];
			cores = new ArrayList<>();
			int coreCount1 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int now = sc.nextInt();
					arr[i][j] = now;
					if (now == 1) {
						if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
							coreCount1 += 1;
						} else {
							cores.add(Arrays.asList(i, j));
						}
					}
				}
			}

			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + minWire);

		}
	}

	static void dfs(int idx, int coreCount, int wireCount) {

		if (idx == cores.size()) {
			if (maxCore < coreCount) {
				maxCore = coreCount;
				minWire = wireCount;
			} else if (maxCore == coreCount) {
				minWire = Math.min(wireCount, minWire);
			}
			return;
		}
		int y = cores.get(idx).get(0);
		int x = cores.get(idx).get(1);
		for (int i = 0; i < 4; i++) {
			if (canConnect(y, x, i)) {
				int length = setWire(y, x, i, true);

				dfs(idx + 1, coreCount + 1, wireCount + length);

				setWire(y, x, i, false);
			}
		}
		dfs(idx + 1, coreCount, wireCount);
	}

	static boolean canConnect(int y, int x, int i) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		while (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			if (arr[ny][nx] == 1) {
				return false;
			}
			if (visited[ny][nx]) {
				return false;
			}
			ny += dy[i];
			nx += dx[i];
		}

		return true;
	}

	static int setWire(int y, int x, int i, boolean canConnect) {
		int count = 0;
		int nx = x + dx[i];
		int ny = y + dy[i];

		while (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			visited[ny][nx] = canConnect;
			count++;
			ny += dy[i];
			nx += dx[i];
		}
		return count;
	}
}
