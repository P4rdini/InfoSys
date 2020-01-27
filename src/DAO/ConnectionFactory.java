/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsavel em abrir e fecha conexao com o banco de dados.
 * @author rafa_
 */
public class ConnectionFactory {
    // url do banco de dados na maquina local
    private static final String url = "jdbc:sqlite:C:\\Users\\rafa_\\Documents\\NetBeansProjects\\infoSys\\db\\InfoSys.db";
    /**
     * Metodo que pega conexao com o banco de dados.
     * @return returna uma conexao 
     */
   public static Connection getConnection (){
       try{
           return DriverManager.getConnection(url);
       }catch(SQLException e){
           throw new RuntimeException("Erro na conexao");
       }
   }
   /**
    * Metodo responsavel para fechar a conexao 
    * @param recebe um objeto de connection para ser fechado 
    */
   public static void closeConnection (Connection con){
       try{
           if (con != null) con.close();
       }catch (SQLException e){
           throw new RuntimeException("Erro no fechamento da conexao ");
       }
   }
    /**
     * Metodo responsabel em fechar a conexao 
     * @param recebe um objeto connetion para ser fechado.
     * @paramr recebe um objeto preparedstatement para ser fechado.
     * @param recebe um objeto resultset para ser fechado. 
     */
    static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
            try{
           if (con != null) con.close();
       }catch (SQLException e){
           throw new RuntimeException("Erro no fechamento da conexao ");
       }
    }
    /**
     * Metodo responsavel em fechar a conexao.
     * @param recebe um objeto de connection para ser fechado.
     * @param recebe um objeto de Preparedstatement para ser fechado.
     */
    static void closeConnection(Connection con, PreparedStatement pst) {
            try{
           if (con != null) con.close();
       }catch (SQLException e){
           throw new RuntimeException("Erro no fechamento da conexao ");
       }
    }
   
   
   
   
}

   


