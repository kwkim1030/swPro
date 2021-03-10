package swPro.source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	7321	3228	2662	43.327%

�� ����
� ������ �¼��� �� �ٷ� �Ǿ� ������ ���ʺ��� ���ʴ�� 1������ N������ ��ȣ�� �Ű��� �ִ�. ������ ���� �� ������� �ڱ��� ����ǿ� ǥ�õǾ� �ִ� �¼��� �ɾƾ� �Ѵ�. ���� ��, ����ǿ� 5���� ���� ������ 5�� �¼��� �ɾƾ� �Ѵ�. ��, �ڱ��� �ٷ� ���� �¼� �Ǵ� �ٷ� ������ �¼����δ� �ڸ��� �ű� �� �ִ�. ���� ��, 7�� ������� ���� ����� 7�� �¼��� �����̰�, 6�� �¼��̳� 8�� �¼����� ���� �� �ִ�. �׷��� 5�� �¼��̳� 9�� �¼����� ���� �� ����.
�׷��� �� ���忡�� ��VIP ȸ�������� �ִ�. �� ������� �ݵ�� �ڱ� �¼����� �ɾƾ� �ϸ� �� �¼����� �ڸ��� �ű� �� ����.
���� ������ ������� �����Ǿ� 1�� �¼����� N�� �¼����� ��� �¼��� �� �ȷȴ�. VIP ȸ������ �¼� ��ȣ���� �־����� ��, ������� �¼��� �ɴ� ���� �ٸ� ����� �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� ��, �׸��� ���� �¼��� 9���̰�, 4�� �¼��� 7�� �¼��� VIP���� ��쿡 <123456789>�� ���� ������ ��ġ�̴�. ���� <213465789> �� <132465798> �� ������ ��ġ�̴�. �׷��� <312456789> �� <123546789> �� ������ �ʴ� ��ġ ����̴�.

�� �Է�
ù° �ٿ��� �¼��� ���� N�� �Էµȴ�. N�� 1 �̻� 40 �����̴�. ��° �ٿ��� �������� ���� M�� �Էµȴ�. M�� 0 �̻� N �����̴�. ���� M ���� �ٿ��� �������� ��ȣ�� ���� ������ ū ���� ������ �� �ٿ� �ϳ��� �Էµȴ�.

�� ���
�־��� ������ �����ϸ鼭 ������� �¼��� ���� �� �ִ� ����� �������� ����Ѵ�. ����� �������� 2,000,000,000�� ���� �ʴ´�. (2,000,000,000 < 231-1)

 */

public class BJ_2302_Best {

	static int[] dp, vip, ans;
	static int sol = 1;

	public static void main(String[] args) throws Exception {
		BJ_2302_Best t = new BJ_2302_Best();
		long startTime = System.currentTimeMillis();
		/* ========================================= */
		// �˰����� �ش� ���� �ȿ� �־� �ۼ��� �˰����� ������ ����� �� �ִ�.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //BufferedReader br = new BufferedReader(new FileReader("src/algorithm/sample_input.txt"));
	    
    	int N = Integer.parseInt(br.readLine()); //�ڸ�����
    	int M = Integer.parseInt(br.readLine()); //vip �¼� ����
	    
    	if (N < 3) {
    		dp = new int[4];
    	} else {
    		dp = new int[N+1];
    	}
    	
    	vip = new int[M];
    	ans = new int[M+1];
    	
    	for (int i=0; i<M ; i++) {
    		vip[i] = Integer.parseInt(br.readLine());
    	}
    	
    	dp[0] = 1;
    	dp[1] = 1;
    	dp[2] = 2;
    	
    	if (M > 0) {
    		ans[0] = calc(vip[0]-1);
    		for (int i=1; i<M; i++) {
    			ans[i] = calc(vip[i] - vip[i-1] - 1);
    		}
    		
    		ans[M] = calc(N - vip[M-1]);
    	} else {
    		ans[M] = calc(N);
    	}
    	
    	for (int a : ans) {
    		sol = sol * a;
    	}
    			
	    System.out.println(sol);
		
		/* ========================================= */
		long endTime = System.currentTimeMillis();
		//System.out.println("����ӵ� : "+(endTime - startTime));
	    
	}
	
	private static int calc(int seat) {
		for (int i=3; i <= seat; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		return dp[seat];
	}

}
