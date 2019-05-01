package br.edu.ifma.dcomp.sd.cobranca.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import br.edu.ifma.dcomp.sd.financeiro.model.Aluno;
import br.edu.ifma.dcomp.sd.financeiro.rmi.service.ServicoFinanceiroInterface;

public class MainClient {

    public static void main(String[] args) {
        try {
            ServicoFinanceiroInterface financeiroService = (ServicoFinanceiroInterface) Naming.lookup("//localhost/financeiro");
            List<Aluno> alunos = financeiroService.alunosComMensalidadeEmAtraso();
            System.out.println(alunos);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
