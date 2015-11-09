package br.com.k21;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendaDAO;
import br.com.k21.dao.VendedorDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotalParaVendedorInexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 99;
		vendedor.setId(entradaIdVendedor);

		int entradaAno = 2001;
		double resultado;
		double esperado = 0.0;

		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);

		// asserts
		assertEquals(esperado, resultado);

	}

	@Test
	public void testTotalParaVendedorSemVenda() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 1;
		vendedor.setId(entradaIdVendedor);

		int entradaAno = 2015;
		double resultado;
		double esperado = 0.0;

		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);

		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotalParaVendedorComMultiplasVendas() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);

		int entradaAno = 2011;
		double resultado;
		double esperado = 2500.0;

		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);

		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotalParaVendedorComVenda() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);

		int entradaAno = 2015;
		double resultado;
		double esperado = 3000.0;

		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);

		// asserts
		assertEquals(esperado, resultado);
	}
}
