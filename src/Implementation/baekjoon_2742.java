package algo_test;

import java.io.*;

public class baekjoon_2742 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = n ; i > 0 ; i--) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
