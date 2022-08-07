package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class Plac extends Panel {

	private EnergetskiSistem owner;
	private Parcela pretParcela = null;
	private int red, kolona;
	private int indexPret;

	public Plac(int redovi, int kolone, EnergetskiSistem owner) {
		red = redovi;
		kolona = kolone;
		this.owner = owner;
		setLayout(new GridLayout(redovi, kolone, 3, 3));
		for (int i = 0; i < red * kolona; i++) {
			if (Math.random() > 0.3) {
				Parcela pom = new TravnataPovrs(this);
				pom.setIndex(i);
				add(pom);

			} else {
				Parcela pom = new VodenaPovrs(this);
				pom.setIndex(i);
				add(pom);
			}
			//System.out.println(i);
		}
	}

	public void paint(Graphics g) {

	}

	public void kliknuto(Parcela p) {
		if (pretParcela != null) {
			pretParcela.setFont(new Font(Font.SERIF, Font.BOLD, 14));
		}
		p.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		indexPret = p.getIndex();
		pretParcela = p;
	}

	public void dodajProizvodjaca(Proizvodjac p) {
		if (pretParcela != null) {
			remove(pretParcela);
			add(p, indexPret);
			p.setIndex(indexPret);
			pretParcela = null;
			indexPret = 0;
			azurirajHidroelektrane();
			validate();
			p.pokreni();
		}

	}

	public void azurirajHidroelektrane() {

		for (int i = 0; i < red * kolona; i++) {
			int br = 0;

			if (getComponent(i) instanceof Hidroelektrana) {
				if (i % kolona == 0) {
					for (int j = (i - kolona >= 0 ? i - kolona : 0); j < (i + kolona + 2 < red * kolona ? i + kolona + 2
							: red * kolona); j++) {
						if (j == i + 1 || j == i + kolona || j == i + kolona + 1 || j == i - kolona
								|| j == i - kolona + 1) {
							if (getComponent(j) instanceof VodenaPovrs) {
								br++;
							}
						}
					}
				} else if ((i + 1) % kolona == 0) {
					for (int j = (i - kolona - 1 >= 0 ? i - kolona - 1 : 0); j < (i + kolona + 1 < red * kolona
							? i + kolona + 1
							: red * kolona); j++) {
						if (j == i - 1 || j == i + kolona - 1 || j == i + kolona || j == i - kolona - 1
								|| j == i - kolona) {
							if (getComponent(j) instanceof VodenaPovrs) {
								br++;
							}
						}
					}
				} else {
					for (int j = ((i - kolona - 1) >= 0 ? i - kolona - 1 : 0); j < (i + kolona + 2 < red * kolona
							? i + kolona + 2
							: red * kolona); j++) {
						if (j == i - 1 || j == i + 1 || j == i - kolona - 1 || j == i - kolona || j == i - kolona + 1
								|| j == i + kolona - 1 || j == i + kolona || j == i + kolona + 1) {
							if (getComponent(j) instanceof VodenaPovrs) {
								br++;
							}
						}
					}
				}
				Hidroelektrana pomocna = (Hidroelektrana) (getComponent(i));
				pomocna.setBrVodenihPovrsina(br);
			}
		}
	}

	public void zaustaviSve() {
		for (int i = 0; i < red * kolona; i++) {
			if (getComponent(i) instanceof Proizvodjac) {
				Proizvodjac pomocna = (Proizvodjac) getComponent(i);
				pomocna.zaustavi();
			}
		}

	}
}
