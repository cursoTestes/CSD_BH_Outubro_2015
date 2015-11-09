<?php
require_once 'src/CalculadoraComissao.php';
require_once 'src/CalculadoraRoyalties.php';
require_once 'src/Venda.php';
require_once 'src/VendaRepository.php';

/**
 * @author cfc
 */
class CalculadoraRoyaltiesUnitTest extends PHPUnit_Framework_TestCase 
{   
    
    private $mockRepository;
    
    public function setUp(){
        $this->mockRepository = $this->getMockBuilder('VendaRepository')
                     ->disableOriginalConstructor()
                     ->getMock();        
        
    }
    
    
    public function testCalcularRoyaltiesParaUmMesSemVenda()
    {
        //arrange
        $esperado = 0;
        $mes = 1;
        $ano = 2015;
        
        
        $this->mockRepository->method('obterVendasPorMesEAno')
                       ->willReturn(array());        
        
        $calculadora = new CalculadoraRoyalties($this->mockRepository);
        
        //act
        $retorno = $calculadora->calcularRoyalties($mes, $ano); 
        
        $this->assertEquals($esperado, $retorno);
    }  
    
       public function testCalcularRoyaltiesParaUmMesComUmaVenda()
    {
        //arrange
        $esperado = 19;
        $mes = 2;
        $ano = 2015;
        
        
        $this->mockRepository->method('obterVendasPorMesEAno')
                       ->willReturn(array(new Venda(1, 1, $mes, $ano, 100)));         
        
        $calculadora = new CalculadoraRoyalties($this->mockRepository);
        
        //act
        $retorno = $calculadora->calcularRoyalties($mes, $ano); 
        
        $this->assertEquals($esperado, $retorno);
    }
    
    public function testCalcularRoyaltiesParaUmMesVariasVendas()
    {
        //arrange
        $esperado = 18819;
        $mes = 3;
        $ano = 2015;
        
       
        $this->mockRepository->method('obterVendasPorMesEAno')
                       ->willReturn(array(
                           new Venda(2, 1, $mes, $ano, 100000),
                           new Venda(1, 1, $mes, $ano, 100)
                           ));       
        
        $calculadora = new CalculadoraRoyalties($this->mockRepository);
        
        //act
        $retorno = $calculadora->calcularRoyalties($mes, $ano); 
        
        $this->assertEquals($esperado, $retorno);
    } 
    
}
?>