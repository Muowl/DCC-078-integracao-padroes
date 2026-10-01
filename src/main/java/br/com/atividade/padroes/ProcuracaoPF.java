package br.com.atividade.padroes;

public class ProcuracaoPF implements Procuracao {

    @Override
    public void emitir() {
        System.out.println("Emitindo procuração para pessoa física.");
    }
}
