import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2814 {
	static int N,M,T,x,y,ans;
	static boolean map[][],visit[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer (br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N+1][N+1];
			visit = new boolean[N+1];
			ans = 0;
			for(int i=1;i<=M;i++) {
				 st = new StringTokenizer (br.readLine());
				 x = Integer.parseInt(st.nextToken());
				 y = Integer.parseInt(st.nextToken());
				 map[x][y] = true;
				 map[y][x] = true;
			}
			for(int i=1;i<=N;i++) {
				visit[i] = true;
				find(i,1);
				visit[i] = false;
			}
			System.out.println("#"+tc+" "+ans);
		}

	}
	private static void find(int start, int cnt) {
		if(ans<cnt)ans = cnt;
		for(int i=1;i<=N;i++) {
			if(map[start][i]&&!visit[i]) {
				visit[i]=true;
				find(i,cnt+1);
				visit[i]=false;
			}
		}
		
	}

}
