
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
public class ControleEspacoFinalTelaMovimentoUniforme {
       
  private boolean estaSuspenso = false;
   
  private static Throwable verificaValidadeDosCamposTelaEspacoFinal(EspacoFinalTelaMovimentoUniforme espacoFinal) throws EspacoFinalExeptionTelaMovimentoUniforme {
        
        if (espacoFinal.espacoInicial.getText().equals("")) {
            espacoFinal.espacoInicial.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Espaço Inicial está Vazio");
        } else if (espacoFinal.velocidadeMedia.getText().equals("")) {
            espacoFinal.velocidadeMedia.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Velocidade Média está Vazio");
        }else if (espacoFinal.tempoGasto.getText().equals("")) {
            espacoFinal.tempoGasto.requestFocus();            
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Tempo gasto está Vazio");
        }else {

            try {

                double espacoInicial = Double.parseDouble(espacoFinal.espacoInicial.getText());

                if (espacoInicial  < 0) {
                    espacoFinal.espacoInicial.setText("");
                    espacoFinal.espacoInicial.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Inicial não pode ser menor que 0");
                }
            
                try {

                    double velocidadeMedia = Double.parseDouble(espacoFinal.velocidadeMedia.getText());

                   if (velocidadeMedia  < 0) {
                       espacoFinal.velocidadeMedia.setText("");
                       espacoFinal.velocidadeMedia.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Velocidade Média não pode ser menor que 0");
                   }

                   if (velocidadeMedia == 0) {
                      espacoFinal.velocidadeMedia.setText("");
                       espacoFinal.velocidadeMedia.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Velocidade Média não pode ser = 0");
                   }
                   
                   try {

                        double tempoGasto = Double.parseDouble(espacoFinal.tempoGasto.getText());

                       if (tempoGasto  < 0) {
                           espacoFinal.tempoGasto.setText("");
                           espacoFinal.tempoGasto.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser menor que 0");
                       }

                       if (tempoGasto == 0) {
                          espacoFinal.tempoGasto.setText("");
                           espacoFinal.tempoGasto.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser = 0");
                       }

                    } catch (NumberFormatException e) {
                        espacoFinal.tempoGasto.setText("");
                        espacoFinal.tempoGasto.requestFocus();
                        throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Tempo Gasto Válido");
                    }

                } catch (NumberFormatException e) {
                    espacoFinal.velocidadeMedia.setText("");
                    espacoFinal.velocidadeMedia.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite uma Velocidade Média Válido");
                }

            } catch (NumberFormatException e) {
                espacoFinal.espacoInicial.setText("");
                espacoFinal.espacoInicial.requestFocus();
                throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Espaço Inicial Válido");

            }

        }

        return null;
    }
    
    private double calculoEspacoFinalKmKmhHrKm(double espacoInicial, double velocidadeMedia,
    double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
        
        double resultado = espacoInicial + (velocidadeMedia * tempoGasto);
                       
        textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +
                 
         "5. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "6. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">7. S = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
         
         
         return resultado;
    }
    
    private double calculoEspacoFinalKmKmhHrM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = espacoInicial + (velocidadeMedia * tempoGasto); 
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
         "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +        
                 
         "5. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "6. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+ "<br>"
         
        + "7. S = " + String.format("%.2f", espacoInicial + (velocidadeMedia*tempoGasto)) +  "<br>"
                 
         + "8. Converte Km em m: " + String.format("%.2f", espacoInicial + (velocidadeMedia*tempoGasto)) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+
         "<br>"        
                 
         + "<font color=\"blue\">9. S = " + String.format("%.2f", resultado * 1000) +  " m" + "</font></html>");   
         
         return resultado * 1000;
    }
    
    private double calculoEspacoFinalKmKmhMinKm(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = espacoInicial + (velocidadeMedia * (tempoGasto/60));   
         
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
           "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +         
                 
         "5. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" + " = " +  String.format("%.2f", tempoGasto/60) +  "<br>"
         
          + "6. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "7. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+ "<br>"
         
         
         + "<font color=\"blue\">8. S = " + String.format("%.2f", resultado) +  " Km" + "</font></html>"); 
         
         
         return resultado;
    }
      
      
    private double calculoEspacoFinalKmKmhMinM(double espacoInicial, double velocidadeMedia, double tempoGasto,JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = espacoInicial + (velocidadeMedia * (tempoGasto/60)); 
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                 
           "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +          
                 
         "5. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
         
          + "6. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "7. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+ "<br>"
         
        + "8. S = " + String.format("%.2f", espacoInicial + (velocidadeMedia*(tempoGasto/60))) +  "<br>"
                
          + "9. Converte Km em m: " + String.format("%.2f", espacoInicial + (velocidadeMedia*(tempoGasto/60))) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+
         "<br>"
         
         + "<font color=\"blue\">10. S = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>"); 
         
         return resultado * 1000;
    }
      
      
     private double calculoEspacoFinalKmMsHrKm(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = espacoInicial + ((velocidadeMedia*3.6) * tempoGasto); 
         
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                 
           "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +        
                 
         "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"
         
          + "6. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>"       
                 
         + "7. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+ "<br>"
                           
         + "<font color=\"blue\">8. S = " + String.format("%.2f", resultado) +  "Km" + "</font></html>");   
         
         
         return resultado;//5
     }
    
     private double calculoEspacoFinalKmMsHrM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = espacoInicial + ((velocidadeMedia*3.6) * tempoGasto);
         
         textoCalculosTelaMovimentoUniforme.setText(
                                  
                 
           "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +         
                 
         "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" +  " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"
         
          + "6. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>"       
                 
         + "7. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+ "<br>"
         
         + "8. S = " + String.format("%.2f", resultado)+ "<br>"
                 
         + "9. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+ "<br>"                 
                           
         + "<font color=\"blue\">10. S = " + String.format("%.2f", resultado*1000) +  "m" + "</font></html>"); 
         
         return resultado * 1000;
     }
    
    private double calculoEspacoFinalKmMsMinKm(double espacoInicial, double velocidadeMedia, double tempoGasto,
            JLabel textoCalculosTelaMovimentoUniforme){
        
         double resultado = espacoInicial + ((velocidadeMedia*3.6) * (tempoGasto/60)); 
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
                  
           "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +         
                 
         "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+   "<br>"
                 
         + "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" + " = " +  String.format("%.2f", tempoGasto/60) +   "<br>"
         
          + "7. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "8. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+ "<br>"
                    
                           
         + "<font color=\"blue\">5. S = " + String.format("%.2f", resultado) +  "Km" + "</font></html>"); 
         
         return resultado;
     }
    
    
    private double calculoEspacoFinalKmMsMinM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = espacoInicial + ((velocidadeMedia*3.6) * (tempoGasto/60));  
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                
           "<html>1. So = " + espacoInicial + " Km" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +            
                 
                 
         "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" +  " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"
                 
         + "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" + " = " +  String.format("%.2f", tempoGasto/60) +   "<br>"
         
          + "7. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "8. S = " + String.format("%.2f", espacoInicial) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+ "<br>"
                 
         + "9. S = " + String.format("%.2f", resultado)+ "<br>"
                    
         + "10. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+  "<br>"
                           
         + "<font color=\"blue\">11. S = " + String.format("%.2f", resultado*1000) +  "m" + "</font></html>"); 
         
         return resultado * 1000;
     }
    
     private double calculoEspacoFinalMKmhHrKm(double espacoInicial, double velocidadeMedia, double tempoGasto, 
             JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + (velocidadeMedia * tempoGasto); 
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
          "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +          
                 
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>"
                 
          + "6. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "7. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+
         "<br>" 
                 
         + "<font color=\"blue\">8. S = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");   
         
         
         return resultado;
     }
    
     private double calculoEspacoFinalMKmhHrM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + (velocidadeMedia * tempoGasto);  
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
                   "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +    
         
          "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>"
                 
         +"6. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>" 
                 
         + "7. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia*tempoGasto) + ")"+ "<br>"
         
        + "8. S = " + String.format("%.2f", (espacoInicial/1000) + (velocidadeMedia*tempoGasto)) +  "<br>"
                 
         + "9. Converte Km em m: " + String.format("%.2f", (espacoInicial/1000) + (velocidadeMedia*tempoGasto)) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+
         "<br>"        
                 
         + "<font color=\"blue\">10. S = " + String.format("%.2f", resultado * 1000) +  " m" + "</font></html>");  
                 
         
         return resultado * 1000;
     }
     
      private double calculoEspacoFinalMKmhMinKm(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + (velocidadeMedia * (tempoGasto/60)); 
         
          textoCalculosTelaMovimentoUniforme.setText(
                  
                            "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" + 
          
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+
         "<br>"          
                  
          + "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" + " = " +  String.format("%.2f", tempoGasto/60) +  "<br>"
         
          + "7. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "8. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+ "<br>"
           
         + "<font color=\"blue\">9. S = " + String.format("%.2f", resultado) +  " Km" + "</font></html>"); 
         
         return resultado;
     }
      
      
    private double calculoEspacoFinalMKmhMinM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + (velocidadeMedia * (tempoGasto/60));
         
         textoCalculosTelaMovimentoUniforme.setText(
          
         "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " Km/h" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +                 
                 
          
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+
         "<br>"          
                 
          + "6. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +  " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
         
          + "7. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "8. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", velocidadeMedia*(tempoGasto/60)) + ")"+ "<br>"
         
        + "9. S = " + String.format("%.2f", (espacoInicial/1000) + (velocidadeMedia*(tempoGasto/60))) +  "<br>"
                
          + "10. Converte Km em m: " + String.format("%.2f", (espacoInicial/1000) + (velocidadeMedia*(tempoGasto/60))) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+
         "<br>"
         
         + "<font color=\"blue\">11. S = " + String.format("%.2f", resultado*1000) +  " m" + "</font></html>"); 
         
         
         
         return resultado * 1000;
    }
    
     private double calculoEspacoFinalMMsHrKm(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + ((velocidadeMedia*3.6) * tempoGasto); 
         
         textoCalculosTelaMovimentoUniforme.setText(
                 
           "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +       
                 
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+
         "<br>"              
                 
         + "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"
         
          + "7. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>"       
                 
         + "8. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+ "<br>"
                           
         + "<font color=\"blue\">9. S = " + String.format("%.2f", resultado) +  "Km" + "</font></html>");   
         
         
         return resultado;
    }
     
     private double calculoEspacoFinalMMsHrM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + ((velocidadeMedia*3.6) * tempoGasto);   
         
           textoCalculosTelaMovimentoUniforme.setText(
                   
                   
        "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Hr" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +  
                 
           "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+
         "<br>"             
                   
         + "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" +  " = " +  String.format("%.2f", (velocidadeMedia*3.6))+ "<br>"
         
          + "7. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", tempoGasto) +")" + "<br>"       
                 
         + "8. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*tempoGasto) + ")"+ "<br>"
                 
         + "9. S = " + String.format("%.2f", resultado) + "<br>"
                 
         + "10. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+
         "<br>"                 
                           
         + "<font color=\"blue\">11. S = " + String.format("%.2f", resultado*1000) +  "m" + "</font></html>"); 
         
         
         return resultado * 1000;
    }
     
      private double calculoEspacoFinalMMsMinKm(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + ((velocidadeMedia*3.6) * (tempoGasto/60));      
         
           textoCalculosTelaMovimentoUniforme.setText(
                   
         "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" + 
                   
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+
         "<br>" 
                 
         + "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+   "<br>"
                 
         + "7. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" +   " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
         
          + "8. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "9. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+ "<br>"
                    
                           
         + "<font color=\"blue\">10. S = " + String.format("%.2f", resultado) +  "Km" + "</font></html>"); 
         
         return resultado;
    }
      
      
      private double calculoEspacoFinalMMsMinM(double espacoInicial, double velocidadeMedia, double tempoGasto, JLabel  textoCalculosTelaMovimentoUniforme){
         double resultado = (espacoInicial/1000) + ((velocidadeMedia*3.6) * (tempoGasto/60));
         
         
           textoCalculosTelaMovimentoUniforme.setText(
                   
            "<html>1. So = " + espacoInicial + " m" + "<br>" +
         
         "2.V = " + velocidadeMedia + " m/s" + "<br>" +
                 
         "3.T = " + tempoGasto +  " Min" + "<br>" +
                
        "4. S = So + V * T " + "<br>" +         
                   
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+
         "<br>"                            
                 
          + "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" +  " = " +  String.format("%.2f", (velocidadeMedia*3.6))+ "<br>"
                 
         + "7. Converte min em hr: " + String.format("%.2f", tempoGasto) + " / 60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
         
          + "8. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)) + 
         " * "  + String.format("%.2f", (tempoGasto/60)) +")" + "<br>"       
                 
         + "9. S = " + String.format("%.2f", (espacoInicial/1000)) + " + (" + String.format("%.2f", (velocidadeMedia*3.6)*(tempoGasto/60)) + ")"+ "<br>"
                 
          + "10. S = " + String.format("%.2f", resultado)+ "<br>"      
                    
         + "11. Converte Km em m: " + String.format("%.2f", resultado) + " * 1000" + " = " +  String.format("%.2f", resultado * 1000)+
         "<br>"
                           
         + "<font color=\"blue\">12. S = " + String.format("%.2f", resultado*1000) +  "m" + "</font></html>");
         
         
         return resultado * 1000;
    }
      
    
    
    public EspacoFinalTelaMovimentoUniforme calculoEspacoFinal(EspacoFinalTelaMovimentoUniforme espacoFinal,JComboBox unidadeEspacoInicial,
    JComboBox unidadeVelocidadeMedia, JComboBox unidadeTempoGasto,JComboBox unidadeResultado,
    JTextField campoTextoResultado, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{

        
        if(verificaValidadeDosCamposTelaEspacoFinal(espacoFinal)==null){
            
            double espacoInicial = Double.parseDouble(espacoFinal.espacoInicial.getText());

            double velocidadeMedia = Double.parseDouble(espacoFinal.velocidadeMedia.getText());
            
            double tempoGasto = Double.parseDouble(espacoFinal.tempoGasto.getText());


            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoFinalKmKmhHrKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km");
                espacoFinal.setEspacoFinal(resultado);
                return espacoFinal;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                double resultado = calculoEspacoFinalKmKmhHrM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " m");
                espacoFinal.setEspacoFinal(resultado);
                return espacoFinal;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoFinalKmKmhMinKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " Km");
                espacoFinal.setEspacoFinal(resultado);
                return espacoFinal;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalKmKmhMinM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
            
            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoFinalKmMsHrKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }

            

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalKmMsHrM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoFinalKmMsMinKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
           
            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalKmMsMinM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
              
            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoFinalMKmhHrKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalMKmhHrM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
             
            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoFinalMKmhMinKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalMKmhMinM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
             
               if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoFinalMMsHrKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
               
            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Hr") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalMMsHrM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("Km")){

                   double resultado = calculoEspacoFinalMMsMinKm(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " Km");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
            }
             
              if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
               && unidadeTempoGasto.getSelectedItem().equals("Min") && unidadeResultado.getSelectedItem().equals("M")){

                   double resultado = calculoEspacoFinalMMsMinM(espacoInicial, velocidadeMedia, tempoGasto, textoCalculosTelaMovimentoUniforme);
                   String resultadoFinal = String.format("%.2f", resultado);
                   campoTextoResultado.setText(resultadoFinal + " m");
                   espacoFinal.setEspacoFinal(resultado);
                   return espacoFinal;
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
       
    
    public void informacoesParaMovimentarCarrinho(EspacoFinalTelaMovimentoUniforme espacoFinal, JTextField campoEspacoInicial, JTextField campoVelocidadeMedia,
       JTextField campoTempoGasto, JComboBox unidadeEspacoInicial,JComboBox unidadeVelocidadeMedia,JComboBox unidadeTempoGasto,
       JComboBox unidadeResultado , JTextField campoTextoResultado, JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2,
       JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel textoCalculosTelaMovimentoUniforme,
       JButton btLimparTelaMovUniforme) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException,
       LineUnavailableException, UnsupportedAudioFileException, IOException, EspacoFinalExeptionTelaMovimentoUniforme {
              
            
        if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempoGasto.getSelectedItem().equals("Hr")
        && unidadeResultado.getSelectedItem().equals("Km")){          
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "Km", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4,textoCalculosTelaMovimentoUniforme);
        }        
        
        //-------------------------------------------------------------------------------------------------
                
        else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempoGasto.getSelectedItem().equals("Hr")
        && unidadeResultado.getSelectedItem().equals("Km")){          
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "Km/h", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Hr")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "hr", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "Km",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
            && unidadeTempoGasto.getSelectedItem().equals("Min")
            && unidadeResultado.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
             imprimiKm2T2(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoVelocidadeMedia, campoTempoGasto, "m", "m/s", "min", "m",unidadeEspacoInicial,
            unidadeVelocidadeMedia, unidadeTempoGasto , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }      
        
            
          if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")){    
              
                if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText())<=100){
                    moverCarrinho(velocidade,carrinho, 8,  btLimparTelaMovUniforme);                   
                }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 100 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <=200){
                    moverCarrinho(velocidade,carrinho, 6,  btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 200 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <= 300){
                    moverCarrinho(velocidade,carrinho, 4,  btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 300 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <= 500){
                    moverCarrinho(velocidade,carrinho,  2,  btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 500 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5,  btLimparTelaMovUniforme);
                }

          }else{
             
              if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText())<=30.56){
                  moverCarrinho(velocidade,carrinho,  8,  btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 30.56 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <=55.56){
                  moverCarrinho(velocidade,carrinho, 6,  btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 55.56 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4,  btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 83.33 && Double.parseDouble(espacoFinal.getVelocidadeMedia().getText())<= 125){
                  moverCarrinho(velocidade,carrinho, 2,  btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 125 &&Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1,  btLimparTelaMovUniforme);
              }else if(Double.parseDouble(espacoFinal.getVelocidadeMedia().getText()) > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5,  btLimparTelaMovUniforme);           
              }
          }    
    }
 
    
    private void imprimiKm1T1(JTextField campoEspacoInicial,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoInicial,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km1, JLabel t1, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoFinalTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoFinalTelaMovimentoUniforme(campoEspacoInicial,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoFinalTelaMovimentoUniforme eF = calculoEspacoFinal(dadosDosCamposEspacoFinal, unidadeEspacoInicial,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);
           
            
           if(eF!=null){
               velocidade.setText(campoVelocidadeMedia.getText() + " " + undVelocidadeMedia);
               km1.setText("0 " + unidadeEspacoInicial.getSelectedItem());
               t1.setText("0 " + undTempoGasto);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
   private void imprimiKm2T2(JTextField campoEspacoInicial,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoInicial,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km2, JLabel t2, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoFinalTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoFinalTelaMovimentoUniforme(campoEspacoInicial,campoVelocidadeMedia, campoTempoGasto);
      
        try {
                        
            EspacoFinalTelaMovimentoUniforme eF = calculoEspacoFinal(dadosDosCamposEspacoFinal, unidadeEspacoInicial,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);            
       
            if (eF != null) {
                
                velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);

                double espacoFinal = eF.espacoFinal/ 3;                
               
                km2.setText(String.format("%.0f",espacoFinal) + undResultado);

                double tempoFinal = (Double.parseDouble(eF.getTempoGasto().getText())) / 3;
                                
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
    
     private void imprimiKm3T3(JTextField campoEspacoInicial,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoInicial,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km3, JLabel t3, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoFinalTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoFinalTelaMovimentoUniforme(campoEspacoInicial,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoFinalTelaMovimentoUniforme eF = calculoEspacoFinal(dadosDosCamposEspacoFinal, unidadeEspacoInicial,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);            
       
            if (eF != null) {
                
             velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);
             
             double espacoFinal = ((eF.getEspacoFinal()/ 3)) * 2 ;
             
             km3.setText(String.format("%.0f", espacoFinal) + undResultado);
             
             double tempoFinal = ((Double.parseDouble(eF.getTempoGasto().getText())) / 3) * 2;
             
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
    
      private void imprimiKm4T4(JTextField campoEspacoInicial,JTextField campoVelocidadeMedia, JTextField campoTempoGasto,
       String undEspacoInicial,String undVelocidadeMedia,String undTempoGasto, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeVelocidaedMedia,JComboBox unidadeTempoGasto,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km4, JLabel t4, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       EspacoFinalTelaMovimentoUniforme dadosDosCamposEspacoFinal = new EspacoFinalTelaMovimentoUniforme(campoEspacoInicial,campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoFinalTelaMovimentoUniforme eF = calculoEspacoFinal(dadosDosCamposEspacoFinal, unidadeEspacoInicial,
            unidadeVelocidaedMedia, unidadeTempoGasto, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);            
       
            if (eF != null) {
                
             velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);
             
             double espacoFinal = (eF.getEspacoFinal() / 1);
             
             km4.setText(String.format("%.0f", espacoFinal) + undResultado);
             
             double tempoFinal = (Double.parseDouble(eF.getTempoGasto().getText())) / 1;
            
             
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

                    synchronized (ControleEspacoFinalTelaMovimentoUniforme.this) {
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