package gui;

public class Baterija {

	int kolicinaEnergije;
	int maxKapacitet;

	public Baterija(int maxKap) {
		maxKapacitet = kolicinaEnergije = maxKap;
	}

	public void dodajEnergiju(int energija) {
		if ((kolicinaEnergije + energija) > maxKapacitet)
			kolicinaEnergije = maxKapacitet;
		else kolicinaEnergije += energija;
	}

	public void isprazni() {
		kolicinaEnergije = 0;
	}

	public boolean baterijaPuna() {
		if (kolicinaEnergije == maxKapacitet)
			return true;
		return false;
	}
}
