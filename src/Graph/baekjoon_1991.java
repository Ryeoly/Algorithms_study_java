package algoTest;
import java.io.*;
import java.util.*;
public class baekjoon_1991 {
	static char[][] child;
	static StringBuilder sb = new StringBuilder();
	static void pre(char node) {
		if(node == '.') return;
		sb.append(node);
		pre(child[node-'0'][0]);
		pre(child[node-'0'][1]);
	}
	static void in(char node) {
		if(node == '.') return;
		in(child[node-'0'][0]);
		sb.append(node);
		in(child[node-'0'][1]);
	}
	static void post(char node) {
		if(node == '.') return;
		post(child[node-'0'][0]);
		post(child[node-'0'][1]);
		sb.append(node);
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		child = new char[43][2];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			child[root-'0'][0] = left;
			child[root-'0'][1] = right;
		}
		pre('A');
		sb.append("\n");
		in('A');
		sb.append("\n");
		post('A');
		
		System.out.print(sb);
		br.close();
	}
}
