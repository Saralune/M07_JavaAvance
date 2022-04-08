//2.1
public class PrintThread {
	public static synchronized void displayThread(String name) {
		for (int i = 0; i < 5; i++) {
			System.out.println(name);
		}
	}
}
