package Implementation;
import java.util.*;
import java.io.*;
public class baekjoon_2630 {
	static void setting(int[][] arr, int x, int y, int size) {
		for(int i = 0 ; i< size; i++) {
			for(int j = 0 ; j < size ; j++) {
				arr[x+i][y+j] = -1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		int blue = 0;
		int white = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int size = n;
		int color;
		boolean flag = true;
		while (size >= 1) {
			for(int i = 0; i < n/size ; i++) { // 작은 틀 start 점을 찍어주는 부분
				for(int j = 0 ; j < n/size ; j++) {
					flag = true;
					color = arr[i*size][j*size];
					if(color == -1) continue;
					else {
						for(int p = 0 ; p < size ; p++) {// 작은 size 창문 모두 체크
							for(int q = 0 ; q < size ; q++) {
								if(arr[i*size+p][j*size+q] != color) {
									flag = false;
									break;
								}
							}
						}
						if(flag) {
							if(color == 1) blue+=1;
							else if(color == 0) white+=1;
							setting(arr, i*size, j*size, size);
						}
					}
				}
			}
			size /= 2;
		}
		System.out.printf("%d\n%d", white, blue);	
	}
}
