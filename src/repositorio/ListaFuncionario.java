package repositorio;

import entidades.Endereco;
import entidades.Funcionario;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaFuncionario {
    private static ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void listarFuncionario() {
        for (Funcionario funcionario : listaFuncionario) {
            System.out.println(listaFuncionario.indexOf(funcionario) + 1 + " - " + "Nome: " + funcionario.getNome() + " - Idade: " + funcionario.getIdade() + " - Endereço: " + funcionario.getEndereco().getLogradouro() + ", "  + funcionario.getEndereco().getNumero() + ", " + funcionario.getEndereco().getCidade() + ", " + funcionario.getEndereco().getEstado() + ", " + funcionario.getEndereco().getCep() + " - Salário: " + funcionario.getSalario());
        }
    }

    public static void buscarFuncionarioPorId(int id) {
        for (Funcionario funcionario : listaFuncionario) {
            if (id == listaFuncionario.indexOf(funcionario) + 1) {
                System.out.println("Nome: " + funcionario.getNome() + "\nIdade: " + funcionario.getIdade() + "\nEndereço: " + funcionario.getEndereco().getLogradouro() + ", "  + funcionario.getEndereco().getNumero() + ", " + funcionario.getEndereco().getCidade() + ", " + funcionario.getEndereco().getEstado() + ", " + funcionario.getEndereco().getCep() + "\nSalário: " + funcionario.getSalario());
            }
        }
    }

    public static void adicionarFuncionario() {
        String nome, logradouro, estado, cidade, cep;
        int idade, numero;
        double salario;
        System.out.print("Nome: ");
        if (!listaFuncionario.isEmpty()) {
            scanner.nextLine();
        }
        nome = scanner.nextLine();
        System.out.print("Idade: ");
        idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Logradouro: ");
        logradouro = scanner.nextLine();
        System.out.print("Estado: ");
        estado = scanner.nextLine();
        System.out.print("Cidade: ");
        cidade = scanner.nextLine();
        System.out.print("CEP: ");
        cep = scanner.nextLine();
        System.out.print("Número: ");
        numero = scanner.nextInt();
        System.out.print("Salário: ");
        salario = scanner.nextDouble();
        Endereco endereco = new Endereco(logradouro, estado, cidade, cep, numero);
        Funcionario funcionario = new Funcionario(nome, idade, endereco, salario);
        listaFuncionario.add(funcionario);
    }

    public static void removerFuncionario(int id) {
        ArrayList<Funcionario> listaAposRemocao = new ArrayList<>();
        for (Funcionario funcionario : listaFuncionario) {
            if (id != listaFuncionario.indexOf(funcionario) + 1) {
                listaAposRemocao.add(funcionario);
            }
        }
        listaFuncionario = listaAposRemocao;
    }

    public static void alterarFuncionario(int id) {
        for (Funcionario funcionario : listaFuncionario) {
            if (id == listaFuncionario.indexOf(funcionario) + 1) {
                String nome, logradouro, estado, cidade, cep;
                int idade, numero;
                double salario;
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                funcionario.setNome(nome);
                System.out.print("Idade: ");
                idade = scanner.nextInt();
                funcionario.setIdade(idade);
                System.out.print("Logradouro: ");
                logradouro = scanner.nextLine();
                System.out.print("Estado: ");
                estado = scanner.nextLine();
                System.out.print("Cidade: ");
                cidade = scanner.nextLine();
                System.out.print("CEP: ");
                cep = scanner.nextLine();
                System.out.print("Número: ");
                numero = scanner.nextInt();
                System.out.print("Salário: ");
                salario = scanner.nextDouble();
                funcionario.setSalario(salario);
                Endereco endereco = new Endereco(logradouro, estado, cidade, cep, numero);
                funcionario.setEndereco(endereco);
            }
        }
    }
}
