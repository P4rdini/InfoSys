/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe responsavel em trocar a aparencia da aplicacao 
 * @author rafa_
 */
public class Configura {
    
    // Metodo para troar o look and feel do programa
    public static void LookAndFeel ( String laf){
           try{
               for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ){
                   if (laf.equals(info.getName())){
                      
                       UIManager.setLookAndFeel(info.getClassName());
                       break;
                   }
               }
           }catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
               System.out.println("Error: " + e.getMessage());
               e.printStackTrace();
           }
               
    }
   
   
    
}
