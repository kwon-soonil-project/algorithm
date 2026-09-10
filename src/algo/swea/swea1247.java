package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1247 {
	static int min;
	static int n;
	static int[][] list;
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			n = sc.nextInt();
			visited = new boolean[n + 2];
			list = new int[n + 2][2];
			list[0][0] = sc.nextInt();
			list[0][1] = sc.nextInt();
			list[n + 1][0] = sc.nextInt();
			list[n + 1][1] = sc.nextInt();
			
			for (int i = 1; i <= n; i++) {
				list[i][0] = sc.nextInt();
				list[i][1] = sc.nextInt();
			}
			
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + min);
			
		}
	}
	static void dfs(int i, int distance, int count) {
		if (count == n) {
			int d = Math.abs(list[i][0] - list[n + 1][0]) + Math.abs(list[i][1] - list[n + 1][1]);
			min = Math.min(min, distance + d);
		}
		for (int j = 1; j <= n; j++) {
			if (!visited[j]) {
				visited[j] = true;
				int d = Math.abs(list[i][0] - list[j][0]) + Math.abs(list[i][1] - list[j][1]);
				dfs(j, distance + d, count + 1);
				visited[j] = false;
			}
		}
	}
}
