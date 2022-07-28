package Implementation;

import java.util.*;
import java.io.*;


public class baekjoon_2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		List<Integer> result = new ArrayList<>();
		
		int[] arr = new int[7];
		arr[a] += 1;
		arr[b] += 1;
		arr[c] += 1;
		for(int i = 6; i >= 0 ; i--) {
			if(arr[i] == 3) {
				result.add(10000 + i*1000);
			}
			else if(arr[i] == 2) {
				result.add(1000 + i*100);
			}
			else if(arr[i] == 1) {
				result.add(i*100);
			}
		}
		System.out.println(Collections.max(result));
	}

}
