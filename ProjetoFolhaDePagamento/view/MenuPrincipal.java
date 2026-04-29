package view;
import javax.swing.JOptionPane;
import model.Funcionario;

public final class MenuPrincipal {
    private Funcionario[] listaFuncionarios = new Funcionario[10];
    private int totalCadastrado = 0;

    // Construtor: contém a lógica principal do menu
    public MenuPrincipal() {
        totalCadastrado = cargaInicial(listaFuncionarios);
        bubbleSort(listaFuncionarios, totalCadastrado);

        int opcao = 0;
        do {

            String menu = "--- FOLHA DE PAGAMENTO ---\n"
                + "Cadastrados: " + totalCadastrado + "/10\n\n"
                + "1. Novo Funcionario\n"
                + "2. Listar Funcionarios\n"
                + "3. Calcular Folha de Pagamento\n"
                + "4. Sair";

            // O Java cria o OK e Cancelar sozinho aqui
            String leitura = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE);

            // Se o usuário clicar em "Cancelar" ou no "X", a variável 'leitura' recebe null
            if (leitura == null)
                break;

            // Se ele clicar em OK, o valor digitado vai para 'opcao'
            opcao = Integer.parseInt(leitura);

            switch (opcao) {

            case 1 -> adicionarFuncionario();

            case 2 -> exibirFuncionarios();

            case 3 -> calcularFolhaPag();

            case 4 -> {
                }

            }

        } while (opcao != 4);

    }

    // Método para carregar dados iniciais
    public int cargaInicial(Funcionario[] lista) {
        lista[0] = new Funcionario(1, "Ana Silva", "Analista", 3000, 2, 1, 8.5);
        lista[1] = new Funcionario(2, "Bruno Souza", "Dev", 5000, 1, 1, 10);
        lista[2] = new Funcionario(3, "Carlos Lima", "Suporte", 1800, 3, 2, 6);
        lista[3] = new Funcionario(4, "Daniela Rocha", "Gerente", 8000, 0, 0, 12);
        lista[4] = new Funcionario(5, "Eduardo Alves", "Estagiário", 1200, 0, 0, 5);
        return 5;
    }

    // Método para ordenar funcionários por nome
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

    //Construtores para cada opção do menu
    private void adicionarFuncionario() {
    TelaCadastroFuncionario tela = new TelaCadastroFuncionario(listaFuncionarios, totalCadastrado);
    tela.exibirTela();
    totalCadastrado = tela.totalCadastrado; // atualiza o total
}

    private void exibirFuncionarios() {
        TelaListaFuncionarios tela = new TelaListaFuncionarios(listaFuncionarios, totalCadastrado);
        tela.exibirTela();
    }

    private void calcularFolhaPag() {
        TelaFolhaPagamento tela = new TelaFolhaPagamento(listaFuncionarios, totalCadastrado);
        tela.exibirTela();
    }

}
