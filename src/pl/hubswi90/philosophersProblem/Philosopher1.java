package pl.hubswi90.philosophersProblem;

public class Philosopher1 extends Fork implements Runnable {

	private boolean spagetti;
	private long millis;
	private int id;

	
	public Philosopher1(long millis, int id) {
		this.millis = millis;
		this.id = id;
	}

	@Override
	public void run() {

		try {
			while (!spagetti) {
				semaphore.acquire();
				fork1.lock();
				if (!fork5.isLocked()) {
					fork5.lock();
					printStartText(id);
					Thread.sleep(millis);
					printEndText(id);
					fork5.unlock();
					spagetti = true;
				}
				fork1.unlock();
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
