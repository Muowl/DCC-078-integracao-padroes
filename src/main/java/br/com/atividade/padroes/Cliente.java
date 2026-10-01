package br.com.atividade.padroes;

public class Cliente {

    private final String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Procuracao solicitarProcuracao(FabricaAbstrata fabrica) {
        return fabrica.emitirProcuracao();
    }

    public Contrato solicitarContrato(FabricaAbstrata fabrica) {
        return fabrica.assinarContrato();
    }
}
