package BFSDFS;
import java.util.*;
import java.io.*;
public class baekjoon_7569 {
	static int[][][] arr;
	static int m, n, h;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dh = {-1,1};
	static void bfs(Queue<int[]> que) {
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int x = tmp[0];
			int y = tmp[1];
			int height = tmp[2];
			
			for(int i = 0 ; i < 4 ; i++) { //사방 탐색
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny][height] == 0) {
					que.add(new int[] {nx, ny, height});
					arr[nx][ny][height] = arr[x][y][height] + 1;
				}
			}
			
			for(int i = 0 ; i < 2; i++) {
				int nh = height + dh[i];
				if(0 <= nh && nh < h && arr[x][y][nh] == 0) {
					que.add(new int[] {x, y, nh});
					arr[x][y][nh] = arr[x][y][height] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken()); // 가로
		n = Integer.parseInt(st.nextToken()); // 세로
		h = Integer.parseInt(st.nextToken()); // 높이
		
		arr = new int[n][m][h];
		Queue<int[]> que = new ArrayDeque<int[]>();
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < n ; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int p = 0 ; p < m ; p++) {
					arr[j][p][i] = Integer.parseInt(st.nextToken());
					if(arr[j][p][i] == 1) que.add(new int[] {j, p, i});
				}
			}
		}
		
		bfs(que);
		int result = -1;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				for(int p = 0 ; p < h ; p++) {
					if(arr[i][j][p] == 0) {System.out.print(-1); return;}
					result = Math.max(arr[i][j][p], result);
				}
			}
		}
		System.out.print(result-1);
	}
}
