package algo.swea;

import java.util.Scanner;

public class swea1220 {
	static int[][] map;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			map = new int[n][n];
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				ans += search(i);
			}
			System.out.println("#" + test_case + " " + ans);


		}
	}

	public static int search(int x) {
		int count = 0;
		boolean isN = false;
		for (int i = 0; i < 100; i++) {
			if (isN) {
				if (map[i][x] == 2) {
					count++;
					isN = false;
				}
			} else {
				if (map[i][x] == 1) {
					isN = true;
				}
			}
		}
		return count;

	}
}
