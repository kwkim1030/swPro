package swPro.source;

public class AlgorithmExecutionRate {
		
	public static void main(String[] args) {
		AlgorithmExecutionRate t = new AlgorithmExecutionRate();
			long startTime = System.currentTimeMillis();
			/* ========================================= */
			// �˰����� �ش� ���� �ȿ� �־� �ۼ��� �˰����� ������ ����� �� �ִ�.
			t.testMethod();	
			/* ========================================= */
			long endTime = System.currentTimeMillis();
			System.out.println("����ӵ� : "+(endTime - startTime));
		}
		
		public void testMethod() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
