package main;

import java.util.Scanner;


public class Mesa {
	
	public static Scanner sc = new Scanner(System.in);
	public static Baralho baralho = new Baralho();
	
	
	public static int compararCartas(Carta c1, Carta c2) {
		int comparacao = c1.comparaValor(c2);
		if(comparacao != 0 || c1.mesmoNaipe(c2)) return comparacao;
		if(c1.getNaipe() == Carta.Naipe.OUROS) return 1;
		if(c2.getNaipe() == Carta.Naipe.OUROS) return -1;
		return 0;
	}
	
	public static void rodada(Jogador[] jogadores) {
		Carta[] cartasMesa = new Carta[jogadores.length];
		int[] maioresCartasIndexs = new int[jogadores.length];
		int mciTop = 0;
		cartasMesa[0] = jogadores[0].throwHighestCard();
		System.out.println("O jogador A jogou a carta " + cartasMesa[0].toString());
		maioresCartasIndexs[0] = 0;
		for(int i = 1; i < jogadores.length; i++) {
			cartasMesa[i] = jogadores[i].throwHighestCard();
			System.out.println("O jogador " + (char)(i + (int)('A')) +" jogou a carta " + cartasMesa[i].toString());
			int comparacao = compararCartas(cartasMesa[maioresCartasIndexs[0]], cartasMesa[i]);
			if(comparacao == -1) {
				maioresCartasIndexs[0] = i;
				mciTop = 0;
			}else if(comparacao == 0) {
				maioresCartasIndexs[++mciTop] = i;
			}
		}
		
		if(mciTop == 0) {
			System.out.println("O jogador " + 
					(char)(maioresCartasIndexs[0] + (int)('A')) + 
					" ganhou com a carta " + 
					cartasMesa[maioresCartasIndexs[0]].toString());
		}else {
			System.out.println((mciTop + 1) + " empataram");
			System.out.println("Os jogadores: ");
			
			Jogador[] jogadoresProx = new Jogador[mciTop + 1];
			
			for(int i = 0; i <= mciTop; i++) {
				System.out.println((char)(maioresCartasIndexs[i] + (int)('A')) + 
						" com a carta " +
						cartasMesa[maioresCartasIndexs[i]].toString());
				
				jogadoresProx[i] = jogadores[maioresCartasIndexs[i]];
			}
			
			if(jogadoresProx[0].getNumCartas() > 0) {
				System.out.println("Seguem para próxima rodada");
				System.out.println("Próxima rodada......");
				rodada(jogadoresProx);
			}else {
				System.out.println("Empataram, e por estarem sem cartas o jogo acabou com todos esses empatados");
			}
			
		}
	}
	
	public static void startGame() {
		System.out.println("Mesa Embaralhando.......");
		baralho.reset();
		baralho.shuffle();
		
		int numCartas;
		int numJogadores;
		boolean erro;
		do {
			System.out.println("Informe o número de jogadores:");
			numJogadores = sc.nextInt();
			System.out.println("Informe o número de cartas a distribuir:");
			numCartas = sc.nextInt();
			erro = numCartas < 1 || numJogadores < 2 || ((numCartas * numJogadores) > 52);
			if(erro) {
				System.out.println("Não é possível essa quantidade de cartas ou jogadores");
			}
		}while(erro);
		
		System.out.println("Mesa distribuindo as " + numCartas + "para cada jogador");
		Jogador[] jogadores = new Jogador[numJogadores];
		for(int i = 0; i < numJogadores; i++) {
			jogadores[i] = new Jogador(numCartas);
		}
		for(int i = 0; i < numCartas; i++) {
			for(Jogador j : jogadores) {
				j.comprarCarta(baralho);
			}
		}
		
		rodada(jogadores);
		
		
		
		
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		
		startGame();

	}

}
