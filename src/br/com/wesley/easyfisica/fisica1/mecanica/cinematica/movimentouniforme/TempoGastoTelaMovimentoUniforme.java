/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.movimentouniforme;

import javax.swing.JTextField;

/**
 *
 * @author Wesley Eduardo
 */
public class TempoGastoTelaMovimentoUniforme {
    
    JTextField espacoInicial;
    JTextField espacoFinal;
    JTextField velocidadeMedia;
    double tempoGasto;  

    public TempoGastoTelaMovimentoUniforme(JTextField espacoInicial, JTextField espacoFinal, JTextField velocidadeMedia) {
        this.espacoInicial = espacoInicial;
        this.espacoFinal = espacoFinal;
        this.velocidadeMedia = velocidadeMedia;        
    }

    public JTextField getEspacoInicial() {
        return espacoInicial;
    }

    public JTextField getEspacoFinal() {
        return espacoFinal;
    }

    
    public JTextField getVelocidadeMedia() {
        return velocidadeMedia;
    }

   public double getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(double tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

   
    
    
    

    
}
