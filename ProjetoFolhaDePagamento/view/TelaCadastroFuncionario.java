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

            Object[] formulario = {

                "Matrícula:", campoMatricula,
                "Nome:", campoNome,
                "Cargo:", campoCargo,
                "Salário:", campoSalario,
                
            };

            int result = JOptionPane.showConfirmDialog(

                null, formulario, "Novo Cadastro", JOptionPane.OK_CANCEL_OPTION);



            if (result == JOptionPane.OK_OPTION) {

                Funcionario f = new Funcionario(
                    Integer.parseInt(campoMatricula.getText()),
                    campoNome.getText(),
                    campoCargo.getText(),
                    Double.parseDouble(campoSalario.getText()),
                    0, 0, 0);
                    
                listaFuncionarios[totalCadastrado] = f;
                totalCadastrado++;

                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

                }

        } else {

            JOptionPane.showMessageDialog(null, "Limite de 10 funcionários atingido!");

        }
    }
}

