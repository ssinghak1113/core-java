package com.mt;

import java.util.concurrent.*;

public class BQEx {

	private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {

		task();
	}

	public static void task() {

		Thread producer = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						System.out.println(Thread.currentThread().getName()
								+ " added" + " " + i);
						bq.put(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}, "Producer");
		Thread consumer = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						//
						System.out.println(Thread.currentThread().getName()
								+ " consumed" + " " + bq.take());

					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}

				}

			}
		}, "Consumer");
		producer.start();
		consumer.start();
	}
}
