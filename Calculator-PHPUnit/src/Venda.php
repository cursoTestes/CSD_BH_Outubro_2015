<?php

/**
 * @author cfc
 */
class Venda {

    public  $idVenda ;
    public  $idVendedor; 
    public  $mesVenda ;
    public  $anoVenda ;
    public  $valor ;
    
    public function __construct($id, $vendedor, $mes, $ano, $valorVenda)
    {
        $this->idVenda = $id;
        $this->idVendedor = $vendedor;
        $this->mesVenda = $mes;
        $this->anoVenda = $ano;
        $this->valor = $valorVenda;
    }

}

?>