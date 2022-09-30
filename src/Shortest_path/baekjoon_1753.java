import java.util.*;
import java.io.*;
public class baekjoon_1753 {

	public static void dijkstra(int start, int[] distance, ArrayList<int[]>[] map) {
		PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
		que.add(new int[] {start,0});
		distance[start] = 0;
		while(!que.isEmpty()) {
			int[] node = que.poll();
			int dest = node[0];
			int weight = node[1];
			if(distance[dest] >= weight) {
				distance[dest] = weight;
				for(int[] nodes : map[dest]) {
					int after_dest = nodes[0];
					int after_weight = nodes[1];
					if(distance[after_dest] <= after_weight+weight) continue; // 이미 존재하는 길보다 길면 볼 필요 없다. 
					distance[after_dest] = after_weight+weight;
					que.add(new int[] {after_dest, after_weight+weight});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] map = new ArrayList[V+1];
		int[] distance = new int[V+1];
		int INF = 1000000000;
		for(int i = 0 ; i <= V ; i++) {distance[i] = INF; map[i] = new ArrayList<>();} 
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[u].add(new int[] {v, w});
		}
		
		dijkstra(K, distance, map);
		for(int i = 1 ; i <= V ; i++) {
			if(distance[i] >= 1000000000) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}
