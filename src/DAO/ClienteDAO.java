/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTML;

/**
 * Classe responsavel em salvar,atualizar,deletar e ler os dados salvo no banco de dados  
 * @author rafa_
 */
public class ClienteDAO implements Persistencia<Cliente> {
    
    /**
     * Metodo responsavel em salvar os dados na tabela do banco de dados
     * 
     * @param recebe um objeto do tipo cliente para fazer a persistencia.
     * @return um id do tipo inteiro que ficara salvo na classe cliente.
     */
    public int create(Cliente c) {
        // variavel responsavel pelo id do cliente
        int id =0 ;
        // cria um objeto de connection que recebe um metodo que pega 
        //a conexao com o banco de dados
        Connection con = ConnectionFactory.getConnection();
        // objeto responsavel para preparar os comandos sql para fazer a 
        //inserção, esta forma e mas segura contra ataques pelo sql injetion.
        PreparedStatement pst = null; 
        // cria um objeto de resultset com valor nulo
        ResultSet rs =null;
        // cria um objeto de string que recebe os comandos de sql para salvar no banco de dados
        String sql = "INSERT INTO Cliente(Nome,CPF,Fone,Celular,Email)VALUES(?,?,?,?,?)";
        try{
            // preparedstatement recebe o comandos de sql da string junto com os parametros que seram inseridos.
            pst= con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            // Inicio da inserção de parametros para o preparedstatement.
            pst.setString(1,c.getNome());
            pst.setString(2,c.getCpf());
            pst.setString(3,c.getFone());
            pst.setString(4,c.getCelular());
            // fim da inserção de parametros do preparedstatement.
            pst.setString(5,c.getEmail());
            
            // executando as instruções salva no preparedstatement.
            pst.execute();
            // resultset recebe todos os comandos de inserção no banco de dados.
            rs = pst.getGeneratedKeys();
            // condicional para pegar o valor do id inserido ,
             if (rs.next()){
                 // id recebe o valor do id inserido no banco de dados
                 id = rs.getInt(1);
                 JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                 
             }
        }
        /**
         * Metodo para se caso der erro.
         * id volta para o valor inicial de 0.
         * é enviado uma mensagem informando que nao foi possivel fazer a persistencia.
         */
        catch (SQLException ex){
            id =0 ;
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "nao foi possivel salvar os dados");
            
        }finally{
            // usando a classe connectionFactory finalizamos a conexao com o banco de dados.
                ConnectionFactory.closeConnection(con, pst, rs);
        }
        // retornamos o id da inserção.
        return id;
    }

   
    /**
     * Metodo responsavel em fazer a atualização da tabela no banco de dados.
     * @param recebe um objeto do tipo cliente
     * @return um valor booleano informando se a alteração obteve exito ou nao.
     */
    public boolean update(Cliente c) {
        // cria um objeto de connection que recebe um metodo que pega 
        //a conexao com o banco de dados
       Connection con = ConnectionFactory.getConnection();
       // objeto responsavel para preparar os comandos sql para fazer a 
        //inserção, esta forma e mas segura contra ataques pelo sql injetion.
       PreparedStatement pst = null;
       // cria um objeto de string que recebe os comandos de sql para atulizar a tabela no banco de dados
       String sql = "update Cliente set Nome = ? ,"
                                        + "CPF = ? , "
                                        + "Fone = ? , "
                                        + "Celular = ? "
                                        + ", Email = ? "
                                        + "where Codigo = ?";
       try
       {
           // preparedstatement recebe o comando de sql salvo na string.
           pst = con.prepareStatement(sql);
           // condicional para testar se o campo nome da tabela nao esta vazio.
           if (!c.getNome().equals("") ){
           // Inicio da inserção de parametros para o preparedstatement.   
           pst.setString(1,c.getNome());
           pst.setString(2,c.getCpf());
           pst.setString(3,c.getFone());
           pst.setString(4,c.getCelular());
           pst.setString(5,c.getEmail());
           // fim da inserção de parametros.
           pst.setInt(6,c.getCodigo());
           // executa a instruçao salva no preparedstatement. 
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
                // usando a classe connectionFactory finalizamos a conexao com o banco de dados.
                ConnectionFactory.closeConnection(con, pst);
            }
       return true;
    }

    /**
     * Metodo responsavel em deletar registro da tabela
     * @param recebe um objeto cliente 
     * @return um valor booleano informando se a exclusao teve exito ou nao
     */
    public boolean delete(Cliente c) {
       // cria um objeto de connection que recebe um metodo que pega 
       //a conexao com o banco de dados
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement pst = null;
      String sql = "delete from Cliente where Codigo = ?;";
      try{
          pst = con.prepareStatement(sql);
          pst.setInt(1, c.getCodigo());
          pst.executeUpdate();
      }catch(SQLException e){
          e.getStackTrace();
          return false;
      }finally{
          // usando a classe connectionFactory finalizamos a conexao com o banco de dados.
          ConnectionFactory.closeConnection(con, pst);
      }
    return true;
    }

    @Override
    public Cliente findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo responsavel em fazer a leitura dos dados da tabela no banco de dados.
     * @return uma lista de objeto cliente com as informaçoes salva no banco de dados.
     */
    public  java.util.List<Cliente> read() {
        // cria um objeto de connection que recebe um metodo que pega 
        //a conexao com o banco de dados
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst=null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Cliente ORDER BY Codigo";
        // Cria um Arraylist do objeto cliente para salvar as informaçoes do banco de dados.
        ArrayList<Cliente> lista = new ArrayList<Cliente>(); 
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            // esta condicional ira rodar ate o resultset for diferente de nulo.
            while (rs.next()){
                // cria-se variaveis que recebem as informaçoes salva no banco de dados.
                int codigo = rs.getInt("Codigo");
                String nome = rs.getString("Nome");
                String cpf = rs.getString("CPF");
                String fone = rs.getString("Fone");
                String celular = rs.getString("Celular");
                String email = rs.getString("Email");
                //adiciona a lista um objeto cliente com as variaveis acima.
                lista.add(new Cliente(codigo,nome,cpf,fone,celular,email));
            }
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            // usando a classe connectionFactory finalizamos a conexao com o banco de dados.
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        return lista;
    }
    
    
    
}
