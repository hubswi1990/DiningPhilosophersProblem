package pl.hubswi90.philosophersProblem;

public class Philosopher3 extends Fork implements Runnable {

	private boolean spagetti;
	private long millis;
	private int id;
	

	public Philosopher3(long millis, int id) {
		this.millis = millis;
		this.id = id;
	}

	@Override
	public void run() {

		try {
			while (!spagetti) {
				semaphore.acquire();
				fork3.lock();
				if (!fork2.isLocked()) {
					fork2.lock();
					printStartText(id);
					Thread.sleep(millis);
					printEndText(id);
					fork2.unlock();
					spagetti = true;
				}
				fork3.unlock();
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
