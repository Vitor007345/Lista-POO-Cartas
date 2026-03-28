package main;

public class Jogador {
	private Carta[] cartas;
	private int numCartas;
	
	
	//constructors
	public Jogador() {
		this(5);
	}
	
	public Jogador(int maxCartas) {
		this.cartas = new Carta[maxCartas];
		this.numCartas = 0;
	}
	
	//getters
	public int getMaxcartas() {
		return this.cartas.length;
	}
	public int getNumCartas() {
		return this.numCartas;
	}
	
	//methods
	public int comprarCarta(Baralho b) {
		if(this.numCartas < this.cartas.length) {
			Carta cartaComprada = b.comprarCarta();
			if(cartaComprada != null) {
				this.cartas[this.numCartas++] = cartaComprada;
				return 0;
			}
			return -1;
		}
		return -2;
	}
	
	private void shiftCartas(int pos) {
		for(int i = pos; i < this.numCartas - 1; i++) {
			this.cartas[i] = this.cartas[i + 1];
		}
		this.cartas[--this.numCartas] = null;
	}
	
	public Carta throwCard(int index){
		Carta c = null;
		if(index < this.numCartas) {
			c = new Carta(this.cartas[index]);
			this.shiftCartas(index);
		}
		return c;
	}
	
	
	
	public int getHighestCardIndex() {
		int iMaior = 0;
		for(int i = 1; i < this.numCartas; i++) {
			int comparacao = this.cartas[iMaior].comparaValor(this.cartas[i]);
			if((comparacao == -1) || 
				(comparacao == 0 &&
				this.cartas[i].getNaipe() == Carta.Naipe.OUROS)
			){
				iMaior = i;
			}
			
		}
		return iMaior;
	}
	
	
	public Carta throwHighestCard() {
		return this.throwCard(this.getHighestCardIndex());
	}
	
	public String cartasStr() {
		String cartas = "[";
		if(this.numCartas > 0) {
			cartas += this.cartas[0].toString();
			for(int i = 1; i < this.numCartas; i++) {
				cartas += ", " + this.cartas[i].toString();
			}
		}
		cartas += "]";
		
		return cartas;
		
	}
	
	
	
	
	
}
