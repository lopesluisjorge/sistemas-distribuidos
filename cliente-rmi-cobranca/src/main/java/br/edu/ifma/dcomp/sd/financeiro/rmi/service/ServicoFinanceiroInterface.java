package br.edu.ifma.dcomp.sd.financeiro.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.edu.ifma.dcomp.sd.financeiro.model.Aluno;

public interface ServicoFinanceiroInterface extends Remote {

    List<Aluno> alunosComMensalidadeEmAtraso() throws RemoteException;

}
