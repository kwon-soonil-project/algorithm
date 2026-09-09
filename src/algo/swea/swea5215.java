package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea5215 {
	static int max;
	static List<Integer> scores;
	static List<Integer> calories;
	static int l;
	static int n;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			n = sc.nextInt();
			l = sc.nextInt();
			scores = new ArrayList<>();
			calories = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				scores.add(sc.nextInt());
				calories.add(sc.nextInt());
			}

			for (int i = 0; i < n; i++) {
				dfs(i, 0, 0);
			}
			System.out.println("#" + test_case + " " + max);

		}
	}

	public static void dfs(int idx, int calorie, int score) {
		
		if (calorie > l) {
			return;
		}
		max = Math.max(max, score);

		if (n == idx) {
			return;
		}
		dfs(idx + 1, calorie, score);
		dfs(idx + 1, calorie + calories.get(idx),  score + scores.get(idx));
	}
}
