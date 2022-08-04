package algo_test;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_15552 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < t ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a+b+"\n");			
		}
		System.out.println(sb);
	}
}
