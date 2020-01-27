/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import Model.Tecnico;
import View.TelaConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Claase responsavel em fazer a persistencia de dados do objeto TECNICO.
 * @author rafa_
 */
public class TecnicoDAO implements Persistencia<Tecnico> {

    @Override
    public int create(Tecnico t) {
     int id =0 ;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null; 
        ResultSet rs =null;
        String sql = "INSERT INTO Tecnico(Nome,Salario,ValorHora)VALUES(?,?,?)";
        try{
            pst= con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,t.getName());
            pst.setDouble(2,t.getSalario());
            pst.setDouble(3,t.getValorHora());
            pst.execute();
            rs = pst.getGeneratedKeys();
             if (rs.next()){
                 id = rs.getInt(1);
                 JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                 
             }
        }catch (SQLException ex){
            id =0 ;
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "nao foi possivel salvar os dados");
            
        }finally{
                ConnectionFactory.closeConnection(con, pst, rs);
        }
        return id;
    }

    @Override
    public List<Tecnico> read() {
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null ;
        String sql = "SELECT * FROM Tecnico ORDER BY Codigo";
        List lista = new ArrayList<Produto>();
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("Codigo");
                String Nome = rs.getString("Nome");
                double salario = rs.getDouble("Salario");
                double Valor = rs.getDouble("ValorHora");
                lista.add(new Tecnico(codigo,Nome,salario,Valor));
                
            }
            
        }catch (SQLException ex){
            throw new RuntimeException("erro no select");
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        return lista;
    }

    @Override
    public boolean update(Tecnico t) {
     Connection con = ConnectionFactory.getConnection();
       PreparedStatement pst = null;
       String sql = "update Tecnico set Nome = ? ,"
                                        + "Salario = ? , "
                                        + "ValorHora = ?  "
                                        + "where Codigo = ?";
       try
       {
           pst = con.prepareStatement(sql);
           if (!t.getName().equals("") ){
           pst.setString(1,t.getName());
           pst.setDouble(2,t.getSalario());
           pst.setDouble(3,t.getValorHora());
           pst.setInt(4,t.getCodigo());
           pst.executeUpdate();
           } else {
               JOptionPane.showMessageDialog(null,"Por favor preencher os campos para efeutar a alteracao");
               return false;
           }
       }catch(SQLException e)
        {
            System.out.println(e.getStackTrace());
            return false;
            }finally{
                ConnectionFactory.closeConnection(con, pst);
            }
       return true;
    }

    @Override
    public boolean delete(Tecnico t) {
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement pst = null;
      String sql = "delete from Tecnico where Codigo = ?;";
      try{
          pst = con.prepareStatement(sql);
          pst.setInt(1, t.getCodigo());
          pst.executeUpdate();
      }catch(SQLException e){
          System.out.println(e.getStackTrace());
          return false;
      }finally{
          ConnectionFactory.closeConnection(con, pst);
      }
      return true;
    }

    @Override
    public Tecnico findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
