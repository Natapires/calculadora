package model;

public class ConfiguracaoSupermercado {
    private String nomeSupermercado;
    private String endereco;

    public ConfiguracaoSupermercado(String nomeSupermercado, String endereco) {
        this.nomeSupermercado = nomeSupermercado;
        this.endereco = endereco;
    }

    // Getters e Setters

    public String getNomeSupermercado() {
        return nomeSupermercado;
    }

    public void setNomeSupermercado(String nomeSupermercado) {
        this.nomeSupermercado = nomeSupermercado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
