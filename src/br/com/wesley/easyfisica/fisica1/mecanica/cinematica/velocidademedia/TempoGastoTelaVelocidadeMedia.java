
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia;

import javax.swing.JTextField;

/**
 *
 * @author Wesley Eduardo
 */
public class TempoGastoTelaVelocidadeMedia {
    
     
    JTextField velocidadeMedia;         
    JTextField espacoPercorrido;
    double tempoGasto;

    public TempoGastoTelaVelocidadeMedia(JTextField campoTextoVelocidadeMediaTelaVelocidadeMedia , JTextField campoTextoEspacoPercorridoTelaVelocidadeMedia) {           
        velocidadeMedia = campoTextoVelocidadeMediaTelaVelocidadeMedia;
        espacoPercorrido  = campoTextoEspacoPercorridoTelaVelocidadeMedia;
    }        

    public JTextField getVelocidadeMedia() {
        return velocidadeMedia;
    }


    public JTextField getEspacoPercorrido() {
        return espacoPercorrido;
    }

    public double getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(double tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

  

    
}
