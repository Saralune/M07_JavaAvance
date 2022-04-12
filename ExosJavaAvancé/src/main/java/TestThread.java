//2.1
public class TestThread extends Thread {
	public TestThread(String name) {
		super(name);
	}
	
	public synchronized void run() {
		PrintThread.displayThread(this.getName());
	}
	
	public static void main(String[] args) {
		TestThread t = new TestThread("1-");
		TestThread t2 = new TestThread("2--");
		TestThread t3 = new TestThread("3---");
		TestThread t4 = new TestThread("4----");
		TestThread t5 = new TestThread("5-----");
		
		t.start();
		//t.join(); //pour avoir un thread dans l'ordre : join attend que le thread soit terminé pour passer au suivant
		t3.start();
		t4.start();
		t2.start();
		t5.start();
	}

}
