package algo.swea;

import java.util.Scanner;

public class swea7102 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] c = new int[n + m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					c[i + j]++;
				}
			}
			int max = 0;
			for (int i = 0; i <= n + m; i++) {
				max = Math.max(max, c[i]);
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i <= n + m; i++) {
				if (c[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
