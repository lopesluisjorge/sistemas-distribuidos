package br.edu.ifma.dcomp.sd.model;

import java.util.Date;

public class Mensalidade {

    private Integer id;
    private Double valor;
    private Date dataDeVencimento;
    private Date dataDePagamento;
    private Aluno aluno;

    public Mensalidade(Integer id, Double valor, Date dataDeVencimento, Date dataDePagamento, Aluno aluno) {
        this.id = id;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Double getValor() {
        return valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }
    
    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
    
    public Date getDataDePagamento() {
        return dataDePagamento;
    }
    
    public void setDataDePagamento(Date dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "\nMensalidade ["
                + "\n\tValor: R$" + valor
                + "\n\tData de Vencimento: " + dataDeVencimento
                + "\n\tData de Pagamento: " + dataDePagamento
                + "\n\tAluno: " + aluno + "\n]";
    }

}
