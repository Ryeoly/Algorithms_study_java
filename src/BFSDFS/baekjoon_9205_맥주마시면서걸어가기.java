import java.util.*;
import java.io.*;
public class baekjoon_9205_맥주마시면서걸어가기 {
	static boolean flag;
	static boolean check(int x, int y, int fx, int fy) {
		if(Math.abs(x-fx) + Math.abs(y-fy) <= 1000) {
			System.out.println("happy");
			flag = true;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < t ; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			ArrayList<int[]> cs = new ArrayList<>();
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cs.add(new int[] {x, y});
			}
			st = new StringTokenizer(br.readLine(), " ");
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			
			
			flag = false;
			boolean[] v = new boolean[n];
			ArrayDeque<int[]> que = new ArrayDeque<>();
			que.add(new int[] {hx, hy});
			while(!que.isEmpty()) {
				int[] tmp = que.poll();
				int x = tmp[0];
				int y = tmp[1];
				if(check(x,y, fx, fy)) break;
				for(int i = 0 ; i < n ; i++) {
					if(v[i]) continue;
					int dis = Math.abs(x-cs.get(i)[0]) + Math.abs(y-cs.get(i)[1]);
					if(dis <= 1000) {
						que.offer(new int[] {cs.get(i)[0], cs.get(i)[1]});
						v[i] = true;
					}
				}
			}
			if(!flag) System.out.println("sad");
		}
	}
}
