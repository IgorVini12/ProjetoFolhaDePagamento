package view;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Funcionario;

public class TelaListaFuncionarios {

    protected Funcionario[] listaFuncionarios;
    protected int totalCadastrado;

    public TelaListaFuncionarios(Funcionario[] lista, int total) {
        this.listaFuncionarios = lista;
        this.totalCadastrado = total;
    }

    // RELATÓRIO EM TEXTO
    public void exibirRelatorioTexto() {

        String relatorio = "--- FUNCIONÁRIOS ---\n\n";

        for (int i = 0; i < totalCadastrado; i++) {

            Funcionario f = listaFuncionarios[i];

            relatorio += (i + 1) + ". "
                    + f.getNome()
                    + " | Cargo: " + f.getCargo()
                    + " | Salário: R$ " + String.format("%.2f", f.getSalario())
                    + " | Filhos <14: " + f.getFilhosMenores14()
                    + " | VT/Dia: R$ " + String.format("%.2f", f.getValeTransporteDia())
                    + "\n";
        }

        JOptionPane.showMessageDialog(null, relatorio);
    }
    public void exibirRelatorioGrid() {

        String[] colunas = {
                "Matrícula",
                "Nome",
                "Cargo",
                "Salário",
                "Filhos <14",
                "Vale Transporte/Dia"
        };

        Object[][] dados = new Object[totalCadastrado][6];

        for (int i = 0; i < totalCadastrado; i++) {

            Funcionario f = listaFuncionarios[i];

            dados[i][0] = f.getMatricula();
            dados[i][1] = f.getNome();
            dados[i][2] = f.getCargo();
            dados[i][3] = "R$ " + String.format("%.2f", f.getSalario());
            dados[i][4] = f.getFilhosMenores14();
            dados[i][5] = "R$ " + String.format("%.2f", f.getValeTransporteDia());
        }

        JTable tabela = new JTable(dados, colunas);

        JScrollPane scroll = new JScrollPane(tabela);

        JOptionPane.showMessageDialog(
                null,
                scroll,
                "Relatório de Funcionários",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public void exibirTela() {
        // usa tabela ao invés do texto
        exibirRelatorioGrid();
    }
    public void bubbleSort(Funcionario[] lista, int total) {

        for (int i = 0; i < total - 1; i++) {

            for (int j = 0; j < total - 1 - i; j++) {

                if (lista[j].getNome()
                        .compareToIgnoreCase(lista[j + 1].getNome()) > 0) {

                    Funcionario temp = lista[j];

                    lista[j] = lista[j + 1];

                    lista[j + 1] = temp;
                }
            }
        }
    }
}