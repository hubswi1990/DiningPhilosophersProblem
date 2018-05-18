package pl.hubswi90.philosophersProblem;

public class Philosopher4 extends Fork implements Runnable {

	private boolean spagetti;
	private long millis;
	private int id;
	

	public Philosopher4(long millis, int id) {
		this.millis = millis;
		this.id = id;
	}

	@Override
	public void run() {

		try {
			while (!spagetti) {
				semaphore.acquire();
				fork4.lock();
				if (!fork3.isLocked()) {
					fork3.lock();
					printStartText(id);
					Thread.sleep(millis);
					printEndText(id);
					fork3.unlock();
					spagetti = true;
				}
				fork4.unlock();
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}	
}
