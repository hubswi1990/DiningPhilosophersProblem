package pl.hubswi90.philosophersProblem;

public class Main {


	public static void main(String[] args) {

		long millis = 5000;
		
		Philosopher1 philosopher1 = new Philosopher1(millis, 1);
		Philosopher2 philosopher2 = new Philosopher2(millis, 2);
		Philosopher3 philosopher3 = new Philosopher3(millis, 3);
		Philosopher4 philosopher4 = new Philosopher4(millis, 4);
		Philosopher5 philosopher5 = new Philosopher5(millis, 5);
		
		Thread t1 = new Thread(philosopher1);
		Thread t2 = new Thread(philosopher2);
		Thread t3 = new Thread(philosopher3);
		Thread t4 = new Thread(philosopher4);
		Thread t5 = new Thread(philosopher5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
