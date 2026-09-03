package algo.swea;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class swea1225 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			int num;
			int count = 1;
			while (true) {
				if (count == 6) count = 1;
				num = q.poll();
				num -= count++;
				if (num <= 0) {
					num = 0;
					q.add(num);
					break;
				}
				q.add(num);
			}
			System.out.print("#" + test + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
