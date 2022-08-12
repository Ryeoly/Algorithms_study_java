package algoTest;
import java.util.*;
import java.io.*;
public class baekjoon_12015 {
	static int[] arr;
	static ArrayList<Integer> result;
	static int n;
	
	static int binary_search(int num) {
		int start = 0;
		int end = result.size()-1;
		int index = -1;
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(result.get(mid) > num) {end = mid-1; index = mid;}
			
			else if(result.get(mid) == num) { //lower
				if(start==end) {return start;}
				end = mid;
				index = mid;
			}
			
			else start = mid+1;
		}
		return index;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		result = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i =0 ; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		result.add(arr[0]);
		for(int i = 1 ; i < n ; i++) {
			int tmp = binary_search(arr[i]);
			if(tmp == -1) result.add(arr[i]);
			else result.set(tmp, arr[i]);
		}
	
		System.out.print(result.size());
		br.close();
	}
}
