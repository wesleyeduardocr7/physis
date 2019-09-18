
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.movimentouniforme;

import javax.swing.JTextField;

/**
 *
 * @author Wesley Eduardo
 */
public class VelocidadeMediaTelaMovimentoUniforme {
     
    JTextField espacoInicial;
    JTextField espacoFinal;    
    JTextField tempoGasto;    
    double velocidadeMedia;

    public VelocidadeMediaTelaMovimentoUniforme(JTextField espacoInicial, JTextField espacoFinal, JTextField tempoGasto) {
        this.espacoInicial = espacoInicial;
        this.espacoFinal = espacoFinal;
        this.tempoGasto = tempoGasto;       
    }

    public JTextField getEspacoInicial() {
        return espacoInicial;
    }  

    public JTextField getEspacoFinal() {
        return espacoFinal;
    }

    public JTextField getTempoGasto() {
        return tempoGasto;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }
    
    
     
    
}
