package br.com.atividade.padroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaAbstrataTest {

    @Test
    void operacoesUsamOsFactoryMethodsDaSubclasse() {
        boolean[] executados = {false, false};
        Procuracao procuracao = () -> executados[0] = true;
        Contrato contrato = () -> executados[1] = true;

        FabricaAbstrata fabrica = new FabricaAbstrata() {
            @Override
            public Procuracao criarProcuracao() {
                return procuracao;
            }

            @Override
            public Contrato criarContrato() {
                return contrato;
            }
        };

        var cliente = new Cliente("Cliente de teste");
        assertSame(procuracao, cliente.solicitarProcuracao(fabrica));
        assertSame(contrato, cliente.solicitarContrato(fabrica));
        assertTrue(executados[0]);
        assertTrue(executados[1]);
    }
}
