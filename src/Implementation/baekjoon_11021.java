package Implementation;

import java.io.*;
import java.util.*;
public class baekjoon_11021 {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< t ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append("Case").append(" #").append(i+1).append(": ").append(a+b).append("\n");
		}
		System.out.println(sb);
	}
	
}
