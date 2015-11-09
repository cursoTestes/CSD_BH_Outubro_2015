<?php

/**
 * @author cfc
 */
class CalculadoraComissao 
{
 
    public static function calcular($valorVenda)
    {		
        $percentual = 0.05;
        
        if ($valorVenda > 10000) 
        {
            $percentual = 0.06;
        }

        $comissao = ($percentual * $valorVenda);
        return CalculadoraComissao::arredondar($comissao);
    }

    private static function arredondar($comissao) 
    {
        $resultado = floor($comissao * 100);
        return ($resultado / 100);
    }
}

?>