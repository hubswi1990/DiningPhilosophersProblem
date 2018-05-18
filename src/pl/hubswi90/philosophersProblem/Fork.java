package pl.hubswi90.philosophersProblem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	protected static final Semaphore semaphore = new Semaphore(2);
	protected static final ReentrantLock fork1 = new ReentrantLock();
	protected static final ReentrantLock fork2 = new ReentrantLock();
	protected static final ReentrantLock fork3 = new ReentrantLock();
	protected static final ReentrantLock fork4 = new ReentrantLock();
	protected static final ReentrantLock fork5 = new ReentrantLock();
	
	protected static void printStartText(int id){
		System.out.println("Philosopher " +id +" eating spaghetti");
	}
	
	protected static void printEndText(int id){
		System.out.println("Philosopher " +id +" finished eating");
	}
}
