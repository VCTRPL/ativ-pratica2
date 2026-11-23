package pm_prova2;

import java.util.ArrayList;

public class PlanoBasico extends Plano implements ControladorPresenca {

    private ArrayList<String> acessosDoDia = new ArrayList<>();

    public PlanoBasico(String nome, double valorMensal, int quantidadeMaximaAtividades,
                       StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Plano Básico] " + getNome());
        System.out.println("  Valor mensal: R$ " + getValorMensal());
        System.out.println("  Máx. atividades: " + getQuantidadeMaximaAtividades());
        System.out.println("  Permite atividade coletiva: Não");
        System.out.println("  Acesso: 1 por dia (frequência controlada)");
        System.out.println("  Status: " + getStatus());
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return false;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (acessosDoDia.contains(nomeParticipante)) {
            System.out.println(nomeParticipante + " já acessou a academia hoje (limite de 1 acesso/dia).");
        } else {
            acessosDoDia.add(nomeParticipante);
            System.out.println("Acesso de " + nomeParticipante + " registrado no plano " + getNome() + ".");
        }
    }
}
