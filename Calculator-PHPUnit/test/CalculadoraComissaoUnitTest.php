<?php
require_once 'src/CalculadoraComissao.php';

/**
 * @author cfc
 */
class CalculadoraComissaoUnitTest extends PHPUnit_Framework_TestCase 
{   
    public function testCalcularComissaoParaVenda1000Retorna50()
    {
        $valorVenda = 1000.0;
        $esperado = 50.0;
        
        $retorno = CalculadoraComissao::calcular($valorVenda);
        
        $this->assertEquals($esperado, $retorno);
    }  
    
    public function testCalcularComissaoParaVenda10000Retorna500()
    {
        $valorVenda = 10000.0;
        $esperado = 500.0;
        
        $retorno = CalculadoraComissao::calcular($valorVenda);
        
        $this->assertEquals($esperado, $retorno);
    }  
    
     public function testCalcularComissaoParaVenda100000Retorna6000()
    {
        $valorVenda = 100000.0;
        $esperado = 6000.0;
        
        $retorno = CalculadoraComissao::calcular($valorVenda);
        
        $this->assertEquals($esperado, $retorno);
    } 
    
     public function testCalcularComissaoParaVendaArredondandoParaBaixo()
    {
        $valorVenda = 55.59;
        $esperado = 2.77;
        
        $retorno = CalculadoraComissao::calcular($valorVenda);
        
        $this->assertEquals($esperado, $retorno);
    } 
}
?>