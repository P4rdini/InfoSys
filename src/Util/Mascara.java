/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.html.HTMLDocument;

/**
 * Classe que faz as formatacoes dos campos da view 
 * @author rafa_
 */
public class Mascara {
    
    // Metodo responsavel em formatar o campo cpf
    public static DefaultFormatterFactory getCpfMask (){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
        }catch (ParseException ex ){
            return null;
        }
        return (new DefaultFormatterFactory(mask,mask));
    }
    // Metodo responsavel em formatar o campo Telefone fixo 
    public static DefaultFormatterFactory getFoneFixoMask (){
        MaskFormatter mask=null;
        try{
            mask= new MaskFormatter("(##)####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException ex){
            return null;
        }
        return (new DefaultFormatterFactory(mask,mask));
    }
    // Metodo responsavel em formatar o campo Celular
    public static DefaultFormatterFactory getCelularMask (){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("(##)#####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException ex){
            return null;
        }
        return (new DefaultFormatterFactory(mask,mask));
    }
    // Metodo responsavel em formatar o campo valor
    public static DefaultFormatterFactory getValorMask(){
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter nf = new NumberFormatter(df);
        nf.setAllowsInvalid(false);
        nf.setMinimum(0.00);
        nf.setMaximum(9999999999999999.99);
        return (new DefaultFormatterFactory(nf));
    }
    // Metodo responsavel em trocar o ponto (.) por vircula (,)
    public static double converterpVirgulaEmPonto(String a){
        String retorno = new String();
        for (int i = 0 ; i< a.length() ;i++){
            if (a.charAt(i) == ','){
                retorno += '.';
            }else {
                retorno += a.charAt(i);
            }
            
        }
        
        return Double.parseDouble(retorno);
    }
    
}
