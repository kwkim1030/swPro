package swPro.source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	128 MB	7785	5097	4495	66.890%

�� ����
�� ������ �� ���̼� ���� ��մ� �����̴�.
Ź�� ���� �� N���� �ִ�. ����̿� â���̴� ���� �����ư��鼭 ���� ��������, ���� 1�� �Ǵ� 3�� ������ �� �ִ�. ������ ���� �������� ����� ������ �̱�� �ȴ�.
�� ����� �Ϻ��ϰ� ������ ���� ��, �̱�� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ������ ����̰� ���� �����Ѵ�.

�� �Է�
ù° �ٿ� N�� �־�����. (1 �� N �� 1000)

�� ���
����̰� ������ �̱�� SK��, â���̰� ������ �̱�� CY�� ����Ѵ�.

 */

public class BJ_9655 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BJ_9655 t = new BJ_9655();
		long startTime = System.currentTimeMillis();
		/* ========================================= */
		// �˰����� �ش� ���� �ȿ� �־� �ۼ��� �˰����� ������ ����� �� �ִ�.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //BufferedReader br = new BufferedReader(new FileReader("src/algorithm/sample_input.txt"));

	    dp = new int[1001];
	    Arrays.fill(dp, -1);
	    dp[0] = 1;
	    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
	    
    	// ��ȭ�� : pick(n) = n���� ���� ���� ��� ����̰� �̱� �� �ִ� �� ����
    	dp[N] = pick(N-1) | pick(N-3);

	    System.out.println(dp[N] == 1 ? "SK" : "CY");
		
		
		/* ========================================= */
		long endTime = System.currentTimeMillis();
		//System.out.println("����ӵ� : "+(endTime - startTime));
	    
	}
	
	/*
	 * ����̰� �̱� �� �ִ��� ���θ� return
	 * �� �������� �ᱹ ����̰� �̱� �� �ִ��� �������� �Ǵ��ϸ� �ȴ�.
	 */
	static int pick(int n) {
		//������� 1 : ���̻� ���� ���� ������ �¸�
		if (n == 0) return dp[0];
		
		//�������2 : 0���� ������ ����(�߸� ������ ��� �� : 2�� ���Ҵµ� 3�� ������ ��� �߸� ������ �ɷ� ���и� ����)
		if (n < 0) return 0;
		
		int ret = dp[n];
		if (ret == -1) {
			int[] cyPick = {1,3}; //â���̰� ���� �� �ִ� ���� ����
			int winSk = 0;
			
			//â���̰� �̰� �� �� ����̰� �̱� �� �ִ��� ���θ� �ٽ� üũ
			for (int i : cyPick) {
				winSk = winSk | (pick(n-i-1) | pick(n-i-3));
			}
			
			dp[n] = winSk;
		}
		
		return dp[n];
	}

}
