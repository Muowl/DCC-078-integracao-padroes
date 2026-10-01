package br.com.atividade.padroes;

public class ContratoPF implements Contrato {

    @Override
    public void assinar() {
        System.out.println("Assinando contrato para pessoa física.");
    }
}
