package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Parcela extends Label {

	private char oznaka;
	private Color boja;
	private Plac owner;
	private int index;

	public Parcela(char oznaka, Color boja, Plac owner) {
		this.oznaka = oznaka;
		this.boja = boja;
		this.owner = owner;
		this.setBackground(boja);

		setAlignment(CENTER);
		setForeground(Color.WHITE);
		this.setFont(new Font(Font.SERIF, Font.BOLD, 14));
		this.setText("" + oznaka);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				owner.kliknuto(Parcela.this);
			}
		});

	}

	public void setIndex(int i) {
		index = i;
	}

	public int getIndex() {
		return index;
	}

	public void promeniPozadinu(Color boja) {
		this.boja = boja;
	}
}
