package br.com.limaisaias;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class MockitoTest {

    //Instancia-se um objeto mock;
    @Mock
    List<String> lista;


    @Test
    @DisplayName("Deve validar se metodo size() foi chamado")
    public void validaSeMetodoFoiChamado() {
        lista.size();
        Mockito.verify(lista).size();
    }

    @Test
    @DisplayName("Deve validar se metodo size() foi chamado apenas uma unica vez.")
    public void validaSeMetodoFoiChamadoEquantidadeDeVezesQueFoiChamado() {
        lista.size();
        Mockito.verify(lista, Mockito.times(1)).size();
    }

    @Test
    @DisplayName("Deve validar se metodo clear() não foi chamado")
    public void validaSeMetodoClearNaoFoiExecutado() {
        Mockito.verify(lista, Mockito.never()).clear();
    }

}
