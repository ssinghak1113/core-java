package com.mt;

public class CreateDeadLock {
	static class Friend {

		private final String name;

		private String getName() {
			return this.name;
		}

		Friend(String name) {
			this.name = name;
		}

		private synchronized void bow(Friend bower) {

			System.out.format("%s : %s" + " has bowed to me! %n", this.name,
					bower.getName());
			bower.bowBack(this);
		}

		private synchronized void bowBack(Friend bower) {
			System.out.format("%s : %s" + " has bowed back to me! %n",
					this.name, bower.getName());
		}

	}

	public static void main(String[] args) {

		Friend alphonse = new Friend("Alphonse");

		Friend gaston = new Friend("Gaston");

		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();

	}

}