import java.util.*;
import java.io.*;
public class baekjoon_1600_말이되고픈원숭이 {
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
	static int[] hx = {-1,-2,-2,-1, 1,2,2,1}, hy = {-2,-1,1,2, -2,-1,1,2};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H+1][W+1];
		for(int i = 1 ; i <= H ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][][] dp = new int[K+1][H+1][W+1];
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {1,1,0}); // x, y, 높이(기능쓴 횟수)
		dp[0][1][1] = 1;
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int x = tmp[0];
			int y = tmp[1];
			int cnt = tmp[2];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<nx && nx<=H && 0<ny && ny<=W && map[nx][ny] == 0 && dp[cnt][nx][ny] == 0) {
					dp[cnt][nx][ny] = dp[cnt][x][y] + 1;
					que.offer(new int[] {nx, ny, cnt});
				}
			}
			if(cnt < K) {
				for(int i = 0 ; i < 8 ; i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];
					if(0<nx && nx<=H && 0<ny && ny<=W && map[nx][ny] == 0 && dp[cnt+1][nx][ny] == 0) {
						dp[cnt+1][nx][ny] = dp[cnt][x][y] + 1;
						que.offer(new int[] {nx, ny, cnt+1});
					}
				}
			}
		}
		int result = 100000000;
		for(int i = 0 ; i <= K ; i++) {
			if(dp[i][H][W] != 0) result = Math.min(result, dp[i][H][W]);
		}
		if(H == 1 && W == 1) System.out.println(0);
		else System.out.println((result == 100000000)? -1 : result-1);
	}
}
