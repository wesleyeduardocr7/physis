
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia;

import javax.swing.JTextField;


/**
 *
 * @author Wesley Eduardo
 */
public class VelocidadeMediaTelaVelocidadeMedia{
    
    JTextField espacoPercorrido;
    JTextField tempoGasto;
    double velocidadeMedia; 

    public VelocidadeMediaTelaVelocidadeMedia(JTextField campoTextoEspacoPercorridoTelaVelocidadeMedia , JTextField campoTextoTempoGastoTelaVelocidadeMedia) {           
        espacoPercorrido = campoTextoEspacoPercorridoTelaVelocidadeMedia;
        tempoGasto  = campoTextoTempoGastoTelaVelocidadeMedia;
    }        

    public JTextField getEspacoPercorrido() {
        return this.espacoPercorrido;
    }

    public JTextField getTempoGasto() {
        return this.tempoGasto;
    }    
    
    public double getVelocidadeMedia() {
        return this.velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }
    
    
    
}
