package com.mt;

import java.util.LinkedList;
import java.util.Queue;

public class ProConWaitNotify {

	private static Queue<Integer> que = new LinkedList<>();
	static Producer producer;
	static Consumer consumer;

	public static void main(String[] args) {
		producer = new Producer();
		consumer = new Consumer();
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		t2.start();
		t1.start();
	}
	public static class Producer implements Runnable{
		public void run() {
			synchronized (this) {
				for (int i = 1; i <= 10; i++) {

					System.out.println("produced " + i);
					que.add(i);
				}
				this.notify();
			}
		}
	}
	public static class Consumer implements Runnable{
		/*Producer producer;
		public Consumer(Producer producer){
			this.producer = producer;
		}*/
		public void run() {
			synchronized (producer) {
				try {
					producer.wait();
					for (int i = 1; i <= 10; i++) {
						System.out.println("consumed " + que.poll());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
