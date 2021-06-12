import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW6731 {
	static int T,N,cnt;
	static char[][] pan;
	static char[][] start;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			pan = new char[N][N];
			start = new char[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					pan[i][j] = str.charAt(j);
					start[i][j] = 'W';
				}
			}
			min = Integer.MAX_VALUE;
			cnt = 0;
			play();
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void play() {
		if (check()) {
			min = Math.min(min, cnt);
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				change(i,j);
				cnt+=1;
				play();
				cnt-=1;
				change(i,j);
			}
		}
		
	}
	private static void change(int i, int j) {
		for(int k=0;k<N;k++) {
			if(start[i][k]=='W')start[i][k]='B';
			else start[i][k]='W';
			if(start[k][j]=='W')start[k][j]='B';
			else start[k][j]='W';
		}
		
	}
	private static boolean check() {
		boolean flag = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(start[i][j]!=pan[i][j]) flag = false;
			}
		}
		if(flag) return false;
		else return true;
	}

}
