/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ClienteDAO;
import DAO.TecnicoDAO;
import Model.Cliente;
import Model.Produto;
import Model.Tecnico;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.html.HTML;
import sun.applet.Main;

/**
 * Classe que mostra, deleta e altera os dados salvo no banco de dados dos seus respectivos objetos
 * @author rafa_
 */
public class TelaConsulta extends javax.swing.JFrame {

    /**
     * Creates new form TelaConsulta
     */
    // variavel que informa a tela de qual objeto pertence, sendo 1= Cliente,2=Produto e 3=Tecnico
    private int num =0 ;
    public TelaConsulta() {
        // metodo responsavel pelos componentes da tela
        initComponents();
        // metodo responsavel no redimencionamento de imagens
        Redimencionamento();
        
    
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

  
     
    
    // metodo responsavel em redimencionar a imagem do log da aplicacao
    public void Redimencionamento (){
            ImageIcon imagem = new ImageIcon(Main.class.getResource("/Resources/InfoSysLogo-Grande.png"));
            Image img = imagem.getImage().getScaledInstance(lbConIcone.getWidth(),lbConIcone.getHeight(),1);
            lbConIcone.setIcon(new ImageIcon(img));
        }
    /**
     *  Metodo responsavel em formatar da tabela da tela para objeto Cliente
     * @param num variavel que informa a tela de qual objeto pertence, sendo 1= Cliente,2=Produto e 3=Tecnico 
     */
    protected void montaTabelaCliente(int num){
        tbConsulta.setModel(Cliente.getTableModel());
        setNum(num);
    }
    /**
     * Metodo responsavel em formatar da tabela da tela para objeto Produto
     * @param num variavel que informa a tela de qual objeto pertence, sendo 1= Cliente,2=Produto e 3=Tecnico
     */
    protected void montarTabelaProduto(int num){
        tbConsulta.setModel(Produto.getTableModel());
        setNum(num);
    }
    /**
     * Metodo responsavel em formatar da tabela da tela para objeto Tecnico
     * @param num variavel que informa a tela de qual objeto pertence, sendo 1= Cliente,2=Produto e 3=Tecnico
     */
    protected void montatabelaTecnico(int num){
        tbConsulta.setModel(Tecnico.getTableModel());
        setNum(num);
    }
 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        pnConTiTulo = new javax.swing.JPanel();
        lbConIcone = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btConsultaDelete = new javax.swing.JButton();
        BtConsultaAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(397, 370));

        tbConsulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbConsulta);

        lbConIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/InfoSysLogo-Grande.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Consultas");

        javax.swing.GroupLayout pnConTiTuloLayout = new javax.swing.GroupLayout(pnConTiTulo);
        pnConTiTulo.setLayout(pnConTiTuloLayout);
        pnConTiTuloLayout.setHorizontalGroup(
            pnConTiTuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConTiTuloLayout.createSequentialGroup()
                .addComponent(lbConIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnConTiTuloLayout.setVerticalGroup(
            pnConTiTuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbConIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pnConTiTuloLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btConsultaDelete.setText("Deletar");
        btConsultaDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaDeleteActionPerformed(evt);
            }
        });

        BtConsultaAtualizar.setText("Atualizar");
        BtConsultaAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultaAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btConsultaDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtConsultaAtualizar)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsultaDelete)
                    .addComponent(BtConsultaAtualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
            .addComponent(pnConTiTulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnConTiTulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
     
    }//GEN-LAST:event_tbConsultaMouseClicked
    /**
     *  Botao responsavel em fazer a exclusao no banco de dados da linha selecionada
     * @param evt 
     */
    private void btConsultaDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaDeleteActionPerformed
       DefaultTableModel t = Tecnico.getTableModel();
       DefaultTableModel c = Cliente.getTableModel();
       DefaultTableModel p = Produto.getTableModel();
            int resp = tbConsulta.getSelectedRow();
            
        if (tbConsulta.getSelectedRow() != -1)
        {
            if (getNum() == 3)
                {
                    int id =Integer.parseInt((String) t.getValueAt(resp, 0));
                    Tecnico tecnico = new Tecnico(id);
                    montatabelaTecnico(3);
                         
                 }   else if (getNum() == 1)
                          {
                            int id =Integer.parseInt((String) c.getValueAt(resp, 0));
                            new Cliente(id);
                            montaTabelaCliente(1);
                            
                          }else if (getNum() == 2)
                                { 
                                    int id =Integer.parseInt((String) p.getValueAt(resp, 0));
                                    Produto produto = new Produto(id);
                                    montarTabelaProduto(2);
                                }
        }
       
        
        
    }//GEN-LAST:event_btConsultaDeleteActionPerformed
    /**
     * Botao responsavel em fazer a atualizacao no banco de dados da linha selecionada
     * @param evt 
     */
    private void BtConsultaAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultaAtualizarActionPerformed
        int linha = tbConsulta.getSelectedRow();
       int codigo = Integer.parseInt((String) tbConsulta.getValueAt(linha, 0));
        if (linha != -1)
        {
            if (getNum() == 1)
            {
                String nome = JOptionPane.showInputDialog("Digite novo Nome:");
                String cpf = JOptionPane.showInputDialog("Digite novo CPF:");
                String fone = JOptionPane.showInputDialog("Digite novo Telefone:");
                String celular = JOptionPane.showInputDialog("Digite novo Celular:");
                String email = JOptionPane.showInputDialog("Digite novo Email:");
                new Cliente(nome, cpf, fone, celular, email,codigo);
                montaTabelaCliente(1);
            }else if(getNum() == 2)
                    {
                        try{
                        String descricao = JOptionPane.showInputDialog("Digite a nova Descricao");
                        int estoque = Integer.parseInt((JOptionPane.showInputDialog("Digite o novo Estoque")));
                        boolean ativo = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite TRUE para Ativo , ou FALSE para Inativo"));
                        double custo = Double.parseDouble(JOptionPane.showInputDialog("Digite um novo Custo:"));
                        double venda = Double.parseDouble(JOptionPane.showInputDialog("Digite uma nova Venda"));
                        new Produto(descricao, estoque, ativo, venda, custo, codigo);
                        montarTabelaProduto(2);
                        }catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(null,"Preencha corratamento os campos");
                        }
                    }else if (getNum() == 3)
                            {
                                String nome = JOptionPane.showInputDialog("Digite novo Nome");
                                try{
                                double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite novo Salario"));
                                double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Digite novo Valor da Hora"));
                                new Tecnico(nome, salario, valorHora, codigo);
                                montatabelaTecnico(3);
                                }catch(NumberFormatException e){
                                    JOptionPane.showMessageDialog(null,"Preencha corratamento os campos");
                                }
                            }
        }
    }//GEN-LAST:event_BtConsultaAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtConsultaAtualizar;
    private javax.swing.JButton btConsultaDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbConIcone;
    private javax.swing.JPanel pnConTiTulo;
    private javax.swing.JTable tbConsulta;
    // End of variables declaration//GEN-END:variables
}