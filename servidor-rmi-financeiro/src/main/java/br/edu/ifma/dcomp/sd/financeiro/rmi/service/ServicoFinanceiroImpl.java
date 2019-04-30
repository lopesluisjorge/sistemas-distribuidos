package br.edu.ifma.dcomp.sd.financeiro.rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifma.dcomp.sd.financeiro.model.Aluno;
import br.edu.ifma.dcomp.sd.financeiro.repository.AlunoRepository;
import br.edu.ifma.dcomp.sd.financeiro.utils.ConnectionPool;

public class ServicoFinanceiroImpl extends UnicastRemoteObject implements ServicoFinanceiroInterface {

    private static final long serialVersionUID = -4097669834596812943L;

    public ServicoFinanceiroImpl() throws RemoteException {
        super();
    }

    @Override
    public List<Aluno> alunosComMensalidadeEmAtraso() throws RemoteException {
        Connection conexao = null;

        try {
            conexao = new ConnectionPool().getConexao();
            final AlunoRepository alunoRepository = new AlunoRepository(conexao);

            final List<Aluno> alunosComMensaliadeEmAtraso = alunoRepository.alunosComMensalidadeEmAtraso();
            conexao.close();

            return alunosComMensaliadeEmAtraso;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
