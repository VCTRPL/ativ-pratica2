package pm_prova2;

public class PlanoPremium extends Plano {

    public PlanoPremium(String nome, double valorMensal, int quantidadeMaximaAtividades,
                        StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Plano Premium] " + getNome());
        System.out.println("  Valor mensal: R$ " + getValorMensal());
        System.out.println("  Máx. atividades: " + getQuantidadeMaximaAtividades());
        System.out.println("  Permite atividade coletiva: Sim");
        System.out.println("  Acesso: ilimitado");
        System.out.println("  Status: " + getStatus());
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return true;
    }
}
