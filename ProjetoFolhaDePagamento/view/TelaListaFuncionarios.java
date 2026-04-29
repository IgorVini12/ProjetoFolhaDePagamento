package view;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Funcionario;

public class TelaListaFuncionarios {
    protected  Funcionario[] listaFuncionarios;
    protected  int totalCadastrado;

    public TelaListaFuncionarios(Funcionario[] lista, int total) {
        this.listaFuncionarios = lista;
        this.totalCadastrado = total;
    }

    public void exibirRelatorioTexto() {

        String relatorio = "--- Funcionários ---\n";

        for (int i = 0; i < totalCadastrado; i++) {

            relatorio += (i + 1) + ". " + listaFuncionarios[i].getNome() + " | Salário: " + String.format("%.2f", listaFuncionarios[i].getSalario()) +" | Cargo: " + listaFuncionarios[i].getCargo() + " | Matrícula: " + listaFuncionarios[i].getMatricula() + "\n";

        }

        JOptionPane.showMessageDialog(null, relatorio);

    }

    public void exibirRelatorioGrid() {

        String[] colunas = { "Matrícula", "Nome", "Cargo", "Salário Base", "Vale Transporte/dia" };

        Object[][] dados = new Object[totalCadastrado][5];

        for (int i = 0; i < totalCadastrado; i++) {
            Funcionario f = listaFuncionarios[i];
            dados[i][0] = f.getMatricula();
            dados[i][1] = f.getNome();
            dados[i][2] = f.getCargo();
            dados[i][3] = f.getSalario();
            dados[i][4] = f.getValeTransporteDia();
        }

        // 3. Criar a tabela com os dados
        JTable tabela = new JTable(dados, colunas);

        // 4. Colocar a tabela dentro de um JScrollPane para aparecer o cabeçalho
        JScrollPane scroll = new JScrollPane(tabela);

        // 5. Exibir tudo no JOptionPane
        JOptionPane.showMessageDialog(null, scroll, "Relatório de Funcionários", JOptionPane.PLAIN_MESSAGE);

    }

    public void exibirTela() {
        exibirRelatorioTexto();
    }

    public void bubbleSort(Funcionario[] lista, int total) {

        for (int i = 0; i < total - 1; i++) {

            for (int j = 0; j < total - 1 - i; j++) {

                if (lista[j].getNome().compareToIgnoreCase(lista[j + 1].getNome()) > 0) {

                    Funcionario temp = lista[j];

                    lista[j] = lista[j + 1];

                    lista[j + 1] = temp;

                }

            }

        }

    }
}
