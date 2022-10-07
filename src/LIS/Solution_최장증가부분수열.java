import java.util.*;
import java.io.*;
public class Solution_최장증가부분수열{
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc<=t ; tc++) {
            int n = Integer.parseInt(br.readLine());
             
            int[] nums = new int[n];
            int[] result = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < n ; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int size = 0;
            for(int i = 0 ; i < n ; i++) {
                int pos = Arrays.binarySearch(result, 0, size, nums[i]);
                if(pos >= 0) continue;
                int index = Math.abs(pos) - 1;
                result[index] = nums[i];
                if(index == size) size++;
            }
            sb.append("#").append(tc).append(" ").append(size).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}