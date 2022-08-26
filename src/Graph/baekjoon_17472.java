package algoTest;
import java.io.*;
import java.util.*;

public class baekjoon_17472 {
	static int[][] map, v, dis;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1}, parent; //하, 상, 우, 좌
	static int n, m, island;
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		else {
			parent[Math.max(a, b)] = Math.min(a, b);
			return true;
		}
	}
	static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	static void make_distance(int x, int y) {
		for(int i = 0 ; i < 4; i++) {
			int load = 0;   // 다리 길이 
			int to = -1;	// 어떤 섬과 닿았는지 
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			while(true) {
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(map[nx][ny] == 0){
						load+=1;
						nx += dx[i];
						ny += dy[i];
					}else{
						to = map[nx][ny];
						break;
					}
				}else break;
			}
			
			if(load >= 2 && to != -1) {
				dis[map[x][y]][to] = Math.min(dis[map[x][y]][to], load);
				dis[to][map[x][y]] = Math.min(dis[to][map[x][y]], load);
			}
		}
	}
	static void bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {x,y});
		v[x][y] = 1;
		map[x][y] = island;
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			x = tmp[0];
			y = tmp[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]!=0 && v[nx][ny]==0) {
					map[nx][ny] = island;
					que.offer(new int[] {nx,ny});
					v[nx][ny] = 1;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		v = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < m ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		island = 1;
		for(int i = 0 ; i< n ; i++) {
			for(int j = 0 ; j < m ;j++) {
				if(map[i][j] != 0 && v[i][j] == 0) {
					bfs(i, j);
					island+=1;
				}
			}
		}
		
		dis = new int[island][island]; // 각 섬으로 이어지는 다리의 최소값을 저장할 distance 배열
		parent = new int[island];
		for(int i = 0 ; i < island ; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE);
			parent[i] = i;
		}
		for(int i = 0 ; i< n ; i++) {
			for(int j = 0 ; j < m ;j++) {
				if(map[i][j] != 0) {
					make_distance(i, j);
				}
			}
		}
		ArrayList<int[]> edges = new ArrayList<>();
		for(int i = 1 ; i < island ; i++) {
			for(int j = 1 ; j < island ; j++) {
				if(dis[i][j] != Integer.MAX_VALUE) {
					edges.add(new int[] {i, j, dis[i][j]});
				}
			}
		}
		Collections.sort(edges, (o1,o2)->Integer.compare(o1[2], o2[2]));
		int answer = 0;
		int cnt = 0;
		for(int i = 0 ; i < edges.size() ; i++) {
			int[] edge = edges.get(i);
			if(union(edge[0], edge[1])) {
				answer += edge[2];
				cnt += 1;
			}
			if(cnt == island-2) break;
		}
		System.out.print(cnt!=island-2? -1:answer);
	}
}