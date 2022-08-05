package algo_test;
import java.util.*;
import java.io.*;
public class baekjoon_11660 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//열 누적
		for(int i = 0 ; i < n ; i++) {
			for(int j = 1 ; j < n ; j++) {
				arr[i][j] = arr[i][j] + arr[i][j-1];
			}
		}
		//행 누적
		for(int i = 0; i < n ; i++) {
			for(int j = 1 ; j < n ; j++) {
				arr[j][i] = arr[j-1][i] + arr[j][i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(x1-2<0 && y1-2<0) {
				result = arr[x2-1][y2-1];
			}else if(x1-2<0){
				result = arr[x2-1][y2-1] - arr[x2-1][y1-2];
			}else if(y1-2<0) {
				result = arr[x2-1][y2-1] - arr[x1-2][y2-1];
			}else {
				result = arr[x2-1][y2-1] - arr[x1-2][y2-1] - arr[x2-1][y1-2] + arr[x1-2][y1-2];
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
