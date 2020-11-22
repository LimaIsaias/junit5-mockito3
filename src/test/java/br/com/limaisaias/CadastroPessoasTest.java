package br.com.limaisaias;

import br.com.limaisaias.exception.CadastroVazioException;
import br.com.limaisaias.exception.PessoaSemNomeNotException;
import br.com.limaisaias.model.CadastroPessoas;
import br.com.limaisaias.model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas ")
    public void deveCriarCadastroPessoas() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa")
    public void deveAdicionarUmaPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("isis");
        cadastro.adicionar(pessoa);

        Assertions.assertThat(cadastro.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);

    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void deveRemoverPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("isis");
        cadastro.adicionar(pessoa);

        cadastro.remover(pessoa);
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("não deve remover uma pessoa inexistente")
    public void deveRetornarErroAoRemoverPessoaInexistente() {

        CadastroPessoas cadastro = new CadastroPessoas();


        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class, () -> cadastro.remover(new Pessoa()));

    }

    @Test
    @DisplayName("não deve cadastrar uma pessoa com nome vazio")
    public void naoDeveCadastrarPessoaComNomeVazio() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        Pessoa pessoa = new Pessoa();
        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeNotException.class, () -> cadastroPessoas.adicionar(pessoa));


    }

}
