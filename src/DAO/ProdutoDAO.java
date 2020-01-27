/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import Util.Mascara;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import sun.util.locale.ParseStatus;

/**
 * Classe responsavel em fazer a persistencia de dados do objeto PRODUTO.
 * @author rafa_
 */
public class ProdutoDAO implements Persistencia<Produto> {

    @Override
    public int create(Produto p) {
        int id =0;
       Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Produto(Descricao,Estoque,Ativo,Custo,Venda)VALUES(?,?,?,?,?)";
       try{
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            if (p.getDescricao() != "" & p.getEstoque() != 0 & p.getCusto() != 0.00 & p.getVenda() != 0.00){
            pst.setString(1,p.getDescricao());
            pst.setInt(2,p.getEstoque());
            pst.setBoolean(3,p.isAtivo());
            pst.setDouble(4,p.getCusto());
            pst.setDouble(5,p.getVenda());
            pst.execute();
            rs = pst.getGeneratedKeys();
        if (rs.next()){
            id = rs.getInt(1);
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
        }
            }else JOptionPane.showMessageDialog(null,"Preenchar os campos para gravar");
    }catch (SQLException ex){
            id =0 ;
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "nao foi possivel salvar os dados");
            }finally{
           ConnectionFactory.closeConnection(con,pst,rs);
       }
       return id;
    }
    

    @Override
    public List<Produto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null ;
        String sql = "SELECT * FROM Produto ORDER BY Codigo";
        List lista = new ArrayList<Produto>();
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("Codigo");
                String descricao = rs.getString("Descricao");
                int estoque = rs.getInt("Estoque");
                boolean ativo = rs.getBoolean("Ativo");
                double custo = rs.getDouble("Custo");
                double venda = rs.getDouble("Venda");
                lista.add(new Produto(codigo,descricao,estoque,ativo,custo,venda));
           
                
            }
            
        }catch (SQLException ex){
            throw new RuntimeException("erro no select");
            
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        return lista;
      }

    @Override
    public boolean update(Produto p) {
     Connection con = ConnectionFactory.getConnection();
       PreparedStatement pst = null;
       String sql = "update Produto set Descricao = ? ,"
                                        + "Estoque = ? , "
                                        + "Ativo = ? , "
                                        + "Custo = ? "
                                        + ", Venda = ? "
                                        + "where Codigo = ?";
       try
       {
           pst = con.prepareStatement(sql);
           if (!p.getDescricao().equals("") ){
           pst.setString(1,p.getDescricao());
           pst.setInt(2,p.getEstoque());
           pst.setBoolean(3,p.isAtivo());
           pst.setDouble(4,p.getCusto());
           pst.setDouble(5,p.getVenda());
           pst.setInt(6,p.getCodigo());
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
    public boolean delete(Produto p) {
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement pst = null ;
      String sql = "delete from Produto where Codigo =?";
      try{
          pst = con.prepareStatement(sql);
          pst.setInt(1, p.getCodigo());
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
    public Produto findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
  
}
