package br.com.victor;

public class TabelaAtividade {

    @Tabela("getNome")
    private String nome;

    public TabelaAtividade (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
