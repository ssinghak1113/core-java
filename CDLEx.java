package com.mt;

import java.util.concurrent.*;

public class CDLEx {

	static CountDownLatch cdl = new CountDownLatch(3);

	public static void main(String[] args) throws InterruptedException{
		task();
		cdl.await();
		System.out.println("All oper done");
	}

	public static void task() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				System.out.println("Oper 1 done");
				cdl.countDown();
			}

		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				System.out.println("Oper 2 done");
				cdl.countDown();
			}
		});

		Thread t3 = new Thread(new Runnable() {

			public void run() {
				System.out.println("Oper 3 done");
				cdl.countDown();
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}
}