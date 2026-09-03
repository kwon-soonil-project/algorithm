package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1219 {
	static List<List<Integer>> list;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			int r = sc.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				list.add(new ArrayList<Integer>());
			}
			int a;
			int b;
			for (int i = 0; i < r; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				list.get(a).add(b);
			}
			System.out.println("#" + test_case + " " + go(0));
		}
	}
	public static int go(int n) {
		if (n == 99) return 1;
		for (int i = 0; i < list.get(n).size(); i++) {
			if (go(list.get(n).get(i)) == 1) {
				return 1;
			}
		}
		return 0;
	}
}
