/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia;

import br.com.wesley.easyfisica.GUI;
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
public class ControleTempoGastoTelaVelocidadeMedia {
    
     private boolean estaSuspenso = false;
   
  private static Throwable verificaValidadeDosCamposTelaTempoGasto(TempoGastoTelaVelocidadeMedia tempoGasto) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
        
        if (tempoGasto.velocidadeMedia.getText().equals("")) {
            tempoGasto.velocidadeMedia.requestFocus();
            throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Campo Velocidade Média está Vazio");
        } else if (tempoGasto.espacoPercorrido.getText().equals("")) {
            tempoGasto.espacoPercorrido.requestFocus();
            throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Campo Espaço Percorrido está Vazio");
        } else {

            try {

                double velocidadeMedia = Double.parseDouble(tempoGasto.velocidadeMedia.getText());

                if (velocidadeMedia < 0) {
                    tempoGasto.velocidadeMedia.setText("");
                    tempoGasto.velocidadeMedia.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Velocidade Média não pode ser menor que 0");
                }

                if (velocidadeMedia == 0) {
                    tempoGasto.velocidadeMedia.setText("");
                    tempoGasto.velocidadeMedia.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Velocidade Média Não Pode ser = 0");
                }

                try {

                    double espacoPercorrido = Double.parseDouble(tempoGasto.espacoPercorrido.getText());

                    if (espacoPercorrido < 0) {
                        tempoGasto.espacoPercorrido.setText("");
                        tempoGasto.espacoPercorrido.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Espaço Percorrido não pode ser menor que 0");
                    }

                    if (espacoPercorrido == 0) {
                         tempoGasto.espacoPercorrido.setText("");
                         tempoGasto.espacoPercorrido.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Espaço Percorrido não Pode ser = 0");
                    }

                } catch (NumberFormatException e) {
                    tempoGasto.espacoPercorrido.setText("");
                    tempoGasto.espacoPercorrido.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Digite um Espaço Percorrido Válido");
                }

            } catch (NumberFormatException e) {
                tempoGasto.velocidadeMedia.setText("");
                tempoGasto.velocidadeMedia.requestFocus();
                throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Digite uma Velocidade Média Válida");

            }

        }

        return null;
    }
    
    private double calculoTempoGastoKmhKmHr(double velocidadeMedia, double espacoPercorrido, JLabel textoCalculoVelocidaMedia){
         double resultado = espacoPercorrido/velocidadeMedia;
         
         String result = GUI.converteHorasEmMinutos(resultado);
         
         textoCalculoVelocidaMedia.setText(
                             
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " Km" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +          
                 
         "4. ∆T = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", velocidadeMedia) + "<br>" 
          
         + "<font color=\"blue\">5. ∆T = " + String.format("%.2f", resultado) +  " hr" + "<br></font>"
                 
         + "<font color=\"red\">6. ∆T = " + result + "</font></html>"); 
         
         return resultado;
    }
    
     private double calculoTempoGastoKmhKmMin(double velocidadeMedia, double espacoPercorrido, JLabel textoCalculoVelocidaMedia){
         double resultado = espacoPercorrido/velocidadeMedia;  
                 
        String result = GUI.converteHorasEmMinutos(resultado); 
         
         textoCalculoVelocidaMedia.setText(
                         
                                
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " Km" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +                   
         
         "4. ∆T = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", velocidadeMedia) + "<br>" 
                 
          
         + "5.∆T = " + String.format("%.2f", resultado) + "<br>" 
                 
         + "6. Converte Hr para Min: " + String.format("%.2f", resultado) + "*60" + " = " +  String.format("%.2f", resultado*60) +  "<br>"
                                           
         + "<font color=\"blue\">7. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "<br></font>"
                 
         + "<font color=\"red\">8. ∆T = " + result + "</font></html>"); 
         
         
         return resultado * 60;
    }
     
      private double calculoTempoGastoKmhMHr(double velocidadeMedia, double espacoPercorrido, JLabel textoCalculoVelocidaMedia){
         double resultado = (espacoPercorrido / 1000) / velocidadeMedia;
         
         
        String result = GUI.converteHorasEmMinutos(resultado); 
        
          textoCalculoVelocidaMedia.setText(
                  
                                
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " m" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +            
                  
         "4. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) +  "<br>"
         
         + "5.∆T = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", velocidadeMedia) + "<br>" 
                         
         + "<font color=\"blue\">6. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>"
          
          + "<font color=\"red\">7. ∆T = " + result + "</font></html>");
         
         return resultado;
    } 
      
       private double calculoTempoGastoKmhMMin(double velocidadeMedia, double espacoPercorrido, JLabel textoCalculoVelocidaMedia){
         double resultado = (espacoPercorrido / 1000) / velocidadeMedia;        
         
          String result = GUI.converteHorasEmMinutos(resultado); 
         
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " m" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +             
                  
         "4. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) +"<br>"
         
         + "5.∆T = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", velocidadeMedia) + "<br>"
                 
         + "6.∆T = " + String.format("%.2f", resultado)  + "<br>"
                 
        + "7. Converte Hr para Min: " + String.format("%.2f", resultado) + "*60" + " = " +  String.format("%.2f", resultado*60) + "<br>"                 
                         
         + "<font color=\"blue\">8. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>"
          
          + "<font color=\"red\">9. ∆T = " + result + "</font></html>");
         
         return resultado * 60;
    } 
      
       private double calculoTempoGastoMsKmHr(double velocidadeMedia, double espacoPercorrido, JLabel textoCalculoVelocidaMedia){
         double resultado = espacoPercorrido / (velocidadeMedia * 3.6) ;
         
        String result = GUI.converteHorasEmMinutos(resultado); 
         
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " Km" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +            
                 
          "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) +  "<br>"
                 
         + "5. ∆T = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>" 
                 
         + "<font color=\"blue\">6. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>" 
         
          + "<font color=\"red\">7. ∆T = " + result + "</font></html>");
         
         return resultado;
    } 
    
      private double calculoTempoGastoMsKmMin(double velocidadeMedia, double espacoPercorrido, JLabel textoCalculoVelocidaMedia){
         double resultado = espacoPercorrido / (velocidadeMedia * 3.6) ;
         
         String result = GUI.converteHorasEmMinutos(resultado); 
         
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " Km" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +  
                 
          "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                 
         + "5. ∆T = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                 
          + "6.∆T = " + String.format("%.2f", resultado) + "<br>"
                 
         + "7. Converte Hr para Min: " + String.format("%.2f", resultado) + "*60" + " = " +  String.format("%.2f", resultado*60) + "<br>"    
                 
         + "<font color=\"blue\">8. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>" 
         
          + "<font color=\"red\">9. ∆T = " + result + "</font></html>");
         
         return resultado * 60 ;
    } 
      
     private double calculoTempoGastoMsMHr(double velocidadeMedia, double espacoPercorrido, JLabel  textoCalculoVelocidaMedia, JComboBox unidadeResultadoTelaVelocidadeMedia){
         double resultado = (espacoPercorrido / 1000) / (velocidadeMedia * 3.6) ;
         
         String result = GUI.converteHorasEmMinutos(resultado); 
         
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " m" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +  
                 
          "4 Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                  
         + "5. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) + "<br>"     
                 
         + "6. ∆T = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"  
                 
         + "<font color=\"blue\">7. ∆T = " + String.format("%.2f", resultado) +  " hr" + "</font><br>" 
         
          + "<font color=\"red\">8. ∆T = " + result + "</font></html>");
         
         return resultado ;
    } 
    
      
     private double calculoTempoGastoMsMMin(double velocidadeMedia, double espacoPercorrido, JLabel  textoCalculoVelocidaMedia){
         double resultado = (espacoPercorrido / 1000) / (velocidadeMedia * 3.6) ;
         
           String result = GUI.converteHorasEmMinutos(resultado); 
         
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆S = " + espacoPercorrido + " m" + "<br>" +    
                
        "3. ∆T = ∆V / ∆S " + "<br>" +  
                 
          "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                  
         + "5. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) + "<br>"     
                 
         + "6. ∆T = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                 
          + "7.∆T = " + String.format("%.2f", resultado) + "<br>"
         
         + "8. Converte Hr para Min: " + String.format("%.2f", resultado) + "*60" + " = " +  String.format("%.2f", resultado*60) + "<br>"   
                 
         + "<font color=\"blue\">9. ∆T = " + String.format("%.2f", resultado*60) +  " min" + "</font><br>" 
         
          + "<font color=\"red\">10. ∆T = " + result + "</font></html>");
         
         return resultado * 60 ;
    } 
    
    public TempoGastoTelaVelocidadeMedia calculoTempoGasto(TempoGastoTelaVelocidadeMedia tempoGasto,JComboBox unidadeVelocidadeMediaTelaVelocidadeMedia,
    JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia, JComboBox unidadeResultadoTelaVelocidadeMedia,
    JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel textoCalculoVelocidaMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {

        
        if(verificaValidadeDosCamposTelaTempoGasto(tempoGasto)==null){
            
            double velocidadeMedia = Double.parseDouble(tempoGasto.velocidadeMedia.getText());

            double espacoPercorrido = Double.parseDouble(tempoGasto.espacoPercorrido.getText());


            if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoKmhKmHr(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                
                if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

           if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoKmhKmMin(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

              if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoKmhMHr(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
              
               if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoKmhMMin(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
               
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
              


            if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoMsKmHr(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }
              
              if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoMsKmMin(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            } 

              if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){

                double resultado = calculoTempoGastoMsMHr(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia, unidadeResultadoTelaVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
               
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
                tempoGasto.setTempoGasto(resultado);
                return tempoGasto;
            }

              
              if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){

                double resultado = calculoTempoGastoMsMMin(velocidadeMedia, espacoPercorrido, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                
                 if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
                    String result = GUI.converteHorasEmMinutos(resultado);

                    campoTextoResultadoTelaVelocidadeMedia.setText(result);
                    
                }else{                    
                   campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " min");
                }
                
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
       
    
    public void informacoesParaMovimentarCarrinho(TempoGastoTelaVelocidadeMedia tempoGasto, JTextField campoVelocidadeMedia, JTextField campoEspacoPercorridp, JComboBox unidadeVelocidadeMedia,
       JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia, JComboBox unidadeResultadoTelaVelocidadeMedia , JTextField campoTextoResultadoTelaVelocidadeMedia,
       JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2, JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel textoCalculoVelocidaMedia, JButton btLimparTelaVelcMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException {
              
            
        if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
      
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1,  t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2,  t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4,  t4, textoCalculoVelocidaMedia);
           
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);
            
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);  
            
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
           
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
           
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"Km/h", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);
        
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);
       
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Min")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "Km", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);
          
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Hr")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "hr",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);
        
        }else{
            
            imprimiKm1T1(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculoVelocidaMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculoVelocidaMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculoVelocidaMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoEspacoPercorridp,"m/s", "m", "min",unidadeVelocidadeMedia,
            unidadeEspacoPercorridoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculoVelocidaMedia);
        }        
        
        
            
          if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")){    
           
                if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())<=100){
                    moverCarrinho(velocidade,carrinho, 8, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 100 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <=200){
                    moverCarrinho(velocidade,carrinho, 6, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 200 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 300){
                    moverCarrinho(velocidade,carrinho,4, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 300 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 500){
                    moverCarrinho(velocidade,carrinho,  2, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 500 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5, btLimparTelaVelcMedia);
                }

          }else{
             
              if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())<=30.56){
                  moverCarrinho(velocidade,carrinho,  8, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 30.56 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <=55.56){
                  moverCarrinho(velocidade,carrinho, 6, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 55.56 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 83.33 && Double.parseDouble(tempoGasto.getVelocidadeMedia().getText())<= 125){
                  moverCarrinho(velocidade,carrinho, 2, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 125 &&Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(tempoGasto.getVelocidadeMedia().getText()) > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5, btLimparTelaVelcMedia);           
              }
          }    
    }
 
    
    private void imprimiKm1T1(JTextField campoVelocidadeMedia, JTextField campoEspacoPercorrido, String undVelocidadeMedia,String undEspaco,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeEspacoPercorrido,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km1, JLabel t1, JLabel textoCalculoVelocidaMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
      
        
        TempoGastoTelaVelocidadeMedia dadosDosCamposTempoGasto = new TempoGastoTelaVelocidadeMedia(campoVelocidadeMedia, campoEspacoPercorrido);
        
        try {
        
            TempoGastoTelaVelocidadeMedia tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeVelocidadeMedia, unidadeEspacoPercorrido,
            unidadeResultadoTelaVelocidadeMedia, campoTextoResultadoTelaVelocidadeMedia, textoCalculoVelocidaMedia);
           
            
           if(tG!=null){
              
               velocidade.setText(campoVelocidadeMedia.getText() + " " + undVelocidadeMedia);
               km1.setText("0 " + undEspaco);
               t1.setText("0 " + undResultado);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (VelocidadeMediaExeptionTelaVelocidadeMedia ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
    private void imprimiKm2T2(JTextField campoVelocidadeMedia, JTextField campoEspacoPercorrido, String undVelocidadeMedia,String undEspaco,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeEspacoPercorrido,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km2, JLabel t2, JLabel textoCalculoVelocidaMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
      
        
        TempoGastoTelaVelocidadeMedia dadosDosCamposTempoGasto = new TempoGastoTelaVelocidadeMedia(campoVelocidadeMedia, campoEspacoPercorrido);
        
        try {
        
            TempoGastoTelaVelocidadeMedia tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeVelocidadeMedia, unidadeEspacoPercorrido,
             unidadeResultadoTelaVelocidadeMedia, campoTextoResultadoTelaVelocidadeMedia, textoCalculoVelocidaMedia);
                       
           if(tG!=null){
              
                double espacoFinal = Double.parseDouble(tG.getEspacoPercorrido().getText()) / 3;                
             
                km2.setText(String.format("%.0f",espacoFinal) + undEspaco);
               
                double tempoFinal = tG.getTempoGasto() / 3;
                
                if(undResultado.equals("min")){        
                    t2.setText(String.format("%.1f", tempoFinal) + undResultado);
                }else{
                   
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t2.setText(resultado);
                }     

            } else {
                JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (VelocidadeMediaExeptionTelaVelocidadeMedia ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
       
              
    }
    
   private void imprimiKm3T3(JTextField campoVelocidadeMedia, JTextField campoEspacoPercorrido, String undVelocidadeMedia,String undEspaco,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeEspacoPercorrido,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km3, JLabel t3, JLabel textoCalculoVelocidaMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
      
        
        TempoGastoTelaVelocidadeMedia dadosDosCamposTempoGasto = new TempoGastoTelaVelocidadeMedia(campoVelocidadeMedia, campoEspacoPercorrido);
          
            TempoGastoTelaVelocidadeMedia tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeVelocidadeMedia, unidadeEspacoPercorrido,
             unidadeResultadoTelaVelocidadeMedia, campoTextoResultadoTelaVelocidadeMedia, textoCalculoVelocidaMedia);
           
            
           if(tG!=null){
             
               double espacoFinal = ((Double.parseDouble(tG.getEspacoPercorrido().getText()) / 3)) * 2 ;
             
             km3.setText(String.format("%.0f", espacoFinal) + undEspaco);
             
             double tempoFinal = ( tG.getTempoGasto() / 3) * 2;
             
             if(undResultado.equals("min")){        
                    t3.setText(String.format("%.1f", tempoFinal) + undResultado);
                }else{
                  
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t3.setText(resultado);
                }    
             
             
         } else {
             JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
    }    
    
   
   private void imprimiKm4T4(JTextField campoVelocidadeMedia, JTextField campoEspacoPercorrido, String undVelocidadeMedia,String undEspaco,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeEspacoPercorrido,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km4, JLabel t4, JLabel textoCalculoVelocidaMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
      
        
        TempoGastoTelaVelocidadeMedia dadosDosCamposTempoGasto = new TempoGastoTelaVelocidadeMedia(campoVelocidadeMedia, campoEspacoPercorrido);
          
            TempoGastoTelaVelocidadeMedia tG = calculoTempoGasto(dadosDosCamposTempoGasto, unidadeVelocidadeMedia, unidadeEspacoPercorrido,
             unidadeResultadoTelaVelocidadeMedia, campoTextoResultadoTelaVelocidadeMedia, textoCalculoVelocidaMedia);
           
            
           if(tG!=null){
               
               double espacoFinal = (Double.parseDouble(tG.getEspacoPercorrido().getText()) / 1) ;
             
             km4.setText(String.format("%.0f", espacoFinal) + undEspaco);
             
             double tempoFinal = (tG.getTempoGasto() / 1);
            
             if(undResultado.equals("min")){        
                    t4.setText(String.format("%.1f", tempoFinal) + undResultado);
                }else{
                    
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t4.setText(resultado);
                }  
             
         } else {
             JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
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
   
    
    private void moverCarrinho(JLabel velocidade, JLabel carrinho, long valorVelocidade, JButton btLimparTelaVelcMedia) throws InterruptedException, MalformedURLException, LineUnavailableException, LineUnavailableException, UnsupportedAudioFileException, IOException {
             
        moverTextoVelocidade(velocidade, valorVelocidade);          
        
        Runnable r = () -> {
            int posicaoInicial = carrinho.getLocation().x;
            int x = carrinho.getLocation().x;
            int y = carrinho.getLocation().y;
            
            while (true) {
                 btLimparTelaVelcMedia.setEnabled(false);
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
             btLimparTelaVelcMedia.setEnabled(true);
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

                    synchronized (ControleTempoGastoTelaVelocidadeMedia.this) {
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
