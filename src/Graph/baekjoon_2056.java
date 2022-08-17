package algoTest;
import java.util.*;
import java.io.*;
public class baekjoon_2056 {
	static int n;
	static int[] needs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		needs = new int[n+1]; 
		for(int i = 1 ; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken()); //걸리는 시간
			int nodes = Integer.parseInt(st.nextToken());// 선행 작업 개수
			for(int j = 0 ; j < nodes ; j++) {
				int node = Integer.parseInt(st.nextToken()); //선행 작업 번호
				if(j == 0) { needs[i] = needs[node]; }
				else { needs[i] = Math.max(needs[i], needs[node]); }
			}
			needs[i] += time;
		}
		
		int result = -1;
		for(int i = 1 ; i <=n ; i++) result = Math.max(needs[i], result);
		System.out.print(result);
	}

}
