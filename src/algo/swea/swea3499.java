package algo.swea;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class swea3499 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			Queue<String> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				q.add(sc.next());
			}
			Queue<String> q1 = new ArrayDeque<>();
			Queue<String> q2 = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				if (i < (float)n / 2) {
					q1.add(q.poll());
				} else {
					q2.add(q.poll());
				}
			}
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					q.add(q1.poll());
				} else {
					q.add(q2.poll());
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
