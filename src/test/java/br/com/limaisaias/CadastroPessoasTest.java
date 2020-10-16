package br.com.limaisaias;

import br.com.limaisaias.exception.CadastroVazioException;
import br.com.limaisaias.exception.PessoaSemNomeNotException;
import br.com.limaisaias.model.CadastroPessoas;
import br.com.limaisaias.model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test
    public void deveCriarCadastroPessoas() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("isis");
        cadastro.adicionar(pessoa);

        Assertions.assertThat(cadastro.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);

    }

    @Test
    public void deveRemoverPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("isis");
        cadastro.adicionar(pessoa);

        cadastro.remover(pessoa);
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveRetornarErroAoRemoverPessoaInexistente(){

        CadastroPessoas cadastro = new CadastroPessoas();
        cadastro.remover(new Pessoa());

    }

    @Test(expected = PessoaSemNomeNotException.class)
    public void naoDeveCadastrarPessoaComNomeVazio() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        Pessoa pessoa = new Pessoa();

        cadastroPessoas.adicionar(pessoa);
    }

}
