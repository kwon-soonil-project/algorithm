package algo.swea;

import java.util.Scanner;

public class swea5432 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] list = sc.next().toCharArray();
			int count = 0;
			int stick = 0;
			for (int i = 0; i < list.length; i++) {
				if (i < list.length - 1 && list[i] == '(' && list[i + 1] == ')') {
					count += stick;
					i++;
					continue;
				}
				if (list[i] == '(') {
					stick++;
				} else {
					stick--;
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}

}
