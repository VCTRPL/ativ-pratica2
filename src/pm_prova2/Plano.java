package pm_prova2;

import java.util.ArrayList;

public abstract class Plano {

    private String nome;
    private double valorMensal;
    private int quantidadeMaximaAtividades;
    private StatusPlano status;
    private ArrayList<Atividade> atividades = new ArrayList<>();

    public Plano(String nome,
                 double valorMensal,
                 int quantidadeMaximaAtividades,
                 StatusPlano status) {

        this.nome = nome;
        this.valorMensal = valorMensal;
        this.quantidadeMaximaAtividades = quantidadeMaximaAtividades;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getQuantidadeMaximaAtividades() {
        return quantidadeMaximaAtividades;
    }

    public void setQuantidadeMaximaAtividades(int quantidadeMaximaAtividades) {
        this.quantidadeMaximaAtividades = quantidadeMaximaAtividades;
    }

    public StatusPlano getStatus() {
        return status;
    }

    public void setStatus(StatusPlano status) {
        this.status = status;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void associarAtividade(Atividade atividade) {
        if (status != StatusPlano.ATIVO) {
            System.out.println("O plano não está ativo.");
        } else if (atividade.getStatus() == StatusAtividade.INATIVA) {
            System.out.println("A atividade está inativa.");
        } else if (atividades.contains(atividade)) {
            System.out.println("Essa atividade já está no plano.");
        } else if (atividade.atividadeColetiva() && !permiteAtividadeColetiva()) {
            System.out.println("Esse plano permite apenas atividades individuais.");
        } else if (atividades.size() >= quantidadeMaximaAtividades) {
            System.out.println("O plano já atingiu o máximo de atividades.");
        } else {
            atividades.add(atividade);
            System.out.println("Atividade " + atividade.getNome() + " associada ao plano " + nome + ".");
        }
    }

    public void exibirAtividades() {
        if (atividades.size() == 0) {
            System.out.println("  Atividades associadas: nenhuma");
        } else {
            System.out.println("  Atividades associadas:");
            for (int i = 0; i < atividades.size(); i++) {
                System.out.println("   - " + atividades.get(i).getNome());
            }
        }
    }

    public abstract void exibirDetalhes();

    public abstract boolean permiteAtividadeColetiva();
}
