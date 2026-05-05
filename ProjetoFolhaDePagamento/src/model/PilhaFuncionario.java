package model;

public class PilhaFuncionario implements TAD_Pilha {
    private int topo;
    private Object[] elementos;

    public PilhaFuncionario(int capacidade) {
        this.elementos = new Object[capacidade];
        this.topo = -1; // Pilha inicia vazia
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    @Override
    public boolean isFull() {
        return topo == elementos.length - 1;
    }

    @Override
    public Object push(Object x) {
        if (!isFull()) {
            elementos[++topo] = x;
            return x;
        }
        return null; 
    }

    @Override
    public Object pop() {
        if (!isEmpty()) {
            Object aux = elementos[topo];
            elementos[topo] = null;
            topo--;
            return aux;
        }
        return null;
    }

    @Override
    public Object top() {
        if (!isEmpty()) return elementos[topo];
        return null;
    }

    // Método essencial para o seu FuncionarioService.listar()
    // Ele retorna apenas os objetos que foram inseridos (até o topo)
    public Object[] getElementosAtivos() {
        Object[] ativos = new Object[topo + 1];
        for (int i = 0; i <= topo; i++) {
            ativos[i] = elementos[i];
        }
        return ativos;
    }

    @Override
    public String toString() {
        return "Pilha com " + (topo + 1) + " funcionários.";
    }
}
