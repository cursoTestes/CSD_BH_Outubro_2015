package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.action.FillConstructor;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}
	
	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		abrirPaginaVenda();
		preencherCampoVendedor("");
		preencherDataVenda("");
		preencherValorVenda("");
		
		submeterForm();
		
		Assert.assertEquals("O valor da venda é obrigatório", findFirst("#valorVenda-error").getText());
		Assert.assertEquals("O identificador do vendedor é obrigatório", findFirst("#vendedor-error").getText()); 
		Assert.assertEquals("A data da venda é obrigatória", findFirst("#dataVenda-error").getText()); 

	}
	
	@Test
	public void testeCadastraUmaVendaPreenchendoDadosCorretos() {
		abrirPaginaVenda();
		preencherCampoVendedor("123");
		preencherDataVenda("01/01/2015");
		preencherValorVenda("1400.32");
		
		submeterForm();
		
		
		
		String textoMensagemCadastradoSucesso = findFirst("#mensagem_sucesso").getText();
		Assert.assertEquals("Cadastro concluido com sucesso", textoMensagemCadastradoSucesso);
		
	}
	
	@Test
	public void testeInsereVendaNaoNumerico() {
		abrirPaginaVenda();
		preencherCampoVendedor("123");
		preencherDataVenda("01/01/2074");
		preencherValorVenda("aa");
		
		submeterForm();
		
		Assert.assertEquals("O valor da venda deve ser numerico", findFirst("#valorVenda-error").getText());

	}


	private void submeterForm() {
		submit("input[type=\"submit\"]");
	}

	private void preencherValorVenda(String valor) {
		fill("#valorVenda").with(valor);
	}

	private void preencherDataVenda(String data) {
		fill("#DataVenda").with(data);
	}

	private FillConstructor preencherCampoVendedor(String id) {
		return fill("#Vendedor").with(id);
	}

	private void abrirPaginaVenda() {
		goTo("http://localhost:3000/");
	}	
	
	
}
