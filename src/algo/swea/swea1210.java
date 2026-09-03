package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1210 {
	static List<List<Integer>> list;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int x = 0;
			int y = 0;
			list = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				list.add(new ArrayList<Integer>());
				for (int j = 0; j < 100; j++) {
					int num = sc.nextInt();
					list.get(i).add(num);
					if (num == 2) {
						x = i;
						y = j;
					}
				}

			}
			System.out.println("#" + n + " " + move(x, y));

		}
	}

	public static int move(int x, int y) {
		list.get(x).set(y, 0);
		if (y + 1 < 100 && list.get(x).get(y + 1) == 1) {
			return move(x, y + 1);
		}
		if (y - 1 >= 0 && list.get(x).get(y - 1) == 1) {
			return move(x, y - 1);
		}
		if (x - 1 >= 0 && list.get(x - 1).get(y) == 1) {
			return move(x - 1, y);
		} else {
			return y;
		}
	}
}
