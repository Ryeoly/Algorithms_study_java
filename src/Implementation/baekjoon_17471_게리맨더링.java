import java.util.*;
import java.io.*;
public class baekjoon_17471_게리맨더링 {
	static boolean[] A;
	static int[] w;
	static ArrayList<Integer>[] arr;
	static int result;
	static void comb(int depth, int n) {
		if(depth > n) {
			ArrayDeque<Integer> aque = new ArrayDeque<>();
			ArrayDeque<Integer> bque = new ArrayDeque<>();
			boolean[] v = new boolean[n+1];
			
			for(int i = 1 ; i <= n ;i++){ 
				if(A[i]) {aque.offer(i); v[i] = true; break;}
			}
			for(int i = 1 ; i <= n ;i++){ 
				if(!A[i]) {bque.offer(i); v[i] = true; break;}
			}
			if(aque.size() == 0 || bque.size() == 0) return;
			
			while(!aque.isEmpty()) {
				int start = aque.poll();
				for(int dest : arr[start]) {
					if(!v[dest] && A[dest]) {v[dest] = true; aque.offer(dest);}
				}
			}
			while(!bque.isEmpty()) {
				int start = bque.poll();
				for(int dest : arr[start]) {
					if(!v[dest] && !A[dest]) {v[dest] = true; bque.offer(dest);}
				}
			}
			
			for(int i = 1 ; i <= n ; i++) {
				if(!v[i]) return;
			}
			
			int a_sum = 0; 
			int b_sum = 0; 
			for(int i = 1 ; i<=n ; i++) {
				if(A[i]) a_sum += w[i];
				else b_sum += w[i];
			}
			result = Math.min(result, Math.abs(a_sum-b_sum));
			return;
		}
		A[depth] = false;
		comb(depth+1, n);
		A[depth] = true;
		comb(depth+1, n);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		w = new int[n+1];
		arr = new ArrayList[n+1];
		A = new boolean[n+1];
		result = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = new ArrayList<>();			
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");	
			int nums = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < nums ; j++) {
				int d = Integer.parseInt(st.nextToken());
				arr[i].add(d);
			}
		}
		
		comb(1, n);
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);		
	}
}
