package algo.swea;

import java.util.HashMap;
import java.util.Scanner;

public class swea1218 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = sc.nextInt();
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			char[] list = sc.next().toCharArray();
			for (int i = 0; i < n; i++) {
				char cc = list[i];
				if (cc == '<') a++;
				else if(cc == '>') a--;
				else if(cc == '(') b++;
				else if(cc == ')') b--;
				else if(cc == '[') c++;
				else if(cc == ']') c--;
				else if(cc == '{') d++;
				else if(cc == '}') d--;

			}
			
			if (a == 0 && b == 0 && c == 0 && d == 0) System.out.println("#" + test_case + " " + 1);
			else System.out.println("#" + test_case + " " + 0);
		}
	}

}
