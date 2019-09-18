/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ControleTempoGastoTelaMovimentoUniforme {
    
    
        
  private boolean estaSuspenso = false;
   
  private static Throwable verificaValidadeDosCamposTelaTempoGasto(TempoGastoTelaMovimentoUniforme tempoGasto) throws EspacoFinalExeptionTelaMovimentoUniforme {
        
        if (tempoGasto.espacoInicial.getText().equals("")) {
            tempoGasto.espacoInicial.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Espaço Inicial está Vazio");
        } else if (tempoGasto.espacoFinal.getText().equals("")) {
            tempoGasto.espacoFinal.requestFocus();
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Espaço Final está Vazio");
        }else if (tempoGasto.velocidadeMedia.getText().equals("")){
            tempoGasto.velocidadeMedia.requestFocus();            
            throw new EspacoFinalExeptionTelaMovimentoUniforme("Campo Velocidade Média está Vazio");
        }else {

            try {

                double espacoInicial = Double.parseDouble(tempoGasto.espacoInicial.getText());

                if (espacoInicial  < 0) {
                    tempoGasto.espacoInicial.setText("");
                    tempoGasto.espacoInicial.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Inicial não pode ser menor que 0");
                }

                if (espacoInicial == 0) {
                     tempoGasto.espacoInicial.setText("");
                    tempoGasto.espacoInicial.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Inicial não pode ser = 0");
                }

                try {

                    double espacoFinal = Double.parseDouble(tempoGasto.espacoFinal.getText());

                   if (espacoFinal  < 0) {
                       tempoGasto.espacoFinal.setText("");
                       tempoGasto.espacoFinal.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Final não pode ser menor que 0");
                   }

                   if (espacoFinal == 0) {
                      tempoGasto.espacoFinal.setText("");
                      tempoGasto.espacoFinal.requestFocus();
                       throw new EspacoFinalExeptionTelaMovimentoUniforme("Espaço Final não pode ser = 0");
                   }
                   
                   try {

                        double velocidadeMedia = Double.parseDouble(tempoGasto.velocidadeMedia.getText());

                       if (velocidadeMedia  < 0) {
                           tempoGasto.velocidadeMedia.setText("");
                           tempoGasto.velocidadeMedia.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Tempo gasto não pode ser menor que 0");
                       }

                       if (velocidadeMedia == 0) {
                          tempoGasto.velocidadeMedia.setText("");
                          tempoGasto.velocidadeMedia.requestFocus();
                           throw new EspacoFinalExeptionTelaMovimentoUniforme("Velocidade Média não pode ser = 0");
                       }

                    } catch (NumberFormatException e) {
                        tempoGasto.velocidadeMedia.setText("");
                        tempoGasto.velocidadeMedia.requestFocus();
                        throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite uma Velocidade Média Válida");
                    }

                } catch (NumberFormatException e) {
                    tempoGasto.espacoFinal.setText("");
                    tempoGasto.espacoFinal.requestFocus();
                    throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Espaço Final Válido");
                }

            } catch (NumberFormatException e) {
                tempoGasto.espacoInicial.setText("");
                tempoGasto.espacoInicial.requestFocus();
                throw new EspacoFinalExeptionTelaMovimentoUniforme("Digite um Espaço Inicial Válido");

            }

        }

        return null;
    }
    
    private double calculoTempoGastoKmKmKmhHr(double espacoInicial, double espacoFinal, double velocidadeMedia,
    JLabel textoCalculosTelaMovimentoUniforme){
        
        double resultado =  (espacoFinal - espacoInicial) / velocidadeMedia;
        
        String result = GUI.converteHorasEmMinutos(resultado);
         
        textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
        "<font color=\"blue\">7. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">8. ∆T = " + result + "</font></html>");   
                 
        return resultado;         
    }
    
    
    
    private double calculoTempoGastoKmKmKmhMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / velocidadeMedia;
         
          String result = GUI.converteHorasEmMinutos(resultado);
         
         textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                                  
        "5. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
         "7. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
         "<html>8. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">9. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">10. ∆T = " + result + "</font></html>");  
         
         return resultado * 60;
    }
    
    
    private double calculoTempoGastoKmKmMsHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / (velocidadeMedia*3.6);  
         
         
          
        String result = GUI.converteHorasEmMinutos(resultado);
         
        textoCalculosTelaMovimentoUniforme.setText(
          
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                
         "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+          
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
        "<font color=\"blue\">8. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">9. ∆T = " + result + "</font></html>"); 
         
         
         return resultado;
    }
      
      
     
    private double calculoTempoGastoKmKmMsMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - espacoInicial) / (velocidadeMedia*3.6);    
         
          String result = GUI.converteHorasEmMinutos(resultado);
         
         textoCalculosTelaMovimentoUniforme.setText(
          
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                
         "5. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+          
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
       "8. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
        "<html>9. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">10. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">11. ∆T = " + result + "</font></html>");  
         
         
         
         return resultado*60;
    }
          
      
   private double calculoTempoGastoKmMKmhHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / velocidadeMedia; 
         
           String result = GUI.converteHorasEmMinutos(resultado);
         
        textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "7. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
        "<font color=\"blue\">8. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">9. ∆T = " + result + "</font></html>");   
         
         return resultado;
    }
      
      
    private double calculoTempoGastoKmMKmhMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / velocidadeMedia;    
         
           String result = GUI.converteHorasEmMinutos(resultado);
         
          textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "7. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
        "8. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
        "<html>9. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">10. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">11. ∆T = " + result + "</font></html>");  
                 
         
         return resultado * 60 ;
    }
      
     
   private double calculoTempoGastoKmMMsHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / (velocidadeMedia*3.6);       
         
           String result = GUI.converteHorasEmMinutos(resultado);
         
          textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                
        "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+    
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "8. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
         "<font color=\"blue\">9. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">10. ∆T = " + result + "</font></html>");  
         
         return resultado;
    }
    
    
  
   private double calculoTempoGastoKmMMsMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - espacoInicial) / (velocidadeMedia*3.6); 
         
          String result = GUI.converteHorasEmMinutos(resultado);
         
           textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " Km" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                
        "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+    
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "8. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-espacoInicial) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
          "9. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
        "<html>10. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">11. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">12. ∆T = " + result + "</font></html>"); 
         
         return resultado * 60;
    }
  
     private double calculoTempoGastoMKmKmhHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / velocidadeMedia;
         
         String result = GUI.converteHorasEmMinutos(resultado);
         
        textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +           
                 
        "6. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "7. ∆T = (" + String.format("%.2f", (espacoFinal)-(espacoInicial / 1000)) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
        "<font color=\"blue\">8. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">9. ∆T = " + result + "</font></html>");   
         
         return resultado;
         
    }
    
     
    private double calculoTempoGastoMKmKmhMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / velocidadeMedia;  
         
         String result = GUI.converteHorasEmMinutos(resultado);
         
         textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +           
                                  
        "6. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "7. ∆T = (" + String.format("%.2f", (espacoFinal)-espacoInicial / 1000) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
         "8. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
         "<html>9. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">10. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">11. ∆T = " + result + "</font></html>");  
         
         return resultado * 60;
    }
    
    
    private double calculoTempoGastoMKmMsHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / (velocidadeMedia*3.6); 
         
         String result = GUI.converteHorasEmMinutos(resultado);
         
        textoCalculosTelaMovimentoUniforme.setText(
          
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
         "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +          
                
         "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+          
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "8. ∆T = (" + String.format("%.2f", (espacoFinal)-espacoInicial / 1000) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
        "<font color=\"blue\">9. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">10. ∆T = " + result + "</font></html>"); 
         
         
         return resultado;
    }
      
      
     
    private double calculoTempoGastoMKmMsMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  (espacoFinal - (espacoInicial/1000)) / (velocidadeMedia*3.6); 
         
         
          String result = GUI.converteHorasEmMinutos(resultado);
         
         textoCalculosTelaMovimentoUniforme.setText(
          
         "<html>1. S = " + espacoFinal + " Km" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
          "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +             
                
         "6. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+          
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "8. ∆T = (" + String.format("%.2f", (espacoFinal)-espacoInicial / 1000) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
       "9. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
        "<html>10. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">11. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">12. ∆T = " + result + "</font></html>");  
         
         
         
         return resultado*60;
    }
         
      
   private double calculoTempoGastoMMKmhHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / velocidadeMedia; 
         
         String result = GUI.converteHorasEmMinutos(resultado);
         
        textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +                             
                 
        "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "8. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-(espacoInicial / 1000)) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
        "<font color=\"blue\">9. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">10. ∆T = " + result + "</font></html>");   
         
         return resultado;
    }
      
      
    private double calculoTempoGastoMMKmhMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / velocidadeMedia;  
         
         
         
           String result = GUI.converteHorasEmMinutos(resultado);
         
          textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " Km/h" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
          "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +           
                 
        "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                 
        "7. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia) + "<br>" +
                 
        "8. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-(espacoInicial / 1000)) + ") / " + String.format("%.2f", velocidadeMedia) + "<br>"+
          
        "9. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
        "<html>10. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">11. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">12. ∆T = " + result + "</font></html>");  
         
         
         return resultado * 60 ;
    }
      
     
   private double calculoTempoGastoMMMsHr(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / (velocidadeMedia*3.6); 
         
         String result = GUI.converteHorasEmMinutos(resultado);
         
          textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
        "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +               
                 
        "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                
        "7. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+    
                 
        "8. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "9. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-(espacoInicial / 1000)) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
         "<font color=\"blue\">10. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"+
        
        "<font color=\"red\">11. ∆T = " + result + "</font></html>");  
         
         return resultado;
    }
    
    
  
   private double calculoTempoGastoMMMsMin(double espacoInicial, double espacoFinal, double velocidadeMedia, JLabel textoCalculosTelaMovimentoUniforme){
         double resultado =  ((espacoFinal/1000) - (espacoInicial/1000)) / (velocidadeMedia*3.6);   
         
          String result = GUI.converteHorasEmMinutos(resultado);
         
           textoCalculosTelaMovimentoUniforme.setText(
          
        "<html>1. S = " + espacoFinal + " m" + "<br>" +
         
         "2.So = " + espacoInicial + " m" + "<br>" +
                 
         "3.∆V = " + velocidadeMedia +  " m/s" + "<br>" +
                
        "4. ∆T = (S - So) / ∆V " + "<br>" +
                 
          "5. Converte m em Km: " + String.format("%.2f", espacoInicial) + " / 1000" + " = " +  String.format("%.2f", espacoInicial / 1000)+  "<br>" +           
                 
        "6. Converte m em Km: " + String.format("%.2f", espacoFinal) + " / 1000" + " = " +  String.format("%.2f", espacoFinal / 1000)+  "<br>" +                    
                
        "7. Converte m/s em Km/h: " + String.format("%.2f", velocidadeMedia) + " * 3.6" + " = " +  String.format("%.2f", (velocidadeMedia*3.6))+  "<br>"+    
                 
        "8. ∆T = (" + String.format("%.2f", espacoFinal / 1000) + " - " + String.format("%.2f", espacoInicial / 1000) + 
        ") / "  + String.format("%.2f", velocidadeMedia*3.6) + "<br>" +
                 
        "9. ∆T = (" + String.format("%.2f", (espacoFinal / 1000)-(espacoInicial / 1000)) + ") / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"+
          
          "10. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br>"+
        
        "<html>11. Converte hr em min: " + String.format("%.2f", resultado) + " * 60" +  " = " +  String.format("%.2f", resultado*60) + "<br>" +          
          
        "<font color=\"blue\">12. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"+
        
        "<font color=\"red\">13. ∆T = " + result + "</font></html>"); 
         
         
         
         return resultado * 60;
    }
   
      
    
    
    public TempoGastoTelaMovimentoUniforme calculoTempoGasto(TempoGastoTelaMovimentoUniforme tempoGasto,JComboBox unidadeEspacoInicial,
    JComboBox unidadeEspacoFinal, JComboBox unidadeVelocidadeMedia,JComboBox unidadeResultado,
    JTextField campoTextoResultado, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme{

        
        if(verificaValidadeDosCamposTelaTempoGasto(tempoGasto)==null){
            
            double espacoInicial = Double.parseDouble(tempoGasto.espacoInicial.getText());

            double espacoFinal = Double.parseDouble(tempoGasto.espacoFinal.getText());
            
            double velocidadeMedia = Double.parseDouble(tempoGasto.velocidadeMedia.getText());


            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoKmKmKmhHr(espacoInicial, espacoFinal, velocidadeMedia,
                textoCalculosTelaMovimentoUniforme);
                
                String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

           if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoKmKmKmhMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }


            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoKmKmMsHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }


            
            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoKmKmMsMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
            
         if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoKmMKmhHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
            

           if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoKmMKmhMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoKmMMsHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
               String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("Km") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoKmMMsMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
                
             }
             
                             
            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoMKmKmhHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
               String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

           if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoMKmKmhMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }


            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoMKmMsHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
               String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }


            
            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("Km")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoMKmMsMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
            
         if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoMMKmhHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
            

           if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoMMKmhMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

            if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoMMMsHr(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String result = GUI.converteHorasEmMinutos(resultado);
                campoTextoResultado.setText(result);
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
            
             if(unidadeEspacoInicial.getSelectedItem().equals("M") && unidadeEspacoFinal.getSelectedItem().equals("M")
            && unidadeVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeResultado.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoMMMsMin(espacoInicial, espacoFinal, velocidadeMedia, textoCalculosTelaMovimentoUniforme);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultado.setText(resultadoFinal + " min");
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
                
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
       
    
    public void informacoesParaMovimentarCarrinho(TempoGastoTelaMovimentoUniforme tempoGasto, JTextField campoEspacoInicial, JTextField campoEspacoFinal,
       JTextField campoVelocidadeMedia, JComboBox unidadeEspacoInicial,JComboBox unidadeEspacoFinal,JComboBox unidadeVelocidadeMedia,
       JComboBox unidadeResultado , JTextField campoTextoResultado, JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2,
       JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel textoCalculosTelaMovimentoUniforme, JButton btLimparTelaMovUniforme) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException,
       LineUnavailableException, UnsupportedAudioFileException, IOException, EspacoFinalExeptionTelaMovimentoUniforme {
              
            
        if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("Km")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "Km", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }        
        
        //-------------------------------------------------------------------------------------------------
                
             
        if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
           
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
            
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("Km")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "Km", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
       
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "Km/h", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Hr")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "hr",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
          
        
        }else if(unidadeEspacoInicial.getSelectedItem().equals("M")
        && unidadeEspacoFinal.getSelectedItem().equals("M")
        && unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeResultado.getSelectedItem().equals("Min")){          
            
            imprimiKm1T1(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km1,  t1, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm2T2(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km2,  t2, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm3T3(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km3,  t3, textoCalculosTelaMovimentoUniforme);
            
            imprimiKm4T4(campoEspacoInicial, campoEspacoFinal, campoVelocidadeMedia, "m", "m", "m/s", "min",unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia , unidadeResultado,campoTextoResultado, velocidade, km4,  t4, textoCalculosTelaMovimentoUniforme);
        }  
        
            
          if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")){    
              
                if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())<=100){
                    moverCarrinho(velocidade,carrinho, 8, btLimparTelaMovUniforme);                   
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 100 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <=200){
                    moverCarrinho(velocidade,carrinho, 6, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 200 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 300){
                    moverCarrinho(velocidade,carrinho, 4, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 300 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 500){
                    moverCarrinho(velocidade,carrinho,  2, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())> 500 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaMovUniforme);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5,btLimparTelaMovUniforme);
                }

          }else{
             
              if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())<=30.56){
                  moverCarrinho(velocidade,carrinho,  8, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 30.56 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <=55.56){
                  moverCarrinho(velocidade,carrinho, 6, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 55.56 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 83.33 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())<= 125){
                  moverCarrinho(velocidade,carrinho, 2, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())> 125 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1, btLimparTelaMovUniforme);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5, btLimparTelaMovUniforme);           
              }
          }    
    }
 
    
    private void imprimiKm1T1(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoVelocidadeMedia,
       String undEspacoInicial,String undEspacoFinal,String undVelocidadeMedia, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeVelocidadeMedia,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km1, JLabel t1, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       TempoGastoTelaMovimentoUniforme dadosDosCamposTempoGasto = new TempoGastoTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoVelocidadeMedia);
        
        try {
                        
            TempoGastoTelaMovimentoUniforme tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);           
            
           if(tG!=null){
               velocidade.setText(campoVelocidadeMedia.getText() + " " + undVelocidadeMedia);
               km1.setText("0 " + undEspacoFinal);
               t1.setText("0 " + undResultado);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (EspacoFinalExeptionTelaMovimentoUniforme ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
     
   private void imprimiKm2T2(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoVelocidadeMedia,
       String undEspacoInicial,String undEspacoFinal,String undVelocidadeMedia, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeVelocidadeMedia,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km2, JLabel t2, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       TempoGastoTelaMovimentoUniforme dadosDosCamposTempoGasto = new TempoGastoTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoVelocidadeMedia);
        
        try {
                        
            TempoGastoTelaMovimentoUniforme tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia, unidadeResultado, campoTextoResultado,textoCalculosTelaMovimentoUniforme);           
            
           if(tG!=null){
               velocidade.setText(campoVelocidadeMedia.getText()+ " " + undVelocidadeMedia);

                double espacoFinal = Double.parseDouble(tG.espacoFinal.getText())/ 3;                
               
                km2.setText(String.format("%.0f",espacoFinal) + undEspacoFinal);

                double tempoFinal = (tG.tempoGasto) / 3;
                
                
                if(undResultado.equals("min")){        
                    t2.setText(String.format("%.1f", tempoFinal) + undResultado);
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
    
  private void imprimiKm3T3(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoVelocidadeMedia,
       String undEspacoInicial,String undEspacoFinal,String undVelocidadeMedia, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeVelocidadeMedia,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km3, JLabel t3, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       TempoGastoTelaMovimentoUniforme dadosDosCamposTempoGasto = new TempoGastoTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoVelocidadeMedia);
        
        try {
                        
            TempoGastoTelaMovimentoUniforme tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);           
            
           if(tG!=null){
               velocidade.setText(campoVelocidadeMedia.getText()+ " " + undVelocidadeMedia);
             
             double espacoFinal = ((Double.parseDouble(tG.espacoFinal.getText())/ 3)) * 2 ;
             
             km3.setText(String.format("%.0f", espacoFinal) + undEspacoFinal);
             
             double tempoFinal = (tG.tempoGasto / 3) * 2;
            
             
             if(undResultado.equals("min")){        
                    t3.setText(String.format("%.1f", tempoFinal) + undResultado);
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
    
    
  private void imprimiKm4T4(JTextField campoEspacoInicial,JTextField campoEspacoFinal, JTextField campoVelocidadeMedia,
       String undEspacoInicial,String undEspacoFinal,String undVelocidadeMedia, String undResultado , JComboBox unidadeEspacoInicial,
       JComboBox unidadeEspacoFinal,JComboBox unidadeVelocidadeMedia,JComboBox unidadeResultado, JTextField campoTextoResultado,
       JLabel velocidade, JLabel km4, JLabel t4, JLabel textoCalculosTelaMovimentoUniforme) throws EspacoFinalExeptionTelaMovimentoUniforme {
               
       TempoGastoTelaMovimentoUniforme dadosDosCamposTempoGasto = new TempoGastoTelaMovimentoUniforme(campoEspacoInicial,campoEspacoFinal, campoVelocidadeMedia);
        
        try {
                        
            TempoGastoTelaMovimentoUniforme tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeEspacoInicial,
            unidadeEspacoFinal, unidadeVelocidadeMedia, unidadeResultado, campoTextoResultado, textoCalculosTelaMovimentoUniforme);           
            
           if(tG!=null){
               velocidade.setText(campoVelocidadeMedia.getText()+ " " + undVelocidadeMedia);
             
             double espacoInicial = (Double.parseDouble(tG.getEspacoFinal().getText()) / 1);
             
             km4.setText(String.format("%.0f", espacoInicial) + undEspacoFinal);
             
             double tempoFinal = (tG.tempoGasto) / 1;
             
             if(undResultado.equals("min")){        
                    t4.setText(String.format("%.1f", tempoFinal) + undResultado);
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

                    synchronized (ControleTempoGastoTelaMovimentoUniforme.this) {
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
