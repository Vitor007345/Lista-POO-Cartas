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
		this(0, Naipe.SEMNAIPE);
	}
	
	public Carta(int valor, Naipe naipe) {
		this.setValor(valor);
		this.setNaipe(naipe);
	}
	
	public Carta(Carta carta) {
		this(carta.getValor(), carta.getNaipe());
	}
	
	//setters
	public boolean setValor(int valor) {
		if(valor >=0 && valor <= 13) {
			this.valor = valor;
			return true;
		}
		return false;
	}
	public boolean setNaipe(Naipe naipe) {
		this.naipe = naipe;
		return true;
	}
	
	//getters
	public int getValor() {return this.valor;}
	public Naipe getNaipe() {return this.naipe;}
	public String getNaipeStr() {return naipesStr[this.naipe.ordinal()];}
	
	//methods
	
	
	
	
	
}
