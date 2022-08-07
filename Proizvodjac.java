package gui;

import java.awt.Color;

public class Proizvodjac extends Parcela implements Runnable {

	private int vreme;
	private Baterija baterija;
	private Thread thread = new Thread(this);
	boolean work;
	protected int kolicinaPunjenja = 0;

	public Proizvodjac(char oznaka, Color boja, int vreme, Baterija baterija, Plac owner) {
		super(oznaka, boja, owner);
		this.baterija = baterija;
		this.vreme = vreme;
	}

	public synchronized void zaustavi() {
		work = false;
		thread.interrupt();

	}

	public synchronized void pokreni() {
		work = true;
		thread.start();
		notify();
	}

	@Override
	public void run() {
		try {
			while (!thread.isInterrupted()) {
				synchronized (this) {
					while (!work)
						wait();
				}
				Thread.sleep(vreme + (int) (Math.random() * 300));

				if (kolicinaPunjenja > 0) {
					baterija.dodajEnergiju(kolicinaPunjenja);
					setForeground(Color.RED);
					 //System.out.println("Napunjeno je " + kolicinaPunjenja + " energije.");
				}
				 //System.out.println("Baterija ima kolicinu energije:"+baterija.kolicinaEnergije);
				Thread.sleep(300);
				setForeground(Color.WHITE);

			}
		} catch (InterruptedException e) {
		}
	}
}
