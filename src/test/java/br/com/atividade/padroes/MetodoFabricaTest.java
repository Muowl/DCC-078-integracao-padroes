package br.com.atividade.padroes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Modifier;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MetodoFabricaTest {

    @Test
    void mantemUmaUnicaInstanciaInclusiveEntreThreads() throws Exception {
        var executor = Executors.newFixedThreadPool(4);
        try {
            var tarefas = IntStream.range(0, 20)
                    .mapToObj(i -> (Callable<MetodoFabrica>) MetodoFabrica::getInstancia)
                    .toList();
            for (var resultado : executor.invokeAll(tarefas)) {
                assertSame(MetodoFabrica.getInstancia(), resultado.get());
            }
        } finally {
            executor.shutdownNow();
        }
        assertTrue(Modifier.isPrivate(MetodoFabrica.class.getDeclaredConstructor().getModifiers()));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "MEI", "INVALIDO"})
    void rejeitaTiposInvalidos(String tipo) {
        assertThrows(IllegalArgumentException.class,
                () -> MetodoFabrica.getInstancia().criarFabrica(tipo));
    }
}
