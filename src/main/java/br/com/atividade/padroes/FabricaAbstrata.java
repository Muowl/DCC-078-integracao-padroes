package br.com.atividade.padroes;

public abstract class FabricaAbstrata {

    public abstract Procuracao criarProcuracao();

    public abstract Contrato criarContrato();

    public final Procuracao emitirProcuracao() {
        Procuracao procuracao = criarProcuracao();
        procuracao.emitir();
        return procuracao;
    }

    public final Contrato assinarContrato() {
        Contrato contrato = criarContrato();
        contrato.assinar();
        return contrato;
    }
}
