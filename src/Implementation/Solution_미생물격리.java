package algo;
import java.util.*;
import java.io.*;
public class Solution_미생물격리 {
	static int[] dx = {-1, 1, 0, 0}, dy = {0,0,-1, 1};
	static class pos implements Comparator<pos>{
		int x;
		int y;
		int num;
		int dir;
		public pos(int x2, int y2, int sum, int max_dir) {
			x = x2; 
			y = y2;
			num = sum;
			dir = max_dir;
		}
		public pos() {
			
		}
		@Override
		public int compare(pos o1, pos o2) {
			int n = o1.x - o2.x;
			if(n == 0) return o1.y - o2.y;
			return n;
		}
	}
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 한번 길이
			int m = Integer.parseInt(st.nextToken()); // 격리 시간 
			int k = Integer.parseInt(st.nextToken()); // 미생물 군집 개수 
		
			
			ArrayList<pos> mesang = new ArrayList<>();
			for(int i = 0 ; i < k ; i++) {
				pos p = new pos();
				st = new StringTokenizer(br.readLine(), " ");
				p.x = Integer.parseInt(st.nextToken()); // x
				p.y = Integer.parseInt(st.nextToken()); // y
				p.num = Integer.parseInt(st.nextToken()); // 미생물 개수 
				p.dir = Integer.parseInt(st.nextToken()); // 이동 방향
				// 1 상 2 하 3 좌 4 우 
				mesang.add(p);
			}
			
			for(int time = 0 ; time < m ; time++) {
				// 미생물 움직이기 
				int len = mesang.size();
				for(int i = 0 ; i < len ; i++) {
					pos p = mesang.get(i);
					int x = p.x + dx[p.dir-1];
					int y = p.y + dy[p.dir-1];
					int dir = p.dir;
					int num = p.num;
					if(x==0 || x==n-1 || y==0 || y==n-1) {
						if(dir<3) dir = (dir%2 + 1);
						else dir = (dir%2)+3;
						num = num/2;
					}
					p.x = x;
					p.y = y;
					p.dir = dir;
					p.num = num;
					mesang.set(i, p);
				}
				// 여기까지 움직이는거 끝 
				
				// 정렬
				mesang.sort(new pos());
				//
				// 좌표 같은것들 합치기 위한 곳 
				ArrayList<pos> new_mesang = new ArrayList<>();
				while(!mesang.isEmpty()) {
					ArrayList<pos> samepos = new ArrayList<>();
					pos p = mesang.remove(0);
					samepos.add(p);
					while(!mesang.isEmpty()) {
						pos first = mesang.get(0);
						if(first.x == p.x && first.y == p.y) {
							samepos.add(mesang.remove(0));
						}else { break; }
					}
					// 위엔 좌표가 같은 친구들을 저장해둠 
					
					int max_v = -1;
					int max_dir = -1;
					int sum = 0;
					for(int i = 0 ; i < samepos.size() ; i++) {
						if(max_v < samepos.get(i).num) {
							max_v = samepos.get(i).num;
							max_dir = samepos.get(i).dir;
						}
						sum += samepos.get(i).num;
					}
					pos new_p = new pos(samepos.get(0).x, samepos.get(0).y, sum, max_dir);
					new_mesang.add(new_p);
				}
				//
				mesang = new_mesang;
			}
			int result = 0;
			for(int i = 0 ; i < mesang.size(); i++) result += mesang.get(i).num;
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
