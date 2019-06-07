package com.learning.multithreading;

import java.util.Scanner;

class MyThread extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("counter value for:"+Thread.currentThread());
			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();

		MyThread mt1 = new MyThread();
		mt1.start();

		System.out.println("press enter to stop!!!!!");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		mt.shutdown();
	}
}
