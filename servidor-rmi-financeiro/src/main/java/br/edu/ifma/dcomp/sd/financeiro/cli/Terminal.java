package br.edu.ifma.dcomp.sd.financeiro.cli;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifma.dcomp.sd.financeiro.model.Mensalidade;
import br.edu.ifma.dcomp.sd.financeiro.repository.MensalidadadeRepository;
import br.edu.ifma.dcomp.sd.financeiro.utils.ConnectionPool;

public class Terminal {

    private static Scanner teclado = new Scanner(System.in);
    
    public void exibeMensagemDeMenuInicial() {
        System.out.println("===============================================================");
        System.out.println("==== Sistema do Setor de Finanças");
        System.out.println("===============================================================");
    }
    
    public void exibeMenuDeOpcoes() {
        System.out.println("===============================================================");
        System.out.println("==== (C) Mensalidades para encaminhar para o setor de cobranças");
        System.out.println("==== (S) Sair");
        System.out.println("===============================================================");
        System.out.println("==== Digite Sua opção: ");
    }

    public char capturaInformacao() {
        String captura = teclado.nextLine();
        return captura.toUpperCase().charAt(0);
    }

    public void executaOpcao(char opcao) throws SQLException {
        Connection conexao = new ConnectionPool().getConexao();

        switch (opcao) {
        case 'C':
            MensalidadadeRepository mensalidadadeRepository = new MensalidadadeRepository(conexao);
            List<Mensalidade> mensalidades = mensalidadadeRepository.mensalidadesEmAtrasoComAlunos();
            System.out.println(mensalidades);
            break;
        case 'S':
            teclado.close();
            break;
        default:
            System.out.println("Opção Inválida");
            System.out.println();
            break;
        }

        conexao.close();
    }

}
