import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1244 {
	static int T,cnt,ans;
	static String num;
	static int[] number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = st.nextToken();//���� ���ڿ��� �Է¹ޱ�
			cnt = Integer.parseInt(st.nextToken());//�ٲܼ� �ִ� Ƚ��
			ans=0;
			number=new int[num.length()];
            for(int i=0;i<num.length();i++){
            	number[i]=(num.charAt(i)-'0');//���ڹ迭�� ����
            }
            dfs(0,0);//��ġ �ٲٱ�
            System.out.println("#" + test_case + " " + ans);
		}
	}
	private static void dfs(int k, int c) {
		int t;
		if(c==cnt) {
			String str = "";
			for(int i=0;i<number.length;i++) {
				str+=Integer.toString(number[i]);
				ans = Math.max(ans, Integer.parseInt(str));
			}
			return;
		}
		for(int i=k;i<number.length;i++) {
			for(int j=i+1;j<number.length;j++) {
				if(number[i]<=number[j]) {
					t = number[i];
					number[i]=number[j];
					number[j]=t;
					dfs(i,c+1);
					t = number[i];
					number[i]=number[j];
					number[j]=t;
				}
			}
		}
	}

}
