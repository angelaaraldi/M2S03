package repositorio;

import entidades.Endereco;
import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListaNutricionista {
    private static ArrayList<Nutricionista> listaNutricionista = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Nutricionista> getListaNutricionista() {
        return listaNutricionista;
    }

    public static void listarNutricionista() {
        for (Nutricionista nutricionista : listaNutricionista) {
            System.out.println(listaNutricionista.indexOf(nutricionista) + 1 + " - " + "Nome: " + nutricionista.getNome() + " - Idade: " + nutricionista.getIdade() + " - Endereço: " + nutricionista.getEndereco().getLogradouro() + ", " + nutricionista.getEndereco().getNumero() + ", " + nutricionista.getEndereco().getCidade() + ", " + nutricionista.getEndereco().getEstado() + ", " + nutricionista.getEndereco().getCep() + " - Salário: " + nutricionista.getSalario() + " - Lista de certificações: " + nutricionista.getListaCertificacoes() + " - Número de consultas: " + nutricionista.getNumeroConsultas() + " - Anos de experiência: " + nutricionista.getTempoExperiencia());
        }
    }

    public static void buscarNutricionistaPorId(int id) {
        for (Nutricionista nutricionista : listaNutricionista) {
            if (id == listaNutricionista.indexOf(nutricionista) + 1) {
                System.out.println("Nome: " + nutricionista.getNome() + "\nIdade: " + nutricionista.getIdade() + "\nEndereço: " + nutricionista.getEndereco().getLogradouro() + ", " + nutricionista.getEndereco().getNumero() + ", " + nutricionista.getEndereco().getCidade() + ", " + nutricionista.getEndereco().getEstado() + ", " + nutricionista.getEndereco().getCep() + "\nSalário: " + nutricionista.getSalario() + "\nLista de certificações: " + nutricionista.getListaCertificacoes() + "\nNúmero de consultas: " + nutricionista.getNumeroConsultas() + "\nAnos de experiência: " + nutricionista.getTempoExperiencia());
            }
        }
    }

    public static void adicionarNutricionista() {
        String nome, logradouro, estado, cidade, cep, listaCertificacoesString;
        int idade, numero, numeroConsultas, tempoExperiencia;
        double salario;
        System.out.print("Nome: ");
        if (!listaNutricionista.isEmpty()) {
            scanner.nextLine();
        }
        nome = scanner.nextLine();
        boolean nomeDuplicado = false;
        for (Nutricionista nutricionista : listaNutricionista) {
            if (Objects.equals(nutricionista.getNome(), nome)) {
                nomeDuplicado = true;
                System.out.println("Nutricionista já cadastrado");
                break;
            }
        }
        if (!nomeDuplicado) {
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
            scanner.nextLine();
            System.out.print("Lista de certificações: ");
            listaCertificacoesString = scanner.nextLine();
            ArrayList<String> listaCertificacoes = new ArrayList<>();
            listaCertificacoes.add(listaCertificacoesString);
            System.out.print("Número de consultas: ");
            numeroConsultas = scanner.nextInt();
            System.out.print("Anos de experiência: ");
            tempoExperiencia = scanner.nextInt();
            Endereco endereco = new Endereco(logradouro, estado, cidade, cep, numero);
            Nutricionista nutricionista = new Nutricionista(nome, idade, endereco, salario, listaCertificacoes, numeroConsultas, tempoExperiencia);
            listaNutricionista.add(nutricionista);
        }
    }

    public static void removerNutricionista(int id) {
        ArrayList<Nutricionista> listaAposRemocao = new ArrayList<>();
        for (Nutricionista nutricionista : listaNutricionista) {
            if (id != listaNutricionista.indexOf(nutricionista) + 1) {
                listaAposRemocao.add(nutricionista);
            }
        }
        listaNutricionista = listaAposRemocao;
    }

    public static void alterarNutricionista(int id) {
        for (Nutricionista nutricionista : listaNutricionista) {
            if (id == listaNutricionista.indexOf(nutricionista) + 1) {
                String nome, logradouro, estado, cidade, cep, listaCertificacoesString;
                int idade, numero, numeroConsultas, tempoExperiencia;
                double salario;
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                boolean nomeDuplicado = false;
                for (Nutricionista nutricionistaItem : listaNutricionista) {
                    if (Objects.equals(nutricionistaItem.getNome(), nome)) {
                        nomeDuplicado = true;
                        System.out.println("Nutricionista já cadastrado");
                        break;
                    }
                }
                if (!nomeDuplicado) {
                    nutricionista.setNome(nome);
                    System.out.print("Idade: ");
                    idade = scanner.nextInt();
                    nutricionista.setIdade(idade);
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
                    nutricionista.setSalario(salario);
                    System.out.print("Lista de certificações: ");
                    listaCertificacoesString = scanner.nextLine();
                    nutricionista.getListaCertificacoes().add(listaCertificacoesString);
                    System.out.print("Número de consultas: ");
                    numeroConsultas = scanner.nextInt();
                    nutricionista.setNumeroConsultas(numeroConsultas);
                    System.out.print("Anos de experiência: ");
                    tempoExperiencia = scanner.nextInt();
                    nutricionista.setTempoExperiencia(tempoExperiencia);
                    Endereco endereco = new Endereco(logradouro, estado, cidade, cep, numero);
                    nutricionista.setEndereco(endereco);
                }
            }
        }
    }
}
