
package br.com.wesley.easyfisica.fisica1.mecanica.cinematica.velocidademedia;
import br.com.wesley.easyfisica.GUI;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sun.java2d.loops.CustomComponent;

/**
 *
 * @author Wesley Eduardo
 */
public  class ControleVelocidadeMediaTelaVelocidadeMedia{            
    
  private boolean estaSuspenso = false;
   
  private static Throwable verificaValidadeDosCamposTelaVelocidadeMedia(VelocidadeMediaTelaVelocidadeMedia velocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
           
        if (velocidadeMedia.espacoPercorrido.getText().equals("")) {
            velocidadeMedia.espacoPercorrido.requestFocus();
            throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Campo Espaço Percorrido está Vazio");
        } else if (velocidadeMedia.tempoGasto.getText().equals("")) {
            velocidadeMedia.tempoGasto.requestFocus();
            throw new VelocidadeMediaExeptionTelaVelocidadeMedia("CampoTempo Gasto está Vazio");
        } else {

            try {

                double espacoPercorrido = Double.parseDouble(velocidadeMedia.espacoPercorrido.getText());

                if (espacoPercorrido < 0) {
                    velocidadeMedia.espacoPercorrido.setText("");
                    velocidadeMedia.espacoPercorrido.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("∆S não pode ser menor que 0");
                }

                if (espacoPercorrido == 0) {
                    velocidadeMedia.espacoPercorrido.setText("");
                    velocidadeMedia.espacoPercorrido.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("∆S Não Pode ser = 0");
                }
                
                 if (espacoPercorrido > 10000000) {
                    velocidadeMedia.espacoPercorrido.setText("");
                    velocidadeMedia.espacoPercorrido.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("∆S não pode ser maior que 10.000.000");
                }

                try {

                    double tempoGasto = Double.parseDouble(velocidadeMedia.tempoGasto.getText());

                    if (tempoGasto < 0) {
                        velocidadeMedia.tempoGasto.setText("");
                        velocidadeMedia.tempoGasto.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Tempo gasto não pode ser menor que 0");
                    }

                    if (tempoGasto == 0) {
                        velocidadeMedia.tempoGasto.setText("");
                        velocidadeMedia.tempoGasto.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Tempo gasto não Pode ser = 0");
                    }
                    
                    if (tempoGasto > 1000000) {
                        velocidadeMedia.tempoGasto.setText("");
                        velocidadeMedia.tempoGasto.requestFocus();
                        throw new VelocidadeMediaExeptionTelaVelocidadeMedia("∆T não Pode ser maior que 1.000.000");
                    }

                } catch (NumberFormatException e) {
                    velocidadeMedia.tempoGasto.setText("");
                    velocidadeMedia.tempoGasto.requestFocus();
                    throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Digite um Tempo Gasto Válido");
                }

            } catch (NumberFormatException e) {
                velocidadeMedia.espacoPercorrido.setText("");
                velocidadeMedia.espacoPercorrido.requestFocus();
                throw new VelocidadeMediaExeptionTelaVelocidadeMedia("Digite um Espaço Percorrido Válido");

            }

        }

        return null;
    }
    
    private double calculaVelocidadeMediaKmHrKmh(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia ){
         double resultado = espacoPercorrido / tempoGasto;        
        
         textoCalculoVelocidaMedia.setText(
                            
        "<html>1. ∆S = " + espacoPercorrido + " Km" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +      
                 
         "4. ∆V = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", tempoGasto) + "<br>" 
                 
         + "<font color=\"blue\">5. ∆V = " + String.format("%.2f", resultado) +  " Km/h" + "</font></html>");  
         
         return resultado;
    }
    
    private double calculaVelocidadeMediaKmHrMs(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = espacoPercorrido / tempoGasto;
         
          textoCalculoVelocidaMedia.setText(
                  
          "<html>1. ∆S = " + espacoPercorrido + " Km" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +          
                  
         "4. ∆V = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", tempoGasto) + "<br>"
         
         + "5. ∆V = " + String.format("%.2f", resultado) +  " Km/h<br>"
                 
        + "6. Converte Km/h para m/s: " + String.format("%.2f", resultado) + "/3.6" + " = " +  String.format("%.2f", resultado/3.6) + "<br>"
                  
         + "<font color=\"blue\">7. ∆V = " + String.format("%.2f", resultado/3.6) + "m/s<br></font></html>");  
         
         return resultado / 3.6;
    }
     
    private double calculaVelocidadeMediaKmMinKmh(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = (espacoPercorrido /  (tempoGasto/60));
         
         textoCalculoVelocidaMedia.setText(
                 
                 
         "<html>1. ∆S = " + espacoPercorrido + " Km" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Min" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +          
                 
         "4. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
                 
         + "5. ∆V = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", tempoGasto/60) + "<br>"
         
         + "<font color=\"blue\">6. ∆V = " + String.format("%.2f", resultado) +  " Km/h<br></font></html>");
                  
         return resultado;
    }
      
      
    private double calculaVelocidadeMediaKmMinMs(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = (espacoPercorrido / (tempoGasto/60));
         
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆S = " + espacoPercorrido + " Km" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Min" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +          
                 
         "4. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
                 
         + "5. ∆V = " + String.format("%.2f", espacoPercorrido) + " / " + String.format("%.2f", tempoGasto/60) + "<br>"
                 
         + "6. ∆V = " + String.format("%.2f", resultado) + "<br>"
         
         + "7. Converte Km/h para m/s: " + resultado + "/3.6"  + " = " +  String.format("%.2f", resultado/3.6) +   "<br>"
                 
         + "<font color=\"blue\">8. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s<br></font></html>");
         
         
         return resultado/3.6;
    }
      
    private double calculaVelocidadeMediaMHrKmh(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = ((espacoPercorrido/1000) / tempoGasto);
         
            
         textoCalculoVelocidaMedia.setText(
                 
         "<html>1. ∆S = " + espacoPercorrido + " m" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +  
                 
         "4. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000"  + " = " +  String.format("%.2f", espacoPercorrido/1000) +  "<br>"
                 
         + "5. ∆V = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", tempoGasto) + "<br>"
                         
         + "<font color=\"blue\">6. ∆V = " + String.format("%.2f", resultado) +  " Km/h<br></font></html>");
         
         return resultado;
    }
    
    private double calculaVelocidadeMediaMHrMs(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = ((espacoPercorrido/1000) / tempoGasto);         
             
         textoCalculoVelocidaMedia.setText(
                 
          "<html>1. ∆S = " + espacoPercorrido + " m" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Hr" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +  
                 
         "4. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) +  "<br>"
                 
         + "5. ∆V = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", tempoGasto) + "<br>"
                 
         + "6. ∆V = " + String.format("%.2f", resultado) + "<br>"       
                 
         + "7. Converte Km/h para m/s: " + String.format("%.2f", resultado) + "/3.6" + " = " +  String.format("%.2f", resultado/3.6) +  "<br>"
                         
         + "<font color=\"blue\">8. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s<br></font></html>");
         
         return resultado/3.6;
    }
    
    private double calculaVelocidadeMediaMMinKmh(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
         double resultado = ((espacoPercorrido/1000) / (tempoGasto/60));
         
         textoCalculoVelocidaMedia.setText(
                 
          "<html>1. ∆S = " + espacoPercorrido + " m" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Min" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +         
                 
         "4. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) +"<br>"
         
         + "5. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60"+ " = " +  String.format("%.2f", tempoGasto/60) +"<br>"
                 
         + "6. ∆V = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", tempoGasto/60) + "<br>"     
                         
         + "<font color=\"blue\">7. ∆V = " + String.format("%.2f", resultado) +  " Km/h<br></font></html>");
         
         return resultado;
    }
       
    private double calculaVelocidadeMediaMMinMs(double espacoPercorrido, double tempoGasto, JLabel textoCalculoVelocidaMedia){
        double resultado = ((espacoPercorrido/1000) / (tempoGasto/60));
        
        textoCalculoVelocidaMedia.setText(                
                 
         "<html>1. ∆S = " + espacoPercorrido + " m" + "<br>" +
         
         "2.∆T = " + tempoGasto + " Min" + "<br>" +    
                
        "3. ∆V = ∆S / ∆T " + "<br>" +         
                 
         "4. Converte m para Km: " + String.format("%.2f", espacoPercorrido) + "/1000" + " = " +  String.format("%.2f", espacoPercorrido/1000) + "<br>"
         
         + "5. Converte Min para Hr: " + String.format("%.2f", tempoGasto) + "/60" + " = " +  String.format("%.2f", tempoGasto/60) + "<br>"
                 
         + "6. ∆V = " + String.format("%.2f", espacoPercorrido/1000) + " / " + String.format("%.2f", tempoGasto/60) + "<br>"
                 
         + "7. ∆V = " + String.format("%.2f", resultado) + "<br>"
                 
         + "8. Converte Km/h para m/s: " + String.format("%.2f", resultado) + "/3.6" + " = " +  String.format("%.2f", resultado/3.6) +  "<br>"
                         
         + "<font color=\"blue\">9. ∆V = " + String.format("%.2f", resultado/3.6) +  " m/s<br></font></html>");
        
        return resultado/3.6;
    }
    
    public VelocidadeMediaTelaVelocidadeMedia calculoVelocidadeMedia(VelocidadeMediaTelaVelocidadeMedia velocidadeMedia,JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia,
    JComboBox unidadeTempogastoTelaVelocidadeMedia, JComboBox unidadeResultadoTelaVelocidadeMedia,
    JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel textoCalculoVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {

        
        if(verificaValidadeDosCamposTelaVelocidadeMedia(velocidadeMedia)==null){
            
            double espacoPercorrido = Double.parseDouble(velocidadeMedia.espacoPercorrido.getText());

            double tempoGasto = Double.parseDouble(velocidadeMedia.tempoGasto.getText());


            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){

                double resultado = calculaVelocidadeMediaKmHrKmh(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){

                double resultado = calculaVelocidadeMediaKmHrMs(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);                
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " M/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }


            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){

                double resultado = calculaVelocidadeMediaKmMinKmh(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){

                double resultado = calculaVelocidadeMediaKmMinMs(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);               
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " M/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){

                double resultado = calculaVelocidadeMediaMHrKmh(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){

                double resultado = calculaVelocidadeMediaMHrMs(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " M/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }

            if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){

                double resultado = calculaVelocidadeMediaMMinKmh(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " Km/h");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
            }


             if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M") && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min") && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){

                double resultado = calculaVelocidadeMediaMMinMs(espacoPercorrido, tempoGasto, textoCalculoVelocidadeMedia);
                String resultadoFinal = String.format("%.2f", resultado);
                campoTextoResultadoTelaVelocidadeMedia.setText(resultadoFinal + " M/s");
                velocidadeMedia.setVelocidadeMedia(resultado);
                return velocidadeMedia;
             }
        }       

        return null;
        
}

    public void mostrarInformacoesBotoesTelaVelocidadeMedia( JButton  bt1ExplicacaoTelaMecanica, JButton btCinematicaTelaFisica1, JButton btDinamicaTelaFisica1,
    JButton btEstaticaTelaFisica1, JButton  btHidrostaticaTelaFisica1, JButton btGravUniversalTelaFisica1, JButton btVoltarTelaFisica1,
    JButton bt1ExplicacaoTelaCinematica, JButton btVoltarTelaAnteriorCinematica, JButton btVoltarTelaInicioCinematica , JButton btVelocidadeMediaTelaCinematica
    ) {

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
       
        
    }
       
    
    public void informacoesParaMovimentarCarrinho(VelocidadeMediaTelaVelocidadeMedia velocidadeMedia, JTextField campoEspacoPercorrido, JTextField campoTempoGasto, JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia,
       JComboBox unidadeTempogastoTelaVelocidadeMedia, JComboBox unidadeResultadoTelaVelocidadeMedia , JTextField campoTextoResultadoTelaVelocidadeMedia,
       JLabel velocidade, JLabel km1 , JLabel t1, JLabel km2 , JLabel t2, JLabel km3 , JLabel t3, JLabel km4 , JLabel t4 , JLabel carrinho, JLabel TextoCalculoVelocidadeMedia, JButton btLimparTelaVelcMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia, InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException {
              
            
        if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1,  t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2,  t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4,  t4, TextoCalculoVelocidadeMedia);
           
        }else if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"Km", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);
            
        }else if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);  
            
        }else if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("Km")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
           
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
           
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"Km", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);
        
        }else if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);
       
        }else if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Hr")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("M/s")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"m", "hr", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);
          
        }else if(unidadeEspacoPercorridoTelaVelocidadeMedia.getSelectedItem().equals("M")
        && unidadeTempogastoTelaVelocidadeMedia.getSelectedItem().equals("Min")
        && unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"m", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"m", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"m", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"m", "min", "Km/h",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);
        
        }else{
            
            imprimiKm1T1(campoEspacoPercorrido, campoTempoGasto,"m", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km1 , t1, TextoCalculoVelocidadeMedia);
            
            imprimiKm2T2(campoEspacoPercorrido, campoTempoGasto,"m", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km2 , t2, TextoCalculoVelocidadeMedia);
            
            imprimiKm3T3(campoEspacoPercorrido, campoTempoGasto,"m", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km3 , t3, TextoCalculoVelocidadeMedia);
            
            imprimiKm4T4(campoEspacoPercorrido, campoTempoGasto,"m", "min", "m/s",unidadeEspacoPercorridoTelaVelocidadeMedia,
            unidadeTempogastoTelaVelocidadeMedia,unidadeResultadoTelaVelocidadeMedia,campoTextoResultadoTelaVelocidadeMedia, velocidade, km4 , t4, TextoCalculoVelocidadeMedia);
        }        
        
         carrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wesley/easyfisica/imagens/Gifs/civic.gif")));
            
          if(unidadeResultadoTelaVelocidadeMedia.getSelectedItem().equals("Km/h")){    
           
                VelocidadeMediaTelaVelocidadeMedia vM = calculoVelocidadeMedia(velocidadeMedia,unidadeEspacoPercorridoTelaVelocidadeMedia,
                unidadeTempogastoTelaVelocidadeMedia,  unidadeResultadoTelaVelocidadeMedia,
                campoTextoResultadoTelaVelocidadeMedia,TextoCalculoVelocidadeMedia);

                if(vM.getVelocidadeMedia()<=100){
                    moverCarrinho(velocidade,carrinho, 8, btLimparTelaVelcMedia);
                }else if(vM.getVelocidadeMedia() > 100 && vM.getVelocidadeMedia() <=200){
                    moverCarrinho(velocidade,carrinho, 6, btLimparTelaVelcMedia);
                }else if(vM.getVelocidadeMedia() > 200 && vM.getVelocidadeMedia() <= 300){
                    moverCarrinho(velocidade,carrinho, 4, btLimparTelaVelcMedia);
                }else if(vM.getVelocidadeMedia() > 300 && vM.getVelocidadeMedia() <= 500){
                    moverCarrinho(velocidade,carrinho,  2, btLimparTelaVelcMedia);
                }else if(vM.getVelocidadeMedia() > 500 && vM.getVelocidadeMedia() <= 1000){
                    moverCarrinho(velocidade,carrinho, 1, btLimparTelaVelcMedia);
                }else if(vM.getVelocidadeMedia() > 1000){
                    moverCarrinho(velocidade,carrinho, (long)0.5, btLimparTelaVelcMedia);
                }

          }else{
              
              VelocidadeMediaTelaVelocidadeMedia vM = calculoVelocidadeMedia(velocidadeMedia,unidadeEspacoPercorridoTelaVelocidadeMedia,
              unidadeTempogastoTelaVelocidadeMedia,  unidadeResultadoTelaVelocidadeMedia,
              campoTextoResultadoTelaVelocidadeMedia, TextoCalculoVelocidadeMedia);
                
              if(vM.getVelocidadeMedia()<=30.56){
                  moverCarrinho(velocidade,carrinho,  8, btLimparTelaVelcMedia);
              }else if(vM.getVelocidadeMedia() > 30.56 && vM.getVelocidadeMedia() <=55.56){
                  moverCarrinho(velocidade,carrinho, 6, btLimparTelaVelcMedia);
              }else if(vM.getVelocidadeMedia() > 55.56 && vM.getVelocidadeMedia() <= 83.33){
                  moverCarrinho(velocidade,carrinho,  4, btLimparTelaVelcMedia);
              }else if(vM.getVelocidadeMedia() > 83.33 && vM.getVelocidadeMedia() <= 125){
                  moverCarrinho(velocidade,carrinho, 2, btLimparTelaVelcMedia);
              }else if(vM.getVelocidadeMedia() > 125 && vM.getVelocidadeMedia() <= 277.88){
                  moverCarrinho(velocidade,carrinho,  (long)1, btLimparTelaVelcMedia);
              }else if(vM.getVelocidadeMedia() > 277.88){
                  moverCarrinho(velocidade, carrinho, (long)0.5, btLimparTelaVelcMedia);           
              }
          }  
          
         
    }
 
    
    private void imprimiKm1T1(JTextField campoEspacoPercorrido, JTextField campoTempoGasto, String undEspaco,String undTempo,
       String undResultado , JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km1, JLabel t1, JLabel TextoCalculoVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
       
        VelocidadeMediaTelaVelocidadeMedia dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaVelocidadeMedia(campoEspacoPercorrido, campoTempoGasto);
        
        try {
            VelocidadeMediaTelaVelocidadeMedia vm = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoPercorridoTelaVelocidadeMedia,
                    unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                    campoTextoResultadoTelaVelocidadeMedia, TextoCalculoVelocidadeMedia);
           if(vm!=null){
               velocidade.setText(String.format("%.1f", vm.getVelocidadeMedia()) + " " + undResultado);
               km1.setText("0 " + undEspaco);
               t1.setText("0 " + undTempo);
           }else{
               JOptionPane.showMessageDialog(null, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
           }

        } catch (VelocidadeMediaExeptionTelaVelocidadeMedia ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }     
       
    }
    
    private void imprimiKm2T2(JTextField campoEspacoPercorrido, JTextField campoTempoGasto, String undEspaco,String undTempo,
       String undResultado , JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km2, JLabel t2, JLabel TextoCalculoVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
   
         VelocidadeMediaTelaVelocidadeMedia dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaVelocidadeMedia(campoEspacoPercorrido, campoTempoGasto);
        
        try {

            VelocidadeMediaTelaVelocidadeMedia vm = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoPercorridoTelaVelocidadeMedia,
                    unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                    campoTextoResultadoTelaVelocidadeMedia, TextoCalculoVelocidadeMedia);

            if (vm != null) {
                
                double velocidadeFinal = vm.getVelocidadeMedia();
                
                velocidade.setText(String.format("%.1f", velocidadeFinal) + " " + undResultado);

                double espacoFinal = Double.parseDouble(vm.getEspacoPercorrido().getText()) / 3;                
             
                km2.setText(String.format("%.0f", espacoFinal) + undEspaco);

                double tempoFinal = (Double.parseDouble(vm.getTempoGasto().getText())) / 3;
                
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
    
    private void imprimiKm3T3(JTextField campoEspacoPercorrido, JTextField campoTempoGasto, String undEspaco,String undTempo,
       String undResultado , JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km3, JLabel t3, JLabel textoCalculoVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
      
         VelocidadeMediaTelaVelocidadeMedia dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaVelocidadeMedia(campoEspacoPercorrido, campoTempoGasto);
        
         VelocidadeMediaTelaVelocidadeMedia vm = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoPercorridoTelaVelocidadeMedia,
                 unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                 campoTextoResultadoTelaVelocidadeMedia, textoCalculoVelocidadeMedia);
         if (vm != null) {                
             
             double velocidadeFinal = vm.getVelocidadeMedia();
             
             velocidade.setText(String.format("%.1f", velocidadeFinal) + " " + undResultado);
             
             double espacoFinal = ((Double.parseDouble(vm.getEspacoPercorrido().getText())) / 3) * 2 ;
             
             km3.setText(String.format("%.0f", espacoFinal) + undEspaco);
             
             double tempoFinal = ((Double.parseDouble(vm.getTempoGasto().getText())) / 3) * 2;
             
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
    
    private void imprimiKm4T4(JTextField campoEspacoPercorrido, JTextField campoTempoGasto, String undEspaco,String undTempo,
       String undResultado , JComboBox unidadeEspacoPercorridoTelaVelocidadeMedia, JComboBox unidadeTempogastoTelaVelocidadeMedia,
       JComboBox unidadeResultadoTelaVelocidadeMedia, JTextField campoTextoResultadoTelaVelocidadeMedia, JLabel velocidade,
       JLabel km4, JLabel t4, JLabel textoCalculoVelocidadeMedia) throws VelocidadeMediaExeptionTelaVelocidadeMedia {
        
         VelocidadeMediaTelaVelocidadeMedia dadosDosCamposVelocidadeMedia = new VelocidadeMediaTelaVelocidadeMedia(campoEspacoPercorrido, campoTempoGasto);
        
         VelocidadeMediaTelaVelocidadeMedia vm = calculoVelocidadeMedia(dadosDosCamposVelocidadeMedia, unidadeEspacoPercorridoTelaVelocidadeMedia,
                 unidadeTempogastoTelaVelocidadeMedia, unidadeResultadoTelaVelocidadeMedia,
                 campoTextoResultadoTelaVelocidadeMedia,textoCalculoVelocidadeMedia);
         if (vm != null) {                
             
             double velocidadeFinal = vm.getVelocidadeMedia();
             
             velocidade.setText(String.format("%.1f", velocidadeFinal) + " " + undResultado);
             
             double espacoFinal = (Double.parseDouble(vm.getEspacoPercorrido().getText())) / 1;
             
             km4.setText(String.format("%.0f", espacoFinal) + undEspaco);
             
             double tempoFinal = (Double.parseDouble(vm.getTempoGasto().getText())) / 1;
             
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
                GUI.desativaBotoesDuranteAnimacao();
                x++;                
                if (x > 870) {                   
                    break;
                }
                while (estaSuspenso) {
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException ex) {}
                }
                
               if(x >= 855){
                    carrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wesley/easyfisica/imagenscarrinhos/civic.png")));
                }
                             
                carrinho.setLocation(x, y);
                try {
                    sleep(valorVelocidade);
                    
                } catch (InterruptedException e) {
                }
            }
            GUI.ativaBotoesDepoisDaAnimacao();
            btLimparTelaVelcMedia.setEnabled(true);
            GUI.desativaBotaoPausaEContinua();
            
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

                    if(x > 900){
                        break;
                    }
                        
                    synchronized (ControleVelocidadeMediaTelaVelocidadeMedia.this) {
                        while (estaSuspenso) {
                            try {
                                Thread.currentThread().wait();
                            } catch (InterruptedException ex) {
                            }
                        }
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
