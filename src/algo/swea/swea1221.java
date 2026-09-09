package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class swea1221 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			List<String> list1 = new ArrayList<>();
			list1.add("ZRO");
			list1.add("ONE");
			list1.add("TWO");
			list1.add("THR");
			list1.add("FOR");
			list1.add("FIV");
			list1.add("SIX");
			list1.add("SVN");
			list1.add("EGT");
			list1.add("NIN");
			int[] list = new int[10];
			String tc = sc.next();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				list[list1.indexOf(sc.next())] += 1;
			}
			System.out.println(tc);
			StringBuilder sb = new StringBuilder();
			int idx = 0;
			for (int i : list) {

				for (int j = 0; j < i; j++) {
					sb.append(list1.get(idx) + " ");
				}
				idx++;
			}
			System.out.println(sb);
		}
	}
}
