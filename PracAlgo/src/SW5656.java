import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656 {
	static int N,W,H,T,res;
	static int map[][];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static class State {
		int r,c,cnt;
		public State(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			int total = 0;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]>0) total++;
				}
			}
			res = Integer.MAX_VALUE;
			start(0,total,map);
			System.out.println("#"+tc+" "+res);
		}
	}
	private static boolean start(int cnt, int remain, int[][]map) {
		// TODO Auto-generated method stub
		if(remain==0) {
			res = 0;
			return true;
		}
		if(cnt==N) {
			res = Math.min(res, remain);
			return false;
		}
		int [][] newMap = new int[H][W];
		for(int c = 0; c<W;c++) {
			int r = 0;
			while(r<H && map[r][c]==0) ++r; // 해당 열에서 가장 위에 있는 벽돌의 위치 찾기
			if(r==H) continue; // 벽돌이 없을경우 pass
			copy(map,newMap);
			int breakcnt = breakblock(newMap,r,c);
			move(newMap);
			if(start(cnt+1,remain-breakcnt,newMap))return true;
		}
		return false;
	}
	private static void move(int[][] map) {
		// TODO Auto-generated method stub
		for(int c=0;c<W;c++) {
			int r = H-1;
			while(r>0) {
				if(map[r][c]==0) {
					int nr = r-1;
					while(nr>0&&map[nr][c]==0)nr--;
					map[r][c]=map[nr][c];
					map[nr][c]=0;
				}
				r--;
			}
		}
	}
	private static int breakblock(int[][] map, int r, int c) {
		// TODO Auto-generated method stub
		int cnt = 0;
		Queue<State>q = new LinkedList<>();
		if(map[r][c]>1)q.add(new State(r,c,map[r][c]));
		map[r][c] = 0;
		cnt++;
		while(!q.isEmpty()) {
			State s = q.poll();
			for(int d = 0; d<4;d++) {
				int cr = s.r;
				int cc = s.c;
				for(int k=0;k<s.cnt-1;k++) {
					cr += dx[d];
					cc += dy[d];
					if(cr<0||cr>=H||cc<0||cc>=W||map[cr][cc]==0)continue;
					if(map[cr][cc]>1)q.add(new State(cr,cc,map[cr][cc]));
					map[cr][cc]=0;
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void copy(int[][] map, int[][] newMap) {
		// TODO Auto-generated method stub
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
