package br.com.atividade.padroes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class IntegracaoPadroesTest {

    @ParameterizedTest
    @CsvSource({"PF, física", "PJ, jurídica", "pf, física", "pj, jurídica"})
    void clienteRecebeEExecutaDocumentosDaMesmaFamilia(String tipo, String pessoa) {
        var fabrica = MetodoFabrica.getInstancia().criarFabrica(" " + tipo + " ");
        var cliente = new Cliente("Felipe");
        var saida = new ByteArrayOutputStream();
        PrintStream original = System.out;
        Procuracao procuracao;
        Contrato contrato;

        try (var captura = new PrintStream(saida, true, StandardCharsets.UTF_8)) {
            System.setOut(captura);
            procuracao = cliente.solicitarProcuracao(fabrica);
            contrato = cliente.solicitarContrato(fabrica);
        } finally {
            System.setOut(original);
        }

        if (tipo.equalsIgnoreCase("PF")) {
            assertInstanceOf(FabricaPF.class, fabrica);
            assertInstanceOf(ProcuracaoPF.class, procuracao);
            assertInstanceOf(ContratoPF.class, contrato);
        } else {
            assertInstanceOf(FabricaPJ.class, fabrica);
            assertInstanceOf(ProcuracaoPJ.class, procuracao);
            assertInstanceOf(ContratoPJ.class, contrato);
        }
        String mensagens = saida.toString(StandardCharsets.UTF_8);
        assertEquals("Emitindo procuração para pessoa " + pessoa + "." + System.lineSeparator()
                + "Assinando contrato para pessoa " + pessoa + "." + System.lineSeparator(), mensagens);
        assertNotSame(procuracao, fabrica.criarProcuracao());
        assertNotSame(contrato, fabrica.criarContrato());
    }
}
