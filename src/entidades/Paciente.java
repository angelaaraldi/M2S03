package entidades;

import repositorio.ListaPaciente;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {
    private final String nome;
    private String dietaAlimentar;
    private final int idade;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double frequenciaCardiaca;
    private final ArrayList<String> atividadesFisicas;
    private static final Scanner scanner = new Scanner(System.in);

    public String getNome() {
        return nome;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public Paciente(String nome, String dietaAlimentar, int idade, double peso, double altura, double pressaoArterial, double frequenciaCardiaca, ArrayList<String> atividadesFisicas) {
        this.nome = nome;
        this.dietaAlimentar = dietaAlimentar;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.atividadesFisicas = atividadesFisicas;
    }

    double calcularImc() {
        return peso / (altura * altura);
    }

    public void monitorar() {
        System.out.println("Nome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso + "\nAltura: " + altura + "\nPressão arterial: " + pressaoArterial + "\nFrequência cardíaca: " + frequenciaCardiaca + "\nDieta alimentar: " + dietaAlimentar + "\nAtividades físicas: " + atividadesFisicas + "\nIMC: " + calcularImc());
    }

    public static void registrarAtividadeFisica(int id) {
        for (Paciente paciente : ListaPaciente.getListaPaciente()) {
            if (id == ListaPaciente.getListaPaciente().indexOf(paciente) + 1) {
                String atividadeFisica;
                System.out.print("Digite a atividade física: ");
                atividadeFisica = scanner.nextLine();
                paciente.atividadesFisicas.add(atividadeFisica);
            }
        }
    }
}
