import java.util.*;
import java.io.*;
public class baekjoon_1094_막대기 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int cm = 64;	
		int sum = 64;	
		int cnt = 1;	
		int x = Integer.parseInt(br.readLine()); 
		while(sum != x) {	
			cnt += 1;	
			cm = cm/2;	
			if(sum-cm >= x) { 
				sum -= cm;
				cnt -= 1;	
			}
		}
		System.out.print(cnt);
		br.close();	
	}
}
