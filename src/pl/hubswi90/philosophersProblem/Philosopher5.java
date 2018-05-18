package pl.hubswi90.philosophersProblem;

public class Philosopher5 extends Fork implements Runnable {

	private boolean spagetti;
	private long millis;
	private int id;
	
	
	public Philosopher5(long millis, int id) {
		this.millis = millis;
		this.id = id;
	}

	@Override
	public void run() {
		
		try {
			while (!spagetti) {
				semaphore.acquire();
				fork5.lock();
				if (!fork4.isLocked()) {
					fork4.lock();
					printStartText(id);
					Thread.sleep(millis);
					printEndText(id);
					fork4.unlock();
					spagetti = true;
				}
				fork5.unlock();
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
