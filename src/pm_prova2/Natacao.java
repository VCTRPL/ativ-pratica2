package pm_prova2;

import java.util.ArrayList;

public class Natacao extends Atividade implements Certificavel, ControladorPresenca {

    private double profundidadePiscina;
    private boolean oferecerCertificado;
    private ArrayList<String> presencas = new ArrayList<>();

    public Natacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes,
                   double valorMensal, StatusAtividade status,
                   double profundidadePiscina, boolean oferecerCertificado) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.profundidadePiscina = profundidadePiscina;
        this.oferecerCertificado = oferecerCertificado;
    }

    public double getProfundidadePiscina() {
        return profundidadePiscina;
    }

    public boolean isOferecerCertificado() {
        return oferecerCertificado;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Natação] " + getNome());
        System.out.println("  Horário: " + getHorario() + " | Duração: " + getDuracaoAula() + " min");
        System.out.println("  Máx. participantes: " + getQuantidadeMaximaParticipantes());
        System.out.println("  Profundidade da piscina: " + profundidadePiscina + " m");
        System.out.println("  Oferece certificado: " + (oferecerCertificado ? "Sim" : "Não"));
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

    @Override
    public void emitirCertificado(String nomeParticipante) {
        if (!oferecerCertificado) {
            System.out.println(getNome() + " não oferece certificado.");
            return;
        }
        System.out.println("CERTIFICADO: " + nomeParticipante
                + " concluiu a atividade " + getNome() + ".");
    }
}
