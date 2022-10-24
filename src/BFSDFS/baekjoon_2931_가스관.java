import java.util.*;
import java.io.*;
public class baekjoon_2931_가스관 {
	static int hx, hy, sx, sy, r, c; // 집, 유치원, 행, 열 변수
	static char[][] map; // 지도
	static int[][][] dir = {{},  //숫자들이 이동할 수 있는 방향들
							{{1,0}, {0,1}}, //하 우
							{{-1,0},{0,1}}, //상 우
							{{-1,0},{0,-1}}, //상 좌				
							{{1,0},{0,-1}} //하 좌  
							};
	
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1}; //상하좌우 , 집 유치원 +가 이동할 수 있는 방향들
	static int[] bfs(int x, int y) { // 집과 유치원에서 bfs로 길을 따라 이동
		int[] result = new int[2];
		
		boolean[][] visited = new boolean[r][c];	//방문 처리를 위한 변수
		Queue<int[]> que = new ArrayDeque<>();		//길을 따라가기 위한 큐
		visited[x][y] = true;						//방문 처리
		que.offer(new int[] {x, y});				//시작 위치 설정
		
		while(!que.isEmpty()) {	//움직일 수 없을때까지 반복
			int[] tmp = que.poll();	// 현재 위치
			int cx = tmp[0];	//x좌표
			int cy = tmp[1];	//y좌표
			if(map[cx][cy] == 'M' || map[cx][cy] == 'Z') { //현재 위치가 집과 유치원이면
				int cnt = 0;	//움직일 수 있는 방향의 수
				for(int i = 0 ; i < 4; i++) { // 4방 탐색
					int nx = cx + dx[i];	//이동  x좌표
					int ny = cy + dy[i];	//이동  y좌표
					if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny] && map[nx][ny] != '.') { //움직일 수 있다면
						cnt += 1;	//움질일수있는 방향 +1
						visited[nx][ny] = true; //방문 처리
						que.offer(new int[] {nx, ny}); //움직일 곳 저장
					}
				}
				if(cnt == 0) {result[0] = -1; result[1] = -1; return result;} // 유치원과 집에서부터 움직일 수 없다면 종료
			}else if(map[cx][cy] == '+') { // +라면
				for(int i = 0 ; i < 4; i++) {//4방탐색
					int nx = cx + dx[i];	//다음 x좌표
					int ny = cy + dy[i];	//다음 y좌표
					if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny]) { //움직일 수있다면
						if(map[nx][ny] == '.') { // 지워진 위치 추론
							result[0] = nx;	// 결과값 저장
							result[1] = ny;
							return result;	// 종료
						}
						visited[nx][ny] = true; //방문 처리
						que.offer(new int[] {nx, ny}); //움직일 곳 저장
					}
				}
			}else if( 0 < map[cx][cy] -'0' && map[cx][cy] -'0' <5) { //숫자라면
				int d = map[cx][cy] - '0';	//char to int
				for(int i = 0 ; i < 2; i++) {	//숫자면 이동 가능방향 2가지
					int nx = cx + dir[d][0][i];	//이동 x좌표
					int ny = cy + dir[d][1][i]; //이동 y좌표
					if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny]) { // 이동 가능
						if(map[nx][ny] == '.') { // 지워진 위치
							result[0] = nx; //결과값 저장
							result[1] = ny;
							return result; //종료
						}
						visited[nx][ny] = true; //방문 처리
						que.offer(new int[] {nx, ny}); //움직일 곳 저장
					}
				}
			}else if(map[cx][cy] == '|') { //상하 이동 가능
				for(int i = 0 ; i < 2; i++) { //2번 확인
					int nx = cx + dx[i]; //다음x 좌표
					int ny = cy + dy[i]; //다음y 좌표 
					if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny]) { //이동 가능
						if(map[nx][ny] == '.') { //지워진 위치
							result[0] = nx; //결과값 저장
							result[1] = ny;
							return result; //종료
						}
						visited[nx][ny] = true; //방문 처리
						que.offer(new int[] {nx, ny}); //움직일 곳 저장
					}
				}
			}else if(map[cx][cy] == '-') { // 좌우
				for(int i = 2 ; i < 4; i++) { //2번 반복
					int nx = cx + dx[i]; //이동 x좌표
					int ny = cy + dy[i]; //이동 y좌표
					if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny]) { //이동 가능
						if(map[nx][ny] == '.') { //지워진 위치
							result[0] = nx; //결과값 저장
							result[1] = ny;
							return result; //종료
						}
						visited[nx][ny] = true; //방문 처리
						que.offer(new int[] {nx, ny}); //움직일 곳 저장
					}
				}
			}else if(map[cx][cy] == '.') { //예외처리
				result[0] = cx;
				result[1] = cy;
				return result;
			}else continue; // 예외 처리
		}
		return result;
	}
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder(); //출력 변수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 변수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken()); // r입력
		c = Integer.parseInt(st.nextToken()); //c 입력
		
		map = new char[r][c]; // 지도 선언
		for(int i = 0 ; i < r;  i++) { //지도 입력 받아 저장, 행
			String line= br.readLine();
			for(int j = 0 ; j < c ; j++) { //열
				char charac = line.charAt(j);
				if(charac == 'M') {hx = i; hy = j;} // 집좌표 저장
				else if(charac == 'Z') {sx = i; sy = j;} //유치원 좌표 저장
				map[i][j] = charac;
			}
		}
		
		int[] result = bfs(hx, hy); // 집에서 이동시 지워진 부분 추론 결과
		if(result[0] == -1 && result[1] == -1) { // 집에서 이동이 불가능하다면
			result = bfs(sx, sy);//유치원에서부터 이동
		}
		int[] check = new int[4]; //지워진 곳 추론하기 위한 변수
		int loads = 0; //길 개수
		for(int i = 0 ; i < 4 ; i++) { //상하좌우 체크
			int nx = result[0] + dx[i];
			int ny = result[1] + dy[i];
			if(0<=nx && nx<r && 0<=ny && ny<c && map[nx][ny] != '.') { // 이동할 수 있는 곳이 있다면
				if(i == 0 && (map[nx][ny] == '|' || map[nx][ny] == '+' || map[nx][ny] == '1' || map[nx][ny] == '4')) {
					check[i] = 1; // 이동 가능 부분 저장
					loads += 1; //이동 가능 길 개수 +1
				}else if(i == 1 && (map[nx][ny] == '|' || map[nx][ny] == '+' || map[nx][ny] == '2' || map[nx][ny] == '3')) {
					check[i] = 1; // 이동 가능 부분 저장
					loads += 1; //이동 가능 길 개수 +1
				}else if(i == 2 && (map[nx][ny] == '-' || map[nx][ny] == '+' || map[nx][ny] == '1' || map[nx][ny] == '2')) {
					check[i] = 1; // 이동 가능 부분 저장
					loads += 1; //이동 가능 길 개수 +1
				}else if(i == 3 && (map[nx][ny] == '-' || map[nx][ny] == '+' || map[nx][ny] == '3' || map[nx][ny] == '4')) {
					check[i] = 1; // 이동 가능 부분 저장
					loads += 1; //이동 가능 길 개수 +1
				}
			}
		}
		char result_char = '.'; // 지워진 곳 결과 저장할 변수
		if(loads == 4) result_char = '+'; // 4방향으로 갈 수 있다면 +
		else { // 지워진 곳 4방 탐색을 한 결과로, 해당 길을 이어주기 위해 각 경우에 따라 결과값을 설정
			if(check[0] == 1 && check[1] == 1) result_char='|'; //상 하
			else if(check[2] == 1 && check[3] == 1) result_char = '-'; //좌 우
			else if(check[1] == 1 && check[3] == 1) result_char = '1'; //하 우
			else if(check[0] == 1 && check[3] == 1) result_char = '2'; //상 우
			else if(check[0] == 1 && check[2] == 1) result_char = '3'; //상 좌
			else if(check[1] == 1 && check[2] == 1) result_char = '4'; //하 좌
		}
		System.out.print((result[0]+1) + " " + (result[1]+1) + " " + result_char); //결과값 출력
		br.close();// 종료
	}
}
