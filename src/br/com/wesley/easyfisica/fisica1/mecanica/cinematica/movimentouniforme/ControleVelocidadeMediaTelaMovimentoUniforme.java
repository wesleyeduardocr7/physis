
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
public class ControleVelocidadeMediaTelaMovimentoUniforme {
    
    
        
  private boolean estaSuspenso = false;
   
  private static Throwable verificaValidadeDosCamposTelaVelocidadeMedia(VelocidadeMediaTelaMovimentoUniforme velocidadeMedia) throws EspacoFinalExeptionTelaMovimentoUniforme {
        
        if (velocidadeMedia.espacoInicial.getText().equals("")) {
            velocidadeMedia.espacoInicial.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Espaço Inicial está Vazio");
        } else if (velocidadeMedia.espacoFinal.getText().equals("")) {
            velocidadeMedia.espacoFinal.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Espaço Final está Vazio");
        }else if (velocidadeMedia.tempoGasto.getText().equals("")) {
            velocidadeMedia.tempoGasto.requestFocus();            
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Tempo gasto está Vazio");
        }else {

            try {

                double espacoInicial = Double.parseDouble(velocidadeMedia.espacoInicial.getText());

                if (espacoInicial  < 0) {
                    velocidadeMedia.espacoInicial.setText("");
                    velocidadeMedia.espacoInicial.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Inicial não pode ser menor que 0");
                }
                

                try {

                    double espacoFinal = Double.parseDouble(velocidadeMedia.espacoFinal.getText());

                   if (espacoFinal  < 0) {
                       velocidadeMedia.espacoFinal.setText("");
                       velocidadeMedia.espacoFinal.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Final não pode ser menor que 0");
                   }

                   if (espacoFinal == 0) {
                      velocidadeMedia.espacoFinal.setText("");
                       velocidadeMedia.espacoFinal.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Final não pode ser = 0");
                   }
                   
                   try {

                        double tempoGasto = Double.parseDouble(velocidadeMedia.tempoGasto.getText());

                       if (tempoGasto  < 0) {
                           velocidadeMedia.tempoGasto.setText("");
                           velocidadeMedia.tempoGasto.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser menor que 0");
                       }

                       if (tempoGasto == 0) {
                          velocidadeMedia.tempoGasto.setText("");
                          velocidadeMedia.tempoGasto.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser = 0");
                       }

                    } catch (NumberFormatException e) {
                        velocidadeMedia.tempoGasto.setText("");
                        velocidadeMedia.tempoGasto.requestFocus();
                        throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Tempo Gasto Válido");
                    }

                } catch (NumberFormatException e) {
                    velocidadeMedia.espacoFinal.setText("");
                    velocidadeMedia.espacoFinal.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Espaço Final Válido");
                }

            } catch (NumberFormatException e) {
                velocidadeMedia.espacoInicial.setText("");
                velocidadeMedia.espacoInicial.requestFocus();
                throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Espaço Inicial Válido");

            }

        }

        return null;
    }
    
    private double calculoVelocidadeMediaKmKmHrKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / tempoGasto;         
        
         textoCalculosTelaMovimentoUniforme.setText(
                 
          "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +        
                         
         "5. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "6. ∆V = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
           "<font color=\"blue\">7. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");   
         
         
         return resultado;
         
    }
   
    
    
    private double calculoVelocidadeMediaKmKmHrMs(double espacoInicial, double espacoFinal, double tempoGasto,  JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / tempoGasto;              
         
               textoCalculosTelaMovimentoUniforme.setText(
                       
         "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +   
                         
         "5. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "6. ∆V = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
          "7. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>" +
                          
         "8. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
          + "<font color=\"blue\">9. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>");
                      
         
         return resultado / 3.6;
    }
    
    
    private double calculoVelocidadeMediaKmKmMinKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / (tempoGasto/60);   
         
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
        "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +   
                 
         "5. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +          
                         
         "6. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "7. ∆V = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
          
          "<font color=\"blue\">8. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");
         
         return resultado;
    }
      
      
    private double calculoVelocidadeMediaKmKmMinMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / (tempoGasto/60); 
         
            textoCalculosTelaMovimentoUniforme.setText(
                    
         "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +   
                 
         "5. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +          
                         
         "6. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "7. ∆V = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
          
          "8. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>"+
            
          "9. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
         + "<font color=\"blue\">10. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>");  
            
         
         return resultado / 3.6;
    }     
      
     private double calculoVelocidadeMediaKmMHrKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / tempoGasto; 
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
        "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +  
                  
          "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +   
                         
         "6. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "7. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - espacoInicial ) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
         "<font color=\"blue\">8. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");  
         
         return resultado;         
    }
      
          
     private double calculoVelocidadeMediaKmMHrMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / tempoGasto; 
         
         
            textoCalculosTelaMovimentoUniforme.setText(
                    
        "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +  
                  
          "<html>5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +   
                         
         "6. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "7. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - espacoInicial ) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
         "8. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>"+
            
          "9. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
         + "<font color=\"blue\">10. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>"); 
                  
         
         return resultado/3.6;
    }
     
    private double calculoVelocidadeMediaKmMMinKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / (tempoGasto/60); 
         
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
                               
        "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" + 
                  
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" + 
                  
         "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +   
                         
         "7. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "8. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - espacoInicial ) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
          
         "<font color=\"blue\">9. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>"); 
         
         
         return resultado;
    }
    
    
    private double calculoVelocidadeMediaKmMMinMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / (tempoGasto/60); 
         
           textoCalculosTelaMovimentoUniforme.setText(
                   
                                            
        "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" + 
                  
         "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" + 
                  
         "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +   
                         
         "7. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "8. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - espacoInicial ) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
                     
         "9. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>"+
            
          "10. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
         + "<font color=\"blue\">11. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>");  
         
         return resultado/3.6;
    }
  
    private double calculoVelocidadeMediaMKmHrKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / tempoGasto;   
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
         "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" + 
             
          "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +          
                  
         "6. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "7. ∆V = (" + String.format("%.2f", espacoFinal - (espacoInicial / 1000)) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
           "<font color=\"blue\">8. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");   
         
         return resultado;
    }
    
    private double calculoVelocidadeMediaMKmHrMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / tempoGasto;  
         
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
        "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" + 
                  
           "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +  
                         
         "6. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "7. ∆V = (" + String.format("%.2f", espacoFinal-(espacoInicial / 1000)) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
          "8. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>" +
                          
         "9. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
          + "<font color=\"blue\">10. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>");
         
         return resultado / 3.6;
         
    }
    
    
    private double calculoVelocidadeMediaMKmMinKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / (tempoGasto/60);   
         
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                            
        "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" + 
          
        "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +  
                 
         "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +          
                         
         "7. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "8. ∆V = (" + String.format("%.2f", espacoFinal-(espacoInicial / 1000)) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
          
          "<font color=\"blue\">9. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");
         
         return resultado;
    }
      
      
    private double calculoVelocidadeMediaMKmMinMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / (tempoGasto/60);
         
           textoCalculosTelaMovimentoUniforme.setText(
                   
          "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " Km" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" + 
                   
           "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +           
                 
         "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +          
                         
         "7. ∆V = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "8. ∆V = (" + String.format("%.2f", espacoFinal-(espacoInicial / 1000)) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
          
          "9. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>"+
            
          "10. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
         + "<font color=\"blue\">11. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>");  
         
         
         return resultado / 3.6;
    }     
      
     private double calculoVelocidadeMediaMMHrKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / tempoGasto;     

          textoCalculosTelaMovimentoUniforme.setText(
                  
              "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +        
                  
           "5 Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +           
                  
          "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +   
                         
         "7. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "8. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - (espacoInicial / 1000) ) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
         "<font color=\"blue\">9. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");  
         
         return resultado;
    }
    
    private double calculoVelocidadeMediaMMHrMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / tempoGasto;    
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
         "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +
                
            "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +                  
                  
          "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +   
                         
         "7. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto) + "<br>" +
                 
         "8. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - (espacoInicial / 1000) ) + ") / " + String.format("%.2f", tempoGasto) + "<br>"+
          
         "9. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>"+
            
          "10. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
         + "<font color=\"blue\">11. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>"); 
                  
         
         return resultado/3.6;
    }
    
    
     
    private double calculoVelocidadeMediaMMMinKmh(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / (tempoGasto/60);
         
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
         "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +
                  
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +                           
                  
         "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" + 
                  
         "7. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +   
                         
         "8. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f",espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "9. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - (espacoInicial / 1000) ) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
          
         "<font color=\"blue\">10. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>"); 
         
         return resultado;
    }
    
    
    private double calculoVelocidadeMediaMMMinMs(double espacoInicial, double espacoFinal, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / (tempoGasto/60); 
         
           textoCalculosTelaMovimentoUniforme.setText(
            
                             
         "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.S = " + espacoFinal  + " m" + "<br>" +
                 
         "3.T = " + tempoGasto +  " min" + "<br>" +  
                 
          "4. V = ( S - So ) / T " + "<br>" +
                   
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +                           
                  
         "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" + 
                  
         "7. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>" +   
                         
         "8. ∆V = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
         ") / "  + String.format("%.2f", tempoGasto/60) + "<br>" +
                 
         "9. ∆V = (" + String.format("%.2f", (espacoFinal / 1000) - (espacoInicial / 1000) ) + ") / " + String.format("%.2f", tempoGasto/60) + "<br>"+
                     
         "10. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "<br>"+
            
          "11. Converte Km/h em m/s: " + String.format("%.2f", resultado) + " / 3.6" + " = " +  String.format("%.2f", (resultado/3.6))+  "<br>"        
         
         + "<font color=\"blue\">12. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s" + "</font></html>");  
         
         return resultado/3.6;
    }
      
    
    
    public VelocidadeMediaTelaMovimentoUniforme calculoVelocidadeMedia(VelocidadeMediaTelaMovimentoUniforme velocidadeMedia,JComboBox unidadeEspacoInicial,
    JComboBox unidadeEspacoFinal, JComboBox unidadeTempoGasto,JComboBox unidadeResultado,
    JTextField campoTextoResultado, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{

        
        if(verificaValidadeDosCamposTelaVelocidadeMedia(velocidadeMedia)==null){
            
            double espacoInicial = Double.parseDouble(velocidadeMedia.espacoInicial.getText());

            double espacoFinal = Double.parseDouble(velocidadeMedia.espacoFinal.getText());
            
            double tempoGasto = Double.parseDouble(velocidadeMedia.tempoGasto.getText());


            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaKmKmHrKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaKmKmHrMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

             if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaKmKmMinKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

              if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaKmKmMinMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            
               if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaKmMHrKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            
            

               if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaKmMHrMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaKmMMinKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaKmMMinMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
                        
            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaMKmHrKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaMKmHrMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

             if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaMKmMinKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

              if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaMKmMinMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            
               if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaMMHrKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            
            

               if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaMMHrMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            

            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km/h")){

                double resultado = calculoVelocidadeMediaMMMinKmh(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M/s")){

                double resultado = calculoVelocidadeMediaMMMinMs(espacoInicial, espacoFinal, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
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
       
    
    public void informacoesParaMovimentarCarrinho(VelocidadeMediaTelaMovimentoUniforme velocidadeMedia, JTextField campoEspacoInicial, JTextField campoEspacoFinal,
       JTextField campoTempoGasto, JComboBox unidadeEspacoInicial,JComboBox unidadeEspacoFinal,JComboBox unidadeTempoGasto,
       JComboBox unidadeResultado , JTextField campoTextoResultado, JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2,
       JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel textoCalculosTelaMovimentoUniforme, JButton btLimparTelaMovUniforme) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException,
       LineUnavailableException, UnsupportedAudioFileException, IOException, EspacoFinalExeptionTelaMovimentoUniforme {
              
            
        if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeTempoGasto.getSelectedItem().equals("Hr")
        && unidadeResultado.getSelectedItem().equals("Km/h")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "Km", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "Km", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "Km", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "Km", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "Km", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }        
        
        //-------------------------------------------------------------------------------------------------
                
           
        if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeTempoGasto.getSelectedItem().equals("Hr")
        && unidadeResultado.getSelectedItem().equals("Km/h")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "Km", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "m", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "hr", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "m", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "hr", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "m", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "min", "Km/h",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoTempoGasto,  "m", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoTempoGasto, "m", "m", "min", "m/s",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }   
        
            
          if(unidadeResultado.getSelectedItem().equals("Km/h")){    
              
                if(velocidadeMedia.getVelocidadeMedia()<=100){
                    moverCarrinho(velocidade,carrinho, 8, btLimparTelaMovUniforme);                   
                }else if(velocidadeMedia.getVelocidadeMedia() > 100 && velocidadeMedia.getVelocidadeMedia() <=200){
                    moverCarrinho(velocidade,carrinho, 6, btLimparTelaMovUniforme);
                }else if(velocidadeMedia.getVelocidadeMedia() > 200 && velocidadeMedia.getVelocidadeMedia() <= 300){
                    moverCarrinho(velocidade,carrinho, 4, btLimparTelaMovUniforme);
                }else if(velocidadeMedia.getVelocidadeMedia() > 300 && velocidadeMedia.getVelocidadeMedia() <= 500){
                    moverCarrinho(velocidade,carrinho,  2, btLimparTelaMovUniforme);
                }else if(velocidadeMedia.getVelocidadeMedia()> 500 && velocidadeMedia.getVelocidadeMedia() <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaMovUniforme);
                }else if(velocidadeMedia.getVelocidadeMedia() > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5, btLimparTelaMovUniforme);
                }

          }else{
             
              if(velocidadeMedia.getVelocidadeMedia()<=30.56){
                  moverCarrinho(velocidade,carrinho,  8, btLimparTelaMovUniforme);
              }else if(velocidadeMedia.getVelocidadeMedia() > 30.56 && velocidadeMedia.getVelocidadeMedia() <=55.56){
                  moverCarrinho(velocidade,carrinho, 6, btLimparTelaMovUniforme);
              }else if(velocidadeMedia.getVelocidadeMedia() > 55.56 && velocidadeMedia.getVelocidadeMedia() <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4, btLimparTelaMovUniforme);
              }else if(velocidadeMedia.getVelocidadeMedia() > 83.33 && velocidadeMedia.getVelocidadeMedia()<= 125){
                  moverCarrinho(velocidade,carrinho, 2, btLimparTelaMovUniforme);
              }else if(velocidadeMedia.getVelocidadeMedia() > 125 && velocidadeMedia.getVelocidadeMedia() <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1, btLimparTelaMovUniforme);
              }else if(velocidadeMedia.getVelocidadeMedia() > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5, btLimparTelaMovUniforme);           
              }
          }    
    }
 
    
    private void imprimiKm1T1(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoTempoGasto,
       String undEspacoInicial,String undEspacoFinal,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km1, JLabel t1, JLabel  textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       VelocidadeMediaTelaMovimentoUniforme dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoTempoGasto);
        
        try {
                        
            VelocidadeMediaTelaMovimentoUniforme vM = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);
           
            
           if(vM!=null){
               velocidade.setText(campoTextoResultado.getText());
               km1.setText("0 " + undEspacoFinal);
               t1.setText("0 " + undTempoGasto);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
     
    private void imprimiKm2T2(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoTempoGasto,
       String undEspacoInicial,String undEspacoFinal,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km2, JLabel t2, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       VelocidadeMediaTelaMovimentoUniforme dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoTempoGasto);
        
        try {
                        
            VelocidadeMediaTelaMovimentoUniforme vM = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);
           
            
           if(vM!=null){
               velocidade.setText(campoTextoResultado.getText());

                double espacoFinal = Double.parseDouble(vM.espacoFinal.getText())/ 3;                
               
                km2.setText(String.format("%.0f",espacoFinal) + undEspacoFinal);

                double tempoFinal = (Double.parseDouble(vM.getTempoGasto().getText())) / 3;
                if(undTempoGasto.equals("min")){        
                    t2.setText(String.format("%.1f", tempoFinal) + undTempoGasto);
                }else{
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
    
    private void imprimiKm3T3(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoTempoGasto,
       String undEspacoInicial,String undEspacoFinal,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km3, JLabel t3, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       VelocidadeMediaTelaMovimentoUniforme dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoTempoGasto);
        
        try {
                        
            VelocidadeMediaTelaMovimentoUniforme vM = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);
           
            
           if(vM!=null){
               velocidade.setText(campoTextoResultado.getText());
             
             double espacoFinal = ((Double.parseDouble(vM.espacoFinal.getText())/ 3)) * 2 ;
             
             km3.setText(String.format("%.0f", espacoFinal) + undEspacoFinal);
             
             double tempoFinal = ((Double.parseDouble(vM.getTempoGasto().getText())) / 3) * 2;
            
               if(undTempoGasto.equals("min")){        
                    t3.setText(String.format("%.1f", tempoFinal) + undTempoGasto);
                }else{
                   
                
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
    
 private void imprimiKm4T4(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoTempoGasto,
       String undEspacoInicial,String undEspacoFinal,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km4, JLabel t4, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       VelocidadeMediaTelaMovimentoUniforme dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoTempoGasto);
        
        try {
                        
            VelocidadeMediaTelaMovimentoUniforme vM = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeTempoGasto, unidadeResultado, campoTextoResultado,textoCalculosTelaMovimentoUniforme);
           
            
           if(vM!=null){
               velocidade.setText(campoTextoResultado.getText());
             
             double espacoInicial = (Double.parseDouble(vM.getEspacoFinal().getText()) / 1);
             
             km4.setText(String.format("%.0f", espacoInicial) + undEspacoFinal);
             
             double tempoFinal = (Double.parseDouble(vM.getTempoGasto().getText())) / 1;
            
             
              if(undTempoGasto.equals("min")){        
                    t4.setText(String.format("%.1f", tempoFinal) + undTempoGasto);
                }else{
                   
                
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

                    synchronized (ControleVelocidadeMediaTelaMovimentoUniforme.this) {
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
