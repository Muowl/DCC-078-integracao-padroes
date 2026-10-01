package br.com.atividade.padroes;

public class FabricaPJ extends FabricaAbstrata {

    @Override
    public ProcuracaoPJ criarProcuracao() {
        return new ProcuracaoPJ();
    }

    @Override
    public ContratoPJ criarContrato() {
        return new ContratoPJ();
    }
}
