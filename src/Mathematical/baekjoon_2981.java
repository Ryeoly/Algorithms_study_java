package algo;
import java.util.*;
import java.io.*;
public class baekjoon_2981 {
	static long gcd(long a, long b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
	static void cnt(int num) {
		for(int i = 2 ;i <= num ; i++) {
			if(num%i == 0) System.out.print(i+" ");
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int tmp = arr[1] - arr[0];
		for(int i = 2; i < n ; i++) tmp = (int) gcd(tmp, arr[i] - arr[i-1]); 
		cnt(tmp);
	}
}
