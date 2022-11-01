import java.util.*;
import java.io.*;
public class programmers_kakao2021 {

	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static int rotation(int[][] map, int x1, int y1, int x2, int y2){
        int first = map[x1][y1];
	    int min_num = first;
	    int dir = 0;
	    int x = x1;
	    int y = y1;
	    int nx = x1 + dx[dir];
	    int ny = y1 + dy[dir];
	        
	    while(true){
	    	if(dir >= 4 || (nx==x1 && ny==y1)) break;
	    	if(nx > x2 || nx < x1 || ny < y1 || ny > y2){
	    		dir+=1;
	    		nx = x + dx[dir];
	    		ny = y + dy[dir];
	    		continue;
	    	}
	    	map[x][y] = map[nx][ny];
	    	x = x + dx[dir];
	    	y = y + dy[dir];
	    	nx = nx + dx[dir];
	    	ny = ny + dy[dir];
	    	min_num = Math.min(map[x][y], min_num);  
	    }
	    map[x1][y1+1] = first;
	    return min_num;
	}
	public static int[] solution(int rows, int columns, int[][] queries) {

		int[] answer = new int[queries.length];

		int[][] map = new int[rows][columns];
		int cnt = 1;

		for(int i = 0 ; i < rows ; i++){
			for(int j = 0 ; j < columns ; j++){
				map[i][j] = cnt++;
			}
		}
		cnt = queries.length;
		for(int i = 0 ; i < cnt ; i++){
			answer[i] = rotation(map, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
		}
	        
		return answer;
	}
	public static void main(String[] args) throws Exception{
		int[][] tmp = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] result = solution(6, 6, tmp);
		for(int r : result) {
			System.out.print(r + " ");
		}
	}

}
