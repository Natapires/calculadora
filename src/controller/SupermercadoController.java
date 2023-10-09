package controller;

import model.ConfiguracaoSupermercado;
import model.Produto;
import view.SupermercadoView;

import java.util.List;

public class SupermercadoController {
    private SupermercadoDAO supermercadoDAO;
    private SupermercadoView supermercadoView;

    public SupermercadoController() {
        this.supermercadoDAO = new SupermercadoDAO();
        this.supermercadoView = new SupermercadoView(this);
    }

    public void exibirJanelaPrincipal() {
        supermercadoView.exibirJanelaPrincipal();
    }

    public void adicionarProduto(Produto produto) {
        supermercadoDAO.adicionarProduto(produto);
    }

    public void removerProduto(int id) {
        supermercadoDAO.removerProduto(id);
    }

    public List<Produto> listarProdutos() {
        return supermercadoDAO.listarProdutos();
    }

    public void atualizarConfiguracaoSupermercado(ConfiguracaoSupermercado configuracao) {
        supermercadoDAO.atualizarConfiguracaoSupermercado(configuracao);
    }

    public ConfiguracaoSupermercado getConfiguracaoSupermercado() {
        return supermercadoDAO.getConfiguracaoSupermercado();
    }
}
