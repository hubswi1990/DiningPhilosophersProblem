package pl.hubswi90.philosophersProblem;

public class Philosopher2 extends Fork implements Runnable {

	private boolean spagetti;
	private long millis;
	private int id;
	

	public Philosopher2(long millis, int id) {
		this.millis = millis;
		this.id = id;
	}


	@Override
	public void run() {
		
		try {
			while (!spagetti) {
				semaphore.acquire();
				fork2.lock();
				if (!fork1.isLocked()) {
					fork1.lock();
					printStartText(id);
					Thread.sleep(millis);
					printEndText(id);
					fork1.unlock();
					spagetti = true;
				}
				fork2.unlock();
				semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}	
}
