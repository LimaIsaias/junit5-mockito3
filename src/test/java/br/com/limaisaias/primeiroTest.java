package br.com.limaisaias;


import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class primeiroTest {

    @Test
    public void deveSomarDoisNumeros() {
        //cenário
        int a = 10;
        int b = 5;
        //execução
        int result = a + b;
        //verificações
        Assertions.assertThat(result).isBetween(14, 16);
    }

}
