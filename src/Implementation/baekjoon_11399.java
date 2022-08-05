package algo_test;
import java.util.*;
import java.io.*;
public class baekjoon_11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i = n ; i > 0 ; i--) {
			result += arr[n-i]*i;
		}
		System.out.println(result);
	}

}
