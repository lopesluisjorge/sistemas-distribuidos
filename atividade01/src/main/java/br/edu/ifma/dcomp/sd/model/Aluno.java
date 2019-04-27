package br.edu.ifma.dcomp.sd.model;

public class Aluno {

    private Integer id;
    private String nome;
    private Integer matricula;
    private String curso;

    public Aluno(Integer id, String nome, Integer matricula, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno [Nome: " + nome + ", Matricula: " + matricula + ", Curso: " + curso + "]";
    }

}
