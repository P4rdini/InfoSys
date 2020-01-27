/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.TecnicoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsavel em criar os atributos e metodos da classe TECNICO
 * @author rafa_
 */
public class Tecnico {
    // variavel que armazena o id da inserção no banco de dados.
    private int codigo =0 ;
    // armazena o nome do Tecnico
    private String Name = null;
    // armazena o salario do tecnico
    private double Salario =0.00;
    // armazena o quando o tecnico ganho por hora
    private double valorHora=0.00;


    // Metodo construtor que grava as informoes no banco de dados atravez do metodo gravar()
    public Tecnico(String Name, Double Salario, Double valorHora) {
        setName(Name);
        setSalario(Salario);
        setValorHora(valorHora);
        gravar();
    }

    // Metodo construtor que as informaoes nas variaveis 
    public Tecnico(int codigo, String Nome, double salario, double Valor) {
        setCodigo(codigo);
        setName(Nome);
        setSalario(salario);
        setValorHora(Valor);
    }
    // Metodo construtor que faz a atualizacao das variaveis no banco de dados atravez do metodo update()
    public Tecnico(String Nome, double salario, double Valor,int codigo) {
        setCodigo(codigo);
        setName(Nome);
        setSalario(salario);
        setValorHora(Valor);
        update();
    }
    // Metodo construtor responsavel em fazer a exclusao no banco de dados atravez do metodo delete usando a varivael codigo
    public Tecnico(int id){
        setCodigo(id);
        delete();
    }


   
    
    @Override
    public String toString() {
        return "Tecnico{" + "Name=" + Name +
                       ", Salario=" + Salario +
                       ", valorHora=" + valorHora + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
    // Metodo responsavel em salvar as informacoes no banco de dados
    private void gravar(){
        TecnicoDAO t = new TecnicoDAO();
        int codigo = t.create(this);
        if ( codigo >0 ) setCodigo(codigo);
    }
    // metodo responsavel em fazer a exclusao no banco de dados
    private boolean delete(){
        TecnicoDAO t = new TecnicoDAO();
         if ( t.delete(this) == true){
             JOptionPane.showMessageDialog(null, "item excluido com sucesso");
             return true;
         }else {
             JOptionPane.showMessageDialog(null, "nao foi possivel excluir");
             return false;
         }
    }
    // metodo responsavel em fazer a atualizacao dos dados no banco de dados
    private boolean update(){
        TecnicoDAO t = new TecnicoDAO();
        if (t.update(this) == true){
            JOptionPane.showMessageDialog(null,"Alteracao salva com sucesso");
            return true;
        }else return false;
    }
    
    // Metodo responsavel em formatar uma tabela para objeto Tecnico
    public static DefaultTableModel getTableModel(){
        TecnicoDAO t = new TecnicoDAO();
        List<Tecnico> lista = t.read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Salario");
        modelo.addColumn("Valor da hora");
        for (Tecnico d: lista){
            String[] reg = {String.valueOf(d.getCodigo()),d.getName(),String.valueOf(d.getSalario()),String.valueOf(d.getValorHora())};
            modelo.addRow(reg);
        }
        return modelo;
    }
    
}
