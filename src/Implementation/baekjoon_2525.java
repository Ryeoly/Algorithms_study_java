package Implementation;

import java.util.Scanner;

public class baekjoon_2525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int need = sc.nextInt();
		
		h += need/60;
		m += need%60;
		
		if(m >= 60) {
			h += 1;
			m -= 60;
		}
		if(h >= 24) {
			h -= 24;
		}
		System.out.println(h + " " + m);
	}

}
