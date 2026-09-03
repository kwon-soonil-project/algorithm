package algo.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1211 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] list = new int[100][100];
			
			List<Integer> xs = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					list[i][j] = sc.nextInt();
					if (i == 0 && list[i][j] == 1) {
						xs.add(j);
						
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			int minx = 0;
			for (int x : xs) {
				int ox = x;
				boolean[][] blist = new boolean[100][100];
				int count = 0;
				int y = 0;
				while (true) {
					blist[y][x] = true;
					if (x + 1 < 100 && list[y][x + 1] == 1 && !blist[y][x + 1]) {
						x++;
					}
					else if(x > 0 && list[y][x - 1] == 1 && !blist[y][x - 1]) {
						x--;
					}
					else if (y + 1 < 100 && list[y + 1][x] == 1 && !blist[y + 1][x]) {
						y++;
					}
					count++;
					if(y == 99) {
						break;
					}
				}
				if(min > count) {
					min = count;
					minx = ox;
				}
			}
			
			
			System.out.println("#" + n + " " + minx);

		}
	}

}
