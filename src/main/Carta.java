package main;

public class Carta {
	public enum Naipe{
		SEMNAIPE, ESPADAS, COPAS, OUROS, PAUS
	}
	private static String[] naipesStr = {"", "Espadas", "Copas", "Ouros", "Paus"};
	
	private Naipe naipe;
	private int valor;
	
	//constructors
	public Carta() {
		this.valor = 0;
		this.naipe = Naipe.SEMNAIPE;
	}
	
	public Carta(int valor, Naipe naipe) {
		if(!this.setValor(valor) || !this.setNaipe(naipe)) {
			throw new IllegalArgumentException("Valores ou naipe invalido para uma carta");
		}
	}
	
	public Carta(Carta carta) {
		this(carta.getValor(), carta.getNaipe());
	}
	
	//validaçoes
	private static boolean validarValor(int valor) {
		return valor >=1 && valor <= 13;
	}
	private static boolean validarNaipe(Naipe naipe) {
		return naipe != Naipe.SEMNAIPE;
	}
	
	public boolean isValid() {
		return validarValor(this.getValor()) && validarNaipe(this.getNaipe());
	}
	
	//setters
	public boolean setValor(int valor) {
		if(validarValor(valor)) {
			this.valor = valor;
			return true;
		}
		return false;
	}
	public boolean setNaipe(Naipe naipe) {
		if(validarNaipe(naipe)) {
			this.naipe = naipe;
			return true;
		}
		return false;
	}
	
	//getters
	public int getValor() {return this.valor;}
	public Naipe getNaipe() {return this.naipe;}
	public String getNaipeStr() {return naipesStr[this.naipe.ordinal()];}
	
	//methods
	
	public int comparaValor(Carta carta) {
		if(this.getValor() > carta.getValor()) {
			return 1;
		}else if(this.getValor() == carta.getValor()){
			return 0;
		}else {
			return -1;
		}
	}
	
	public boolean mesmoNaipe(Carta carta) {
		return this.getNaipe() == carta.getNaipe();
	}
	
	
	
	
}
