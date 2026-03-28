package main;

public class Carta {
	public enum Naipe{
		SEMNAIPE, OUROS, ESPADAS, COPAS, PAUS;
		
		private static final String[] naipesStr = {"", "Ouros", "Espadas", "Copas", "Paus"};
		
		public static Naipe fromIndex(int index) {
	        if (index < 0 || index >= Naipe.values().length) {
	            throw new IllegalArgumentException("Naipe invalido use de 0 a 3. Recebido: " + index);
	        }
	        return Naipe.values()[index];
	    }
		
		public static Naipe fromStr(String naipe) {
			for(int i = 0; i < Naipe.naipesStr.length; i++) {
				if(Naipe.naipesStr[i].equals(naipe)) {
					return Naipe.fromIndex(i);
				}
			}
			throw new IllegalArgumentException("String naipe invalido: " + naipe);
		}
		
		@Override
		public String toString() {
			return Naipe.naipesStr[this.ordinal()];
		}
		
		
	}
	
	private static final String[] figuras = {"Ás", "Valete", "Dama", "Rei"};
	
	
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
	
	public Carta(int valor, String naipe) {
		this(valor, Naipe.fromStr(naipe));
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
	public String getNaipeStr() {return this.naipe.toString();}
	
	public String getValorStr() {
		String nomeValor;
		if(this.getValor() == 1) {
			nomeValor = figuras[0];
		}else if(this.getValor() > 10) {
			nomeValor = figuras[this.getValor() - 10];
		}else {
			nomeValor = String.valueOf(this.getValor());
		}
		return nomeValor;
	}
	
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
	
	@Override
	public String toString() {
		return this.getValorStr() + "de " + this.getNaipeStr();
	}
	
	
	
	
}
