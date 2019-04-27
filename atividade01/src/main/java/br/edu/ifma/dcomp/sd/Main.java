package br.edu.ifma.dcomp.sd;

import java.sql.SQLException;

import br.edu.ifma.dcomp.sd.cli.Terminal;

public class Main {

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
