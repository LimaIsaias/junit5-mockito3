package br.com.limaisaias;

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
    public void deveRetornarErroAoRemoverPessoaInexistente() {

        CadastroPessoas cadastro = new CadastroPessoas();
        cadastro.remover(new Pessoa());

    }

    @Test
    public void naoDeveCadastrarPessoaComNomeVazio() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        Pessoa pessoa = new Pessoa();

        cadastroPessoas.adicionar(pessoa);
    }

}
