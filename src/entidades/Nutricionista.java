package entidades;

import java.util.ArrayList;

public class Nutricionista extends Funcionario {
    private final ArrayList<String> listaCertificacoes;
    private int numeroConsultas;
    private int tempoExperiencia;

    public ArrayList<String> getListaCertificacoes() {
        return listaCertificacoes;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public void adicionarAnoTempoExperiencia() {
        tempoExperiencia++;
    }

    public void adicionarCertificacao(String certificacao) {
        listaCertificacoes.add(certificacao);
    }

    public Nutricionista(String nome, int idade, Endereco endereco, double salario, ArrayList<String> listaCertificacoes, int  numeroConsultas, int tempoExperiencia) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setEndereco(endereco);
        this.setSalario(salario);
        this.listaCertificacoes = listaCertificacoes;
        this.numeroConsultas = numeroConsultas;
        this.tempoExperiencia = tempoExperiencia;
    }
}
