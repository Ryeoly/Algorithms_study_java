import java.util.*;
import java.io.*;
public class Main {
	static int n, e;
	static ArrayList<int[]>[] arr;
	static int INF = 100000000;
	static class node implements Comparable<node>{
		int end;
		int weight;
		public node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		public int getEnd() {
			return end;
		}
		public int getWeight() {
			return weight;
		}
		@Override
		public int compareTo(node o) {
			return this.weight - o.getWeight();
		}
	}
	static int[] dijkstra(int start) {
		int[] dis = new int[n+1];
		Arrays.fill(dis, INF);
		PriorityQueue<node> heapq = new PriorityQueue<>();
		
		dis[start] = 0;
		heapq.offer(new node(start, 0));
		//arr = end node 번호, 가중치 // heapq<node>
		while(!heapq.isEmpty()) {
			node tmp = heapq.poll();
			if(dis[tmp.getEnd()] < tmp.getWeight()) continue;
			for(int i = 0 ; i<arr[tmp.getEnd()].size() ; i++) {
				int node = arr[tmp.getEnd()].get(i)[0];
				int weight = arr[tmp.getEnd()].get(i)[1] + dis[tmp.end];
				if(weight < dis[node]) {
					dis[node] = weight;
					heapq.offer(new node(node, weight));
				}
			}
		}
		return dis;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) arr[i] = new ArrayList<>();
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[a].add(new int[] {b, weight});
			arr[b].add(new int[] {a, weight});
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken()); 
		
		
		int[] v1_dis = dijkstra(v1);
		int[] v2_dis = dijkstra(v2);
		int one = v1_dis[1] + v1_dis[v2] + v2_dis[n];
		int two = v2_dis[1] + v2_dis[v1] + v1_dis[n];
		int result = (one >= INF && two >= INF) ? -1 : Math.min(one, two);
		System.out.print(result);
		br.close();
	}
}