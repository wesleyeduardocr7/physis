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
public class EspacoFinalTelaMovimentoUniforme {
    
    JTextField espacoInicial; 
    JTextField velocidadeMedia; 
    JTextField tempoGasto;    
    double espacoFinal;

    public EspacoFinalTelaMovimentoUniforme(JTextField espacoInicial, JTextField velocidadeMedia, JTextField tempoGasto) {
        this.espacoInicial = espacoInicial;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoGasto = tempoGasto;       
    }

    public JTextField getEspacoInicial() {
        return espacoInicial;
    }

    public JTextField getVelocidadeMedia() {
        return velocidadeMedia;
    }
   

    public JTextField getTempoGasto() {
        return tempoGasto;
    }    

    public double getEspacoFinal() {
        return espacoFinal;
    }

    public void setEspacoFinal(double espacoFinal) {
        this.espacoFinal = espacoFinal;
    }
    
}
