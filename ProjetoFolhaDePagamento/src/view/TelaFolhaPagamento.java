package view;

import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Funcionario;
import service.CalcularFolha;

public class TelaFolhaPagamento {

    protected Funcionario[] listaFuncionarios;
    protected int totalCadastrado;

    public TelaFolhaPagamento(Funcionario[] lista, int total) {

        this.listaFuncionarios = lista;
        this.totalCadastrado = total;
    }

    public void exibirFolha() {
        try {
            // VERIFICA SE EXISTEM FUNCIONÁRIOS
            if (totalCadastrado == 0) {
               JOptionPane.showMessageDialog(null,"Nenhum funcionário cadastrado!"
                );
                return;
            }
            // COLUNAS
            String[] colunas = {
                    "Matrícula","Nome","Cargo","Salário Base","INSS","IRRF",
                    "Vale Transporte","Salário Família","FGTS",
                    "Salário Líquido"
            };
            Object[][] dados = new Object[totalCadastrado][10];

            //para fazer os calculos 
            CalcularFolha calc = new CalcularFolha();
            // para deixa no nosso padrao 
            NumberFormat nf =NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

/*====================Calculos da tabela ====================================*/
            for (int i = 0; i < totalCadastrado; i++) {
                if (listaFuncionarios[i] != null) {
                    Funcionario f = listaFuncionarios[i];
                    BigDecimal inss =
                            calc.calcularINSS(f.getSalario());
                    BigDecimal irrf =
                            calc.calcularIRRF(
                                    f.getSalario(),
                                    f.getDependentes()
                            );
                    BigDecimal vt =
                            calc.calcularValeTransporte(f);

                    BigDecimal sf =
                            calc.calcularSalarioFamilia(
                                    f.getSalario(),
                                    f.getFilhosMenores14()
                            );
                    BigDecimal fgts =
                            calc.calcularFGTS(f.getSalario());
                    BigDecimal liquido =
                            calc.calcularSalarioLiquido(f);
                    dados[i][0] = f.getMatricula();
                    dados[i][1] = f.getNome();
                    dados[i][2] = f.getCargo();
                    dados[i][3] = nf.format(f.getSalario());
                    dados[i][4] = nf.format(inss);
                    dados[i][5] = nf.format(irrf);
                    dados[i][6] = nf.format(vt);
                    dados[i][7] = nf.format(sf);
                    dados[i][8] = nf.format(fgts);
                    dados[i][9] = nf.format(liquido);
                }
            }
/*============================================================================================================================================= */
    /* tiver que fazer tudo isso para a tabela fica menos ruim de visualiza */
    //nem tenta mexer nisso se nao vai da merda       
    JTable tabela = new JTable(dados, colunas);
            tabela.setRowHeight(30);
            tabela.setRowMargin(5);
            tabela.setShowGrid(true);
            tabela.setEnabled(false);
            tabela.setAutoResizeMode(
                    JTable.AUTO_RESIZE_OFF
            );
            tabela.getTableHeader()
                    .setReorderingAllowed(false);
            tabela.getTableHeader()
                    .setPreferredSize(
                            new Dimension(100, 35)
                    );
            //principamente nessa parte        
            tabela.getColumnModel().getColumn(0)
                    .setPreferredWidth(90);
            tabela.getColumnModel().getColumn(1)
                    .setPreferredWidth(180);
            tabela.getColumnModel().getColumn(2)
                    .setPreferredWidth(130);
            tabela.getColumnModel().getColumn(3)
                    .setPreferredWidth(140);
            tabela.getColumnModel().getColumn(4)
                    .setPreferredWidth(120);
            tabela.getColumnModel().getColumn(5)
                    .setPreferredWidth(120);
            tabela.getColumnModel().getColumn(6)
                    .setPreferredWidth(150);
            tabela.getColumnModel().getColumn(7)
                    .setPreferredWidth(150);
            tabela.getColumnModel().getColumn(8)
                    .setPreferredWidth(120);
            tabela.getColumnModel().getColumn(9)
                    .setPreferredWidth(150);

            DefaultTableCellRenderer direita =
                    new DefaultTableCellRenderer();

            direita.setHorizontalAlignment(
                    DefaultTableCellRenderer.RIGHT
            );

            for (int i = 3; i < tabela.getColumnCount(); i++) {
                tabela.getColumnModel()
                        .getColumn(i)
                        .setCellRenderer(direita);
            }
            JScrollPane scroll =
                    new JScrollPane(tabela);

            scroll.setPreferredSize(
                    new Dimension(1200, 250)
            );
            JOptionPane.showMessageDialog(
                    null,
                    scroll,
                    "Folha de Pagamento",
                    JOptionPane.PLAIN_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao abrir folha:\n" + e.getMessage()
            );
        }
    }

    public void exibirTela() {

        exibirFolha();
    }
}