package br.com.limaisaias;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    //Instancia-se um objeto mock;
    @Mock
    List<String> lista;


    @Test
    public void validaSeMetodoFoiChamado() {
        lista.size();
        Mockito.verify(lista).size();
    }

    @Test
    public void validaSeMetodoFoiChamadoEquantidadeDeVezesQueFoiChamado() {
        lista.size();
        Mockito.verify(lista, Mockito.times(1)).size();
    }

    @Test
    public void validaSeMetodoClearNaoFoiExecutado() {
        Mockito.verify(lista, Mockito.never()).clear();
    }

}
