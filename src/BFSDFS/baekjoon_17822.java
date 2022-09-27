import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.io.*;

public class Main {
	public static boolean bfs(int x, int y, int[][] map, int n, int m) {
		boolean check = false;
		int standard = map[x][y];
		int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
		Queue<int[]> que = new ArrayDeque<>(); 
		que.offer(new int[] {x, y});
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int curx = tmp[0];
			int cury = tmp[1];
			
			for(int i = 0 ; i < 4; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(ny == 0) ny = m;
				if(ny == m+1) ny = 1;
				if(0<nx && nx<=n && 0<ny && ny<=m && map[nx][ny] == standard) {
					map[nx][ny] = 0;
					map[x][y] = 0;
					check = true;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		return check;
	}
	
	public static void rotation(int d, int k, int[] map, int m) {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for(int i = 1 ; i <= m ; i++) {
			que.offer(map[i]);
		}
		if(d == 0) { // 시계 방향
			for(int i = 0 ; i < k ; i++) {
				int last = que.pollLast();
				que.offerFirst(last);
			}
		}else { // 반시계 방향
			for(int i = 0 ; i < k ; i++) {
				int first = que.pollFirst();
				que.offerLast(first);
			}
		}
		for(int i = 1 ; i<=m ; i++) {
			map[i] = que.pollFirst();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m+1];
		
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0 ; i < t ; i++) { // rotation
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x의 배수
			int d = Integer.parseInt(st.nextToken()); // 방향
			int k = Integer.parseInt(st.nextToken()); // k번 회전
			
			for(int p = x ; p <= n ; p+=x) {
				rotation(d, k, map[p], m);
			}
			
			boolean check = false;
			for(int p = 1 ; p <= n ; p++) {
				for(int q = 1 ; q <= m ; q++) {
					if(map[p][q] != 0) {
						if(!check) check = bfs(p, q, map, n, m);
						else bfs(p, q, map, n, m);
					}
				}
			}
	
			if(!check) { //결국 아무것도 바뀌지 않았을때
				int sum = 0; 
				int cnt = 0;
				for(int p = 1; p<=n ; p++) {
					for(int q = 1; q<=m ; q++) {
						if(map[p][q] != 0) {cnt += 1; sum += map[p][q];}
					}
				}
				if(cnt == 0) {System.out.println(0); return;}
				double avg = (1.0)*sum/cnt;
				for(int p = 1 ; p<=n ; p++) {
					for(int q = 1; q<=m ; q++) {
						if(map[p][q] == 0) continue;
						if(map[p][q] > avg) map[p][q] -= 1;
						else if(map[p][q] < avg) map[p][q] += 1;
					}
				}
			}
			
		}
		
		int sum = 0; 
		for(int p = 1; p<=n ; p++) {
			for(int q = 1; q<=m ; q++) {
				sum += map[p][q];
			}
		}
		System.out.println(sum);		
	}
}
