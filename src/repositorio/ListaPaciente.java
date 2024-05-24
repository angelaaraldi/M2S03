package repositorio;

import entidades.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ListaPaciente {
    private static ArrayList<Paciente> listaPaciente = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public static void listarPaciente() {
        for (Paciente paciente : listaPaciente) {
            System.out.println(listaPaciente.indexOf(paciente) + 1 + " - " + paciente.getNome());
        }
    }

    public static void buscarPacientePorId(int id) {
        for (Paciente paciente : listaPaciente) {
            if (id == listaPaciente.indexOf(paciente) + 1) {
                paciente.monitorar();
            }
        }
    }

    public static void adicionarPaciente() {
        String nome, dietaAlimentar, atividadesFisicasString;
        int idade;
        double peso, altura, pressaoArterial, frequenciaCardiaca;
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("Idade: ");
        idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Peso: ");
        peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Altura: ");
        altura = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Pressão arterial: ");
        pressaoArterial = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Frequência cardíaca: ");
        frequenciaCardiaca = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Dieta alimentar: ");
        dietaAlimentar = scanner.nextLine();
        System.out.print("Atividades físicas: ");
        atividadesFisicasString = scanner.nextLine();
        ArrayList<String> atividadesFisicas = new ArrayList<>();
        atividadesFisicas.add(atividadesFisicasString);
        Paciente paciente = new Paciente(nome, dietaAlimentar, idade, peso, altura, pressaoArterial, frequenciaCardiaca, atividadesFisicas);
        listaPaciente.add(paciente);
    }

    public static void removerPaciente(int id) {
        ArrayList<Paciente> listaAposRemocao = new ArrayList<>();
        for (Paciente paciente : listaPaciente) {
            if (id != listaPaciente.indexOf(paciente) + 1) {
                listaAposRemocao.add(paciente);
            }
        }
        listaPaciente = listaAposRemocao;
    }

    public static void alterarPaciente(int id) {
        for (Paciente paciente : listaPaciente) {
            if (id == listaPaciente.indexOf(paciente) + 1) {
                System.out.print("Peso: ");
                paciente.setPeso(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Altura: ");
                paciente.setAltura(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Pressão arterial: ");
                paciente.setPressaoArterial(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Frequência cardíaca: ");
                paciente.setFrequenciaCardiaca(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Dieta alimentar: ");
                paciente.setDietaAlimentar(scanner.nextLine());
            }
        }
    }
}
