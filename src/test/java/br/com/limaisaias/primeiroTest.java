package br.com.limaisaias;


import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class primeiroTest {

    @Test
    public void deveSomarDoisNumeros() {
        //cenário
        int a = 10;
        int b = 5;
        //execução
        int result = a + b;
        //verificações
        Assert.assertEquals(15, result);
        Assertions.assertThat(result).isBetween(14, 16);
    }

}
