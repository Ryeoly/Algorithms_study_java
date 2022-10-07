import java.util.*;
import java.io.*;
public class Solution_사람네트워크2{
 
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1 ; tc<=t ; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
             
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for(int i = 0 ; i < n ;i++) {
                for(int j = 0 ; j<n ; j++) {
                    int dis = Integer.parseInt(st.nextToken());
                    if(dis == 0 && i!=j) map[i][j] = 100000000;
                    else map[i][j] = dis;
                }
            }
             
            for(int k = 0 ; k < n ; k++) {
                for(int i = 0 ; i < n ;i++) {
                    for(int j = 0 ; j < n ; j++) {
                        map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
                    }
                }
            }
             
            int result = Integer.MAX_VALUE;
             
            for(int i = 0 ; i < n ; i++) {
                int sum = 0;
                for(int j = 0 ; j < n ; j++) {
                    sum += map[i][j];
                }
                result = Math.min(result, sum);
            }
             
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}