package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProdutoTableModel extends AbstractTableModel {
    private List<Produto> produtos;
    private String[] colunas = {"ID", "Nome", "Preço"};

    public ProdutoTableModel(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return produto.getId();
            case 1:
                return produto.getNome();
            case 2:
                return produto.getPreco();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
