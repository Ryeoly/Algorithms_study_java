package Implementation;

import java.io.*;
import java.util.*;

public class baekjoon_1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		String students = in.readLine();
		
		for(int i = 0 ; i < Integer.parseInt(students) ; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				for(int j = 0 ; j < N ; j++) {
					if((j+1)%num == 0) arr[j] = arr[j] == 0 ? 1:0;
				}
			}
			else if(sex ==2) {
				num -= 1;
				arr[num] = (arr[num])==1 ? 0:1;
				for(int j = 1 ; j < N+1 ; j++) {
					if(num-j >= 0 && num+j < N) {
						if(arr[num-j] == arr[num+j]) {
							arr[num-j] = (arr[num-j])==1 ? 0:1;
							arr[num+j] = (arr[num+j])==1 ? 0:1;
						}else{break;}
					}else {break;}
				}
			}else {
				System.out.println("error");
			}
		}
		for(int i = 0; i<N; i++) {
			System.out.print(arr[i] + " ");
			if((i+1) % 20 == 0) System.out.println();
		}
	}
}
