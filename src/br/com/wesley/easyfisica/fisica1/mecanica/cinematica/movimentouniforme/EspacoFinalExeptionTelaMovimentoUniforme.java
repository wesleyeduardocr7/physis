/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.movimentouniforme;

/**
 *
 * @author Wesley Eduardo
 */
public class EspacoFinalExeptionTelaMovimentoUniforme extends Exception{
    
     private String descricao;
    
    public EspacoFinalExeptionTelaMovimentoUniforme(String descricao) {
        this.descricao = descricao;
     
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
}
