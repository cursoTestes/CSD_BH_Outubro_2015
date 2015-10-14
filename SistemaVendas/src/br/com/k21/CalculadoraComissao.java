package br.com.k21;

public class CalculadoraComissao {
	
	private static final int LIMITE = 10000;
	private static final double FAIXA01 = 0.05;
	private static final double FAIXA02 = 0.06;

	public static double calcular(double valorVenda) {
		
		double percentual = FAIXA01;
		
		if (valorVenda > LIMITE) {
			percentual = FAIXA02;
		}
		
		double comissao = (percentual * valorVenda);
		return arredondar(comissao);
	}

	private static double arredondar(double comissao) {
		double resultado = Math.floor(comissao * 100);
		return (resultado / 100);
	}
}
