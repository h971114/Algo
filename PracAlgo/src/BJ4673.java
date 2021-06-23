
public class BJ4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] check = new boolean[10001];	// 1부터 10000이므로
 
		for (int i = 1; i < 10001; i++){
			int n = d(i);
		
			if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
				check[n] = true;
			}
		}
		for (int i = 1; i < 10001; i++) {
			if (!check[i]) {	// false 인 인덱스만 출력
				System.out.println(i);
			}
		}
	}

	private static int d(int i) {
		// TODO Auto-generated method stub
		int sum = i;
		while(i!=0) {
			sum = sum+(i%10);
			i = i/10;
		}
		return sum;
	}

}
