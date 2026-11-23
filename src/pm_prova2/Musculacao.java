package pm_prova2;

public class Musculacao extends Atividade {

    private int quantidadeAparelhos;

    public Musculacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes,
                      double valorMensal, StatusAtividade status, int quantidadeAparelhos) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    public int getQuantidadeAparelhos() {
        return quantidadeAparelhos;
    }

    public void setQuantidadeAparelhos(int quantidadeAparelhos) {
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Musculação] " + getNome());
        System.out.println("  Horário: " + getHorario() + " | Duração: " + getDuracaoAula() + " min");
        System.out.println("  Máx. participantes: " + getQuantidadeMaximaParticipantes());
        System.out.println("  Aparelhos disponíveis: " + quantidadeAparelhos);
        System.out.println("  Valor mensal: R$ " + getValorMensal() + " | Status: " + getStatus());
    }

    @Override
    public boolean atividadeColetiva() {
        return false;
    }
}
