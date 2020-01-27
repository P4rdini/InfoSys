/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsavel em criar todos os atributos e metodos do objeto PRODUTO
 * @author rafa_
 */
public class Produto {
    // variavel que armazena o id da inserção no banco de dados.
    private int codigo =0 ;
    // varivael que armazena a descrição do produto
    private String descricao=null;
    // varivael que armazena a quantidade de estoque do produto
    private int estoque =0;
    // variavel que armazena se o produto esta ativo ou nao
    private boolean ativo = false;
    // variavel que armazena o custo do produto
    private double custo = 0;
    // varivael que armazena o valor de venda do produto
    private double venda =0;

   // Metodo construtor que grava os informaçoes no banco de dados atravez do metodo gravar()
    public Produto(String descricao , int estoque, boolean ativo ,double custo,double venda) {
        setDescricao(descricao);
        setEstoque(estoque);
        setAtivo(ativo);
        setCusto(custo);
        setVenda(venda);
        gravar();
        
    }

    // Metodo construtor que salva as informaçoes nas variaveis da classe
    public Produto(int codigo ,String descricao,int estoque,boolean ativo,double valor,double custo) {
        setCodigo(codigo);
        setDescricao(descricao);
        setEstoque(estoque);
        setAtivo(ativo);
        setVenda(valor);
        setCusto(custo);
         }
    // Metodo construtor que faz a atualização das variaveis no banco de dados atravez do metodo update()
    public Produto(String descricao,int estoque,boolean ativo,double valor,double custo,int codigo ) {
        setCodigo(codigo);
        setDescricao(descricao);
        setEstoque(estoque);
        setAtivo(ativo);
        setVenda(valor);
        setCusto(custo);
        update();
         }
    // Metodo construtor que faz a exclução no banco de dados atravez do metodo delete() usando a variavel codigo
    public Produto (int Codigo){
        setCodigo(Codigo);
        delete();
    }
    @Override
    public String toString() {
        return "Produto{" + "descricao=" + descricao +
                ", estoque=" + estoque +
                ", ativo=" + ativo +
                ", valor=" + venda +
                ", custo=" + custo + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    // metodo responsavel em gravar as informaçoes das variaveis no banco de dados
    private void gravar(){
        ProdutoDAO p = new ProdutoDAO();
        int codigo = p.create(this);
        if (codigo >0 ) setCodigo(codigo);
    }
    // metodo responsavel em deletar as informaçoes selecionadas no banco de dados
    private boolean delete(){
        ProdutoDAO p = new ProdutoDAO();
        if (p.delete(this) == true) return true;
        else return false;
    }
    // metodo responsavel em fazer a atualização as informaçoes das variaveis no banco de dados
    private boolean update(){
        ProdutoDAO p = new ProdutoDAO();
        if (p.update(this) == true){
            JOptionPane.showMessageDialog(null,"Alteracao salva com sucesso");
            return true;
        }
        else return false;
    }
    // Metodo responsavel em formatar uma tabela para a classe produto
    public static DefaultTableModel getTableModel(){
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Descricao");
        modelo.addColumn("Estoque");
        modelo.addColumn("Ativo");
        modelo.addColumn("Custo");
        modelo.addColumn("Venda");
        for (Produto p: lista) {
            String[] reg = {String.valueOf(p.getCodigo()),p.getDescricao(),String.valueOf(p.getEstoque()),String.valueOf(p.isAtivo()),String.valueOf(p.getCusto()),String.valueOf(p.getVenda())};
            modelo.addRow(reg);
        }
        return modelo;
    } 
}
