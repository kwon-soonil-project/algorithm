package algo.swea;

import java.util.Scanner;

public class swea1204 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            int n = sc.nextInt();
            int[] scores = new int[101];
            for (int i = 0; i < 1000; i++) {
                scores[sc.nextInt()]++;
            }
            int max = 0;
            for(int i = 0; i < 101; i++) {
                if (scores[i] >= max) {
                    max = i;
                }
            }
            System.out.printf("$%d %d%n", test_case, scores[max]);
		}
	}

	
}
