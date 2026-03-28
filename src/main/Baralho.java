package main;

import java.security.SecureRandom;

public class Baralho {
	
	//atributes
	private Carta[] cartas;
	private int qntCartas;
	
	private static final SecureRandom random = new SecureRandom();
	
	
	//constructors
	public Baralho() {
		this.cartas = new Carta[52];
		this.resetInOriginalOrder();
	}
	
	
	public Baralho(Baralho b) {
		this.cartas = new Carta[52];
		this.qntCartas = b.qntCartas;
		for(int i = 0; i< b.cartas.length; i++) {
			this.cartas[i] = new Carta(b.cartas[i]);
		}
	}
	
	
	
	
	
	//methods
	
	public void reset() {
		this.qntCartas = 52;
	}
	
	public void resetInOriginalOrder() {
		this.reset();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				this.cartas[(i*13) + j] = new Carta(j + 1, Carta.Naipe.fromIndex(i+1));
			}
		}
	}
	
	private void swapCards(int pos1, int pos2) {
		Carta temp = this.cartas[pos1];
		this.cartas[pos1] = this.cartas[pos2];
		this.cartas[pos2] = temp;
	}
	
	public void shuffle() {
		for(int i = this.qntCartas - 1; i >= 0 ; i--) {
			this.swapCards(i, random.nextInt(i + 1));
		}
	}
	
	public Carta comprarCarta() {
		if(qntCartas <= 0) {
			return null;
		}
		return new Carta(this.cartas[--this.qntCartas]);
	}
	
}
