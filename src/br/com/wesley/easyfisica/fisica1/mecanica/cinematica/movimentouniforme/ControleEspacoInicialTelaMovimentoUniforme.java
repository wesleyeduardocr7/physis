
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.movimentouniforme;

import br.com.wesley.easyfisica.GUI;
import br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia.VelocidadeMediaExeptionTelaVelocidadeMedia;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Wesley Eduardo
 */
public class ControleEspacoInicialTelaMovimentoUniforme {
    
        
  private boolean estaSuspenso = false;
 
  
  private static Throwable verificaValidadeDosCamposTelaEspacoInicial(EspacoInicialTelaMovimentoUniforme espacoInicial) throws EspacoFinalExeptionTelaMovimentoUniforme {
        
        if (espacoInicial.espacoFinal.getText().equals("")) {
            espacoInicial.espacoFinal.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Espaço Final está Vazio");
        } else if (espacoInicial.velocidadeMedia.getText().equals("")) {
            espacoInicial.velocidadeMedia.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Velocidade Média está Vazio");
        }else if (espacoInicial.tempoGasto.getText().equals("")) {
            espacoInicial.tempoGasto.requestFocus();            
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Tempo gasto está Vazio");
        }else {

            try {

                double espacoFinal = Double.parseDouble(espacoInicial.espacoFinal.getText());

                if (espacoFinal  < 0) {
                    espacoInicial.espacoFinal.setText("");
                    espacoInicial.espacoFinal.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Final não pode ser menor que 0");
                }

                if (espacoFinal == 0) {
                    espacoInicial.espacoFinal.setText("");
                    espacoInicial.espacoFinal.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Final não pode ser = 0");
                }

                try {

                    double velocidadeMedia = Double.parseDouble(espacoInicial.velocidadeMedia.getText());

                   if (velocidadeMedia  < 0) {
                       espacoInicial.velocidadeMedia.setText("");
                       espacoInicial.velocidadeMedia.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Velocidade Média não pode ser menor que 0");
                   }

                   if (velocidadeMedia == 0) {
                      espacoInicial.velocidadeMedia.setText("");
                      espacoInicial.velocidadeMedia.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Velocidade Média não pode ser = 0");
                   }
                   
                   try {

                        double tempoGasto = Double.parseDouble(espacoInicial.tempoGasto.getText());

                       if (tempoGasto  < 0) {
                           espacoInicial.tempoGasto.setText("");
                           espacoInicial.tempoGasto.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser menor que 0");
                       }

                       if (tempoGasto == 0) {
                          espacoInicial.tempoGasto.setText("");
                           espacoInicial.tempoGasto.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser = 0");
                       }

                    } catch (NumberFormatException e) {
                        espacoInicial.tempoGasto.setText("");
                        espacoInicial.tempoGasto.requestFocus();
                        throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Tempo Gasto Válido");
                    }

                } catch (NumberFormatException e) {
                    espacoInicial.velocidadeMedia.setText("");
                    espacoInicial.velocidadeMedia.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite uma Velocidade Média Válido");
                }

            } catch (NumberFormatException e) {
                espacoInicial.espacoFinal.setText("");
                espacoInicial.espacoFinal.requestFocus();
                throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Espaço Final Válido");

            }

        }

        return null;
    }
    

  
    private double calculoEspacoInicialKmKmhHrKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
        
        double resultado = espacoFinal - (velocidadeMedia * tempoGasto); 
        
       
         if(resultado < 0){             
        
           throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !");             
         }   
        
         textoCalculosTelaMovimentoUniforme.setText(
                 
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +        
                 
         "5. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "6. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">7. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
        
         
         return resultado;
    }
    
    private double calculoEspacoInicialKmKmhHrM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
        
         double resultado = espacoFinal - (velocidadeMedia * tempoGasto); 
       
                   
         if(resultado < 0){
             
        
             
           throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                 
                      
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +         
                 
         "5. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "6. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+
         "<br>"
         
         + "7. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
                 
         + "8. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
          + "<font color=\"blue\">9. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");
                 
         
         return resultado * 1000;
    }
    
    private double calculoEspacoInicialKmKmhMinKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
        
         double resultado = espacoFinal - (velocidadeMedia * (tempoGasto/60)); 
         
         if(resultado < 0){
             
     
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                 
                              
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +  
                 
          "5. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "6. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto/60) +")" + "<br>" 
                 
         + "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">8. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");
         
         return resultado;
    }
      
      
    private double calculoEspacoInicialKmKmhMinM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         double resultado = espacoFinal - (velocidadeMedia * (tempoGasto/60));   
         
         if(resultado < 0){
             
      
             
           throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                                           
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +  
                 
          "5. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "6. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto/60) +")" + "<br>" 
                 
         + "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+
         "<br>" 
                 
         + "8. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
         + "9. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
          + "<font color=\"blue\">10. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");
         
         
         
         return resultado * 1000;
    }
 
      
     private double calculoEspacoInicialKmMsHrKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         
         double resultado = espacoFinal - ((velocidadeMedia*3.6) * tempoGasto); 
         
         if(resultado < 0){
             
      
             
           throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
                  
          textoCalculosTelaMovimentoUniforme.setText(
                  
                                              
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +         
         
          "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
         "6. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">8. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
         
         return resultado;
     }
     
         
    
     private double calculoEspacoInicialKmMsHrM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         
         double resultado = espacoFinal - ((velocidadeMedia*3.6) * tempoGasto); 
         
         if(resultado < 0){
             
   
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
         
                 
                                                       
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +    
                 
          "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
         "6. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+
         "<br>" 
                 
         + "8. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
         + "9. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
         + "<font color=\"blue\">10. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");  
         
         return resultado * 1000;
     }
     
   
    
    private double calculoEspacoInicialKmMsMinKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
        
         double resultado = espacoFinal - ((velocidadeMedia*3.6) * (tempoGasto/60));   
         
         if(resultado < 0){
             
           
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
        textoCalculosTelaMovimentoUniforme.setText(
         
                      
                                                       
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +   
                
                
        "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
        "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +        
                  
        "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>" 
                 
        + "8. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+
         "<br>" 
                 
        + "<font color=\"blue\">9. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
                 
        return resultado;
     }
    

    private double calculoEspacoInicialKmMsMinM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
        
         double resultado = espacoFinal - ((velocidadeMedia*3.6) * (tempoGasto/60));  
         
         if(resultado < 0){
             
       
             
           throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
                   
                                                       
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. So = S - V * T " + "<br>" +
         
        "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
        "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +        
                  
        "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>" 
                 
        + "8. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+
         "<br>" 
                 
        + "9. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
         + "10. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
         + "<font color=\"blue\">11. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");  
         
         
         return resultado * 1000;
     }
    
     private double calculoEspacoInicialMKmhHrKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         
         double resultado = (espacoFinal/1000) - (velocidadeMedia * tempoGasto);    
         
         if(resultado < 0){
             
     
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
          textoCalculosTelaMovimentoUniforme.setText(
          
                  
                                                        
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +        
                  
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
                 
         "6. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "7. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">8. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
         
         return resultado;
     }
    
     private double calculoEspacoInicialMKmhHrM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         
         double resultado = (espacoFinal/1000) - (velocidadeMedia * tempoGasto);   
         
         if(resultado < 0){
             
        
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
          
                                                                    
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +   
                 
                 
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
             
         "6. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "7. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+
         "<br>"
         
         + "8. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
                 
         + "9. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
          + "<font color=\"blue\">10. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");
                 
         
         return resultado * 1000;
     }
     
      private double calculoEspacoInicialMKmhMinKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
          
         double resultado = (espacoFinal/1000) - (velocidadeMedia * (tempoGasto/60)); 
         
         if(resultado < 0){
             
     
             
           throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                                                                             
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +  
          
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
         
                         
          "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "7. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto/60) +")" + "<br>" 
                 
         + "8. So = " + String.format("%.2f", espacoFinal) + " - (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">9. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");
         
         return resultado;
     }
      
      
    private double calculoEspacoInicialMKmhMinM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
        
         double resultado = (espacoFinal/1000) - (velocidadeMedia * (tempoGasto/60));
         
         if(resultado < 0){
             
          
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
          
                            
                                                                             
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +  
                 
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
         
          "<6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "7. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto/60) +")" + "<br>" 
                 
         + "8. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+
         "<br>" 
                 
         + "9. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
         + "10. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
          + "<font color=\"blue\">11. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");
         
         
         return resultado * 1000;
    }
    
     private double calculoEspacoInicialMMsHrKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         
         double resultado = (espacoFinal/1000) - ((velocidadeMedia*3.6) * tempoGasto); 
         
         if(resultado < 0){
             

             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
                    "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +  
          
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
         
         "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
         "7. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "8. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">9. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
         
         return resultado;
    }
     
     private double calculoEspacoInicialMMsHrM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
         
         double resultado = (espacoFinal/1000) - ((velocidadeMedia*3.6) * tempoGasto); 
         
         if(resultado < 0){
             
      
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +  
          
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
         
         "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
         "7. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "8. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+
         "<br>" 
                 
         + "9. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
         + "10. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
         + "<font color=\"blue\">11. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");  
         
         return resultado * 1000;
    }
     
      private double calculoEspacoInicialMMsMinKm(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
          
         double resultado = (espacoFinal/1000) - ((velocidadeMedia*3.6) * (tempoGasto/60));  
         
         if(resultado < 0){
       
             
          throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
                  
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" +         
          
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
         
          
        "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
        "7. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +        
                  
        "8. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>" 
                 
        + "9. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+
         "<br>" 
                 
        + "<font color=\"blue\">10. So = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
         
         return resultado;
    }
      
      
      private double calculoEspacoInicialMMsMinM(double espacoFinal, double velocidadeMedia, double tempoGasto,
    JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{
          
         double resultado = (espacoFinal/1000) - ((velocidadeMedia*3.6) * (tempoGasto/60));      
         
         if(resultado < 0){
             
         
             
         throw new EspacoFinalExeptionTelaMovimentoUniforme("Atenção ! Para esses Valores o Resultado será Negativo, Altere para outros Valores !"); 
         }   
        
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                            
         "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. So = S - V * T " + "<br>" + 
          
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>"+
         
          "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+         
                  
        "7. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +        
                  
        "8. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>" 
                 
        + "9. So = " + String.format("%.2f", espacoFinal / 1000) + " - (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+
         "<br>" 
                 
        + "10. So = " + String.format("%.2f", resultado) +  " Km" + "<br>" 
         
         + "11. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"               
         
         + "<font color=\"blue\">12. So = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>");  
         
         return resultado * 1000;
    }
      
    
    
    public EspacoInicialTelaMovimentoUniforme calculoEspacoInicial(EspacoInicialTelaMovimentoUniforme espacoInicial,JComboBox unidadeEspacoFinal,
    JComboBox unidadeVelocidadeMedia, JComboBox unidadeTempoGasto,JComboBox unidadeResultado,
    JTextField campoTextoResultado, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{

        
        if(verificaValidadeDosCamposTelaEspacoInicial(espacoInicial)==null){
            
            double espacoFinal = Double.parseDouble(espacoInicial.espacoFinal.getText());

            double velocidadeMedia = Double.parseDouble(espacoInicial.velocidadeMedia.getText());
            
            double tempoGasto = Double.parseDouble(espacoInicial.tempoGasto.getText());


            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoInicialKmKmhHrKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km");
                espacoInicial.setEspacoInicial(resultado);
                return espacoInicial;
            }

            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                double resultado = calculoEspacoInicialKmKmhHrM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m");
                espacoInicial.setEspacoInicial(resultado);
                return espacoInicial;
            }

            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoInicialKmKmhMinKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km");
                espacoInicial.setEspacoInicial(resultado);
                return espacoInicial;
            }

            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialKmKmhMinM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
            
            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoInicialKmMsHrKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }

            

            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialKmMsHrM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }

            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoInicialKmMsMinKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
           
            if(unidadeEspacoFinal.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialKmMsMinM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
              
            if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoInicialMKmhHrKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
            
             if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialMKmhHrM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
             
            if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoInicialMKmhMinKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
            
             if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialMKmhMinM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
             
               if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoInicialMMsHrKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
               
            if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialMMsHrM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
            
             if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoInicialMMsMinKm(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
             
              if(unidadeEspacoFinal.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoInicialMMsMinM(espacoFinal, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoInicial.setEspacoInicial(resultado);
                   return espacoInicial;
            }
        }       

        return null;
        
}

    public void mostrarInformacoesBotoesTelaVelocidadeMedia( JButton  bt1ExplicacaoTelaMecanica, JButton btCinematicaTelaFisica1, JButton btDinamicaTelaFisica1,
    JButton btEstaticaTelaFisica1, JButton  btHidrostaticaTelaFisica1, JButton btGravUniversalTelaFisica1, JButton btVoltarTelaFisica1,
    JButton bt1ExplicacaoTelaCinematica, JButton btVoltarTelaAnteriorCinematica, JButton btVoltarTelaInicioCinematica , JButton btVelocidadeMediaTelaCinematica,
    JButton bt1ExplicacaoVelocidadeMedia) {

        bt1ExplicacaoTelaMecanica.setToolTipText("A Mecânica é a parte da Física que estuda o estado de movimento dos corpos");
        btCinematicaTelaFisica1.setToolTipText("A cinemática é o ramo da física que se ocupa da descrição dos movimentos dos corpos, sem se preocupar com a análise de suas causas (dinâmica)");
        btDinamicaTelaFisica1.setToolTipText("A dinâmica é o ramo da mecânica que estuda o movimento de um corpo e as causas desse movimento");
        btEstaticaTelaFisica1.setToolTipText("A estática é a parte que estuda sistemas sob a ação de forças que se equilibram");
        btHidrostaticaTelaFisica1.setToolTipText("A hidrostática é a parte da física que estuda os fluidos em repouso");
        btGravUniversalTelaFisica1.setToolTipText("A gravitação universal é uma força fundamental de atração que age entre todos os objetos, de acordo com a quantidade de matéria de que são constituídos (massa)");
        btVoltarTelaFisica1.setToolTipText("Voltar ao Menu Inicial");
        bt1ExplicacaoTelaCinematica.setToolTipText("A cinemática é o ramo da física que se ocupa da descrição dos movimentos dos corpos, sem se preocupar com a análise de suas causas (dinâmica)");
        btVoltarTelaAnteriorCinematica.setToolTipText("Voltar à tela anterior");
        btVoltarTelaInicioCinematica.setToolTipText("Voltar à tela Inicial");
        btVelocidadeMediaTelaCinematica.setToolTipText("Na física, a velocidade é uma grandeza que identifica o deslocamento de um corpo num determinado tempo");
        bt1ExplicacaoVelocidadeMedia.setToolTipText("Na física, a velocidade é uma grandeza que identifica o deslocamento de um corpo num determinado tempo");
        
    }
       
    
    public void informacoesParaMovimentarCarrinho(EspacoInicialTelaMovimentoUniforme espacoInicial, JTextField campoEspacoFinal, JTextField campoVelocidadeMedia,
       JTextField campoTempoGasto, JComboBox unidadeEspacoFinal,JComboBox unidadeVelocidadeMedia,JComboBox unidadeTempoGasto,
       JComboBox unidadeResultado , JTextField campoTextoResultado, JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2,
       JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel textoCalculosTelaMovimentoUniforme, JButton btLimparTelaMovUniforme) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException,
       LineUnavailableException, UnsupportedAudioFileException, IOException, EspacoFinalExeptionTelaMovimentoUniforme {
              
            
        if(unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempoGasto.getSelectedItem().equals("Hr")
        && unidadeResultado.getSelectedItem().equals("Km")){          
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }        
        
        //-------------------------------------------------------------------------------------------------
                
        else if(unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempoGasto.getSelectedItem().equals("Hr")
        && unidadeResultado.getSelectedItem().equals("Km")){          
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoFinal, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoFinal,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }      
        
            
          if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")){    
              
                if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText())<=100){
                    moverCarrinho(velocidade,carrinho, 8, btLimparTelaMovUniforme);                   
                }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 100 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <=200){
                    moverCarrinho(velocidade,carrinho, 6, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 200 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <= 300){
                    moverCarrinho(velocidade,carrinho, 4, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 300 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <= 500){
                    moverCarrinho(velocidade,carrinho,  2, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 500 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5, btLimparTelaMovUniforme);
                }

          }else{
             
              if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText())<=30.56){
                  moverCarrinho(velocidade,carrinho,  8, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 30.56 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <=55.56){
                  moverCarrinho(velocidade,carrinho, 6, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 55.56 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 83.33 && Double.parseDouble(espacoInicial.getVelocidadeMedia().getText())<= 125){
                  moverCarrinho(velocidade,carrinho, 2, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 125 &&Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoInicial.getVelocidadeMedia().getText()) > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5, btLimparTelaMovUniforme);           
              }
          }    
    }
 
    
    private void imprimiKm1T1(JTextField campoEspacoFinal,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoFinal,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoFinal,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km1, JLabel t1, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoInicialTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoInicialTelaMovimentoUniforme(campoEspacoFinal,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoInicialTelaMovimentoUniforme eI = calculoEspacoInicial(dadosDosCamposEspacoFinal, unidadeEspacoFinal,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado,textoCalculosTelaMovimentoUniforme);
           
            
           if(eI!=null){
               velocidade.setText(campoVelocidadeMedia.getText() + " " + undVelocidadeMedia);
               km1.setText("0 " + unidadeEspacoFinal.getSelectedItem());
               t1.setText("0 " + undTempoGasto);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
    private void imprimiKm2T2(JTextField campoEspacoFinal,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoFinal,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoFinal,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km2, JLabel t2, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoInicialTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoInicialTelaMovimentoUniforme(campoEspacoFinal,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoInicialTelaMovimentoUniforme eI = calculoEspacoInicial(dadosDosCamposEspacoFinal, unidadeEspacoFinal,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado ,textoCalculosTelaMovimentoUniforme);           
       
            if (eI != null) {
                
                velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);

                double espacoInicial = eI.espacoInicial/ 3;                
               
                km2.setText(String.format("%.0f",espacoInicial) + undResultado);

                double tempoFinal = (Double.parseDouble(eI.getTempoGasto().getText())) / 3;
                
                 if(undTempoGasto.equals("min")){        
                    t2.setText(String.format("%.1f", tempoFinal) + undTempoGasto);
                }else{
                    System.out.println(tempoFinal+"\n");
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t2.setText(resultado);
                } 

            } else {
                JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }              
    }
    
     private void imprimiKm3T3(JTextField campoEspacoFinal,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoFinal,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoFinal,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km3, JLabel t3, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoInicialTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoInicialTelaMovimentoUniforme(campoEspacoFinal,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoInicialTelaMovimentoUniforme eI = calculoEspacoInicial(dadosDosCamposEspacoFinal, unidadeEspacoFinal,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);           
       
            if (eI != null) {
                
            velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);
             
             double espacoInicial = ((eI.espacoInicial/ 3)) * 2 ;
             
             km3.setText(String.format("%.0f", espacoInicial) + undResultado);
             
             double tempoFinal = ((Double.parseDouble(eI.getTempoGasto().getText())) / 3) * 2;
               
             if(undTempoGasto.equals("min")){        
                    t3.setText(String.format("%.1f", tempoFinal) + undTempoGasto);
                }else{
                    System.out.println(tempoFinal+"\n");
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t3.setText(resultado);
                } 
             
         } else {
             JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
            
         } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } 
    }    
    
  private void imprimiKm4T4(JTextField campoEspacoFinal,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoFinal,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoFinal,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km4, JLabel t4,  JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoInicialTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoInicialTelaMovimentoUniforme(campoEspacoFinal,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoInicialTelaMovimentoUniforme eI = calculoEspacoInicial(dadosDosCamposEspacoFinal, unidadeEspacoFinal,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);           
       
            if (eI != null) {
                
                velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);
             
             double espacoInicial = (eI.getEspacoInicial() / 1);
             
             km4.setText(String.format("%.0f", espacoInicial) + undResultado);
             
             double tempoFinal = (Double.parseDouble(eI.getTempoGasto().getText())) / 1;
             
             if(undTempoGasto.equals("min")){        
                    t4.setText(String.format("%.1f", tempoFinal) + undTempoGasto);
                }else{
                    System.out.println(tempoFinal+"\n");
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t4.setText(resultado);
                }    
             
         } else {
             JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
            
        } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } 
        
    }
    
    
    private void suspend() {
        this.estaSuspenso = true;
    }
    
    private synchronized void resume() {
        this.estaSuspenso = false;
        notify();
    }

    public  void pararCarrinho() throws InterruptedException {
        this.suspend();
        Thread.sleep(50);
        this.resume();
    }
   
    
    private void moverCarrinho(JLabel velocidade, JLabel carrinho, long valorVelocidade, JButton btLimparTelaMovUniforme) throws InterruptedException, MalformedURLException, LineUnavailableException, LineUnavailableException, UnsupportedAudioFileException, IOException {
             
        moverTextoVelocidade(velocidade, valorVelocidade);          
        
        Runnable r = () -> {
            int posicaoInicial = carrinho.getLocation().x;
            int x = carrinho.getLocation().x;
            int y = carrinho.getLocation().y;
            
            while (true) {
                btLimparTelaMovUniforme.setEnabled(false);
                x++;                
                if (x > 850) {   
             
                    break;
                }
                while (estaSuspenso) {
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException ex) {}
                }

                carrinho.setLocation(x, y);
                try {
                    sleep(valorVelocidade);
                    
                } catch (InterruptedException e) {
                }
            }
            btLimparTelaMovUniforme.setEnabled(true);
        };

        Thread t = new Thread(r);

        t.start();

    }

    private void moverTextoVelocidade(JLabel velocidade, long valorVelocidade) {

        new Thread() {
            @Override
            public void run() {
                int posicaoInicial = velocidade.getLocation().x;
                int x = velocidade.getLocation().x;
                int y = velocidade.getLocation().y;
                while (true) {
                    x++;

                    synchronized (ControleEspacoInicialTelaMovimentoUniforme.this) {
                        while (estaSuspenso) {
                            try {
                                Thread.currentThread().wait();
                            } catch (InterruptedException ex) {
                            }
                        }
                    }

                    if (x > 885) {
                        break;
                    }
                    velocidade.setLocation(x, y);
                    try {
                        sleep(valorVelocidade);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
    }

    
    
}
