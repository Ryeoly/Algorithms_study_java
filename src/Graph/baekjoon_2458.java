package algoTest;
import java.io.*;
import java.util.*;
public class baekjoon_2458 {
	static int n, m;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		int a, b;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		
		for(int k = 1 ; k <= n ; k++) {
			for(int i = 1 ; i <= n; i++) {
				for(int j = 1; j <=n ; j++) {
					if(arr[i][j] == 0 && arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for(int i = 1; i<= n ; i++) {
			for(int j = 1; j <= n ;j++) {
				if(arr[i][j] == 1) arr[j][i] =1;
				if(i == j) arr[i][j] = 1;
			}
		}
	
		int result = n;
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1; j<= n ; j++) {
				if(arr[i][j] == 0) {
					result -= 1;
					break;
				}
			}
		}
		System.out.print(result);
	}
}
