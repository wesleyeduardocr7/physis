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
public class EspacoInicialTelaMovimentoUniforme {
    
    JTextField espacoFinal;
    JTextField velocidadeMedia;     
    JTextField tempoGasto;    
    double espacoInicial; 

    public EspacoInicialTelaMovimentoUniforme(JTextField espacoFinal, JTextField velocidadeMedia, JTextField tempoGasto) {
        this.espacoFinal = espacoFinal;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoGasto = tempoGasto;       
    }

    public JTextField getEspacoFinal() {
        return espacoFinal;
    }

    public JTextField getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public JTextField getTempoGasto() {
        return tempoGasto;
    }

    public double getEspacoInicial() {
        return espacoInicial;
    }

    public void setEspacoInicial(double espacoInicial) {
        this.espacoInicial = espacoInicial;
    }

    
    
    
    
    
    
    
}
