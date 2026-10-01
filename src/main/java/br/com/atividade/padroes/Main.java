package br.com.atividade.padroes;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Cliente de exemplo");
        MetodoFabrica metodoFabrica = MetodoFabrica.getInstancia();
        FabricaAbstrata fabricaPJ = metodoFabrica.criarFabrica("PJ");
        FabricaAbstrata fabricaPF = metodoFabrica.criarFabrica("PF");

        cliente.solicitarProcuracao(fabricaPJ);
        cliente.solicitarContrato(fabricaPJ);
        cliente.solicitarProcuracao(fabricaPF);
        cliente.solicitarContrato(fabricaPF);

        System.out.println("Mesma instância de MetodoFabrica: "
                + (metodoFabrica == MetodoFabrica.getInstancia()));
    }
}
