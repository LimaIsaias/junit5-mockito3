package br.com.limaisaias.model;

import br.com.limaisaias.exception.CadastroVazioException;
import br.com.limaisaias.exception.PessoaSemNomeNotException;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    public CadastroPessoas() {
        pessoas = new ArrayList<>();
    }

    public CadastroPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    private List<Pessoa> pessoas;


    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionar(Pessoa pessoa) {
        if (pessoa.getNome() == null) {
            throw new PessoaSemNomeNotException();
        }
        this.pessoas.add(pessoa);

    }

    public void remover(Pessoa pessoa) {
        if (getPessoas().isEmpty()) {
            throw new CadastroVazioException();
        }

        getPessoas().remove(pessoa);
    }
}
