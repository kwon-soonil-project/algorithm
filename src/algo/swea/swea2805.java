package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n = sc.nextInt();
			List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(sc.next());
			}
			int ns = n / 2;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Math.abs(ns - i) + Math.abs(ns - j) <= ns){
						sum += list.get(i).charAt(j) - 48;
					}
				}
			}
			System.out.printf("#%d %d%n", test_case, sum);
			
		}

	}
}
