package DP;
import java.util.*;
import java.io.*;

public class baekjoon_1149 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dp[0][0] = Integer.parseInt(st.nextToken()); // red
		dp[0][1] = Integer.parseInt(st.nextToken()); // green
		dp[0][2] = Integer.parseInt(st.nextToken()); // blue
		
		for(int i = 1 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[i][0] = Integer.min(dp[i-1][1], dp[i-1][2]) + r;
			dp[i][1] = Integer.min(dp[i-1][0], dp[i-1][2]) + g;
			dp[i][2] = Integer.min(dp[i-1][0], dp[i-1][1]) + b;
		}
		System.out.println( Integer.min( Integer.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]) );
	}
}
