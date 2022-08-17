package algoTest;

import java.util.*;
import java.io.*;

public class baekjoon_1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean[] arr = new boolean[4000001];
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		for(int i = 2 ; i*i <= n ; i++) {
			if(arr[i]) {for(int j = i*i ; j <= n ; j+=i) arr[j] = false;}
		}
		
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i = 2; i <= n ; i++) {if(arr[i]) prime.add(i);}
		
		int l = -1, r = -1, result = 0;
		int sum = 0;
		while(l <= r) {
			if(sum < n) { 
				r += 1; 
				if(r < prime.size()) sum += prime.get(r);
				else break;
			}
			else if(sum > n) {  
				l += 1;
				if(l < prime.size()) sum -= prime.get(l);
				else break;
			}
			else {
				result += 1; 
				r += 1; 
				if(r < prime.size()) sum += prime.get(r);
				else break;
			} 
		}
		System.out.print(result);
	}
}
