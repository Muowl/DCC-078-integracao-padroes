package br.com.atividade.padroes;

import java.util.Locale;

public final class MetodoFabrica {

    private static final MetodoFabrica instancia = new MetodoFabrica();

    private MetodoFabrica() {
    }

    public static MetodoFabrica getInstancia() {
        return instancia;
    }

    public FabricaAbstrata criarFabrica(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo da fábrica não pode ser nulo.");
        }

        return switch (tipo.trim().toUpperCase(Locale.ROOT)) {
            case "PJ" -> new FabricaPJ();
            case "PF" -> new FabricaPF();
            default -> throw new IllegalArgumentException(
                    "Tipo de fábrica desconhecido: " + tipo);
        };
    }
}
