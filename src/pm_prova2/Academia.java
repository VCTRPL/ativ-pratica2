package pm_prova2;

import java.util.ArrayList;

public class Academia {

    private ArrayList<Atividade> atividades = new ArrayList<>();
    private ArrayList<Plano> planos = new ArrayList<>();

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public ArrayList<Plano> getPlanos() {
        return planos;
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void adicionarPlano(Plano plano) {
        planos.add(plano);
    }

    public void exibirAtividades() {
        for (int i = 0; i < atividades.size(); i++) {
            atividades.get(i).exibirDetalhes();
        }
    }

    public void exibirPlanos() {
        for (int i = 0; i < planos.size(); i++) {
            planos.get(i).exibirDetalhes();
            planos.get(i).exibirAtividades();
        }
    }

    public void exibirPlanosAtivos() {
        for (int i = 0; i < planos.size(); i++) {
            if (planos.get(i).getStatus() == StatusPlano.ATIVO) {
                planos.get(i).exibirDetalhes();
                planos.get(i).exibirAtividades();
            }
        }
    }

    public void emitirCertificado(Atividade atividade, String nomeParticipante) {
        if (atividade instanceof Certificavel) {
            Certificavel c = (Certificavel) atividade;
            c.emitirCertificado(nomeParticipante);
        } else {
            System.out.println("Essa atividade não emite certificado.");
        }
    }

    public void registrarPresenca(Atividade atividade, String nomeParticipante) {
        if (atividade instanceof ControladorPresenca) {
            ControladorPresenca c = (ControladorPresenca) atividade;
            c.registrarPresenca(nomeParticipante);
        } else {
            System.out.println("Essa atividade não controla presença.");
        }
    }

    public void removerAtividadesInativas() {
        int removidas = 0;
        for (int i = atividades.size() - 1; i >= 0; i--) {
            Atividade a = atividades.get(i);
            if (a.getStatus() == StatusAtividade.INATIVA) {
                for (int j = 0; j < planos.size(); j++) {
                    planos.get(j).getAtividades().remove(a);
                }
                atividades.remove(i);
                removidas++;
            }
        }
        System.out.println(removidas + " atividade(s) inativa(s) removida(s).");
    }
}
