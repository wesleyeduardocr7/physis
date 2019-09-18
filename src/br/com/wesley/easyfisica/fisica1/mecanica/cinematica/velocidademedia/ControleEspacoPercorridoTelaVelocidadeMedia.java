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
public class ControleEspacoPercorridoTelaVelocidadeMedia {
    
  private boolean estaSuspenso = false;
   
  private static Throwable verificaValidadeDosCamposTelaEspacoPercorrido(EspacoPercorridoTelaVelocidadeMedia espacoPercorrido) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
        
   
      
        if (espacoPercorrido.velocidadeMedia.getText().equals("")) {
            espacoPercorrido.velocidadeMedia.requestFocus();
            throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Campo Velocidade Média está Vazio");
        } else if (espacoPercorrido.tempoGasto.getText().equals("")) {
            espacoPercorrido.tempoGasto.requestFocus();
            throw new VelocidadeMediaExeptionTelaVelocidadeMedia("CampoTempo Gasto está Vazio");
        } else {

            try {

                double velocidadeMedia = Double.parseDouble(espacoPercorrido.velocidadeMedia.getText());

                if (velocidadeMedia < 0) {
                    espacoPercorrido.velocidadeMedia.setText("");
                    espacoPercorrido.velocidadeMedia.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Velocidade Média não pode ser menor que 0");
                }

                if (velocidadeMedia == 0) {
                    espacoPercorrido.velocidadeMedia.setText("");
                    espacoPercorrido.velocidadeMedia.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Velocidade Média Não Pode ser = 0");
                }

                try {

                    double tempoGasto = Double.parseDouble(espacoPercorrido.tempoGasto.getText());

                    if (tempoGasto < 0) {
                        espacoPercorrido.tempoGasto.setText("");
                        espacoPercorrido.tempoGasto.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Tempo gasto não pode ser menor que 0");
                    }

                    if (tempoGasto == 0) {
                        espacoPercorrido.tempoGasto.setText("");
                        espacoPercorrido.tempoGasto.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Tempo gasto não Pode ser = 0");
                    }

                } catch (NumberFormatException e) {
                    espacoPercorrido.tempoGasto.setText("");
                    espacoPercorrido.tempoGasto.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Digite um Tempo Gasto Válido");
                }

            } catch (NumberFormatException e) {
                espacoPercorrido.velocidadeMedia.setText("");
                espacoPercorrido.velocidadeMedia.requestFocus();
                throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Digite um Espaço Percorrido Válido");

            }

        }

        return null;
    }
    
    private double calculoEspacoPercorridoKmhHrKm(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = velocidadeMedia * tempoGasto;    
         
         textoCalculoVelocidaMedia.setText(
                 
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +                        
                 
         "4. ∆S = " + String.format("%.2f", velocidadeMedia) + " * " + String.format("%.2f", tempoGasto) + "<br>" 
                 
         + "<font color=\"blue\">5. ∆S = " + String.format("%.2f", resultado) +  " Km" + "</font></html>");  
         
         return resultado;
    }
    
    private double calculoEspacoPercorridoKmhHrM(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = velocidadeMedia * tempoGasto; 
         
         textoCalculoVelocidaMedia.setText(
                 
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +          
                  
         "4. ∆S = " + String.format("%.2f", velocidadeMedia) + " * " + String.format("%.2f", tempoGasto) + "<br>"
         
         + "5. ∆S = " + String.format("%.2f", resultado) +  " <br>"
                 
        + "6. Converte Km para m: " + String.format("%.2f", resultado) + "*1000" + " = " +  String.format("%.2f", resultado*1000) + "<br>"
                  
         + "<font color=\"blue\">7. ∆S = " + String.format("%.2f", resultado*1000) + "m<br></font></html>");  
         
         return resultado * 1000;
    }
     
    private double calculoEspacoPercorridoKmhMinKm(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = velocidadeMedia * ( tempoGasto / 60 );
         
         textoCalculoVelocidaMedia.setText(
                 
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆T = " + tempoGasto + " min" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +          
                 
          "4. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"        
                  
         +"5. ∆S = " + String.format("%.2f", velocidadeMedia) + " * " + String.format("%.2f", tempoGasto/60) + "<br>"       
                  
         + "<font color=\"blue\">6. ∆S = " + String.format("%.2f", resultado) + " Km<br></font></html>"); 
         
         return resultado;
    }
      
      
    private double calculoEspacoPercorridoKmhMinM(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
        double resultado = velocidadeMedia * ( tempoGasto / 60 );
        
        textoCalculoVelocidaMedia.setText(
                
          "<html>1. ∆V = " + velocidadeMedia + " Km/h" + "<br>" +
         
         "2.∆T = " + tempoGasto + " min" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +        
                 
          "4 Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60"+ " = " +  String.format("%.2f", tempoGasto/60) +"<br>"        
                  
         +"5. ∆S = " + String.format("%.2f", velocidadeMedia) + " * " + String.format("%.2f", tempoGasto/60) + "<br>" 
                 
          +"6. ∆S = " + String.format("%.2f", resultado) + "<br>"        
         
         + "7. Converte Km para m: " + String.format("%.2f", resultado) + "*1000" + " = " +  String.format("%.2f", resultado*1000) +  "<br>"
                 
         + "<font color=\"blue\">8. ∆S = " + String.format("%.2f", resultado*1000) + " m<br></font></html>"); 
        
         return resultado * 1000;
    }
      
    private double calculoEspacoPercorridoMsHrKm(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
        double resultado = (velocidadeMedia * 3.6) * tempoGasto;
        
        textoCalculoVelocidaMedia.setText(
                
          "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +        
                 
          "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) +  "<br>"        
                  
         +"5. ∆S = " + String.format("%.2f", velocidadeMedia*3.6) + " * " + String.format("%.2f", tempoGasto) + "<br>" 
                 
         + "<font color=\"blue\">6. ∆S = " + String.format("%.2f", resultado) + " Km<br></font></html>");
        
         return resultado;
    }
    
     private double calculoEspacoPercorridoMsHrM(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
        double resultado = (velocidadeMedia * 3.6) * tempoGasto;
        
         textoCalculoVelocidaMedia.setText(
                 
          "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +          
                 
          "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) + "<br>"        
                  
         +"5. ∆S = " + String.format("%.2f", velocidadeMedia*3.6) + " * " + String.format("%.2f", tempoGasto) + "<br>"
                 
          +"6. ∆S = " + String.format("%.2f", resultado) + "<br>"       
                 
          + "7. Converte Km para m: " + String.format("%.2f", resultado) + "*1000" + " = " +  String.format("%.2f", resultado*1000) + "<br>"
                 
         + "<font color=\"blue\">8. ∆S = " + String.format("%.2f", resultado*1000) + " m<br></font></html>");
        
         return resultado * 1000;
    }
    
    private double calculoEspacoPercorridoMsminutosKm(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
        double resultado = (velocidadeMedia * 3.6) * (tempoGasto / 60);
        
        textoCalculoVelocidaMedia.setText(
                
         "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆T = " + tempoGasto + " min" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +          
                 
         "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                  
         + "5. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
                  
         +"6. ∆S = " + String.format("%.2f", velocidadeMedia*3.6) + " * " + String.format("%.2f", tempoGasto/60) + "<br>"
                                  
                 
         + "<font color=\"blue\">7. ∆S = " + String.format("%.2f", resultado) + " Km<br></font></html>");
        
         return resultado;
    }
    
   private double calculoEspacoPercorridoMsminutosM(double velocidadeMedia, double tempoGasto, JLabel textoCalculoVelocidaMedia){
        double resultado = (velocidadeMedia * 3.6) * (tempoGasto / 60);
        
         textoCalculoVelocidaMedia.setText(
                                  
         "<html>1. ∆V = " + velocidadeMedia + " m/s" + "<br>" +
         
         "2.∆T = " + tempoGasto + " min" + "<br>" +    
                
        "3. ∆S = ∆V * ∆T " + "<br>" +           
                 
         "4. Converte m/s para Km/h: " + String.format("%.2f", velocidadeMedia) + "*3.6" + " = " +  String.format("%.2f", velocidadeMedia*3.6) + "<br>"
                  
         + "5. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
                  
         +"6. ∆S = " + String.format("%.2f", velocidadeMedia*3.6) + " * " + String.format("%.2f", tempoGasto/60) + "<br>"
                 
           +"7. ∆S = " + String.format("%.2f", resultado) + "<br>"  
                 
          + "8. Converte Km para m: " + String.format("%.2f", resultado) + "*1000" + " = " +  String.format("%.2f", resultado*1000) +  "<br>"
                 
         + "<font color=\"blue\">9. ∆S = " + String.format("%.2f", resultado*1000) + " m<br></font></html>");
        
         return resultado * 1000;
    }
    
    
    public EspacoPercorridoTelaVelocidadeMedia calculoEspacoPercorrido(EspacoPercorridoTelaVelocidadeMedia espacoPercorrido,JComboBox unidadeVelocidadeMediaTelaVelocidadeMedia,
    JComboBox unidadeTempogastoTelaVelocidadeMedia, JComboBox unidadeResultadoTelaVelocidadeMedia,
    JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel textoCalculoVelocidaMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {

        
        if(verificaValidadeDosCamposTelaEspacoPercorrido(espacoPercorrido)==null){
            
            double velocidadeMedia = Double.parseDouble(espacoPercorrido.velocidadeMedia.getText());

            double tempoGasto = Double.parseDouble(espacoPercorrido.tempoGasto.getText());


            if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoPercorridoKmhHrKm(velocidadeMedia, tempoGasto,textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }

              if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){

                double resultado = calculoEspacoPercorridoKmhHrM(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " m");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }


              if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoPercorridoKmhMinKm(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }


            if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("Km/h") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){

                double resultado = calculoEspacoPercorridoKmhMinM(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " m");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }

            if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoPercorridoMsHrKm(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }

               if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){

                double resultado = calculoEspacoPercorridoMsHrM(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " m");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }
           
               if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){

                double resultado = calculoEspacoPercorridoMsminutosKm(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
            }

              
               if(unidadeVelocidadeMediaTelaVelocidadeMedia.getSelectedItem().equals("M/s") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){

                double resultado = calculoEspacoPercorridoMsminutosM(velocidadeMedia, tempoGasto, textoCalculoVelocidaMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " m");
                espacoPercorrido.setEspacoPercorrido(resultado);
                return espacoPercorrido;
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
       
    
    public void informacoesParaMovimentarCarrinho(EspacoPercorridoTelaVelocidadeMedia espacoPercorrido, JTextField campoVelocidadeMedia, JTextField campoTempoGasto, JComboBox unidadeVelocidadeMedia,
       JComboBox unidadeTempogastoTelaVelocidadeMedia, JComboBox unidadeResultadoTelaVelocidadeMedia , JTextField campoTextoResultadoTelaVelocidadeMedia,
       JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2, JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel textoCalculosTelaVelocidadeMedia, JButton btLimparTelaVelcMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException {
              
            
        if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){
          
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1,  t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2,  t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4,  t4, textoCalculosTelaVelocidadeMedia);
           
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"Km/h", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);
            
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);  
            
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
           
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
           
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"Km/h", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);
        
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);
       
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"m/s", "hr", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);
          
        }else if(unidadeVelocidadeMedia.getSelectedItem().equals("M/s")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km")){
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "Km",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);
        
        }else{
            
            imprimiKm1T1(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm2T2(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm3T3(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, textoCalculosTelaVelocidadeMedia);
            
            imprimiKm4T4(campoVelocidadeMedia, campoTempoGasto,"m/s", "min", "m",unidadeVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, textoCalculosTelaVelocidadeMedia);
        }        
        
        
            
          if(unidadeVelocidadeMedia.getSelectedItem().equals("Km/h")){    
           
                if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText())<=100){
                    moverCarrinho(velocidade,carrinho, 8,btLimparTelaVelcMedia);
                }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 100 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <=200){
                    moverCarrinho(velocidade,carrinho, 6, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 200 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <= 300){
                    moverCarrinho(velocidade,carrinho, 4, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 300 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <= 500){
                    moverCarrinho(velocidade,carrinho,  2, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 500 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaVelcMedia);
                }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5, btLimparTelaVelcMedia);
                }

          }else{
             
              if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText())<=30.56){
                  moverCarrinho(velocidade,carrinho,  8, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 30.56 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <=55.56){
                  moverCarrinho(velocidade,carrinho, 6, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 55.56 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 83.33 && Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText())<= 125){
                  moverCarrinho(velocidade,carrinho, 2, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 125 &&Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1, btLimparTelaVelcMedia);
              }else if(Double.parseDouble(espacoPercorrido.getVelocidadeMedia().getText()) > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5, btLimparTelaVelcMedia);           
              }
          }    
    }
 
    
    private void imprimiKm1T1(JTextField campoVelocidadeMedia, JTextField campoTempoGasto, String undVelocidadeMedia,String undTempo,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km1, JLabel t1, JLabel textoCalculosTelaVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
               
        EspacoPercorridoTelaVelocidadeMedia dadosDosCamposEspacoPercorrido = new EspacoPercorridoTelaVelocidadeMedia(campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoPercorridoTelaVelocidadeMedia eP = calculoEspacoPercorrido(dadosDosCamposEspacoPercorrido, unidadeVelocidadeMedia,
                    unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                    campoTextoResultadoTelaVelocidadeMedia, textoCalculosTelaVelocidadeMedia);
           
            
           if(eP!=null){
               velocidade.setText(campoVelocidadeMedia.getText() + " " + undVelocidadeMedia);
               km1.setText("0 " + unidadeResultadoTelaVelocidadeMedia.getSelectedItem());
               t1.setText("0 " + undTempo);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (VelocidadeMediaExeptionTelaVelocidadeMedia ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
    private void imprimiKm2T2(JTextField campoVelocidadeMedia, JTextField campoTempoGasto, String undVelocidadeMedia,String undTempo,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km2, JLabel t2, JLabel textoCalculosTelaVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
   
        EspacoPercorridoTelaVelocidadeMedia dadosDosCamposEspacoPercorrido = new EspacoPercorridoTelaVelocidadeMedia(campoVelocidadeMedia, campoTempoGasto);
        
        try {
                        
            EspacoPercorridoTelaVelocidadeMedia eP = calculoEspacoPercorrido(dadosDosCamposEspacoPercorrido, unidadeVelocidadeMedia,
                    unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                    campoTextoResultadoTelaVelocidadeMedia, textoCalculosTelaVelocidadeMedia);
       
            if (eP != null) {
                
                 velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidadeMedia);

                double espacoFinal = eP.getEspacoPercorrido() / 3;                
             
                km2.setText(String.format("%.0f",espacoFinal) + undResultado);

                double tempoFinal = (Double.parseDouble(eP.getTempoGasto().getText())) / 3;
                                
                if(undTempo.equals("min")){        
                    t2.setText(String.format("%.1f", tempoFinal) + undTempo);
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
    
    private void imprimiKm3T3(JTextField campoVelocidadeMedia, JTextField campoTempoGasto, String unidVelocidade,String undTempo,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km3, JLabel t3, JLabel textoCalculosTelaVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {

        EspacoPercorridoTelaVelocidadeMedia dadosDosCamposEspacoPercorrido = new EspacoPercorridoTelaVelocidadeMedia(campoVelocidadeMedia, campoTempoGasto);
                                
            EspacoPercorridoTelaVelocidadeMedia eP = calculoEspacoPercorrido(dadosDosCamposEspacoPercorrido, unidadeVelocidadeMedia,
                    unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                    campoTextoResultadoTelaVelocidadeMedia, textoCalculosTelaVelocidadeMedia);
       
            if (eP != null) {
             
             velocidade.setText(campoVelocidadeMedia.getText() + " " + undResultado);
             
             double espacoFinal = ((eP.getEspacoPercorrido() / 3)) * 2 ;
             
             km3.setText(String.format("%.0f", espacoFinal) + undResultado);
             
             double tempoFinal = ((Double.parseDouble(eP.getTempoGasto().getText())) / 3) * 2;
            
             if(undTempo.equals("min")){        
                    t3.setText(String.format("%.1f", tempoFinal) + undTempo);
                }else{
             
                
                    String resultado = GUI.converteHorasEmMinutos(tempoFinal);

                    t3.setText(resultado);
                }  
             
         } else {
             JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
    }    
    
    private void imprimiKm4T4(JTextField campoVelocidadeMedia, JTextField campoTempoGasto, String undVelocidade,String undTempo,
       String undResultado , JComboBox unidadeVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km4, JLabel t4, JLabel textoCalculosTelaVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
        
        EspacoPercorridoTelaVelocidadeMedia dadosDosCamposEspacoPercorrido = new EspacoPercorridoTelaVelocidadeMedia(campoVelocidadeMedia, campoTempoGasto);
                                
            EspacoPercorridoTelaVelocidadeMedia eP = calculoEspacoPercorrido(dadosDosCamposEspacoPercorrido, unidadeVelocidadeMedia,
                    unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                    campoTextoResultadoTelaVelocidadeMedia, textoCalculosTelaVelocidadeMedia);
             
            if (eP != null) {   
       
             velocidade.setText(campoVelocidadeMedia.getText()  + " " + undVelocidade);
             
             double espacoFinal = (eP.getEspacoPercorrido() / 1);
             
             km4.setText(String.format("%.0f", espacoFinal) + undResultado);
             
             double tempoFinal = (Double.parseDouble(eP.getTempoGasto().getText())) / 1;
             
              if(undTempo.equals("min")){        
                    t4.setText(String.format("%.1f", tempoFinal) + undTempo);
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

                    synchronized (ControleEspacoPercorridoTelaVelocidadeMedia.this) {
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
