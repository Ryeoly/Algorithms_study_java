package Binary_Search;
import java.io.*;
import java.util.*;

public class baekjoon_2805 {
	static long[] arr;
	static long n, m;
	static long binary_search(long start, long end) {
		long result = 0;
		long mid=0;
		while(end >= start) {
			mid = (end+start)/2;
			long sum = 0;	
			for(int i = 0 ; i < n ; i++) {
				sum += Math.max(0,  arr[i] - mid);
			}
			if(sum < m) end = mid-1;
			else {
				start = mid + 1;
				if(result < mid) result = mid;
			}
		}
	
		return result;
	}	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		arr = new long[(int) n];
		st = new StringTokenizer(br.readLine(), " ");
		long max = -1;
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Long.parseLong(st.nextToken()); 
			max = Math.max(arr[i], max);
		}
		System.out.println(binary_search(0, max));
	}
}
