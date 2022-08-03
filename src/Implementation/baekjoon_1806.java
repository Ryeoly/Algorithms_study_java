package algo_test;

import java.util.*;
import java.io.*;
public class baekjoon_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int[] s_arr = new int[n+1];
		s_arr[1] = Integer.parseInt(st.nextToken());
		for(int i = 2 ; i < n+1 ; i++) {
			s_arr[i] = s_arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int first = 1;
		int second = 0;
		int result = Integer.MAX_VALUE;
		int temp = 0;
		while(first < n && second < n) {
			temp = s_arr[first] - s_arr[second];
			result = Math.min(result, first-second+1);
			if(temp > s) second += 1;
			if(temp <= s) first += 1;
		}
		System.out.println(result);
	}
}
