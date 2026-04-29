package view;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Funcionario;

public class TelaFolhaPagamento {
    protected  Funcionario[] listaFuncionarios;
    protected  int totalCadastrado;

    public TelaFolhaPagamento(Funcionario[] lista, int total) {
        this.listaFuncionarios = lista;
        this.totalCadastrado = total;
    }

    public void exibirFolha() {
        if (totalCadastrado == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado!");
            return;
        }

        String[] colunas = { "Matrícula", "Nome", "Cargo", "Salário Base", "Vale Transporte" };
        Object[][] dados = new Object[totalCadastrado][5];

        for (int i = 0; i < totalCadastrado; i++) {
            dados[i][0] = listaFuncionarios[i].getMatricula();
            dados[i][1] = listaFuncionarios[i].getNome();
            dados[i][2] = listaFuncionarios[i].getCargo();
            dados[i][3] = String.format("%.2f", listaFuncionarios[i].getSalario());
            dados[i][4] = String.format("%.2f", listaFuncionarios[i].getValetransporteDia() * 20);
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        JOptionPane.showMessageDialog(null, scroll, "Folha de Pagamento", JOptionPane.PLAIN_MESSAGE);
    }

    public void exibirTela() {
        exibirFolha();
    }
}
