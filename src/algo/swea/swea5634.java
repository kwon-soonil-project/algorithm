package algo.swea;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class swea5634 {
	static List<List<Integer>> list;
	static int[] shorter;
	static int[] taller;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] p = new int[n + 1];
			list = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list.get(a).add(b);
				p[b] += 1;
			}

			shorter = new int[n + 1];
			taller = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				visited = new boolean[n + 1];
				visited[i] = true;
				dfs(i, i);
			}

			System.out.println(Arrays.toString(shorter));
			System.out.println(Arrays.toString(taller));
			
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (taller[i] + shorter[i] == n - 1) {
					ans++;
				}
			}
			System.out.print("#" + test_case + " " + ans);
		}
	}

	static void dfs(int n, int start) {

		if (list.get(n).isEmpty()) {
			return;
		}
		for (int i : list.get(n)) {
			if (!visited[i]) {
				visited[i] = true;
				taller[start] += 1;
				shorter[i] += 1;
				dfs(i, start);
			}

		}

	}
}
