package entidades;

public class Endereco {
    private final String logradouro;
    private final String estado;
    private final String cidade;
    private final String cep;
    private final int numero;

    public String getLogradouro() {
        return logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public Endereco(String logradouro, String estado, String cidade, String cep, int numero) {
        this.logradouro = logradouro;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
    }
}
