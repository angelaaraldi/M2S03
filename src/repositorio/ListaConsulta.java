package repositorio;

import entidades.Consulta;
import entidades.Nutricionista;
import entidades.Paciente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListaConsulta {
    private static ArrayList<Consulta> listaConsulta = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Consulta> getListaConsulta() {
        return listaConsulta;
    }

    public static void listarConsulta() {
        for (Consulta consulta : listaConsulta) {
            System.out.println(listaConsulta.indexOf(consulta) + 1 + " - " + "Data e hora: " + consulta.getDataHora() + " - Nutricionista: " + consulta.getNomeNutricionista() + " - Paciente: " + consulta.getNomePaciente() + " - Consulta realizada: " + (consulta.getConsultaRealizada() ? "Sim" : "Não"));
        }
    }

    public static void buscarConsultaPorId(int id) {
        for (Consulta consulta : listaConsulta) {
            if (id == listaConsulta.indexOf(consulta) + 1) {
                System.out.println("Data e hora: " + consulta.getDataHora() + "\nNutricionista: " + consulta.getNomeNutricionista() + "\nPaciente: " + consulta.getNomePaciente() + "\nConsulta realizada: " + (consulta.getConsultaRealizada() ? "Sim" : "Não"));
            }
        }
    }

    public static void adicionarConsulta() {
        String nomeNutricionista, nomePaciente;
        LocalDateTime dataHora;
        boolean consultaRealizada;
        System.out.print("Nome do nutricionista: ");
        if (!listaConsulta.isEmpty()) {
            scanner.nextLine();
        }
        nomeNutricionista = scanner.nextLine();
        boolean nutricionistaExiste = false;
        boolean pacienteExiste = false;
        for (Nutricionista nutricionista : ListaNutricionista.getListaNutricionista()) {
            if (Objects.equals(nutricionista.getNome(), nomeNutricionista)) {
                nutricionistaExiste = true;
                System.out.print("Nome do paciente: ");
                nomePaciente = scanner.nextLine();
                for (Paciente paciente : ListaPaciente.getListaPaciente()) {
                    if (Objects.equals(paciente.getNome(), nomePaciente)) {
                        pacienteExiste = true;
                        System.out.print("Data e hora: ");
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        dataHora = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
                        System.out.println("Consulta realizada? Digite 1 para sim");
                        consultaRealizada = Objects.equals(scanner.nextInt(), 1);
                        Consulta consulta = new Consulta(nomeNutricionista, nomePaciente, dataHora, consultaRealizada);
                        listaConsulta.add(consulta);
                        for (Nutricionista nutricionistaItem : ListaNutricionista.getListaNutricionista()) {
                            if (Objects.equals(nutricionistaItem.getNome(), nomeNutricionista)) {
                                nutricionistaItem.setNumeroConsultas(nutricionistaItem.getNumeroConsultas() + 1);
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (!nutricionistaExiste) {
            System.out.println("Nutricionista não cadastrado");
        }
        if (!pacienteExiste) {
            System.out.println("Paciente não cadastrado");
        }
    }

    public static void removerConsulta(int id) {
        ArrayList<Consulta> listaAposRemocao = new ArrayList<>();
        for (Consulta consulta : listaConsulta) {
            if (id != listaConsulta.indexOf(consulta) + 1) {
                listaAposRemocao.add(consulta);
            }
        }
        listaConsulta = listaAposRemocao;
    }

    public static void alterarConsulta(int id) {
        for (Consulta consulta : listaConsulta) {
            if (id == listaConsulta.indexOf(consulta) + 1) {
                String nomeNutricionista, nomePaciente;
                LocalDateTime dataHora;
                boolean consultaRealizada;
                System.out.print("Nome do nutricionista: ");
                nomeNutricionista = scanner.nextLine();
                consulta.setNomeNutricionista(nomeNutricionista);
                System.out.print("Nome do paciente: ");
                nomePaciente = scanner.nextLine();
                consulta.setNomePaciente(nomePaciente);
                System.out.print("Data e hora: ");
                dataHora = LocalDateTime.parse(scanner.nextLine());
                consulta.setDataHora(dataHora);
                System.out.println("Consulta realizada? Digite 1 para sim");
                consultaRealizada = Objects.equals(scanner.nextInt(), 1);
                consulta.setConsultaRealizada(consultaRealizada);
            }
        }
    }
}
