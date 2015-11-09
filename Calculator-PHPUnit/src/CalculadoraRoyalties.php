<?php

require_once 'CalculadoraComissao.php';
require_once 'VendaRepository.php';
require_once 'Venda.php';

/**
 * @author cfc
 */
class CalculadoraRoyalties
{
    private $repository;
    
    function __construct(VendaRepository $repository) {
        $this->repository = $repository;
    }
    
    public function calcularRoyalties($mes, $ano)
    {
        
        $listaVendas = $this->repository->obterVendasPorMesEAno($ano, $mes);
        
        $totalBruto = 0;
        $totalComissao = 0;
        
        foreach ((array)$listaVendas as $venda) {
            $totalBruto += $venda->valor;
            $totalComissao += CalculadoraComissao::calcular($venda->valor);
        }
        
        return ($totalBruto - $totalComissao) * 0.2;
    }
}
?>