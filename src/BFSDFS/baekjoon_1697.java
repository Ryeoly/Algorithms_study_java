package BFSDFS;

import java.util.*;
import java.io.*;


public class baekjoon_1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] line = new int[100001];
		
		Queue<Integer> que = new ArrayDeque<>();
		que.add(n);
		line[n] = 1;
		while(line[k] == 0) {
			int pos = que.poll();
			if(0 <= pos+1 && pos+1 < 100001 && line[pos+1]== 0) {
				line[pos+1] = line[pos]+1;
				que.add(pos+1);
			}
			if(0 <= pos-1 && pos-1 < 100001 && line[pos-1]== 0) {
				line[pos-1] = line[pos]+1;
				que.add(pos-1);
			}
			if(0 <= pos*2 && pos*2 < 100001 && line[pos*2]== 0) {
				line[pos*2] = line[pos]+1;
				que.add(pos*2);
			}
		}
		System.out.print(line[k]-1);
	}
}
