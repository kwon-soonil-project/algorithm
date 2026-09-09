package algo.swea;

import java.util.*;

public class swea3952 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] list = new int[n + 1];
			List<List<Integer>> graph = new ArrayList<>();
			graph.add(new ArrayList<Integer>());
			for (int i = 1; i <= n; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int i = 1; i <= m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.get(a).add(b);
				list[b] += 1;
			}
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) {
				if (list[i] == 0) {
					q.add(i);
				}
			}
			System.out.print("#" + test_case);
			while (!q.isEmpty()) {
				int now = q.poll();
				System.out.print(" " + now);
				for (int s : graph.get(now)) {
					list[s] -= 1;
					if (list[s] == 0) {
						q.add(s);
					}
				}
			}
			System.out.println();
			
		}
	}
}
