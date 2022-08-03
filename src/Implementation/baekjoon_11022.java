package algo_test;

import java.io.*;
import java.util.*;

public class baekjoon_11022 {

	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st;
		 for(int i = 1; i<=t ; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 sb.append("Case #").append(i).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b).append("\n");
		 }
		 System.out.print(sb);
		 
	}

}
