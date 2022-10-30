import java.util.*;
import java.io.*;
public class baekjoon_2206_벽부수고이동하기 {
	static int[] dx = {1,-1,0,0}, dy= {0,0,1,-1};
	public static void bfs(int[][] map, int n, int m) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {0,0,1,0}); // x, y, 이동 거리, 벽뚫? - 0은 안뚫, 1은 뚫 
		boolean[][][] visited = new boolean[2][n][m];
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
				if(0 <= nx && nx < n && 0 <= ny && ny < m) {
					if(map[nx][ny] == 1) { //이동 불가능. 벽
						if(skill == 0 && !visited[1][nx][ny]) {
							que.offer(new int[] {nx, ny, dis+1, 1});
							visited[1][nx][ny] = true;
						}
					}else { // 이동 가능. 평지
						if(!visited[skill][nx][ny]) {
							que.offer(new int[] {nx, ny, dis+1, skill});
							visited[skill][nx][ny] = true;
						}
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
		int[][] map = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String Line = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = (Line.charAt(j) - '0');
			}
		}
		bfs(map,n,m);
		System.out.print("-1");
		br.close();
	}
}
