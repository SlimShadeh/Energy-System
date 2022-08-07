package gui;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {

	private int brojVodenihPovrsina;

	public Hidroelektrana(Baterija baterija, Plac owner) {
		super('H', Color.BLUE, 1500, baterija, owner);
		kolicinaPunjenja = 0;

	}

	public void setBrVodenihPovrsina(int pom) {
		brojVodenihPovrsina = kolicinaPunjenja = pom;

	}

}
