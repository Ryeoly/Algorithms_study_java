package algo_test;
import java.util.*;
import java.io.*;
public class baekjoon_10871 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp < x) {
				sb.append(temp).append(" ");
			}
			
		}
		System.out.print(sb);
	}

}
