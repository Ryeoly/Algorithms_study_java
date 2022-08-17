package algoTest;
import java.util.*;
import java.io.*;
public class baekjoon_1717 {
	static int[] arr;
	static void union(int x, int y) {
		int a = find(arr[x]);
		int b = find(arr[y]);
		arr[Math.max(a, b)] = Math.min(a, b);
	}
	static int find(int num) {
		if(arr[num] == num) return num;
		else return arr[num] = find(arr[num]);
	}
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1]; 
		for(int i = 0 ; i <= n ; i++)arr[i] = i;
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			if(cmd == 0) union(a, b);
			else {
				int x = find(a);
				int y = find(b);
				if(x == y) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
