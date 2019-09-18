
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia;

/**
 *
 * @author Wesley Eduardo
 */
public class VelocidadeMediaExeptionTelaVelocidadeMedia extends Exception{
    
    private String descricao;
    
    public VelocidadeMediaExeptionTelaVelocidadeMedia(String descricao) {
        this.descricao = descricao;
     
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
        
}
