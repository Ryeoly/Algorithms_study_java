package BFSDFS;
import java.util.*;
import java.io.*;
public class baekjoon_17070 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < n ; j++) { arr[i][j] = Integer.parseInt(st.nextToken()); }
		}
		
		int result = 0;
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.add(new int[] {0,0,0,1});
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int x1 = tmp[0];
			int y1 = tmp[1];
			int x2 = tmp[2];
			int y2 = tmp[3];
			
			if(x1 == x2 && y1 + 1 == y2) {
				if(x2 == n-1 && y2+1 == n-1) {result += 1;}//가로로 있는데, 가로로 한칸이 도착이면
				else if(y2+1 < n && arr[x2][y2+1] == 0) que.add(new int[] {x2,y2,x2,y2+1}); //가로로 있는데 가로로 밀고 도착아니면 추가
			}else if(x1 + 1 == x2 && y1 == y2) { //세로로 있는데
				if(x2+1 == n-1 && y2 == n-1) {result += 1;}//세로로 한칸이 도착이면
				else if(x2+1 < n && arr[x2+1][y2] == 0) que.add(new int[] {x2,y2,x2+1,y2}); //세로로 있는데 세로로 한칸ㅇ ㅣ동
			}else if(x1+1 == x2 && y1+1 ==y2) {
				if(x2 == n-1 && y2+1 == n-1) {result += 1;} //가로
				else if(y2+1 < n && arr[x2][y2+1] == 0) que.add(new int[] {x2,y2,x2,y2+1}); //가로로 있는데 가로로 밀고 도착아니면 추가
				if(x2+1 == n-1 && y2 == n-1) {result += 1;}//세로로 한칸이 도착이면
				else if(x2+1 < n && arr[x2+1][y2] == 0) que.add(new int[] {x2,y2,x2+1,y2}); //세로로 있는데 세로로 한칸ㅇ ㅣ동
			}
			if(x2+1 == n-1 && y2+1 == n-1) {result += 1;}
			else if(y2+1 < n && x2+1 < n && arr[x2][y2+1] == 0 && arr[x2+1][y2+1] == 0 && arr[x2+1][y2] == 0) que.add(new int[] {x2,y2,x2+1,y2+1});
		}
		System.out.print(result);
	}
}
