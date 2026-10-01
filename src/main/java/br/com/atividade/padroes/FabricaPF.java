package br.com.atividade.padroes;

public class FabricaPF extends FabricaAbstrata {

    @Override
    public ProcuracaoPF criarProcuracao() {
        return new ProcuracaoPF();
    }

    @Override
    public ContratoPF criarContrato() {
        return new ContratoPF();
    }
}
