import entidades.Consulta;
import entidades.Paciente;
import repositorio.ListaConsulta;
import repositorio.ListaFuncionario;
import repositorio.ListaNutricionista;
import repositorio.ListaPaciente;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static void selecionar() {
        System.out.println("Escolha uma opção:\n1 - Cadastrar um novo paciente\n2 - Listar todos os pacientes\n3 - Alterar informações do paciente\n4 - Mostrar informações de um paciente\n5 - Registrar atividade física para um paciente\n6 - Remover paciente\n7 - Cadastrar um novo funcionário\n8 - Cadastrar um novo nutricionista\n9 - Criar uma nova consulta\n10 - Listar todos os funcionários e nutricionistas\n11 - Listar todas as consultas\n12 - Realizar uma consulta");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        int id;
        switch (opcao) {
            case 1:
                ListaPaciente.adicionarPaciente();
                selecionar();
                break;
            case 2:
                ListaPaciente.listarPaciente();
                selecionar();
                break;
            case 3:
                System.out.print("Digite o ID do paciente: ");
                id = scanner.nextInt();
                scanner.nextLine();
                for (Paciente paciente : ListaPaciente.getListaPaciente()) {
                    if (id == ListaPaciente.getListaPaciente().indexOf(paciente) + 1) {
                        ListaPaciente.alterarPaciente(id);
                    }
                }
                selecionar();
                break;
            case 4:
                System.out.print("Digite o ID do paciente: ");
                id = scanner.nextInt();
                scanner.nextLine();
                for (Paciente paciente : ListaPaciente.getListaPaciente()) {
                    if (id == ListaPaciente.getListaPaciente().indexOf(paciente) + 1) {
                        ListaPaciente.buscarPacientePorId(id);
                    }
                }
                selecionar();
                break;
            case 5:
                System.out.print("Digite o ID do paciente: ");
                id = scanner.nextInt();
                scanner.nextLine();
                Paciente.registrarAtividadeFisica(id);
                selecionar();
                break;
            case 6:
                System.out.print("Digite o ID do paciente: ");
                id = scanner.nextInt();
                scanner.nextLine();
                for (Paciente paciente : ListaPaciente.getListaPaciente()) {
                    if (id == ListaPaciente.getListaPaciente().indexOf(paciente) + 1) {
                        ListaPaciente.removerPaciente(id);
                        break;
                    }
                }
                selecionar();
                break;
            case 7:
                ListaFuncionario.adicionarFuncionario();
                selecionar();
                break;
            case 8:
                ListaNutricionista.adicionarNutricionista();
                selecionar();
                break;
            case 9:
                ListaConsulta.adicionarConsulta();
                selecionar();
                break;
            case 10:
                System.out.println("Funcionários: ");
                ListaFuncionario.listarFuncionario();
                System.out.println("Nutricionistas: ");
                ListaNutricionista.listarNutricionista();
                selecionar();
                break;
            case 11:
                ListaConsulta.listarConsulta();
                selecionar();
                break;
            case 12:
                System.out.print("Digite o ID da consulta: ");
                id = scanner.nextInt();
                scanner.nextLine();
                for (Consulta consulta : ListaConsulta.getListaConsulta()) {
                    if (id == ListaConsulta.getListaConsulta().indexOf(consulta) + 1) {
                        consulta.setConsultaRealizada(true);
                        break;
                    }
                }
                selecionar();
                break;
            default:
                System.out.println("Opção inválida");
                selecionar();
        }
    }

    public static void main(String[] args) {
        selecionar();
    }
}
