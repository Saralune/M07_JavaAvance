//2.2
public class TestRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.toString().repeat(i));
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new TestRunnable());
		thread.start();
	}
	
	@Override
	public String toString() {
		return "*";
	}

}
