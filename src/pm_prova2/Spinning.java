package pm_prova2;

import java.util.ArrayList;

public class Spinning extends Atividade implements ControladorPresenca {

    private int quantidadeBicicletas;
    private ArrayList<String> presencas = new ArrayList<>();

    public Spinning(String nome, int duracaoAula, int quantidadeMaximaParticipantes,
                    double valorMensal, StatusAtividade status, int quantidadeBicicletas) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    public int getQuantidadeBicicletas() {
        return quantidadeBicicletas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Spinning] " + getNome());
        System.out.println("  Horário: " + getHorario() + " | Duração: " + getDuracaoAula() + " min");
        System.out.println("  Máx. participantes: " + getQuantidadeMaximaParticipantes());
        System.out.println("  Bicicletas: " + quantidadeBicicletas);
        System.out.println("  Presenças registradas: " + presencas.size());
        System.out.println("  Valor mensal: R$ " + getValorMensal() + " | Status: " + getStatus());
    }

    @Override
    public boolean atividadeColetiva() {
        return true;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        presencas.add(nomeParticipante);
        System.out.println("Presença de " + nomeParticipante + " registrada em " + getNome() + ".");
    }
}
