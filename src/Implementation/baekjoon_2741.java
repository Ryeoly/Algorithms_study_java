package algo_test;

import java.util.Scanner;

public class baekjoon_2741 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= n ; i++) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}
