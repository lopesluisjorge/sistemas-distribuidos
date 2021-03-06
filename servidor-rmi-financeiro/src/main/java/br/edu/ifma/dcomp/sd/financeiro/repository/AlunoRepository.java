package br.edu.ifma.dcomp.sd.financeiro.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.dcomp.sd.financeiro.model.Aluno;

public class AlunoRepository {

    private final Connection conexao;

    public AlunoRepository(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Aluno> alunosComMensalidadeEmAtraso() {
        final List<Aluno> lista = new ArrayList<>();

        String consulta = new StringBuilder()
                .append("SELECT DISTINCT ")
                .append("a.id id_aluno, a.nome nome_aluno, a.matricula matricula_aluno, a.curso curso_aluno ")
                .append("FROM aluno a, mensalidade m ")
                .append("WHERE ")
                .append("  a.id = m.aluno_id")
                .append("  AND m.data_pagamento IS NULL")
                .append("  AND DATEDIFF(current_date, m.data_vencimento) >= 45;")
                .toString();

        try (PreparedStatement stm = conexao.prepareStatement(consulta)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Integer idAluno = rs.getInt("id_aluno");
                String nomeAluno = rs.getString("nome_aluno");
                Integer matriculaAluno = rs.getInt("matricula_aluno");
                String cursoAluno = rs.getString("curso_aluno");

                Aluno aluno = new Aluno(idAluno, nomeAluno, matriculaAluno, cursoAluno);

                lista.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

}
