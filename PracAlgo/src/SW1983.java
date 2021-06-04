import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW1983 {
	static int T,N,K;
	static double find;
	static Double total[];
	static String[] score= {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			total = new Double[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				total[i]=(Integer.parseInt(st.nextToken())*0.35+Integer.parseInt(st.nextToken())*0.45+Integer.parseInt(st.nextToken())*0.2);
				if(i+1==K)  find = total[i];
			}
			Arrays.sort(total,Collections.reverseOrder());
			int index=0;
			for(int i=0;i<N;i++) {
				if(total[i]==find) {
					index=i;
				}
			}
			index = index/(N/10);
			System.out.println("#"+tc+" "+score[index]);
			
		}
	}

}
