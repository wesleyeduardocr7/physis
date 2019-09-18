/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia;

import javax.swing.JTextField;

/**
 *
 * @author Wesley Eduardo
 */
public class EspacoPercorridoTelaVelocidadeMedia{
    
    JTextField velocidadeMedia; 
    JTextField tempoGasto;    
    double espacoPercorrido;

    public EspacoPercorridoTelaVelocidadeMedia(JTextField campoTextoVelocidadeMediaTelaVelocidadeMedia , JTextField campoTextoTempoGastoTelaVelocidadeMedia) {           
        velocidadeMedia = campoTextoVelocidadeMediaTelaVelocidadeMedia;
        tempoGasto  = campoTextoTempoGastoTelaVelocidadeMedia;
    }        

    public JTextField getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public JTextField getTempoGasto() {
        return tempoGasto;
    }

    public double getEspacoPercorrido() {
        return espacoPercorrido;
    }

    public void setEspacoPercorrido(double espacoPercorrido) {
        this.espacoPercorrido = espacoPercorrido;
    }

   
    
    
}
