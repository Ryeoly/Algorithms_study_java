package algo;

import java.io.*;
import java.util.*;

public class Solution_d4_보급로 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1 ; TC <= T ; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			int[][] result = new int[N+1][N+1];
			
			for(int i = 1; i <=N ; i++) {
				String line = br.readLine();
				for(int j = 1 ; j <=N ; j++) {
					map[i][j] = line.charAt(j-1)-'0';
					result[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Queue<int[]> que = new ArrayDeque<int[]>();
			que.offer(new int[] {1,1});
			
			int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
			result[1][1] = map[1][1];
			while(!que.isEmpty()) {
				int[] tmp = que.poll();
				int x = tmp[0];
				int y = tmp[1];
				for(int i = 0; i< 4 ; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 < nx && nx <= N && 0 < ny && ny <= N) {
						if(map[nx][ny]+result[x][y] < result[nx][ny]) {
							que.offer(new int[] {nx, ny});
							result[nx][ny] = map[nx][ny]+result[x][y];
						}
					}
				}
			}
			sb.append("#").append(TC).append(" ").append(result[N][N]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
