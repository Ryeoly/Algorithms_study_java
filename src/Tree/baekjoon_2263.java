package algoTest;
import java.io.*;
import java.util.*;
public class baekjoon_2263 {
	static StringBuilder sb;
	static int[] in, post;
	static void recur(int ins, int ine, int pos, int poe) {
		if(ins > ine || pos > poe) return;
		int root = post[poe];
		sb.append(root).append(" ");
		int index = ins; 
		for(int i = ins ; i<=ine ;i++) {
			if(root == in[i]) {
				index = i;
				break;
			}
		}
		recur(ins, index-1, pos, poe-(ine-index+1));
		recur(index+1, ine,poe-(ine-index),poe-1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		in = new int[n];
		post = new int[n];
		
		StringTokenizer line2 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer line3 = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			in[i] = Integer.parseInt(line2.nextToken());
			post[i] = Integer.parseInt(line3.nextToken());
		}
		
		recur(0,n-1, 0,n-1);
		System.out.print(sb);
		br.close();
	}
}
