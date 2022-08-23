package algoTest;
import java.io.*;
import java.util.*;
public class baekjoon_11657 {
	static int n,m, INF = 10000000;
	static long[] distance;
	static edge[] edges;
	static class edge{
		int s;
		int e;
		int w;
		public edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	static boolean bellmanford() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				edge tmp = edges[j];
				if(distance[tmp.s]==INF) continue;
				if(distance[tmp.e] > distance[tmp.s] + tmp.w) {
					distance[tmp.e] = distance[tmp.s] + tmp.w;
					if(i == n-1) return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		distance = new long[n+1];
		Arrays.fill(distance, INF);
		distance[1] = 0;
		edges= new edge[m];
		int s, e, w;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges[i] = new edge(s, e, w);
		}
		
		if(!bellmanford()) System.out.print(-1);
		else {
			for(int i = 2 ; i <= n ; i++) {
				if(distance[i] == INF) System.out.println(-1);
				else System.out.println(distance[i]);
			}
		}
	}
}
