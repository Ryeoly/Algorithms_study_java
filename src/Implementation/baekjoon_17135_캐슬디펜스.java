import java.util.*;
import java.io.*;
public class Main {
	static int n, m, d, result, death;
	static boolean[][] map, test;
	static int[] pos;
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	static boolean round() {
		// 궁수가 공격
		ArrayList<int[]> list = new ArrayList<>();
		for(int i = 0 ; i < 3 ; i++) {
			int[] tmp = bfs(n-1, pos[i]);
			if((tmp[0] != n) && test[tmp[0]][tmp[1]]) { //두 궁수가 한 적을 죽일 수 있기에
				list.add(tmp);
			}
		}
		for(int i = 0 ; i < list.size() ; i++) {
			if(test[list.get(i)[0]][list.get(i)[1]]) { // 두 궁수가 한적을 죽이는 경우
				test[list.get(i)[0]][list.get(i)[1]] = false;
				result += 1;
			}
		}
		
		//적들이 앞으로 한칸씩 이동
		int cnt = 0;
		for(int i = n-1 ; i >= 1; i--) {
			for(int j = 0 ; j < m ; j++) {
				test[i][j] = test[i-1][j]; 
				if(test[i-1][j]) {
					cnt++;
				}
			}
		}
		for(int i = 0 ; i < m ; i++) test[0][i] = false;
		return (cnt>0)?true:false;
	}
	
	static int[] bfs(int x, int y) {
		if(test[x][y]) return new int[] {x, y}; //거리 1인 경우 바로 출력
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {x, y});
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			for(int i = 0 ; i < 3; i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(0<= nx && nx < n && 0<=ny && ny<m ) {
					if((Math.abs(nx-x)+Math.abs(ny-y)) < d) {
						if(test[nx][ny]) return new int[] {nx, ny};
						else que.offer(new int[] {nx, ny});
					}
					else return new int[] {n, n};
				}
			}
		}
		return new int[] {n, n};
	}
	static void comb(int depth, int start) {
		if(depth == 3) {
			result = 0;
			test = new boolean[n][m];
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) test[i][j] = map[i][j]; 
			}
			while(true) {
				if(!round()) break;
			}
			death = Math.max(death, result);
			return;
		}
		for(int i = start ; i < m ; i++) {
			pos[depth] = i;
			comb(depth+1, i+1);
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new boolean[n+1][m];

		death = -1;
		pos = new int[3];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < m ;j++) {
				if(Integer.parseInt(st.nextToken()) == 1) map[i][j] = true; 
			}
		}
		comb(0, 0);
		System.out.print(death);
	}
}