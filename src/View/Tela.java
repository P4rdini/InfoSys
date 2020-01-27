/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cliente;
import Model.Produto;
import Model.Tecnico;
import Util.Mascara;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import sun.applet.Main;
import sun.text.normalizer.Replaceable;

/**
 * Classe responsavel pela parte visual da aplicacao 
 * @author rafa_
 */
public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    public Tela() {
        // metodo responsavel pelos componentes da tela
        initComponents();
        // metodo resonsavel em setar os campos de formatacao 
        setMask();
        // metodo que seta o focu no componente Nome do Cliente
        tfCliNome.requestFocus();
        // metodo que faz o redimencionamento do logo da aplicacao
        Redimencionamento();
        // metodo que deixa como padrao 0 no componente Custo do objeto Produto
        tfProCusto.setValue(0.00);
        // metodo que deixa como padrao 0 no componente venda do objeto Produto
        tfProVenda.setValue(0.00);
        // metodo que deixa como padrao 0 no componente salario do objeto Tecnico
        tfTecSalario.setValue(0.00);
        // metodo que deixa como padrao 0 no componente Valor_hora do objeto Tecnico
        tfTecValorHora.setValue(0.00);
        
    }

   /* public Tela(JFormattedTextField tfCliCPF, JFormattedTextField tfCliCelular, JTextField tfCliEmail, JTextField tfCliNome) {
        this.tfCliCPF = tfCliCPF;
        this.tfCliCelular = tfCliCelular;
        this.tfCliEmail = tfCliEmail;
        this.tfCliNome = tfCliNome;
     
    }*/
    
       
    // metodo que faz a formatar dos componentes 
     public void setMask(){
         tfCliCPF.setFormatterFactory(Mascara.getCpfMask());
         tfCliTelefone.setFormatterFactory(Mascara.getFoneFixoMask());
         tfCliCelular.setFormatterFactory(Mascara.getCelularMask());
         tfProCusto.setFormatterFactory(Mascara.getValorMask());
         tfProVenda.setFormatterFactory(Mascara.getValorMask());
         tfTecSalario.setFormatterFactory(Mascara.getValorMask());
         tfTecValorHora.setFormatterFactory(Mascara.getValorMask());
        
     }
        // metodo que limpa todos os valores preenchidos no campos da tela Produto
        public void LimparProduto (){
            tfProDescricao.setText("");
            spProEstoque.setValue(0);
            cbProAtivo.setSelected(true);
            tfProCusto.setText("0,00");
            tfProVenda.setText("0,00");
        }
        // metodo que limpa todos os valores preenchidos no campos da tela Cliente
        public void LimparCliente(){
            tfCliNome.setText("");
            tfCliCPF.setText("");
            tfCliCelular.setText("");
            tfCliTelefone.setText("");
            tfCliEmail.setText("");
        }
        // metodo que limpa todos os valores preenchidos no campos da tela Tecnico
        public void LimparTecnico(){
            tfTecNome.setText("");
            tfTecSalario.setText("0,00");
            tfTecValorHora.setText("0,00");
            tfTecNome.requestFocus();
        }
        // metodo responsavel em pegar os valores preenchidos nos campos Cliente e criar um objeto Cliente 
        public void GravarCliente (){
            String nome = tfCliNome.getText();
            String cpf = tfCliCPF.getText();
            String fone = tfCliTelefone.getText();
            String celular = tfCliTelefone.getText();
            String email = tfCliEmail.getText();
            System.out.println(new Cliente(nome,cpf,fone,celular,email));
            LimparCliente();
        }
        // metodo responsavel em pegar os valores preenchidos nos campos Produto e criar um objeto Produto 
        public void GravarProduto(){
            String descricao = tfProDescricao.getText();
            int estoque = (int) spProEstoque.getValue();
            boolean ativo = Boolean.parseBoolean(cbProAtivo.getText());
            double Custo = Util.Mascara.converterpVirgulaEmPonto(tfProCusto.getText());
            double Venda = Util.Mascara.converterpVirgulaEmPonto(tfProVenda.getText());
            System.out.println(new Produto(descricao,estoque,ativo,Custo,Venda));
            LimparProduto();
        }
        // metodo responsavel em pegar os valores preenchidos nos campos Tecnico e criar um objeto Tecnico 
        public void GravarTecnico(){
            String Nome = tfTecNome.getText();
            double Salario = Util.Mascara.converterpVirgulaEmPonto(tfTecSalario.getText());
            double vlHora = Util.Mascara.converterpVirgulaEmPonto(tfTecValorHora.getText());
            System.out.println(new Tecnico(Nome,Salario,vlHora));
            LimparTecnico();
        }
    
        // metodo responsavel em fazer o redimencionamento de imagem
        public void Redimencionamento (){
            ImageIcon imagem = new ImageIcon(Main.class.getResource("/Resources/InfoSysLogo-Grande.png"));
            Image img = imagem.getImage().getScaledInstance(lbIcon.getWidth(),lbIcon.getHeight(),1);
            lbIcon.setIcon(new ImageIcon(img));
        }
                

        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        pnRodape = new javax.swing.JPanel();
        btLimpar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btLista = new javax.swing.JButton();
        pnCentral = new javax.swing.JTabbedPane();
        pnCliente = new javax.swing.JPanel();
        lbCliNome = new javax.swing.JLabel();
        lbCliCpf = new javax.swing.JLabel();
        lbCliTelefone = new javax.swing.JLabel();
        lbCliCelular = new javax.swing.JLabel();
        lbCliEmail = new javax.swing.JLabel();
        tfCliEmail = new javax.swing.JTextField();
        tfCliNome = new javax.swing.JTextField();
        tfCliCPF = new javax.swing.JFormattedTextField();
        tfCliTelefone = new javax.swing.JFormattedTextField();
        tfCliCelular = new javax.swing.JFormattedTextField();
        pnProduto = new javax.swing.JPanel();
        lbProDescricao = new javax.swing.JLabel();
        tfProDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        spProEstoque = new javax.swing.JSpinner();
        cbProAtivo = new javax.swing.JCheckBox();
        pnProPreco = new javax.swing.JPanel();
        lbProCusto = new javax.swing.JLabel();
        lbProVenda = new javax.swing.JLabel();
        tfProCusto = new javax.swing.JFormattedTextField();
        tfProVenda = new javax.swing.JFormattedTextField();
        pnServico = new javax.swing.JPanel();
        pnTecnico = new javax.swing.JPanel();
        lbTecNome = new javax.swing.JLabel();
        lbtecSalario = new javax.swing.JLabel();
        lbTecValorHora = new javax.swing.JLabel();
        tfTecNome = new javax.swing.JTextField();
        tfTecSalario = new javax.swing.JFormattedTextField();
        tfTecValorHora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setBackground(new java.awt.Color(255, 255, 0));
        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        lbTitulo.setText("Cadastro");
        lbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnTitulo.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 10, 180, -1));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/InfoSysLogo-Grande.png"))); // NOI18N
        pnTitulo.add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btLista.setText("Listar");
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRodapeLayout = new javax.swing.GroupLayout(pnRodape);
        pnRodape.setLayout(pnRodapeLayout);
        pnRodapeLayout.setHorizontalGroup(
            pnRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRodapeLayout.createSequentialGroup()
                .addComponent(btLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btLimpar))
        );
        pnRodapeLayout.setVerticalGroup(
            pnRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRodapeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btGravar)
                    .addComponent(btLista))
                .addContainerGap())
        );

        pnCliente.setLayout(new java.awt.GridBagLayout());

        lbCliNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCliNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 39, 0, 0);
        pnCliente.add(lbCliNome, gridBagConstraints);

        lbCliCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCliCpf.setText("CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 43, 0, 0);
        pnCliente.add(lbCliCpf, gridBagConstraints);

        lbCliTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCliTelefone.setText("Telefone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 15, 0, 0);
        pnCliente.add(lbCliTelefone, gridBagConstraints);

        lbCliCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCliCelular.setText("Celular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 25, 0, 0);
        pnCliente.add(lbCliCelular, gridBagConstraints);

        lbCliEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbCliEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 35, 0, 0);
        pnCliente.add(lbCliEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 233;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 8, 16, 30);
        pnCliente.add(tfCliEmail, gridBagConstraints);

        tfCliNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCliNomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 9, 0, 30);
        pnCliente.add(tfCliNome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 9, 0, 0);
        pnCliente.add(tfCliCPF, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 83;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 9, 0, 0);
        pnCliente.add(tfCliTelefone, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 8, 0, 0);
        pnCliente.add(tfCliCelular, gridBagConstraints);

        pnCentral.addTab("Clientes", pnCliente);

        lbProDescricao.setText("Descricao:");

        jLabel1.setText("Estoque:");

        spProEstoque.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spProEstoqueStateChanged(evt);
            }
        });

        cbProAtivo.setText("Ativo");

        pnProPreco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Preco"));

        lbProCusto.setText("Custo:");

        lbProVenda.setText("Venda:");

        javax.swing.GroupLayout pnProPrecoLayout = new javax.swing.GroupLayout(pnProPreco);
        pnProPreco.setLayout(pnProPrecoLayout);
        pnProPrecoLayout.setHorizontalGroup(
            pnProPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProPrecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProCusto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfProCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbProVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfProVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnProPrecoLayout.setVerticalGroup(
            pnProPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProPrecoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnProPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProCusto)
                    .addComponent(lbProVenda)
                    .addComponent(tfProCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnProdutoLayout = new javax.swing.GroupLayout(pnProduto);
        pnProduto.setLayout(pnProdutoLayout);
        pnProdutoLayout.setHorizontalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProdutoLayout.createSequentialGroup()
                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lbProDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnProdutoLayout.createSequentialGroup()
                                .addComponent(spProEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145)
                                .addComponent(cbProAtivo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfProDescricao)))
                    .addComponent(pnProPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        pnProdutoLayout.setVerticalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProdutoLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProDescricao)
                    .addComponent(tfProDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spProEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProAtivo))
                .addGap(18, 18, 18)
                .addComponent(pnProPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pnCentral.addTab("Produtos", pnProduto);

        javax.swing.GroupLayout pnServicoLayout = new javax.swing.GroupLayout(pnServico);
        pnServico.setLayout(pnServicoLayout);
        pnServicoLayout.setHorizontalGroup(
            pnServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        pnServicoLayout.setVerticalGroup(
            pnServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );

        pnCentral.addTab("Serviços", pnServico);

        lbTecNome.setText("Nome:");

        lbtecSalario.setText("Salario:");

        lbTecValorHora.setText("Valor da hora:");

        javax.swing.GroupLayout pnTecnicoLayout = new javax.swing.GroupLayout(pnTecnico);
        pnTecnico.setLayout(pnTecnicoLayout);
        pnTecnicoLayout.setHorizontalGroup(
            pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTecnicoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTecValorHora)
                    .addComponent(lbTecNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtecSalario, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTecnicoLayout.createSequentialGroup()
                        .addGroup(pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTecSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(tfTecValorHora))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfTecNome, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTecnicoLayout.setVerticalGroup(
            pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTecnicoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTecNome)
                    .addComponent(tfTecNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbtecSalario)
                    .addComponent(tfTecSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTecValorHora)
                    .addComponent(tfTecValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pnCentral.addTab("Tecnicos", pnTecnico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnCentral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCentral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Botao responsavel em limpar todos os campos da tela
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
       if (pnCentral.getSelectedComponent() == pnProduto){
           LimparProduto();
       }else if (pnCentral.getSelectedComponent() == pnCliente){
           LimparCliente();
       }else if (pnCentral.getSelectedComponent() == pnTecnico){
          LimparTecnico();
       }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btLimparActionPerformed
    // Botao responsavel em gravar os dados preenchidos nos campos da tela 
    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
       if (pnCentral.getSelectedComponent() == pnCliente){
           GravarCliente();
       }else if (pnCentral.getSelectedComponent() == pnProduto){
           GravarProduto();
       }else if (pnCentral.getSelectedComponent()== pnTecnico){
           GravarTecnico();
       }
          
    }//GEN-LAST:event_btGravarActionPerformed
    // Metodo responsavel em informar o estado no botao estoque da tela Produto
    private void spProEstoqueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spProEstoqueStateChanged
       int v = (int) spProEstoque.getValue();
       if (v < 0) spProEstoque.setValue(0);
    }//GEN-LAST:event_spProEstoqueStateChanged
    // botao responsavel em mostrar a tela consulta dos seus respectivos objetos
    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
       TelaConsulta t = new TelaConsulta();
       
       if (pnCentral.getSelectedComponent() == pnCliente){
           t.montaTabelaCliente(1);
           
       }else if (pnCentral.getSelectedComponent() == pnProduto){
           t.montarTabelaProduto(2);
          
       }else {
           t.montatabelaTecnico(3);
           
       }
       t.setVisible(true);
      
    }//GEN-LAST:event_btListaActionPerformed

    private void tfCliNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCliNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCliNomeActionPerformed

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
             /*   if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } */
     
                   UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel"); 
                 
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btLista;
    private javax.swing.JCheckBox cbProAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCliCelular;
    private javax.swing.JLabel lbCliCpf;
    private javax.swing.JLabel lbCliEmail;
    private javax.swing.JLabel lbCliNome;
    private javax.swing.JLabel lbCliTelefone;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbProCusto;
    private javax.swing.JLabel lbProDescricao;
    private javax.swing.JLabel lbProVenda;
    private javax.swing.JLabel lbTecNome;
    private javax.swing.JLabel lbTecValorHora;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbtecSalario;
    private javax.swing.JTabbedPane pnCentral;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnProPreco;
    private javax.swing.JPanel pnProduto;
    private javax.swing.JPanel pnRodape;
    private javax.swing.JPanel pnServico;
    private javax.swing.JPanel pnTecnico;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSpinner spProEstoque;
    private javax.swing.JFormattedTextField tfCliCPF;
    private javax.swing.JFormattedTextField tfCliCelular;
    private javax.swing.JTextField tfCliEmail;
    private javax.swing.JTextField tfCliNome;
    private javax.swing.JFormattedTextField tfCliTelefone;
    private javax.swing.JFormattedTextField tfProCusto;
    private javax.swing.JTextField tfProDescricao;
    private javax.swing.JFormattedTextField tfProVenda;
    private javax.swing.JTextField tfTecNome;
    private javax.swing.JFormattedTextField tfTecSalario;
    private javax.swing.JFormattedTextField tfTecValorHora;
    // End of variables declaration//GEN-END:variables
}
