/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ClienteDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsabel em criar todos atributos e metodos do objeto cliente.
 * @author rafa_
 */
public class Cliente {
    // variavel que armazena o id da inserção no banco de dados.
    private int codigo =0;
    // variavel de string para armazenar o nome do cliente.
    private String nome = null;
    // variavel de string para armazenar o cpf do cliente.
    private String cpf = null;
    // variavel de string para armazenar o telefone do cliente.
    private String fone = null;
    // variavel de string para armazenar o celular do cliente.
    private String celular = null;
    // variavel de string para armazenar o email do cliente.
    private String email = null;

    /**
     * Metodo construtor para pegar os dados da view que armazenar nas variaveis da classe
     * @param nome
     * @param cpf
     * @param fone
     * @param celular
     * @param email 
     */
    public Cliente(String nome,String cpf,String fone,String celular,String email) {
        setNome(nome);
        setCpf(cpf);
        setFone(fone);
        setCelular(celular);
        setEmail(email);
        gravar();
    }
    
   // construtor com a variavel CODIGO.
    public Cliente(int codigo,String nome,String cpf,String fone,String celular,String email) {
        setCodigo(codigo);
        setNome(nome);
        setCpf(cpf);
        setFone(fone);
        setCelular(celular);
        setEmail(email);
    }
            /**
             * Metodo responsavel em pegar as informaçoes da view 
             * e enviar para o DAO atravez do metodo UPDATE.
             * @param nome
             * @param cpf
             * @param fone
             * @param celular
             * @param email
             * @param codigo 
             */
            public Cliente(String nome,String cpf,String fone,String celular,String email,int codigo) {
                setCodigo(codigo);
                setNome(nome);
                setCpf(cpf);
                setFone(fone);
                setCelular(celular);
                setEmail(email);
                update();
            }
    /**
     * Metodo construtor para pegar o id da view e enviar para DAO deletar.
     * @param id 
     */
    public Cliente (int id){
        setCodigo(id);
        delete();
    }
   

    @Override
    public String toString() {
    return "Cliente{" + "nome=" + nome +
                        ", cpf=" + cpf + 
                      ", fone=" + fone +
                ", celular=" + celular +
                    ", email=" + email + '}';
    }
    
      public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo que envia as informaçoes para o DAO gravar no banco de dados.
     */   
    private void gravar (){
        ClienteDAO d = new ClienteDAO();
        int codigo = d.create(this);
        if ( codigo >0 ) setCodigo(codigo);
    }
    /**
     * Metodo que envia as informaçoes para o DAO deletar no banco de dados.
     * @return 
     */
    private boolean delete(){
        ClienteDAO c = new ClienteDAO();
        if (c.delete(this) == true){
            JOptionPane.showMessageDialog(null,"item excluido com sucesso");
            return true;
        }else {
             JOptionPane.showMessageDialog(null, "nao foi possivel excluir");
             return false;
        }
    }
    /**
     * Metodo que envia as informçoes para o DAO atulizar o banco de dados.
     * @return 
     */
    private boolean update(){
        ClienteDAO c = new ClienteDAO();
        if (c.update(this) == true){
            JOptionPane.showMessageDialog(null,"Alteracao salva com sucesso");
            return true;
        }else{
           // JOptionPane.showMessageDialog(null,"Nao foi possivel fazer a atulizacao dos dados");
            return false;
        }
    }
    /**
     * Metodo que configura Tabela na view
     * @return retorna uma tabela configurada.
     */
    public static DefaultTableModel getTableModel(){
        // instancia do DAO 
        ClienteDAO d =new ClienteDAO();
        // List de objeto cliente que recebe os dados da tabela cliente do banco de dados.
        List<Cliente> lista = d.read();
        // Criação de um objeto de modelo de tabela para implementarmos na view.
        DefaultTableModel modelo = new DefaultTableModel();
        // acionando colunas na tabela da view
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("Celular");
        modelo.addColumn("Email");
        for(Cliente c: lista){
            // adicionando linhas com as informaçoes salvas no banco de dados.
            String[] reg = {String.valueOf(c.getCodigo()),c.getNome(),c.getCpf(),c.getFone(),c.getCelular(),c.getEmail() };
            modelo.addRow(reg);
        }
       // retorna um modelo de tabela para view.
        return modelo;
        
    }
    
    
    
}
