/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Util.Configura;
import View.Tela;
import DAO.ConnectionFactory;
import java.util.Locale;

/**
 *
 * @author rafa_
 */
public class Principal {
    public static void main(String[] args) {
        Configura.LookAndFeel("Windows Classic");
        new Tela().setVisible(true); 
        DAO.ConnectionFactory.getConnection();
    }
    
    
    
}
