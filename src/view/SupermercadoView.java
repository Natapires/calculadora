package view;

import controller.SupermercadoController;
import model.ConfiguracaoSupermercado;
import model.Produto;
import model.ProdutoTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SupermercadoView {
    private final SupermercadoController supermercadoController;
    private JFrame janelaPrincipal;
    private JTextField txtNomeProduto;
    private JTextField txtPrecoProduto;
    private JTable tabelaProdutos;

    public SupermercadoView(SupermercadoController supermercadoController) {
        this.supermercadoController = supermercadoController;
    }

    public void exibirJanelaPrincipal() {
        janelaPrincipal = new JFrame("Supermercado");
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setSize(800, 600);
        janelaPrincipal.setLayout(new BorderLayout());

        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNomeSupermercado = new JLabel("Nome do Supermercado:");
        JTextField txtNomeSupermercado = new JTextField(20);
        JButton btnSalvarConfiguracao = new JButton("Salvar");
        painelSuperior.add(lblNomeSupermercado);
        painelSuperior.add(txtNomeSupermercado);
        painelSuperior.add(btnSalvarConfiguracao);

        JPanel painelCentral = new JPanel(new BorderLayout());

        JPanel painelProdutos = new JPanel(new BorderLayout());
        JLabel lblTituloProdutos = new JLabel("Produtos");
        tabelaProdutos = new JTable();
        JScrollPane scrollPaneProdutos = new JScrollPane(tabelaProdutos);
        painelProdutos.add(lblTituloProdutos, BorderLayout.NORTH);
        painelProdutos.add(scrollPaneProdutos, BorderLayout.CENTER);

        JPanel painelFormularioProduto = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNomeProduto = new JLabel("Nome do Produto:");
        txtNomeProduto = new JTextField(20);
        JLabel lblPrecoProduto = new JLabel("Preço do Produto:");
        txtPrecoProduto = new JTextField(10);
        JButton btnAdicionarProduto = new JButton("Adicionar");
        painelFormularioProduto.add(lblNomeProduto);
        painelFormularioProduto.add(txtNomeProduto);
        painelFormularioProduto.add(lblPrecoProduto);
        painelFormularioProduto.add(txtPrecoProduto);
        painelFormularioProduto.add(btnAdicionarProduto);

        painelCentral.add(painelProdutos, BorderLayout.CENTER);
        painelCentral.add(painelFormularioProduto, BorderLayout.SOUTH);

        janelaPrincipal.add(painelSuperior, BorderLayout.NORTH);
        janelaPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Ação do botão "Salvar" para atualizar a configuração do supermercado
        btnSalvarConfiguracao.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nomeSupermercado = txtNomeSupermercado.getText();
                ConfiguracaoSupermercado configuracao = new ConfiguracaoSupermercado(nomeSupermercado, "");
                supermercadoController.atualizarConfiguracaoSupermercado(configuracao);
                JOptionPane.showMessageDialog(janelaPrincipal, "Configuração do supermercado atualizada.");
            }
        });

        // Ação do botão "Adicionar" para adicionar um novo produto
        btnAdicionarProduto.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nomeProduto = txtNomeProduto.getText();
                double precoProduto = Double.parseDouble(txtPrecoProduto.getText());
                Produto produto = new Produto(0, nomeProduto, precoProduto);
                supermercadoController.adicionarProduto(produto);
                JOptionPane.showMessageDialog(janelaPrincipal, "Produto adicionado.");
                atualizarTabelaProdutos();
                limparCamposProduto();
            }
        });

        janelaPrincipal.setVisible(true);
        carregarConfiguracaoSupermercado();
        atualizarTabelaProdutos();
    }

    public void atualizarTabelaProdutos() {
        List<Produto> produtos = supermercadoController.listarProdutos();
        ProdutoTableModel tableModel = new ProdutoTableModel(produtos);
        tabelaProdutos.setModel(tableModel);
    }

    public void carregarConfiguracaoSupermercado() {
        ConfiguracaoSupermercado configuracao = supermercadoController.getConfiguracaoSupermercado();
        if (configuracao != null) {
            JTextField txtNomeSupermercado = (JTextField) ((JPanel) janelaPrincipal.getContentPane().getComponent(0)).getComponent(1);
            txtNomeSupermercado.setText(configuracao.getNomeSupermercado());
        }
    }

    public void limparCamposProduto() {
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
    }
}
