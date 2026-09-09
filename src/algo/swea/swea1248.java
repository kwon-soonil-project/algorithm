package algo.swea;

import java.util.Scanner;

public class swea1248 {
	static int[][] g;
	static int ans;
	static int a;
	static int b;
	static int cnt;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			g = new int[v + 1][2];
			for (int i = 0; i < e; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				if (g[p][0] == 0) {
					g[p][0] = c;
				} else {
					g[p][1] = c;
				}
			}
			search(1);
			System.out.println("#" + test_case + " " + ans + " " + cnt(ans));
		}
	}

	public static boolean search(int s) {
		boolean[] bList = new boolean[2];
		if (s == a || s == b) {
			return true;
		}
		for (int i = 0; i < 2; i++) {
			if (g[s][i] > 0) {
				bList[i] = search(g[s][i]);
			}
		}
		if (bList[0] && bList[1]) {
			ans = s;
		}
		return bList[0] || bList[1];
	}

	public static int cnt(int s) {
		int count = 1;
		for (int i = 0; i < 2; i++) {
			if (g[s][i] > 0) {
				count += cnt(g[s][i]);
			}
		}
		return count;
	}
}
