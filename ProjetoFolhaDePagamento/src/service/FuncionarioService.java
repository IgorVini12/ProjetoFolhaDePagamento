package service;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioService {
    private List<Funcionario> lista = new ArrayList<>();

/* ===== TAD PILHA ESTÁTICA =====
Funcionamento LIFO (Last In, First Out)
-Permite desfazer remoções de funcionários
-Histórico de operações
-Recuperação de dados deletados acidentalmente
-É como um "Ctrl+Z" para funcionários removidos,um histórico oculto que permite desfazer remoções a qualquer momento
*/

    private PilhaEstatica pilha = new PilhaEstatica(10);

    private class PilhaEstatica {
        private Funcionario[] elementos;
        private int topo;

        public PilhaEstatica(int capacidade) {
            elementos = new Funcionario[capacidade];
            topo = -1;
        }

        public void empilhar(Funcionario f) {
            if (topo < elementos.length - 1) {
                elementos[++topo] = f;
            }
        }

        public Funcionario desempilhar() {
            if (topo >= 0) {
                return elementos[topo--];
            }
            return null;
        }

        public Funcionario topo() {
            if (topo >= 0) {
                return elementos[topo];
            }
            return null;
        }

        public boolean estaVazia() {
            return topo == -1;
        }
    }
    // ===== FIM PILHA ESTÁTICA =====

    public void carregarDadosIniciais() {
        lista.add(new Funcionario(1, "Ana Silva", "Analista", 3000, 2, 1, 8.5));
        lista.add(new Funcionario(2, "Bruno Souza", "Dev", 5000, 1, 1, 10));
        lista.add(new Funcionario(3, "Carlos Lima", "Suporte", 1800, 3, 2, 6));
        lista.add(new Funcionario(4, "Daniela Rocha", "Gerente", 8000, 0, 0, 12));
        lista.add(new Funcionario(5, "Eduardo Alves", "Estagiário", 1200, 0, 0, 5));
    }

    public void adicionar(Funcionario f) {
        lista.add(f);
    }

    public List<Funcionario> listar() {
        return lista;
    }

    public void remover(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            Funcionario removido = lista.remove(indice);
            pilha.empilhar(removido);
        }
    }

    public Funcionario recuperar() {
        if (!pilha.estaVazia()) {
            return pilha.desempilhar();
        }
        return null;
    }
}