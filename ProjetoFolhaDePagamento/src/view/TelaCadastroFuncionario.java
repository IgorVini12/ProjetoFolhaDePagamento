package view;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Funcionario;

public class TelaCadastroFuncionario {
    protected  Funcionario[] listaFuncionarios;
    protected  int totalCadastrado;

    public TelaCadastroFuncionario(Funcionario[] lista, int total) {
        this.listaFuncionarios = lista;
        this.totalCadastrado = total;
    }

    public void exibirTela() {

        if (totalCadastrado < 10) {

            JTextField campoMatricula = new JTextField();
            JTextField campoNome = new JTextField();
            JTextField campoCargo = new JTextField();
            JTextField campoSalario = new JTextField();
            JTextField campoDependentes = new JTextField();

            //add campofilhos e vale transporte para podemos fazer os calculos dos descontos
            JTextField campoFilhos = new JTextField();
            JTextField campoValeTransporte = new JTextField();

            Object[] formulario = {

                "Matrícula:", campoMatricula,
                "Nome:", campoNome,
                "Cargo:", campoCargo,
                "Salário:", campoSalario,
                "Número de dependentes:", campoDependentes,
                "Filhos menores de 14 anos:", campoFilhos,
                "Vale transporte por dia:", campoValeTransporte
            };

            int result = JOptionPane.showConfirmDialog(

                null, formulario, "Novo Cadastro", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {

                Funcionario f = new Funcionario(
                    Integer.parseInt(campoMatricula.getText()),
                    campoNome.getText(),
                    campoCargo.getText(),
                    Double.parseDouble(campoSalario.getText()),
                    Integer.parseInt(campoDependentes.getText()),
                    Integer.parseInt(campoFilhos.getText()),
                    Double.parseDouble(campoValeTransporte.getText())
                    );
                    
                listaFuncionarios[totalCadastrado] = f;
                totalCadastrado++;

                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

                }

        } else {

            JOptionPane.showMessageDialog(null, "Limite de 10 funcionários atingido!");

        }
    }
}

