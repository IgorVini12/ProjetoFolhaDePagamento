package service;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.PilhaFuncionario; 

public class FuncionarioService {
    
    private PilhaFuncionario pilha = new PilhaFuncionario(100);

    public void carregarDadosIniciais() {
        
        adicionar(new Funcionario(1, "Ana Silva", "Analista", 3000, 2, 1, 8.5));
        adicionar(new Funcionario(2, "Bruno Souza", "Dev", 5000, 1, 1, 10));
        adicionar(new Funcionario(3, "Carlos Lima", "Suporte", 1800, 3, 2, 6));
        adicionar(new Funcionario(4, "Daniela Rocha", "Gerente", 8000, 0, 0, 12));
        adicionar(new Funcionario(5, "Eduardo Alves", "Estagiário", 1200, 0, 0, 5));
    }

    public void adicionar(Funcionario f) {
        
        if (!pilha.isFull()) {
            pilha.push(f);
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public List<Funcionario> listar() {
        
        List<Funcionario> listaParaView = new ArrayList<>();
        
        Object[] elementos = pilha.getElementosAtivos();
        for (Object obj : elementos) {
            listaParaView.add((Funcionario) obj); 
        }
        
        return listaParaView;
    }
}
