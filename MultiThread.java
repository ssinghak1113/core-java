package com.mt;

public class MultiThread {
	private static int count = 0;

	public static void main(String[] args) {
		MultiThread.taskManager();
		System.out.println("counter = " + count);
	}

	public static void taskManager() {

		Thread threadOne = new Thread(new Runnable() {

			public void run() {

				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
					countIncrementer();
				}

			}

		});

		Thread threadTwo = new Thread(new Runnable() {

			public void run() {

				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(1);
					}

					catch (InterruptedException ie) {
						ie.printStackTrace();
					}
					countIncrementer();
				}

			}

		});

		threadOne.start();
		threadTwo.start();

		try {
			threadOne.join();
			threadTwo.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public synchronized static void countIncrementer() {
		count = count + 1;
	}
}
