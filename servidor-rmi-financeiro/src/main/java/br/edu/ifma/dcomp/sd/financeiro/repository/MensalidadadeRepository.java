package br.edu.ifma.dcomp.sd.financeiro.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifma.dcomp.sd.financeiro.model.Aluno;
import br.edu.ifma.dcomp.sd.financeiro.model.Mensalidade;

public class MensalidadadeRepository {

    private final Connection conexao;

    public MensalidadadeRepository(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Mensalidade> mensalidadesEmAtrasoComAlunos() {
        final List<Mensalidade> lista = new ArrayList<>();

        String consulta = new StringBuilder()
                .append("SELECT")
                .append("  m.id, m.valor, m.data_vencimento, a.id id_aluno, a.nome nome_aluno, a.matricula matricula_aluno, a.curso curso_aluno ")
                .append("FROM mensalidade m, aluno a ")
                .append("WHERE ")
                .append("  a.id = m.aluno_id")
                .append("  AND m.data_pagamento IS NULL")
                .append("  AND DATEDIFF(current_date, m.data_vencimento) > 45;")
                .toString();

        try (PreparedStatement stm = conexao.prepareStatement(consulta)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                Double valor = rs.getDouble("valor");
                Date dataVencimento = rs.getDate("data_vencimento");
                Integer idAluno = rs.getInt("id_aluno");
                String nomeAluno = rs.getString("nome_aluno");
                Integer matriculaAluno = rs.getInt("matricula_aluno");
                String cursoAluno = rs.getString("curso_aluno");

                Aluno aluno = new Aluno(idAluno, nomeAluno, matriculaAluno, cursoAluno);

                lista.add(new Mensalidade(id, valor, dataVencimento, null, aluno));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

}
