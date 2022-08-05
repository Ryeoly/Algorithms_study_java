package algo_test;
import java.util.*;
import java.io.*;
public class baekjoon_17298 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[n]; // 결과로 출력할 배열
		ArrayList<Integer>[] cnt = new ArrayList[1000002]; // 각 숫자에 해당하는 index
		for(int i = 0 ; i < 1000002 ; i++) {
			cnt[i] = new ArrayList();
		}
		PriorityQueue<Integer> que = new PriorityQueue<>(); // 낮은 숫자가 우선 순위인 큐
		que.add(arr[0]);
		cnt[arr[0]].add(0);
		for(int i = 1 ; i < n ; i++) {
			while(!que.isEmpty() && que.peek() < arr[i]) {
				int num = que.remove();
				while(cnt[num].size() != 0) {
					result[cnt[num].remove(0)] = arr[i];
				}
			}
			que.add(arr[i]);
			cnt[arr[i]].add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			if(result[i] == 0) {
				sb.append(-1).append(" ");
			}
			else sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
