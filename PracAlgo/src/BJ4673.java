
public class BJ4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] check = new boolean[10001];	// 1���� 10000�̹Ƿ�
 
		for (int i = 1; i < 10001; i++){
			int n = d(i);
		
			if(n < 10001){	// 10000 �� �Ѵ� ���� �ʿ䰡 ����
				check[n] = true;
			}
		}
		for (int i = 1; i < 10001; i++) {
			if (!check[i]) {	// false �� �ε����� ���
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
