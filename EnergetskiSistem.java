package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {

	private Panel topPanel = new Panel();
	private Baterija baterija;
	private Plac plac;

	public void populateWindow() {

		Button dodaj = new Button("Dodaj");
		dodaj.addActionListener((ae) -> {
			// baterija.isprazni();
			plac.dodajProizvodjaca(new Hidroelektrana(baterija, plac));
		});
		topPanel.add(dodaj);
		add(topPanel, BorderLayout.NORTH);
		add(plac, BorderLayout.CENTER);
	};

	public EnergetskiSistem(int redovi, int kolone, int kapacitet) {
		setBounds(700, 200, 500, 500);
		setTitle("Energetski sistem");
		setResizable(false);
		baterija = new Baterija(kapacitet);
		plac = new Plac(redovi, kolone, this);

		populateWindow();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				plac.zaustaviSve();
				dispose();
			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {
		new EnergetskiSistem(5, 5, 50);

	}
}
