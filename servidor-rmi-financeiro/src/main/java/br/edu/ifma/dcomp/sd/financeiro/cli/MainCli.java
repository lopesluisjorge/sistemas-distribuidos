package br.edu.ifma.dcomp.sd.financeiro.cli;

import java.sql.SQLException;

public class MainCli {

    public static void main(String[] args) throws SQLException {
        char opcao;
        
        Terminal cli = new Terminal();
        cli.exibeMensagemDeMenuInicial();

        do {
            cli.exibeMenuDeOpcoes();
            opcao =  cli.capturaInformacao();
            cli.executaOpcao(opcao);
        } while (opcao != 'S');
    }

}
