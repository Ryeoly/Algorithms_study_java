import java.util.*;
import java.io.*;
public class baekjoon_16946_벽부수고이동하기4 {
	static int cnt;
	public static void bfs(int[][] map, int[][][] result, boolean[][] visited, int i , int j, int n, int m) {
		int[] dx = {1, -1, 0, 0}, dy = {0,0,1,-1};
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {i, j});
		visited[i][j] = true;
		
		ArrayDeque<int[]> aftercheck = new ArrayDeque<>();
		aftercheck.offer(new int[] {i, j});
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int q = 0 ; q < 4 ; q++) {
				int nx = x + dx[q];
				int ny = y + dy[q];
				if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny] != 1 && !visited[nx][ny]) {
					que.offer(new int[] {nx, ny});
					aftercheck.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		int size = aftercheck.size();
		while(!aftercheck.isEmpty()) {
			int[] tmp = aftercheck.poll();
			result[0][tmp[0]][tmp[1]] = size;
			result[1][tmp[0]][tmp[1]] = cnt;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			String line = br.readLine();
			for(int j =0 ; j < m ; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		
		int[][][] result = new int[2][n][m];
		boolean[][] visited = new boolean[n][m];
		cnt = 1;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 0 && result[0][i][j] == 0) {
					bfs(map, result, visited, i, j, n, m);
					cnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int[] dx = {1, -1, 0, 0}, dy = {0,0,1,-1};
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 1) {
					int cnt = 1;
					HashSet<Integer> set = new HashSet<>();
					for(int q = 0 ; q<4 ; q++) {
						int nx = i + dx[q];
						int ny = j + dy[q];
						if(0<=nx && nx<n && 0<=ny && ny<m && !set.contains(result[1][nx][ny])) {
							cnt += result[0][nx][ny];
							set.add(result[1][nx][ny]);
						}
					}
					sb.append(cnt%10);
				}else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}
