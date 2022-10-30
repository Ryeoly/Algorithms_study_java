import java.util.*;
import java.io.*;
public class baekjoon_14442_벽부수고이동하기2 {
	public static void bfs(int[][] map, int n, int m, int k) {
		int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
		boolean[][][] visited = new boolean[n][m][k+1];
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {0,0,1,0}); // x, y 좌표 , 이동 거리, 벽 뚫은 횟수
		visited[0][0][0] = true;
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int x = tmp[0];
			int y = tmp[1];
			int dis = tmp[2];
			int skill = tmp[3];
			if(x == n-1 && y == m-1) {
				System.out.print(dis);
				System.exit(0);
			}
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || n<=nx || ny<0 || m<=ny) continue;
				
				if(map[nx][ny] == 1) { //벽이면
					if(skill < k && !visited[nx][ny][skill+1]) {
						que.offer(new int[] {nx, ny, dis+1, skill+1});
						visited[nx][ny][skill+1] = true;
					}
				}else { //평지면
					if(!visited[nx][ny][skill]) {
						que.offer(new int[] {nx, ny, dis+1, skill});
						visited[nx][ny][skill] = true;
					}
				}
				
			}
			
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String Line = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = (Line.charAt(j) - '0');
			}
		}
		bfs(map, n, m, k);
		System.out.print(-1);
		br.close();
	}
}
