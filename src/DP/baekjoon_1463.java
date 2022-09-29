package DP;
import java.util.*;
import java.io.*;
public class baekjoon_1463 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1000001];
		
		for(int i = 2; i <=n ; i++) {
			int cnt = 1000001;
			if(i%3==0) cnt = Integer.min(cnt, dp[i/3]+1);
			if(i%2==0) cnt = Integer.min(cnt, dp[i/2]+1);
			cnt = Integer.min(cnt, dp[i-1]+1);
			dp[i] = cnt;
		}
		System.out.println(dp[n]);
	}

}
