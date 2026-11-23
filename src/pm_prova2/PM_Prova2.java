package pm_prova2;

import java.util.Scanner;

public class PM_Prova2 {

    public static void main(String[] args) {
        Academia academia = new Academia();
        criarDadosIniciais(academia);

        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== ACADEMIA =====");
            System.out.println("1 - Associar atividade a um plano");
            System.out.println("2 - Exibir todas as atividades");
            System.out.println("3 - Exibir todos os planos");
            System.out.println("4 - Exibir apenas planos ativos");
            System.out.println("5 - Emitir certificado");
            System.out.println("6 - Registrar presença em atividade");
            System.out.println("7 - Remover atividades inativas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) {
                int p = escolherPlano(academia, teclado);
                int a = escolherAtividade(academia, teclado);
                if (p >= 0 && a >= 0) {
                    academia.getPlanos().get(p).associarAtividade(academia.getAtividades().get(a));
                }
            } else if (opcao == 2) {
                academia.exibirAtividades();
            } else if (opcao == 3) {
                academia.exibirPlanos();
            } else if (opcao == 4) {
                academia.exibirPlanosAtivos();
            } else if (opcao == 5) {
                int a = escolherAtividade(academia, teclado);
                if (a >= 0) {
                    System.out.print("Nome do participante: ");
                    String nome = teclado.nextLine();
                    academia.emitirCertificado(academia.getAtividades().get(a), nome);
                }
            } else if (opcao == 6) {
                int a = escolherAtividade(academia, teclado);
                if (a >= 0) {
                    System.out.print("Nome do participante: ");
                    String nome = teclado.nextLine();
                    academia.registrarPresenca(academia.getAtividades().get(a), nome);
                }
            } else if (opcao == 7) {
                academia.removerAtividadesInativas();
            } else if (opcao == 0) {
                System.out.println("Encerrando...");
            } else {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void criarDadosIniciais(Academia academia) {
        Musculacao musculacao = new Musculacao("Musculação", 60, 30, 90.0, StatusAtividade.ATIVA, 25);
        musculacao.setHorario("06:00");

        Natacao natacao = new Natacao("Natação", 45, 15, 120.0, StatusAtividade.ATIVA, 1.8, true);
        natacao.setHorario("08:00");

        Spinning spinning = new Spinning("Spinning", 50, 20, 100.0, StatusAtividade.INATIVA, 20);
        spinning.setHorario("18:30");

        academia.adicionarAtividade(musculacao);
        academia.adicionarAtividade(natacao);
        academia.adicionarAtividade(spinning);

        academia.adicionarPlano(new PlanoBasico("Básico", 99.9, 1, StatusPlano.ATIVO));
        academia.adicionarPlano(new PlanoPremium("Premium", 199.9, 3, StatusPlano.ATIVO));
    }

    public static int escolherPlano(Academia academia, Scanner teclado) {
        for (int i = 0; i < academia.getPlanos().size(); i++) {
            System.out.println((i + 1) + " - " + academia.getPlanos().get(i).getNome());
        }
        System.out.print("Escolha o plano: ");
        int n = Integer.parseInt(teclado.nextLine());
        if (n < 1 || n > academia.getPlanos().size()) {
            System.out.println("Plano inválido.");
            return -1;
        }
        return n - 1;
    }

    public static int escolherAtividade(Academia academia, Scanner teclado) {
        for (int i = 0; i < academia.getAtividades().size(); i++) {
            System.out.println((i + 1) + " - " + academia.getAtividades().get(i).getNome());
        }
        System.out.print("Escolha a atividade: ");
        int n = Integer.parseInt(teclado.nextLine());
        if (n < 1 || n > academia.getAtividades().size()) {
            System.out.println("Atividade inválida.");
            return -1;
        }
        return n - 1;
    }
}
