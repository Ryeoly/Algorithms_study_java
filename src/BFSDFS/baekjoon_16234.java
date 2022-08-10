package BFSDFS;
import java.util.*;
import java.io.*;
public class baekjoon_16234 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n, l , r;
	
	static class pos{
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
	}
	
	static void move(int x, int y) {
		List<pos> poss = new ArrayList<>();
		Queue<pos> que = new ArrayDeque<>();
		visited[x][y] = true;
		que.offer(new pos(x, y));
		poss.add(new pos(x, y));
		int sum = arr[x][y];
		int cnt = 1;
		while(!que.isEmpty()) {
			int cur_x = que.peek().getX();
			int cur_y = que.peek().getY();
			que.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
					int sub = Math.abs(arr[cur_x][cur_y] - arr[nx][ny]);
					if(l <= sub && sub <= r) {
						que.offer(new pos(nx,ny));
						poss.add(new pos(nx,ny));
						visited[nx][ny] = true;
						sum += arr[nx][ny];
						cnt += 1;
					}
				}
				
			}
		}
		if(cnt != 1) {
			for(int i = 0 ; i < cnt ; i++) {
				arr[poss.get(i).getX()][poss.get(i).getY()] = sum/cnt;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < n ; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = -1;
		int result = 0;
		while(cnt != 0) {
			cnt = 0;
			visited = new boolean[n][n];
			for(int i = 0 ; i<n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(!visited[i][j]) { //방문을 안했다면
						move(i, j);
						cnt++;
					}
				}
			}
			if(cnt == n*n) break;
			else result += 1;
		}
		System.out.println(result);
	}
}
