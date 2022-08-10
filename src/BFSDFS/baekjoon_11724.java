package BFSDFS;
import java.util.*;
import java.io.*;
public class baekjoon_11724 {
	static int[] arr;
	static int find(int x) {
		if(x == arr[x]) return x;
		else return arr[x] = find(arr[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) arr[Math.max(x, y)] = Math.min(x, y);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) arr[i] = i; 
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 1 ; i <= n ; i++) arr[i] = find(i);
		for(int i = 1 ; i <= n ; i++) set.add(arr[i]);
		System.out.println(set.size());
	}
}