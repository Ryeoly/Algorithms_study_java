package algoTest;
import java.util.*;
import java.io.*;
public class baekjoon_17070 {
	static int[][] arr;
	static int result;
	static int n;
	static void dfs(int x, int y, int mod) { //가로 0 , 세로 1, 대각 2
		if(x == n-1 && y == n-1) {
			result++;
			return;
		}
		if(mod == 0 || mod == 2) {
			if((y + 1 <= n-1) && (arr[x][y+1] != 1)) {dfs(x, y+1, 0);}
		}if(mod == 1 || mod == 2) {
			if((x+1 <= n-1) && (arr[x+1][y] != 1)) {dfs(x+1, y, 1);}
		}if(mod == 0 || mod == 1 || mod == 2) {
			if((x+1 <= n-1) && (y+1 <= n-1) && (arr[x+1][y] != 1) && (arr[x][y+1] != 1) && (arr[x+1][y+1] != 1)) {dfs(x+1, y+1, 2);}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		result = 0;
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0,1,0);
		System.out.print(result);
	}
}
