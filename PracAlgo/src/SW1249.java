import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW1249 {
	static int[] dx = {0,0,1-1,1};
	static int[] dy = {1,-1,0,0};
	static int T,N;
	static int map[][];
	static int ans[][];
	static boolean visit[][];
	static int min;
	 static class pos{
		int x,y;

		 pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			ans = new int [N][N];
			visit = new boolean [N][N];
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			for(int i=0;i<N;i++) Arrays.fill(ans[i], Integer.MAX_VALUE);
			ans[0][0]=0;
			move(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void move(int xx, int yy) {
		Queue <pos> q = new LinkedList<>();
		q.offer(new pos(xx,yy));
		visit[xx][yy] = true;
		while(!q.isEmpty()) {
			pos p = q.poll();
			int cx = p.x;
			int cy = p.y;
			if(cx==N-1&&cy==N-1) {
				min = Math.min(ans[N-1][N-1], min);
				return;
			}
			if(min<=ans[cx][cy]) continue;
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(!visit[nx][ny]||ans[nx][ny]>ans[cx][cy]+map[nx][ny]) {
				visit[nx][ny]=true;
				ans[nx][ny] = ans[cx][cy]+map[nx][ny];
				q.offer(new pos(nx,ny));
				}
			}
		}

	}
}
