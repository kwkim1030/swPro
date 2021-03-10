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

public class BJ_9655_Best2 {

	static int N;
	static boolean[] d = new boolean[1001];

	public static void main(String[] args) throws Exception {
		BJ_9655_Best2 t = new BJ_9655_Best2();
		long startTime = System.currentTimeMillis();
		/* ========================================= */
		// �˰����� �ش� ���� �ȿ� �־� �ۼ��� �˰����� ������ ����� �� �ִ�.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //BufferedReader br = new BufferedReader(new FileReader("src/algorithm/sample_input.txt"));

	    try {
	    	N = Integer.parseInt(br.readLine());
	    	d[0] = false;
	    	
	    	for (int i=1; i<=1000; i++) {
	    		d[i] = false;
	    		
	    		if (i-1 >= 0 && d[i-1] == false) {
	    			d[i] = true;
	    		}
	    		
	    		if (i-3 >= 0 && d[i-3] == false) {
	    			d[i] = true;
	    		}
	    	}
	    	
	    	System.out.println(d[N] ? "SK" : "CY");
	    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		/* ========================================= */
		long endTime = System.currentTimeMillis();
		//System.out.println("����ӵ� : "+(endTime - startTime));
	    
	}
}
