package controller;

import model.ConfiguracaoSupermercado;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupermercadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/supermercado_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "22061998";

    public void adicionarProduto(Produto produto) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO produtos (id, nome, preco) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, produto.getId());
            statement.setString(2, produto.getNome());
            statement.setDouble(3, produto.getPreco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProduto(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM produtos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT id, nome, preco FROM produtos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                Produto produto = new Produto(id, nome, preco);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public void atualizarConfiguracaoSupermercado(ConfiguracaoSupermercado configuracao) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE configuracao_supermercado SET nome = ?, endereco = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, configuracao.getNomeSupermercado());
            statement.setString(2, configuracao.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ConfiguracaoSupermercado getConfiguracaoSupermercado() {
        ConfiguracaoSupermercado configuracao = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT nome, endereco FROM configuracao_supermercado";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                configuracao = new ConfiguracaoSupermercado(nome, endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return configuracao;
    }
}
