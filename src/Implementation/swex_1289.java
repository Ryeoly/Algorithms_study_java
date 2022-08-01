package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swex_1289 {

	public static void swit(char[] zero,int num) {
		for(int i = num ; i < zero.length ; i++) {
			zero[i] = zero[i]=='1' ? '0':'1';
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine()); 
		
		for(int i = 1 ; i <= T ; i++) {
			char[] line = in.readLine().toCharArray();
			char[] zero = new char[line.length];
			for(int j = 0 ; j < line.length ; j++) zero[j] = '0';
			int result = 0;
			for(int j = 0 ; j < line.length ; j++) {
				if(zero[j] != line[j]) {
					result += 1;
					swit(zero, j);
				}
			}
			System.out.printf("#%d %d\n", i, result);
		}
	}
}
