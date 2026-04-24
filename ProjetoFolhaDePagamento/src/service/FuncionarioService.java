package service;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioService {
    private List<Funcionario> lista = new ArrayList<>();

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
}