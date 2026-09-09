package algo.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("data/경비원사각지대.txt"));
		Scanner sc = new Scanner(System.in);

// Scanner로 입력
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int x = 0;
			int y = 0;
			int ans = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2) {
						x = i;
						y = j;
					}
					if (arr[i][j] == 0) {
						cnt++;
					}
				}
			}
//            int[] dr = {-1, 1
			// 위
			for (int i = x; i >= 0; i--) {
				if (arr[i][y] == 0) {
					arr[i][y] = 1;
					cnt--;
				} else if (arr[i][y] == 1) {
					break;
				}
//
			}
			// 아래
			for (int i = x; i < N; i++) {
				if (arr[i][y] == 0) {
					arr[i][y] = 1;
					cnt--;
				} else if (arr[i][y] == 1) {
					break;
				}
			}
			// 오
			for (int i = y; i >= 0; i--) {
				if (arr[x][i] == 0) {
					arr[x][i] = 1;
					cnt--;
				} else if (arr[x][i] == 1) {
					break;
				}
			}
			// 왼
			for (int i = y; i < N; i++) {
				if (arr[x][i] == 0) {
					arr[x][i] = 1;
					cnt--;
				} else if (arr[x][i] == 1) {
					break;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
/*
 * 1 5 0 0 0 1 0 1 0 1 1 0 0 0 1 0 2 1 0 0 0 0 1 1 1 1 0
 */
