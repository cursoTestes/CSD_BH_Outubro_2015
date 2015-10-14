package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTestCalculadoraComissao {

	@Test
	public void comissaoValorDeVendaMenorQue10000() {
		double valorVenda = 1000.0;
		double esperado = 50.0;

		double resultado = CalculadoraComissao.calcular(valorVenda);

		assertEquals(esperado, resultado, 0);
	}

	@Test
	public void comissaoValorDeVendaIgual10000() {
		double valorVenda = 10000.0;
		double esperado = 501.0;

		double resultado = CalculadoraComissao.calcular(valorVenda);

		assertEquals(esperado, resultado, 0);
	}

	@Test
	public void comissaoValorDeVendaMaiorQue10000() {
		double valorVenda = 20000.0;
		double esperado = 1200.0;

		double resultado = CalculadoraComissao.calcular(valorVenda);

		assertEquals(esperado, resultado, 0);
	}

	@Test
	public void comissaoEmpresaSemPrejuizo() {
		double valorVenda = 55.59;
		double esperado = 2.77;

		double resultado = CalculadoraComissao.calcular(valorVenda);

		assertEquals(esperado, resultado, 0);
	}



}

