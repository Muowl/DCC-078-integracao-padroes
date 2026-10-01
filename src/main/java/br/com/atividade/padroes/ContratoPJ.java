package br.com.atividade.padroes;

public class ContratoPJ implements Contrato {

    @Override
    public void assinar() {
        System.out.println("Assinando contrato para pessoa jurídica.");
    }
}
